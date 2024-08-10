package com.modded.datagen;

import com.modded.block.ModBlocks;
import com.modded.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
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

        //registerAllWoodBlockModels(blockStateModelGenerator, ModBlocks.UNREFINED_NETHER_PEARL_BLOCK, "unrefined_nether_pearl_block");

        BlockStateModelGenerator.BlockTexturePool blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.UNREFINED_NETHER_PEARL_BLOCK);

        blockTexturePool.stairs(ModBlocks.getBlockByName("unrefined_nether_pearl_block" + "_stairs"));


        blockStateModelGenerator.registerDoor(ModBlocks.getBlockByName("unrefined_nether_pearl_block" + "_door"));
        blockStateModelGenerator.registerTrapdoor(ModBlocks.getBlockByName("unrefined_nether_pearl_block" + "_trapdoor"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NETHER_PEARL, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNREFINED_NETHER_PEARL, Models.GENERATED);

    }


    // Register models for various block types
    private void registerAllWoodBlockModels(BlockStateModelGenerator blockStateModelGenerator, Block block, String materialName) {
        // Register variants
        BlockStateModelGenerator.BlockTexturePool blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(block);

        blockTexturePool.stairs(ModBlocks.getBlockByName(materialName + "_stairs"));
        blockTexturePool.slab(ModBlocks.getBlockByName(materialName + "_slab"));
        blockTexturePool.button(ModBlocks.getBlockByName(materialName + "_button"));
        blockTexturePool.pressurePlate(ModBlocks.getBlockByName(materialName + "_pressure_plate"));
        blockTexturePool.fence(ModBlocks.getBlockByName(materialName + "_fence"));
        blockTexturePool.fenceGate(ModBlocks.getBlockByName(materialName + "_fence_gate"));

        blockStateModelGenerator.registerDoor(ModBlocks.getBlockByName(materialName + "_door"));
        blockStateModelGenerator.registerTrapdoor(ModBlocks.getBlockByName(materialName + "_trapdoor"));
    }
}
