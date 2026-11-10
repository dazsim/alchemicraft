package com.workshopcraft.alchemicraft.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
//? if >=1.21.5 {
import net.minecraft.world.item.component.TooltipDisplay;
import java.util.function.Consumer;
//?} else {
/*import java.util.List;
*///?}
//? if <1.20.5 {
/*import net.minecraft.world.level.Level;
*///?}

// an item with one grey line of help under its name
public class HintItem extends Item {
    private final String hint;

    public HintItem(Properties properties, String hint) {
        super(properties);
        this.hint = hint;
    }

    protected Component hintLine() {
        return Component.translatable(hint).withStyle(ChatFormatting.GRAY);
    }

    //? if >=1.21.5 {
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> out, TooltipFlag flag) {
        out.accept(hintLine());
    }
    //?} else if >=1.20.5 {
    /*@Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> out, TooltipFlag flag) {
        out.add(hintLine());
    }
    *///?} else {
    /*@Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> out, TooltipFlag flag) {
        out.add(hintLine());
    }
    *///?}
}
