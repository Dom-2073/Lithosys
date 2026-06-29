package net.dom2073.lithosys.datagen;

import net.dom2073.lithosys.Lithosys;
import net.dom2073.lithosys.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Lithosys.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BASALT_COPPER_ORE.get())
                .add(ModBlocks.PERIDOTITE.get())
                .add(ModBlocks.GABBRO.get())
                .add(ModBlocks.GNEISS.get())
                .add(ModBlocks.GYPSUM.get())
                .add(ModBlocks.MARBLE.get())
                .add(ModBlocks.SCHIST.get())
                .add(ModBlocks.LIMESTONE.get())
                .add(ModBlocks.CASSITERITE_ORE.get())
                .add(ModBlocks.SALT_BLOCK.get())
                .add(ModBlocks.PUMICE.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SALT_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MARBLE.get())
                .add(ModBlocks.LIMESTONE.get())
                .add(ModBlocks.SALT_BLOCK.get())
                .add(ModBlocks.GYPSUM.get())
                .add(ModBlocks.PUMICE.get())
                .add(ModBlocks.CASSITERITE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GNEISS.get())
                .add(ModBlocks.BASALT_COPPER_ORE.get())
                .add(ModBlocks.SCHIST.get())
                .add(Blocks.SMOOTH_BASALT)
                .add(ModBlocks.GABBRO.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PERIDOTITE.get());
    }

}
