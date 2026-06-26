package net.dom2073.lithosys.block;

import net.dom2073.lithosys.Lithosys;
import net.dom2073.lithosys.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Lithosys.MODID);

    public static final DeferredBlock<Block> LIMESTONE = registerBlock("limestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CALCITE)));

    public static final DeferredBlock<HalfTransparentBlock> GYPSUM = registerBlock("gypsum",
            () -> new HalfTransparentBlock(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
                    .noOcclusion()));

    public static final DeferredBlock<Block> PERIDOTITE =registerBlock("peridotite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> GNEISS =registerBlock("gneiss",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PUMICE =registerBlock("pumice",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.75f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CALCITE)));

    public static final DeferredBlock<Block> SALT_BLOCK =registerBlock("salt_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.75f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SAND)));

    public static final DeferredBlock<Block> GABBRO =registerBlock("gabbro",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BASALT)));

    public static final DeferredBlock<Block> SCHIST =registerBlock("schist",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BASALT)));

    public static final DeferredBlock<Block> MARBLE =registerBlock("marble",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));


    //Helper method
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
