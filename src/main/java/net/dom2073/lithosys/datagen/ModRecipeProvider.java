package net.dom2073.lithosys.datagen;

import net.dom2073.lithosys.Lithosys;
import net.dom2073.lithosys.block.ModBlocks;
import net.dom2073.lithosys.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> COPPER_SMELTABLE= List.of(ModBlocks.BASALT_COPPER_ORE);
        List<ItemLike> TIN_SMELTABLE= List.of(ModItems.RAW_CASSITERITE,ModBlocks.CASSITERITE_ORE);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SALT_BLOCK)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.SALT.get())
                .unlockedBy("has_salt",has(ModItems.SALT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ModItems.SALT,4)
                .unlockedBy("has_salt_block", has(ModBlocks.SALT_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput,COPPER_SMELTABLE,RecipeCategory.MISC, Items.COPPER_INGOT,0.7f,200,"copper_ingot");
        oreSmelting(recipeOutput,TIN_SMELTABLE,RecipeCategory.MISC, ModItems.TIN_INGOT.get(),0.75f,200,"tin_ingot");
        oreBlasting(recipeOutput,COPPER_SMELTABLE,RecipeCategory.MISC, Items.COPPER_INGOT,0.7f,100,"copper_ingot");
        oreBlasting(recipeOutput,TIN_SMELTABLE,RecipeCategory.MISC, ModItems.TIN_INGOT.get(),0.75f,100,"tin_ingot");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,String pGroup){
        oreCooking(recipeOutput,RecipeSerializer.SMELTING_RECIPE,SmeltingRecipe::new,pIngredients,pCategory,pResult,pExperience,pCookingTime,pGroup,"_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,String pGroup){
        oreCooking(recipeOutput,RecipeSerializer.BLASTING_RECIPE,BlastingRecipe::new,pIngredients,pCategory,pResult,pExperience,pCookingTime,pGroup,"_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,String pGroup,String pRecipeName){
        for(ItemLike itemLike : pIngredients){
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory,pResult,pExperience,pCookingTime,pCookingSerializer,factory).group(pGroup).unlockedBy(getHasName(itemLike),has(itemLike))
                    .save(recipeOutput,Lithosys.MODID + ":" + getItemName(pResult) + pRecipeName + "_"+ getItemName(itemLike));
        }
    }
}
