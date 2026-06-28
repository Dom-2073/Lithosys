package net.dom2073.lithosys;

import net.dom2073.lithosys.block.ModBlocks;
import net.dom2073.lithosys.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,Lithosys.MODID);

    public static final Supplier<CreativeModeTab> LITHOSYS_BLOCK_TAB= CREATIVE_MODE_TAB.register("lithosys_block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LIMESTONE.get()))
                    .title(Component.translatable("creativetab.lithosys.lithosys_block"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.LIMESTONE);
                        output.accept(ModBlocks.GYPSUM);
                        output.accept(ModBlocks.PERIDOTITE);
                        output.accept(ModBlocks.PUMICE);
                        output.accept(ModBlocks.SALT_BLOCK);
                        output.accept(ModBlocks.GNEISS);
                        output.accept(ModBlocks.GABBRO);
                        output.accept(ModBlocks.SCHIST);
                        output.accept(ModBlocks.MARBLE);
                        output.accept(ModBlocks.BASALT_COPPER_ORE);
                        output.accept(ModBlocks.CASSITERITE_ORE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> LITHOSYS_ORES_TAB= CREATIVE_MODE_TAB.register("lithosys_ores_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SALT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Lithosys.MODID,"lithosys_block_tab"))
                    .title(Component.translatable("creativetab.lithosys.lithosys_ores"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SALT);
                        output.accept(ModItems.RAW_CASSITERITE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> LITHOSYS_INGOT_TAB= CREATIVE_MODE_TAB.register("lithosys_ingot_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Lithosys.MODID,"lithosys_ores_tab"))
                    .title(Component.translatable("creativetab.lithosys.lithosys_ores"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.CRUDE_BRONZE_INGOT);
                    })
                    .build());


    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
