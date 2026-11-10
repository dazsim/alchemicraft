package com.workshopcraft.alchemicraft.neoforge;

//? if neoforge {
/*import com.workshopcraft.alchemicraft.Alchemicraft;
import com.workshopcraft.alchemicraft.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Alchemicraft.MOD_ID)
public class AlchemicraftNeoForge {
    public AlchemicraftNeoForge(IEventBus modBus) {
        modBus.addListener(AlchemicraftNeoForge::onRegister);
    }

    private static void onRegister(RegisterEvent e) {
        e.register(Registries.ITEM, h -> ModItems.registerItems(h::register));
        e.register(Registries.CREATIVE_MODE_TAB, h -> ModItems.registerCreativeTabs(h::register));
        e.register(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, h -> h.register(Alchemicraft.id("archaeology_fragment"), FragmentLootModifier.CODEC));
    }
}
*///?}
