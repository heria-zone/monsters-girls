package net.msymbios.monsters_girls.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.item.custom.EnchantedItem;

public class ModItems {

    // -- Variables --
    public static final Item POWDER_GENESIS = registerItem("powder_genesis", new EnchantedItem(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));

    //Block of Soul Wanderer Fungus

    // -- Methods --
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MonstersGirlsMod.MODID, name), item);
    } // registerItem ()

    public static void registerModItems() {
        MonstersGirlsMod.LOGGER.debug(MonstersGirlsMod.MODID + ": Registering Items");
    } // registerModItems ()

} // Class ModItems