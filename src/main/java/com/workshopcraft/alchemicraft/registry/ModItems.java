package com.workshopcraft.alchemicraft.registry;

import com.workshopcraft.alchemicraft.Alchemicraft;
import com.workshopcraft.alchemicraft.Mc;
import com.workshopcraft.alchemicraft.item.FragmentItem;
import com.workshopcraft.alchemicraft.item.LensItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiConsumer;

public final class ModItems {
    public static Item LENS;
    public static Item ALCHEMIST_FRAGMENT;
    public static CreativeModeTab TAB;

    private ModItems() {
    }

    public static void registerItems(BiConsumer<Identifier, Item> r) {
        LENS = new LensItem(Mc.item("lens").stacksTo(1));
        r.accept(Alchemicraft.id("lens"), LENS);
        ALCHEMIST_FRAGMENT = new FragmentItem(Mc.item("alchemist_fragment").stacksTo(16));
        r.accept(Alchemicraft.id("alchemist_fragment"), ALCHEMIST_FRAGMENT);
    }

    public static void registerCreativeTabs(BiConsumer<Identifier, CreativeModeTab> r) {
        TAB = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup." + Alchemicraft.MOD_ID))
                .icon(() -> new ItemStack(LENS))
                .displayItems((params, out) -> {
                    out.accept(LENS);
                    out.accept(ALCHEMIST_FRAGMENT);
                })
                .build();
        r.accept(Alchemicraft.id("main"), TAB);
    }

    public static <T> BiConsumer<Identifier, T> direct(Registry<? super T> registry) {
        return (id, value) -> Registry.register(registry, id, value);
    }

    public static void registerAllDirect() {
        registerItems(direct(BuiltInRegistries.ITEM));
        registerCreativeTabs(direct(BuiltInRegistries.CREATIVE_MODE_TAB));
    }
}
