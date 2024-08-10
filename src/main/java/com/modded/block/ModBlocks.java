package com.modded.block;

import com.modded.OurModded;
import com.modded.datagen.ModModelProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.data.DataProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block UNREFINED_NETHER_PEARL_BLOCK = RegisterBlock("unrefined_nether_pearl_block",
            new Block(FabricBlockSettings
                    .copyOf(Blocks.IRON_BLOCK)
                    .sounds(BlockSoundGroup.CHAIN)
                    .strength(600f)
                    .hardness(3f)
                    .requiresTool()
            ),
            true);

    public static final Block NETHER_PEARL_BLOCK = RegisterBlock("nether_pearl_block",
            new Block(FabricBlockSettings
                    .copyOf(Blocks.IRON_BLOCK)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .luminance(10)
                    .strength(600f) //Explosion proof
                    .hardness(50f) //Hard as obsidian
                    .requiresTool()
            ),
            true);


    public static final Block NETHER_PEARL_ORE = RegisterBlock("nether_pearl_ore",
    new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
            FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE)
                    .sounds(BlockSoundGroup.BASALT)
                    .strength(600f) //Explosion proof
                    .hardness(3f)
                    .requiresTool()
    ),
            true);

    //Rpublic static final egisterAllBlockTypes("nether_pearl", UNREFINED_NETHER_PEARL_BLOCK);

    public static final Block stairBlock = new StairsBlock(UNREFINED_NETHER_PEARL_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(UNREFINED_NETHER_PEARL_BLOCK));

    private static Block RegisterBlock(String name, Block block, Boolean shouldRegisterItem){
        Identifier id = Identifier.of(OurModded.MOD_ID, name);

        if (shouldRegisterItem) {
            RegisterBlockItem(name, block);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    private static Item RegisterBlockItem(String name, Block block) {
        Identifier id = Identifier.of(OurModded.MOD_ID, name);

        return Registry.register(Registries.ITEM, id,
            new BlockItem(block, new Item.Settings()));
    }


    public static void RegisterModBlocks() {
        OurModded.LOGGER.info("Registering ModBlocks for " + OurModded.MOD_ID);
    }

    // Automatic Creation of Stair, Door, Slab and Trapdoor from given block
    public static final BlockSetType DOOR_BLOCK_SET_TYPE = new BlockSetType("door");
    public static final BlockSetType TRAPDOOR_BLOCK_SET_TYPE = new BlockSetType("trapdoor");

    public static void RegisterAllBlockTypes(String materialName, Block material) {
        materialName = materialName.toLowerCase();
        // Extract the settings from the material block
        FabricBlockSettings materialSettings = FabricBlockSettings.copyOf(material);
        BlockSetType CUSTOM_WOOD_TYPE = BlockSetType.OAK;
        WoodType CUSTOM_WOOD_TYPE_GATE = WoodType.OAK;

        // Register stair block
        Block stairBlock = new StairsBlock(material.getDefaultState(), materialSettings);
        RegisterBlock(materialName + "_stairs", stairBlock, true);

        // Register slab block
        Block slabBlock = new SlabBlock(materialSettings);
        RegisterBlock(materialName + "_slab", slabBlock, true);

        // Register button block
        Block buttonBlock = new ButtonBlock(CUSTOM_WOOD_TYPE, 1, materialSettings);
        RegisterBlock(materialName + "_button", buttonBlock, true);

        // Register pressurePlate block
        Block pressurePlateBlock = new PressurePlateBlock(CUSTOM_WOOD_TYPE, materialSettings);
        RegisterBlock(materialName + "_pressure_plate", pressurePlateBlock, true);

        // Register fence block
        Block fenceBlock = new FenceBlock(materialSettings);
        RegisterBlock(materialName + "_fence", fenceBlock, true);

        // Register fence gate block
        Block fenceGateBlock = new FenceGateBlock(CUSTOM_WOOD_TYPE_GATE, materialSettings);
        RegisterBlock(materialName + "_fence_gate", fenceGateBlock, true);

        // Register door block
        Block doorBlock = new DoorBlock(CUSTOM_WOOD_TYPE, materialSettings);
        RegisterBlock(materialName + "_door", doorBlock, true);

        // Register trapdoor block
        Block trapdoorBlock = new TrapdoorBlock(CUSTOM_WOOD_TYPE, materialSettings);
        RegisterBlock(materialName + "_trapdoor", trapdoorBlock, true);
    }

    // Retrieve a block by its name
    public static Block getBlockByName(String blockName) {
        return Registries.BLOCK.get(Identifier.of("ourmodded", blockName));
    }

}
