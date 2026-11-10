package com.workshopcraft.alchemicraft;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;

public final class Alchemicraft {
    public static final String MOD_ID = "alchemicraft";
    public static final String MOD_NAME = "Alchemicraft";
    public static final Logger LOGGER = LogUtils.getLogger();

    private Alchemicraft() {
    }

    public static Identifier id(String path) {
        //? if >=1.21 {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
        //?} else {
        /*return new Identifier(MOD_ID, path);
        *///?}
    }
}
