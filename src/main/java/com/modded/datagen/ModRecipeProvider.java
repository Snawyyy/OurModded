package com.modded.datagen;

import com.modded.block.ModBlocks;
import com.modded.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.UNREFINED_NETHER_PEARL);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        //**Smelting**//
        // Nether Pearl
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.NETHER_PEARL,
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.NETHER_PEARL,
                0.7f, 100, "ruby");


        //**Compacting**//
        // Unrefined Nether Pearl Block
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.UNREFINED_NETHER_PEARL, RecipeCategory.DECORATIONS,
                ModBlocks.UNREFINED_NETHER_PEARL_BLOCK);


        //**Shaped**//
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.NETHER_PEARL_BLOCK, 1)
                .pattern("NRN")
                .pattern("RPR")
                .pattern("BBB")
                .input('N', Items.NETHERITE_INGOT)
                .input('R', Items.NETHERRACK)
                .input('P', ModItems.NETHER_PEARL)
                .input('B', Items.BLAZE_ROD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.NETHER_PEARL), FabricRecipeProvider.conditionsFromItem(ModItems.NETHER_PEARL)) // What makes it pop into the crafting book
                .offerTo(exporter, getRecipeName(ModBlocks.NETHER_PEARL_BLOCK));
    }
}
