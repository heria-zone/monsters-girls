
package net.mcreator.monstersandgirls.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.monstersandgirls.procedures.InkCapMushroomGirlInBedRightclickedOnBlockProcedure;
import net.mcreator.monstersandgirls.init.MonstersAndGirlsModTabs;

public class InkCapMushroomGirlInBedItem extends Item {
	public InkCapMushroomGirlInBedItem() {
		super(new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		InkCapMushroomGirlInBedRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
