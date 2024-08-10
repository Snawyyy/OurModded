package com.modded.item;

import com.modded.OurModded;
import com.modded.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    // Items here will be added to the mod category in creative
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(OurModded.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ourmodded"))
                    .icon(() -> new ItemStack(ModItems.NETHER_PEARL)).entries((displayContext, entries) -> {
                        // Ores
                        entries.add(ModItems.NETHER_PEARL);
                        entries.add(ModItems.UNREFINED_NETHER_PEARL);

                        // Blocks
                        entries.add(ModBlocks.NETHER_PEARL_BLOCK);
                        entries.add(ModBlocks.NETHER_PEARL_ORE);
                        entries.add(ModBlocks.UNREFINED_NETHER_PEARL_BLOCK);

                    }).build());
    public static void registerItemGroups() {
        OurModded.LOGGER.info("Registering Item Groups");
    }
}
