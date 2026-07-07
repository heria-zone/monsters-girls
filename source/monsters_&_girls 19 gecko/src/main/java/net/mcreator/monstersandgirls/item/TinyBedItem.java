
package net.mcreator.monstersandgirls.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.monstersandgirls.init.MonstersAndGirlsModTabs;

public class TinyBedItem extends Item {
	public TinyBedItem() {
		super(new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS).stacksTo(64).rarity(Rarity.COMMON));
	}
}
