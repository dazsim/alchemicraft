package com.workshopcraft.alchemicraft.fabric;

//? if fabric {
import com.workshopcraft.alchemicraft.loot.ArchaeologyLoot;
import com.workshopcraft.alchemicraft.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.storage.loot.entries.LootItem;
//? if >=1.20.5 {
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
//?} else {
/*import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
*///?}

public class AlchemicraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ModItems.registerAllDirect();
        //? if >=1.21.11 {
        LootTableEvents.MODIFY.register((key, table, source, registries) -> {
            ArchaeologyLoot.Odds odds = source.isBuiltin() ? ArchaeologyLoot.odds(key.identifier()) : null;
        //?} else if >=1.20.5 {
        /*LootTableEvents.MODIFY.register((key, table, source, registries) -> {
            ArchaeologyLoot.Odds odds = source.isBuiltin() ? ArchaeologyLoot.odds(key.location()) : null;
        *///?} else {
        /*LootTableEvents.MODIFY.register((resources, lootData, id, table, source) -> {
            ArchaeologyLoot.Odds odds = source.isBuiltin() ? ArchaeologyLoot.odds(id) : null;
        *///?}
            if (odds != null) table.modifyPools(pool -> pool.add(LootItem.lootTableItem(ModItems.ALCHEMIST_FRAGMENT).setWeight(odds.weight())));
        });
    }
}
//?}
