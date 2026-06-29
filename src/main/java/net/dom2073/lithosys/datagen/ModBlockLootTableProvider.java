package net.dom2073.lithosys.datagen;

import net.dom2073.lithosys.block.ModBlocks;
import net.dom2073.lithosys.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.GYPSUM.get());
        dropSelf(ModBlocks.PUMICE.get());
        dropSelf(ModBlocks.PERIDOTITE.get());
        dropSelf(ModBlocks.GNEISS.get());
        dropSelf(ModBlocks.GABBRO.get());
        dropSelf(ModBlocks.PERIDOTITE.get());
        dropSelf(ModBlocks.LIMESTONE.get());
        dropSelf(ModBlocks.SCHIST.get());
        dropSelf(ModBlocks.MARBLE.get());

        add(ModBlocks.CASSITERITE_ORE.get(),
                block -> createOreDrop(ModBlocks.CASSITERITE_ORE.get(), ModItems.RAW_CASSITERITE.get()));

        add(ModBlocks.BASALT_COPPER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BASALT_COPPER_ORE.get(), Items.RAW_COPPER,2f,5f));

        add(ModBlocks.SALT_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.SALT_BLOCK.get(),ModItems.SALT.get(),4,4));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float min_Drops, float max_Drops){
        HolderLookup.RegistryLookup<Enchantment> registryLookup= this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,LootItem.lootTableItem(Items.RAW_COPPER)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min_Drops,max_Drops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
