package net.msymbios.monsters_girls.item.internal;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantedItem extends Item {

    // -- Constructor --
    public EnchantedItem(Settings settings) {
        super(settings);
    } // Constructor EnchantedPowderGenesis ()

    // -- Inherited Method --
    public boolean hasGlint(ItemStack stack) {
        return true;
    } // hasGlint ()

} // Class EnchantedItem