package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstersandgirls.init.MonstersAndGirlsModItems;
import net.mcreator.monstersandgirls.init.MonstersAndGirlsModEntities;
import net.mcreator.monstersandgirls.entity.WarpedJarEntity;
import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

public class WarpedinjarrightclickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstersAndGirlsModItems.WARPEDGIRLINAJAR.get()) {
			if (world.isEmptyBlock(new BlockPos(x, y + 1, z))) {
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.WARPEDGIRLINAJAR.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				MonstersAndGirlsMod.queueServerWork(1, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new WarpedJarEntity(MonstersAndGirlsModEntities.WARPED_JAR.get(), _level);
						entityToSpawn.moveTo((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				});
			}
		}
	}
}
