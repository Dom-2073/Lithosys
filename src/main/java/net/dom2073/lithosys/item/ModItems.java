package net.dom2073.lithosys.item;

import net.dom2073.lithosys.Lithosys;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Lithosys.MODID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
