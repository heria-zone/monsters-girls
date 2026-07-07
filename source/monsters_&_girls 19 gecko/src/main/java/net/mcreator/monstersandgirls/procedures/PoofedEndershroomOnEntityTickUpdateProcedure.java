package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.monstersandgirls.init.MonstersAndGirlsModEntities;
import net.mcreator.monstersandgirls.entity.StationCarpetEntity;
import net.mcreator.monstersandgirls.entity.EnderMushroomGalEntity;

import java.util.Comparator;

public class PoofedEndershroomOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double baseRate = 0;
		double rateWithAmplifier = 0;
		if (entity.isOnGround()) {
			if (!(entity instanceof Mob _mobEnt ? _mobEnt.isLeashed() : false)) {
				if (!entity.isPassenger()) {
					if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
						if (Math.random() < 0.03) {
							if (!entity.level.isClientSide())
								entity.discard();
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = new EnderMushroomGalEntity(MonstersAndGirlsModEntities.ENDER_MUSHROOM_GAL.get(), _level);
								entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
								entityToSpawn.setYBodyRot(entity.getYRot());
								entityToSpawn.setYHeadRot(entity.getYRot());
								if (entityToSpawn instanceof Mob _mobToSpawn)
									_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
								world.addFreshEntity(entityToSpawn);
							}
						}
					} else if (entity instanceof TamableAnimal _tamIsTamedBy && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
						if (Math.random() < 0.03) {
							if (!entity.level.isClientSide())
								entity.discard();
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = new EnderMushroomGalEntity(MonstersAndGirlsModEntities.ENDER_MUSHROOM_GAL.get(), _level);
								entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
								entityToSpawn.setYBodyRot(entity.getYRot());
								entityToSpawn.setYHeadRot(entity.getYRot());
								if (entityToSpawn instanceof Mob _mobToSpawn)
									_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
								world.addFreshEntity(entityToSpawn);
							}
							if (((Entity) world.getEntitiesOfClass(EnderMushroomGalEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
								_toTame.tame(_owner);
						}
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(StationCarpetEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
			entity.startRiding(((Entity) world.getEntitiesOfClass(StationCarpetEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)));
		}
	}
}
