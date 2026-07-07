package net.msymbios.monsters_girls.common.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InternalItems {

    // -- Methods --

    protected static Item register(Identifier name, Item item) {
        return Registry.register(Registries.ITEM, name, item);
    } // register ()

    protected static Item register(Identifier name, Block block) {
        return Registry.register(Registries.ITEM, name, new BlockItem(block, new FabricItemSettings()));
    } // register

} // InternalItems