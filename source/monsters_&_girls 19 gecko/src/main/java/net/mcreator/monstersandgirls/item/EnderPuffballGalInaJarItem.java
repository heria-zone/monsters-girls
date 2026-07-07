
package net.mcreator.monstersandgirls.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.monstersandgirls.procedures.PuffballJarRightclickedOnBlockProcedure;
import net.mcreator.monstersandgirls.init.MonstersAndGirlsModTabs;

public class EnderPuffballGalInaJarItem extends Item {
	public EnderPuffballGalInaJarItem() {
		super(new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		PuffballJarRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
