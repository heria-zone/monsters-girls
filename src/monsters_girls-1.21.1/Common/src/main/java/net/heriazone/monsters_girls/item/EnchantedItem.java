package net.heriazone.monsters_girls.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class EnchantedItem extends Item {

    // -- Constructor --

    public EnchantedItem(Properties properties) {
        super(properties);
    } // Constructor: EnchantedItem ()

    // -- Inherited Method --

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    } // isFoil ()

} // Class: EnchantedItem