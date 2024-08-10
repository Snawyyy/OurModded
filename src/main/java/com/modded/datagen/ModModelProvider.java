package com.modded.datagen;

import com.modded.block.ModBlocks;
import com.modded.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PEARL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PEARL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNREFINED_NETHER_PEARL_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NETHER_PEARL, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNREFINED_NETHER_PEARL, Models.GENERATED);

    }
}
