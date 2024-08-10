package com.modded.block;

import com.modded.OurModded;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

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
}
