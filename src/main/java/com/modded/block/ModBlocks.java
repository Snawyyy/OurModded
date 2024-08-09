package com.modded.block;

import com.modded.OurModded;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RUBY_BLOCK = RegisterBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .luminance(1)
                    .requiresTool()
            ),
            true);

    public static final Block RUBY_ORE = RegisterBlock("ruby_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_COPPER_BLOCK).sounds(BlockSoundGroup.CHAIN)),
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
