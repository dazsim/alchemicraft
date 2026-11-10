package com.workshopcraft.alchemicraft.element;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.Locale;

// six base elements in opposite pairs, and the fifteen combinations of two of them
public enum Element {
    LIFE(0x55E055),
    DEATH(0x8E44AD),
    FIRE(0xFF7A1A),
    ICE(0x9FE8FF),
    CHAOS(0xD94FD9),
    STABLE(0xB8A88A),

    UNDEATH(0x6B8E4E, LIFE, DEATH),
    AIR(0xE8F4FF, FIRE, ICE),
    TRANSMUTE(0xFFD24A, CHAOS, STABLE),
    LIGHTNING(0xFFFF77, LIFE, FIRE),
    WATER(0x3F76E4, LIFE, ICE),
    MUTATION(0x9ACD32, LIFE, CHAOS),
    GROWTH(0x2EAA2E, LIFE, STABLE),
    ASH(0x8A8A8A, DEATH, FIRE),
    PRESERVE(0x6FB7C9, DEATH, ICE),
    PLAGUE(0x7A8B2A, DEATH, CHAOS),
    BONE(0xE8E2C8, DEATH, STABLE),
    BLAST(0xFF4500, FIRE, CHAOS),
    FORGE(0xC0602A, FIRE, STABLE),
    WARP(0x2E9B8A, ICE, CHAOS),
    CRYSTAL(0xC9A0FF, ICE, STABLE);

    private final int colour;
    private final Element a;
    private final Element b;

    Element(int colour) {
        this(colour, null, null);
    }

    Element(int colour, Element a, Element b) {
        this.colour = colour;
        this.a = a;
        this.b = b;
    }

    public String id() {
        return name().toLowerCase(Locale.ROOT);
    }

    public int colour() {
        return colour;
    }

    public boolean isBase() {
        return a == null;
    }

    public Element first() {
        return a;
    }

    public Element second() {
        return b;
    }

    public MutableComponent displayName() {
        return Component.translatable("element.alchemicraft." + id()).withStyle(s -> s.withColor(colour));
    }

    public static Element byId(String id) {
        for (Element e : values()) if (e.id().equals(id)) return e;
        return null;
    }
}
