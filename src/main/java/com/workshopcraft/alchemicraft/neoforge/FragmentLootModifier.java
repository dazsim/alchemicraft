package com.workshopcraft.alchemicraft.neoforge;

//? if neoforge {
/*import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.workshopcraft.alchemicraft.loot.ArchaeologyLoot;
import com.workshopcraft.alchemicraft.registry.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

// swaps the brushed item for an alchemist's fragment at the same odds the Fabric pool weight gives
public class FragmentLootModifier extends LootModifier {
    public static final MapCodec<FragmentLootModifier> CODEC = RecordCodecBuilder.mapCodec(i -> codecStart(i).apply(i, FragmentLootModifier::new));

    //? if >=26.3 {
    /^public FragmentLootModifier(java.util.Optional<net.minecraft.core.Holder<LootItemCondition>> condition, int priority) {
        super(condition, priority);
    }
    ^///?} else if >=26.1 {
    public FragmentLootModifier(LootItemCondition[] conditions, int priority) {
        super(conditions, priority);
    }
    //?} else {
    /^public FragmentLootModifier(LootItemCondition[] conditions) {
        super(conditions);
    }
    ^///?}

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> loot, LootContext context) {
        ArchaeologyLoot.Odds odds = ArchaeologyLoot.odds(context.getQueriedLootTableId());
        if (odds == null || context.getRandom().nextFloat() >= odds.chance()) return loot;
        loot.clear();
        loot.add(new ItemStack(ModItems.ALCHEMIST_FRAGMENT));
        return loot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
*///?}
