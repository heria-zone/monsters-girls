package net.msymbios.monsters_girls.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;

public class MonstersGirlsItemsGroup {

    // -- Variables --
    public static final ItemGroup DEFAULT_GROUP = FabricItemGroup.builder(new Identifier(MonstersGirls.MODID, "default_group"))
            .icon(() -> new ItemStack(MonstersGirlsItems.POWDER_GENESIS)).build();

} // Class MonstersGirlsItems