package com.workshopcraft.alchemicraft.loot;

import net.minecraft.resources.Identifier;

import java.util.Map;

// alchemist's fragments turn up when brushing suspicious sand and gravel in these ruins.
// weight is set against the vanilla pool total, so a fragment comes out weight / (total + weight) of the time
public final class ArchaeologyLoot {
    public record Odds(int weight, int vanillaTotal) {
        public float chance() {
            return weight / (float) (vanillaTotal + weight);
        }
    }

    public static final Map<String, Odds> TABLES = Map.of(
            "minecraft:archaeology/desert_well", new Odds(1, 8),
            "minecraft:archaeology/desert_pyramid", new Odds(1, 8),
            "minecraft:archaeology/trail_ruins_common", new Odds(4, 45),
            "minecraft:archaeology/trail_ruins_rare", new Odds(2, 12),
            "minecraft:archaeology/ocean_ruin_warm", new Odds(2, 15),
            "minecraft:archaeology/ocean_ruin_cold", new Odds(2, 15));

    private ArchaeologyLoot() {
    }

    public static Odds odds(Identifier table) {
        return TABLES.get(table.toString());
    }
}
