
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class MonstersAndGirlsModTabs {
	public static CreativeModeTab TAB_MONSTERS_AND_GIRLS;

	public static void load() {
		TAB_MONSTERS_AND_GIRLS = new CreativeModeTab("tabmonsters_and_girls") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MonstersAndGirlsModItems.DEBUG.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
