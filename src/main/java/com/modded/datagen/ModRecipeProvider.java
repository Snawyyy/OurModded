package com.modded.datagen;

import com.modded.block.ModBlocks;
import com.modded.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //**Smelting**//
        //Nether_Pearl
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 100, "ruby");

        //**Compacting**//
        /*
        exemple:
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_RUBY_BLOCK);
        */

        //**Shaped**//
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK, 1)
                .pattern("NRN")
                .pattern("RPR")
                .pattern("BBB")
                .input('N', Items.NETHERITE_INGOT)
                .input('R', Items.NETHERRACK)
                .input('P', ModItems.RUBY)
                .input('B', Items.BLAZE_ROD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromItem(ModItems.RUBY)) // What makes it pop into the crafting book
                .offerTo(exporter, getRecipeName(ModBlocks.RUBY_BLOCK));
    }
}
