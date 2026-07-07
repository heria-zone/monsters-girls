package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstersandgirls.entity.GreenWispEntity;

public class GreenWispRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 18) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD) {
				if (entity instanceof GreenWispEntity) {
					((GreenWispEntity) entity).setAnimation("yipee");
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT) {
				if (entity instanceof GreenWispEntity) {
					((GreenWispEntity) entity).setAnimation("yipee");
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GOLD_NUGGET) {
				if (entity instanceof GreenWispEntity) {
					((GreenWispEntity) entity).setAnimation("yipee");
				}
			}
		}
	}
}
