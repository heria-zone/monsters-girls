package net.msymbios.monsters_girls.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;

public class MonstersGirlsItemsGroup {

    // -- Variables --
    public static final ItemGroup DEFAULT_GROUP = FabricItemGroupBuilder.build(new Identifier(MonstersGirls.MODID, "default_group"), () -> new ItemStack(MonstersGirlsItems.POWDER_GENESIS));

} // Class MonstersGirlsItems