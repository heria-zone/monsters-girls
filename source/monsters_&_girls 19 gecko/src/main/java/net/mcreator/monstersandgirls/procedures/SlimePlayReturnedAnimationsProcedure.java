package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.entity.Entity;

public class SlimePlayReturnedAnimationsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.isVehicle()) {
			return "ride";
		}
		return "empty";
	}
}
