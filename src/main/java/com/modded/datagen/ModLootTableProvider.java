package com.modded.datagen;

import com.modded.block.ModBlocks;
import com.modded.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    protected ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Blocks
        addDrop((ModBlocks.NETHER_PEARL_BLOCK));
        addDrop((ModBlocks.UNREFINED_NETHER_PEARL_BLOCK));
        //AddAllWoodBlockTypesDrops("unrefined_nether_pearl_block");

        //Ores
        addDrop(ModBlocks.NETHER_PEARL_ORE,
                MultipleOreDrops(ModBlocks.NETHER_PEARL_ORE, ModItems.UNREFINED_NETHER_PEARL, 1, 3));
    }

    // Drop Functions //
    public LootTable.Builder MultipleOreDrops(Block drop, Item item, float min, float max) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ItemEntry.builder(item)
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider
                                        .create(min, max))) // Amount of drops
                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

    public void AddAllWoodBlockTypesDrops(String materialName) {
        // Retrieve each block by name and add it as a drop
        addDrop(ModBlocks.getBlockByName(materialName + "_stairs"));
        addDrop(ModBlocks.getBlockByName(materialName + "_button"));
        addDrop(ModBlocks.getBlockByName(materialName + "_pressure_plate"));
        addDrop(ModBlocks.getBlockByName(materialName + "_fence"));
        addDrop(ModBlocks.getBlockByName(materialName + "_fence_gate"));
        addDrop(ModBlocks.getBlockByName(materialName + "_trapdoor"));

        addDrop(ModBlocks.getBlockByName(materialName + "_slab"), slabDrops(ModBlocks.getBlockByName(materialName + "_slab")));
        addDrop(ModBlocks.getBlockByName(materialName + "_door"), doorDrops(ModBlocks.getBlockByName(materialName + "_door")));
    }

}
