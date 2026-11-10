package com.workshopcraft.alchemicraft.forge;

//? if forge {
/*import com.workshopcraft.alchemicraft.Alchemicraft;
import com.workshopcraft.alchemicraft.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Alchemicraft.MOD_ID)
public class AlchemicraftForge {
    public AlchemicraftForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(AlchemicraftForge::onRegister);
    }

    private static void onRegister(RegisterEvent e) {
        e.register(Registries.ITEM, h -> ModItems.registerItems(h::register));
        e.register(Registries.CREATIVE_MODE_TAB, h -> ModItems.registerCreativeTabs(h::register));
        e.register(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, h -> h.register(Alchemicraft.id("archaeology_fragment"), FragmentLootModifier.CODEC));
    }
}
*///?}
