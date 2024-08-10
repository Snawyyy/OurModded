package com.modded.item;

import com.modded.OurModded;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item NETHER_PEARL = registerItem("nether_pearl", new Item(new Item.Settings()));
    public static final Item UNREFINED_NETHER_PEARL = registerItem("unrefined_nether_pearl", new Item(new Item.Settings()));
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(NETHER_PEARL);
        entries.add(UNREFINED_NETHER_PEARL);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(OurModded.MOD_ID, name), item);
    }
    public static void registerModItems() {
        OurModded.LOGGER.info("Registering mod items for " + OurModded.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

    public static Item getItemByName(String itemName) {
        Identifier itemId = Identifier.of(OurModded.MOD_ID, itemName);
        return Registries.ITEM.get(itemId);
    }
}
