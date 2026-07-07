package net.mcreator.monstersandgirls.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstersandgirls.entity.PoofedEndershroomEntity;

public class PoofedEndershroomOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PoofedEndershroomEntity) {
			((PoofedEndershroomEntity) entity).setAnimation("puff");
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_and_girls:enderpuffballgalpuffs")), SoundSource.AMBIENT, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_and_girls:enderpuffballgalpuffs")), SoundSource.AMBIENT, 1, 1, false);
			}
		}
		for (int index0 = 0; index0 < 1; index0++) {
			entity.setDeltaMovement(new Vec3(0, 0.1, 0));
		}
	}
}
