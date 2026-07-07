package net.msymbios.monsters_girls.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirlsMod;

public class ModItemsGroup {

    // -- Variables --
    public static final ItemGroup MONSTERS_GIRLS = FabricItemGroupBuilder.build(new Identifier(MonstersGirlsMod.MODID, "mod_group"), () -> new ItemStack(ModItems.ITEM_GROUP_ICON));

} // Class ModItemsGroup