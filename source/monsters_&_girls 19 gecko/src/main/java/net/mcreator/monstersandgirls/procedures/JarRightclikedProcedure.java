package net.mcreator.monstersandgirls.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstersandgirls.init.MonstersAndGirlsModItems;
import net.mcreator.monstersandgirls.entity.WarpedMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.WarpedMushroomGalBigSpotsEntity;
import net.mcreator.monstersandgirls.entity.SoulWandererGalEntity;
import net.mcreator.monstersandgirls.entity.RedMushromGalEntity;
import net.mcreator.monstersandgirls.entity.PoofedEndershroomEntity;
import net.mcreator.monstersandgirls.entity.MoltenMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.InkCapEntity;
import net.mcreator.monstersandgirls.entity.InfernalMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.FlyAlexgaricEntity;
import net.mcreator.monstersandgirls.entity.EnderMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.CrimsonMushroomGirlBigspotsEntity;
import net.mcreator.monstersandgirls.entity.CrimsonMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.BrownMushroomGalEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JarRightclikedProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstersAndGirlsModItems.TINY_BED.get()) {
			if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
				if (entity instanceof RedMushromGalEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.MUSHROOMGIRLINA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof CrimsonMushroomGirlBigspotsEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.CRIMSON_GIRLINA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof WarpedMushroomGalEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.WARPEDGIRLINAJAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof BrownMushroomGalEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.BROWN_MUSHROOM_GIRL_IN_A_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof InfernalMushroomGalEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.INFERNAL_MUSHROOM_GAL_INA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof EnderMushroomGalEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.ENDER_PUFFBALL_GAL_INA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof PoofedEndershroomEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.ENDER_PUFFBALL_GAL_INA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof MoltenMushroomGalEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.MOLTEN_MUSHROOM_GAL_INA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof SoulWandererGalEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.SOUL_WANDERER_MUSHROOM_GIRL_INA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof WarpedMushroomGalBigSpotsEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.RARE_WARPEDGIRLINA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof CrimsonMushroomGalEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.RARE_CRIMSON_GAL_INA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof FlyAlexgaricEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.FLY_ALEXGARIC_INA_JAR.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof InkCapEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstersAndGirlsModItems.TINY_BED.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (!entity.level.isClientSide())
						entity.discard();
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstersAndGirlsModItems.INK_CAP_MUSHROOM_GIRL_IN_BED.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}
