package com.workshopcraft.alchemicraft.fabric;

import com.workshopcraft.alchemicraft.Alchemicraft;
import net.fabricmc.api.ModInitializer;

public class AlchemicraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Alchemicraft.init();
    }
}
