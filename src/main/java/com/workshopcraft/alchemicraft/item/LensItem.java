package com.workshopcraft.alchemicraft.item;

import com.workshopcraft.alchemicraft.element.LensReadout;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
//? if >=1.21.5 {
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
//?} else {
/*import net.minecraft.world.level.Level;
*///?}

public class LensItem extends HintItem {
    public LensItem(Properties properties) {
        super(properties, "item.alchemicraft.lens.hint");
    }

    //? if >=1.21.5 {
    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity owner, EquipmentSlot slot) {
        if (owner instanceof ServerPlayer player) LensReadout.tick(player, stack);
    }
    //?} else {
    /*@Override
    public void inventoryTick(ItemStack stack, Level level, Entity owner, int slot, boolean selected) {
        if (!level.isClientSide() && owner instanceof ServerPlayer player) LensReadout.tick(player, stack);
    }
    *///?}
}
