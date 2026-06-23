package net.dom2073.lithosys;

import net.dom2073.lithosys.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
                    })
                    .build());

    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
