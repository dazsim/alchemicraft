package com.workshopcraft.alchemicraft;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

// small calls that differ between the Minecraft versions this builds for
public final class Mc {
    private Mc() {
    }

    public static Item.Properties item(String name) {
        //? if >=1.21.2 {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Alchemicraft.id(name)));
        //?} else {
        /*return new Item.Properties();
        *///?}
    }

    public static MinecraftServer server(ServerPlayer player) {
        return ((ServerLevel) player.level()).getServer();
    }

    public static void overlay(ServerPlayer player, Component message) {
        //? if >=1.21.9 {
        player.sendOverlayMessage(message);
        //?} else {
        /*player.displayClientMessage(message, true);
        *///?}
    }

    public static void message(ServerPlayer player, Component message) {
        //? if >=1.21.9 {
        player.sendSystemMessage(message);
        //?} else {
        /*player.displayClientMessage(message, false);
        *///?}
    }

    public static boolean creative(Player player) {
        //? if >=1.21.2 {
        return player.hasInfiniteMaterials();
        //?} else {
        /*return player.getAbilities().instabuild;
        *///?}
    }

    // true when the player did not know the recipe before
    public static boolean learnRecipe(ServerPlayer player, Identifier id) {
        //? if >=1.21.2 {
        ResourceKey<net.minecraft.world.item.crafting.Recipe<?>> key = ResourceKey.create(Registries.RECIPE, id);
        return server(player).getRecipeManager().byKey(key).map(r -> player.awardRecipes(List.of(r)) > 0).orElse(false);
        //?} else {
        /*return server(player).getRecipeManager().byKey(id).map(r -> player.awardRecipes(List.of(r)) > 0).orElse(false);
        *///?}
    }

    public static void consume(ItemStack stack, Player player) {
        if (!creative(player)) stack.shrink(1);
    }
}
