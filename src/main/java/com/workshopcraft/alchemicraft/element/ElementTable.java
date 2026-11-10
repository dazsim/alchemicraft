package com.workshopcraft.alchemicraft.element;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.workshopcraft.alchemicraft.Alchemicraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.io.Reader;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

// element values from data/<namespace>/alchemicraft/elements/*.json, read from the server's data packs and reread after /reload
public final class ElementTable {
    public static final String FOLDER = "alchemicraft/elements";

    private static ResourceManager loadedFrom;
    private static final Map<String, ElementMix> ITEMS = new HashMap<>();
    private static final Map<String, ElementMix> BLOCKS = new HashMap<>();
    private static final Map<String, ElementMix> ENTITIES = new HashMap<>();

    private ElementTable() {
    }

    public static ElementMix item(MinecraftServer server, ItemStack stack) {
        refresh(server);
        if (stack.isEmpty()) return null;
        return ITEMS.get(BuiltInRegistries.ITEM.getKey(stack.getItem()).toString());
    }

    public static ElementMix block(MinecraftServer server, BlockState state) {
        refresh(server);
        ElementMix mix = BLOCKS.get(BuiltInRegistries.BLOCK.getKey(state.getBlock()).toString());
        if (mix != null) return mix;
        return ITEMS.get(BuiltInRegistries.ITEM.getKey(state.getBlock().asItem()).toString());
    }

    public static ElementMix entity(MinecraftServer server, Entity entity) {
        refresh(server);
        if (entity instanceof ItemEntity item) return item(server, item.getItem());
        return ENTITIES.get(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString());
    }

    private static synchronized void refresh(MinecraftServer server) {
        ResourceManager manager = server.getResourceManager();
        if (manager == loadedFrom) return;
        loadedFrom = manager;
        ITEMS.clear();
        BLOCKS.clear();
        ENTITIES.clear();
        Map<Identifier, Resource> files = manager.listResources(FOLDER, id -> id.getPath().endsWith(".json"));
        files.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
            try (Reader reader = e.getValue().openAsReader()) {
                JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
                read(root, "items", ITEMS, e.getKey());
                read(root, "blocks", BLOCKS, e.getKey());
                read(root, "entities", ENTITIES, e.getKey());
            } catch (Exception ex) {
                Alchemicraft.LOGGER.error("Could not read element file {}", e.getKey(), ex);
            }
        });
        Alchemicraft.LOGGER.info("Loaded elements for {} items, {} blocks and {} entities", ITEMS.size(), BLOCKS.size(), ENTITIES.size());
    }

    private static void read(JsonObject root, String section, Map<String, ElementMix> into, Identifier file) {
        if (!root.has(section)) return;
        for (Map.Entry<String, JsonElement> entry : root.getAsJsonObject(section).entrySet()) {
            String key = entry.getKey().contains(":") ? entry.getKey() : "minecraft:" + entry.getKey();
            EnumMap<Element, Integer> amounts = new EnumMap<>(Element.class);
            for (Map.Entry<String, JsonElement> part : entry.getValue().getAsJsonObject().entrySet()) {
                Element element = Element.byId(part.getKey());
                if (element == null) {
                    Alchemicraft.LOGGER.warn("Unknown element {} for {} in {}", part.getKey(), key, file);
                    continue;
                }
                amounts.put(element, part.getValue().getAsInt());
            }
            into.put(key, new ElementMix(amounts));
        }
    }
}
