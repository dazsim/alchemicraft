package com.workshopcraft.alchemicraft;

//? if fabric {
import net.fabricmc.api.ModInitializer;

public class AlchemicraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Alchemicraft.init();
    }
}
//?}
