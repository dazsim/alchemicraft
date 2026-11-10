package com.workshopcraft.alchemicraft.element;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

// what one thing breaks down into, strongest element first
public final class ElementMix {
    private final List<Map.Entry<Element, Integer>> parts;

    public ElementMix(EnumMap<Element, Integer> amounts) {
        List<Map.Entry<Element, Integer>> list = new ArrayList<>();
        for (Map.Entry<Element, Integer> e : amounts.entrySet()) if (e.getValue() > 0) list.add(Map.entry(e.getKey(), e.getValue()));
        list.sort((x, y) -> y.getValue() != x.getValue().intValue() ? y.getValue() - x.getValue() : x.getKey().compareTo(y.getKey()));
        this.parts = Collections.unmodifiableList(list);
    }

    public List<Map.Entry<Element, Integer>> parts() {
        return parts;
    }

    public boolean isEmpty() {
        return parts.isEmpty();
    }

    public int amount(Element element) {
        for (Map.Entry<Element, Integer> e : parts) if (e.getKey() == element) return e.getValue();
        return 0;
    }

    public MutableComponent describe() {
        MutableComponent out = Component.empty();
        boolean first = true;
        for (Map.Entry<Element, Integer> e : parts) {
            if (!first) out.append(Component.literal(", ").withStyle(ChatFormatting.GRAY));
            out.append(e.getKey().displayName().append(" " + e.getValue()));
            first = false;
        }
        return out;
    }
}
