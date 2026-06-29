package net.dom2073.lithosys.datagen;

import net.dom2073.lithosys.Lithosys;
import net.dom2073.lithosys.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Lithosys.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SALT_BLOCK);
        blockWithItem(ModBlocks.BASALT_COPPER_ORE);
        blockWithItem(ModBlocks.CASSITERITE_ORE);
        blockWithItem(ModBlocks.GABBRO);
        blockWithItem(ModBlocks.GNEISS);
        blockWithItem(ModBlocks.GYPSUM);
        blockWithItem(ModBlocks.LIMESTONE);
        blockWithItem(ModBlocks.MARBLE);
        blockWithItem(ModBlocks.PUMICE);
        blockWithItem(ModBlocks.SCHIST);
        blockWithItem(ModBlocks.PERIDOTITE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock ){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
