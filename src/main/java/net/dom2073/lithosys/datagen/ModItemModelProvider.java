package net.dom2073.lithosys.datagen;

import net.dom2073.lithosys.Lithosys;
import net.dom2073.lithosys.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Lithosys.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SALT.get());
        basicItem(ModItems.RAW_CASSITERITE.get());
        basicItem(ModItems.TIN_INGOT.get());
        basicItem(ModItems.CRUDE_BRONZE_INGOT.get());
    }
}
