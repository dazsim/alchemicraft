package com.workshopcraft.alchemicraft.element;

import com.workshopcraft.alchemicraft.Mc;
import com.workshopcraft.alchemicraft.registry.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// a player holding the lens sees what they look at broken into elements on the action bar.
// with nothing in sight it reads the item in the other hand. worked out on the server so it follows the server's data packs
public final class LensReadout {
    private static final double RANGE = 6.0;
    private static final int EVERY = 5;
    private static final Map<UUID, String> SHOWN = new HashMap<>();

    private LensReadout() {
    }

    public static void tick(ServerPlayer player, ItemStack lens) {
        if (player.tickCount % EVERY != 0) return;
        // with a lens in each hand only the main hand one reads
        if (lens != player.getMainHandItem() && (lens != player.getOffhandItem() || player.getMainHandItem().is(ModItems.LENS))) return;
        MinecraftServer server = Mc.server(player);
        Component name = null;
        ElementMix mix = null;
        String target = null;

        Vec3 eye = player.getEyePosition();
        HitResult blockHit = player.pick(RANGE, 1.0F, false);
        double blockDist = blockHit.getType() == HitResult.Type.MISS ? RANGE * RANGE : eye.distanceToSqr(blockHit.getLocation());
        Vec3 end = eye.add(player.getViewVector(1.0F).scale(RANGE));
        AABB box = player.getBoundingBox().expandTowards(end.subtract(eye)).inflate(1.0);
        EntityHitResult entityHit = ProjectileUtil.getEntityHitResult(player, eye, end, box, e -> !e.isSpectator() && (e.isPickable() || e instanceof ItemEntity), blockDist);

        if (entityHit != null) {
            Entity entity = entityHit.getEntity();
            name = entity instanceof ItemEntity item ? item.getItem().getHoverName() : entity.getDisplayName();
            mix = ElementTable.entity(server, entity);
            target = "e" + entity.getId();
        } else if (blockHit.getType() == HitResult.Type.BLOCK) {
            BlockPos pos = ((BlockHitResult) blockHit).getBlockPos();
            BlockState state = player.level().getBlockState(pos);
            name = state.getBlock().getName();
            mix = ElementTable.block(server, state);
            target = "b" + pos.asLong() + state;
        } else {
            InteractionHand other = lens == player.getMainHandItem() ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
            ItemStack held = player.getItemInHand(other);
            if (!held.isEmpty()) {
                name = held.getHoverName();
                mix = ElementTable.item(server, held);
                target = "i" + held.getItem();
            }
        }

        if (target == null) {
            if (SHOWN.remove(player.getUUID()) != null) Mc.overlay(player, Component.empty());
            return;
        }
        SHOWN.put(player.getUUID(), target);
        Mc.overlay(player, line(name, mix));
    }

    private static Component line(Component name, ElementMix mix) {
        MutableComponent out = Component.empty().append(name.copy().withStyle(ChatFormatting.WHITE)).append(Component.literal(": ").withStyle(ChatFormatting.GRAY));
        if (mix == null || mix.isEmpty()) return out.append(Component.translatable("readout.alchemicraft.unknown").withStyle(ChatFormatting.DARK_GRAY));
        return out.append(mix.describe());
    }
}
