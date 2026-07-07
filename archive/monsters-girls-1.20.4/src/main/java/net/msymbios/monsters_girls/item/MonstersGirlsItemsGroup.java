package net.msymbios.monsters_girls.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.common.item.InternalItemsGroup;
import net.msymbios.monsters_girls.config.MonstersGirlsID;

public class MonstersGirlsItemsGroup extends InternalItemsGroup {

    // -- Variables --

    // ITEM GROUP
    public static ItemGroup MONSTERS_GIRLS_GROUP = register(MonstersGirlsID.getId(MonstersGirlsID.DEFAULT_GROUP), registerGroup(MonstersGirlsID.TRANS_DEFAULT_ITEM_GROUP, MonstersGirlsItems.POWDER_GENESIS));

    // KEY
    public static RegistryKey<ItemGroup> MONSTERS_GIRLS_KEY = registerKey(MonstersGirlsID.getId(MonstersGirlsID.DEFAULT_GROUP));

    // -- Methods --

    public static void register () {
        MonstersGirls.LOGGER.info("Registering ItemGroups for: " + MonstersGirls.MODID);
    } // register ()

} // Class MonstersGirlsItemsGroup