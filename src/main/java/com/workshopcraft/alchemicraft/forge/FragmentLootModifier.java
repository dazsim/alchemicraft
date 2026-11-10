package com.workshopcraft.alchemicraft.forge;

//? if forge {
/*import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.workshopcraft.alchemicraft.loot.ArchaeologyLoot;
import com.workshopcraft.alchemicraft.registry.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

// swaps the brushed item for an alchemist's fragment at the same odds the Fabric pool weight gives
public class FragmentLootModifier extends LootModifier {
    public static final Codec<FragmentLootModifier> CODEC = RecordCodecBuilder.create(i -> codecStart(i).apply(i, FragmentLootModifier::new));

    public FragmentLootModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> loot, LootContext context) {
        ArchaeologyLoot.Odds odds = ArchaeologyLoot.odds(context.getQueriedLootTableId());
        if (odds == null || context.getRandom().nextFloat() >= odds.chance()) return loot;
        loot.clear();
        loot.add(new ItemStack(ModItems.ALCHEMIST_FRAGMENT));
        return loot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
*///?}
