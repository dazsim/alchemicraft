package com.workshopcraft.alchemicraft.item;

import com.workshopcraft.alchemicraft.Alchemicraft;
import com.workshopcraft.alchemicraft.Mc;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
//? if >=1.21.2 {
import net.minecraft.world.InteractionResult;
//?} else {
/*import net.minecraft.world.InteractionResultHolder;
*///?}

// an old alchemist's note. reading it teaches its recipe and uses it up; one the player already knows stays in hand
public class FragmentItem extends HintItem {
    public FragmentItem(Properties properties) {
        super(properties, "item.alchemicraft.alchemist_fragment.hint");
    }

    // true when it taught something new
    private static boolean read(Level level, Player player, ItemStack stack) {
        if (!(player instanceof ServerPlayer sp)) return true;
        boolean learned = Mc.learnRecipe(sp, Alchemicraft.id("lens"));
        if (learned) {
            Mc.message(sp, Component.translatable("message.alchemicraft.fragment.lens").withStyle(ChatFormatting.LIGHT_PURPLE));
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BOOK_PAGE_TURN, SoundSource.PLAYERS, 1.0F, 1.0F);
            Mc.consume(stack, player);
        } else {
            Mc.overlay(sp, Component.translatable("message.alchemicraft.fragment.known").withStyle(ChatFormatting.GRAY));
        }
        return learned;
    }

    //? if >=1.21.2 {
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        return read(level, player, player.getItemInHand(hand)) ? InteractionResult.SUCCESS : InteractionResult.FAIL;
    }
    //?} else {
    /*@Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        return read(level, player, stack) ? InteractionResultHolder.sidedSuccess(stack, level.isClientSide()) : InteractionResultHolder.fail(stack);
    }
    *///?}
}
