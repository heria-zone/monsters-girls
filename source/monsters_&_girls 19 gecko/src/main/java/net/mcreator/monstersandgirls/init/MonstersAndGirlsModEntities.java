
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstersandgirls.entity.YellowWispEntity;
import net.mcreator.monstersandgirls.entity.WarpedMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.WarpedMushroomGalBigSpotsEntity;
import net.mcreator.monstersandgirls.entity.WarpedJarEntity;
import net.mcreator.monstersandgirls.entity.StationCarpetEntity;
import net.mcreator.monstersandgirls.entity.SpookEntity;
import net.mcreator.monstersandgirls.entity.SoulWandererJarEntity;
import net.mcreator.monstersandgirls.entity.SoulWandererGalEntity;
import net.mcreator.monstersandgirls.entity.RedMushromGalEntity;
import net.mcreator.monstersandgirls.entity.RedJarEntity;
import net.mcreator.monstersandgirls.entity.RareWarpedJarEntity;
import net.mcreator.monstersandgirls.entity.RareCrimsonJarEntity;
import net.mcreator.monstersandgirls.entity.PuffballJarEntity;
import net.mcreator.monstersandgirls.entity.PoofedEndershroomEntity;
import net.mcreator.monstersandgirls.entity.PeachEntity;
import net.mcreator.monstersandgirls.entity.MoltenMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.MoltenJarEntity;
import net.mcreator.monstersandgirls.entity.InkCapEntity;
import net.mcreator.monstersandgirls.entity.InkCapBedEntity;
import net.mcreator.monstersandgirls.entity.InfernalMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.InfernalJarEntity;
import net.mcreator.monstersandgirls.entity.GreenWispEntity;
import net.mcreator.monstersandgirls.entity.GreenMandrakeEntity;
import net.mcreator.monstersandgirls.entity.FruityMandrakeEntity;
import net.mcreator.monstersandgirls.entity.FlyAlexgaricEntity;
import net.mcreator.monstersandgirls.entity.EnderMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.CrimsonMushroomGirlBigspotsEntity;
import net.mcreator.monstersandgirls.entity.CrimsonMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.CrimsonJarEntity;
import net.mcreator.monstersandgirls.entity.BrownMushroomGalEntity;
import net.mcreator.monstersandgirls.entity.BrownMandragoraEntity;
import net.mcreator.monstersandgirls.entity.BrownJarEntity;
import net.mcreator.monstersandgirls.entity.BlueWispEntity;
import net.mcreator.monstersandgirls.entity.BlueSlimeGirlEntity;
import net.mcreator.monstersandgirls.entity.BeeGirlWorkerEntity;
import net.mcreator.monstersandgirls.entity.AlexJarEntity;
import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MonstersAndGirlsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MonstersAndGirlsMod.MODID);
	public static final RegistryObject<EntityType<FruityMandrakeEntity>> FRUITY_MANDRAKE = register("fruity_mandrake",
			EntityType.Builder.<FruityMandrakeEntity>of(FruityMandrakeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FruityMandrakeEntity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<StationCarpetEntity>> STATION_CARPET = register("station_carpet", EntityType.Builder.<StationCarpetEntity>of(StationCarpetEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StationCarpetEntity::new).fireImmune().sized(1f, 0.06f));
	public static final RegistryObject<EntityType<BeeGirlWorkerEntity>> BEE_GIRL_WORKER = register("bee_girl_worker",
			EntityType.Builder.<BeeGirlWorkerEntity>of(BeeGirlWorkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BeeGirlWorkerEntity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<BrownMushroomGalEntity>> BROWN_MUSHROOM_GAL = register("brown_mushroom_gal",
			EntityType.Builder.<BrownMushroomGalEntity>of(BrownMushroomGalEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BrownMushroomGalEntity::new)

					.sized(0.7f, 1.1f));
	public static final RegistryObject<EntityType<MoltenMushroomGalEntity>> MOLTEN_MUSHROOM_GAL = register("molten_mushroom_gal", EntityType.Builder.<MoltenMushroomGalEntity>of(MoltenMushroomGalEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MoltenMushroomGalEntity::new).fireImmune().sized(0.7f, 1.1f));
	public static final RegistryObject<EntityType<EnderMushroomGalEntity>> ENDER_MUSHROOM_GAL = register("ender_mushroom_gal",
			EntityType.Builder.<EnderMushroomGalEntity>of(EnderMushroomGalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EnderMushroomGalEntity::new)

					.sized(0.7f, 1.1f));
	public static final RegistryObject<EntityType<InfernalMushroomGalEntity>> INFERNAL_MUSHROOM_GAL = register("infernal_mushroom_gal", EntityType.Builder.<InfernalMushroomGalEntity>of(InfernalMushroomGalEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InfernalMushroomGalEntity::new).fireImmune().sized(0.7f, 1.1f));
	public static final RegistryObject<EntityType<SpookEntity>> SPOOK = register("spook",
			EntityType.Builder.<SpookEntity>of(SpookEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpookEntity::new).fireImmune().sized(0.8f, 1.18f));
	public static final RegistryObject<EntityType<PoofedEndershroomEntity>> POOFED_ENDERSHROOM = register("poofed_endershroom",
			EntityType.Builder.<PoofedEndershroomEntity>of(PoofedEndershroomEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PoofedEndershroomEntity::new)

					.sized(0.7f, 1.1f));
	public static final RegistryObject<EntityType<InkCapEntity>> INK_CAP = register("ink_cap",
			EntityType.Builder.<InkCapEntity>of(InkCapEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InkCapEntity::new)

					.sized(0.7f, 1.44f));
	public static final RegistryObject<EntityType<RedMushromGalEntity>> RED_MUSHROM_GAL = register("red_mushrom_gal",
			EntityType.Builder.<RedMushromGalEntity>of(RedMushromGalEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RedMushromGalEntity::new)

					.sized(0.7f, 1.1f));
	public static final RegistryObject<EntityType<WarpedMushroomGalEntity>> WARPED_MUSHROOM_GAL = register("warped_mushroom_gal", EntityType.Builder.<WarpedMushroomGalEntity>of(WarpedMushroomGalEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WarpedMushroomGalEntity::new).fireImmune().sized(0.6f, 1f));
	public static final RegistryObject<EntityType<WarpedMushroomGalBigSpotsEntity>> WARPED_MUSHROOM_GAL_BIG_SPOTS = register("warped_mushroom_gal_big_spots",
			EntityType.Builder.<WarpedMushroomGalBigSpotsEntity>of(WarpedMushroomGalBigSpotsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(WarpedMushroomGalBigSpotsEntity::new).fireImmune().sized(0.7f, 1f));
	public static final RegistryObject<EntityType<CrimsonMushroomGirlBigspotsEntity>> CRIMSON_MUSHROOM_GIRL_BIGSPOTS = register("crimson_mushroom_girl_bigspots",
			EntityType.Builder.<CrimsonMushroomGirlBigspotsEntity>of(CrimsonMushroomGirlBigspotsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(CrimsonMushroomGirlBigspotsEntity::new).fireImmune().sized(0.7f, 1.25f));
	public static final RegistryObject<EntityType<CrimsonMushroomGalEntity>> CRIMSON_MUSHROOM_GAL = register("crimson_mushroom_gal", EntityType.Builder.<CrimsonMushroomGalEntity>of(CrimsonMushroomGalEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrimsonMushroomGalEntity::new).fireImmune().sized(0.7f, 1.25f));
	public static final RegistryObject<EntityType<SoulWandererGalEntity>> SOUL_WANDERER_GAL = register("soul_wanderer_gal", EntityType.Builder.<SoulWandererGalEntity>of(SoulWandererGalEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SoulWandererGalEntity::new).fireImmune().sized(0.7f, 1.25f));
	public static final RegistryObject<EntityType<FlyAlexgaricEntity>> FLY_ALEXGARIC = register("fly_alexgaric",
			EntityType.Builder.<FlyAlexgaricEntity>of(FlyAlexgaricEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlyAlexgaricEntity::new)

					.sized(0.7f, 1f));
	public static final RegistryObject<EntityType<PeachEntity>> PEACH = register("peach",
			EntityType.Builder.<PeachEntity>of(PeachEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PeachEntity::new).fireImmune().sized(0.8f, 1.18f));
	public static final RegistryObject<EntityType<BlueWispEntity>> BLUE_WISP = register("blue_wisp",
			EntityType.Builder.<BlueWispEntity>of(BlueWispEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlueWispEntity::new).fireImmune().sized(0.5f, 0.7f));
	public static final RegistryObject<EntityType<GreenWispEntity>> GREEN_WISP = register("green_wisp", EntityType.Builder.<GreenWispEntity>of(GreenWispEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(GreenWispEntity::new).fireImmune().sized(0.5f, 0.7f));
	public static final RegistryObject<EntityType<YellowWispEntity>> YELLOW_WISP = register("yellow_wisp", EntityType.Builder.<YellowWispEntity>of(YellowWispEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(YellowWispEntity::new).fireImmune().sized(0.5f, 0.7f));
	public static final RegistryObject<EntityType<BlueSlimeGirlEntity>> BLUE_SLIME_GIRL = register("blue_slime_girl",
			EntityType.Builder.<BlueSlimeGirlEntity>of(BlueSlimeGirlEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlueSlimeGirlEntity::new)

					.sized(1f, 2f));
	public static final RegistryObject<EntityType<GreenMandrakeEntity>> GREEN_MANDRAKE = register("green_mandrake",
			EntityType.Builder.<GreenMandrakeEntity>of(GreenMandrakeEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GreenMandrakeEntity::new)

					.sized(0.5f, 0.9f));
	public static final RegistryObject<EntityType<BrownMandragoraEntity>> BROWN_MANDRAGORA = register("brown_mandragora",
			EntityType.Builder.<BrownMandragoraEntity>of(BrownMandragoraEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BrownMandragoraEntity::new)

					.sized(0.6f, 0.9f));
	public static final RegistryObject<EntityType<RedJarEntity>> RED_JAR = register("red_jar",
			EntityType.Builder.<RedJarEntity>of(RedJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RedJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<WarpedJarEntity>> WARPED_JAR = register("warped_jar",
			EntityType.Builder.<WarpedJarEntity>of(WarpedJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WarpedJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<CrimsonJarEntity>> CRIMSON_JAR = register("crimson_jar",
			EntityType.Builder.<CrimsonJarEntity>of(CrimsonJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrimsonJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<SoulWandererJarEntity>> SOUL_WANDERER_JAR = register("soul_wanderer_jar", EntityType.Builder.<SoulWandererJarEntity>of(SoulWandererJarEntity::new, MobCategory.AMBIENT)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SoulWandererJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<RareWarpedJarEntity>> RARE_WARPED_JAR = register("rare_warped_jar", EntityType.Builder.<RareWarpedJarEntity>of(RareWarpedJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RareWarpedJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<AlexJarEntity>> ALEX_JAR = register("alex_jar",
			EntityType.Builder.<AlexJarEntity>of(AlexJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AlexJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<RareCrimsonJarEntity>> RARE_CRIMSON_JAR = register("rare_crimson_jar", EntityType.Builder.<RareCrimsonJarEntity>of(RareCrimsonJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RareCrimsonJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<InkCapBedEntity>> INK_CAP_BED = register("ink_cap_bed",
			EntityType.Builder.<InkCapBedEntity>of(InkCapBedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InkCapBedEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<BrownJarEntity>> BROWN_JAR = register("brown_jar",
			EntityType.Builder.<BrownJarEntity>of(BrownJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BrownJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<PuffballJarEntity>> PUFFBALL_JAR = register("puffball_jar", EntityType.Builder.<PuffballJarEntity>of(PuffballJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PuffballJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<InfernalJarEntity>> INFERNAL_JAR = register("infernal_jar", EntityType.Builder.<InfernalJarEntity>of(InfernalJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InfernalJarEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<MoltenJarEntity>> MOLTEN_JAR = register("molten_jar",
			EntityType.Builder.<MoltenJarEntity>of(MoltenJarEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MoltenJarEntity::new).fireImmune().sized(1f, 1f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			FruityMandrakeEntity.init();
			StationCarpetEntity.init();
			BeeGirlWorkerEntity.init();
			BrownMushroomGalEntity.init();
			MoltenMushroomGalEntity.init();
			EnderMushroomGalEntity.init();
			InfernalMushroomGalEntity.init();
			SpookEntity.init();
			PoofedEndershroomEntity.init();
			InkCapEntity.init();
			RedMushromGalEntity.init();
			WarpedMushroomGalEntity.init();
			WarpedMushroomGalBigSpotsEntity.init();
			CrimsonMushroomGirlBigspotsEntity.init();
			CrimsonMushroomGalEntity.init();
			SoulWandererGalEntity.init();
			FlyAlexgaricEntity.init();
			PeachEntity.init();
			BlueWispEntity.init();
			GreenWispEntity.init();
			YellowWispEntity.init();
			BlueSlimeGirlEntity.init();
			GreenMandrakeEntity.init();
			BrownMandragoraEntity.init();
			RedJarEntity.init();
			WarpedJarEntity.init();
			CrimsonJarEntity.init();
			SoulWandererJarEntity.init();
			RareWarpedJarEntity.init();
			AlexJarEntity.init();
			RareCrimsonJarEntity.init();
			InkCapBedEntity.init();
			BrownJarEntity.init();
			PuffballJarEntity.init();
			InfernalJarEntity.init();
			MoltenJarEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(FRUITY_MANDRAKE.get(), FruityMandrakeEntity.createAttributes().build());
		event.put(STATION_CARPET.get(), StationCarpetEntity.createAttributes().build());
		event.put(BEE_GIRL_WORKER.get(), BeeGirlWorkerEntity.createAttributes().build());
		event.put(BROWN_MUSHROOM_GAL.get(), BrownMushroomGalEntity.createAttributes().build());
		event.put(MOLTEN_MUSHROOM_GAL.get(), MoltenMushroomGalEntity.createAttributes().build());
		event.put(ENDER_MUSHROOM_GAL.get(), EnderMushroomGalEntity.createAttributes().build());
		event.put(INFERNAL_MUSHROOM_GAL.get(), InfernalMushroomGalEntity.createAttributes().build());
		event.put(SPOOK.get(), SpookEntity.createAttributes().build());
		event.put(POOFED_ENDERSHROOM.get(), PoofedEndershroomEntity.createAttributes().build());
		event.put(INK_CAP.get(), InkCapEntity.createAttributes().build());
		event.put(RED_MUSHROM_GAL.get(), RedMushromGalEntity.createAttributes().build());
		event.put(WARPED_MUSHROOM_GAL.get(), WarpedMushroomGalEntity.createAttributes().build());
		event.put(WARPED_MUSHROOM_GAL_BIG_SPOTS.get(), WarpedMushroomGalBigSpotsEntity.createAttributes().build());
		event.put(CRIMSON_MUSHROOM_GIRL_BIGSPOTS.get(), CrimsonMushroomGirlBigspotsEntity.createAttributes().build());
		event.put(CRIMSON_MUSHROOM_GAL.get(), CrimsonMushroomGalEntity.createAttributes().build());
		event.put(SOUL_WANDERER_GAL.get(), SoulWandererGalEntity.createAttributes().build());
		event.put(FLY_ALEXGARIC.get(), FlyAlexgaricEntity.createAttributes().build());
		event.put(PEACH.get(), PeachEntity.createAttributes().build());
		event.put(BLUE_WISP.get(), BlueWispEntity.createAttributes().build());
		event.put(GREEN_WISP.get(), GreenWispEntity.createAttributes().build());
		event.put(YELLOW_WISP.get(), YellowWispEntity.createAttributes().build());
		event.put(BLUE_SLIME_GIRL.get(), BlueSlimeGirlEntity.createAttributes().build());
		event.put(GREEN_MANDRAKE.get(), GreenMandrakeEntity.createAttributes().build());
		event.put(BROWN_MANDRAGORA.get(), BrownMandragoraEntity.createAttributes().build());
		event.put(RED_JAR.get(), RedJarEntity.createAttributes().build());
		event.put(WARPED_JAR.get(), WarpedJarEntity.createAttributes().build());
		event.put(CRIMSON_JAR.get(), CrimsonJarEntity.createAttributes().build());
		event.put(SOUL_WANDERER_JAR.get(), SoulWandererJarEntity.createAttributes().build());
		event.put(RARE_WARPED_JAR.get(), RareWarpedJarEntity.createAttributes().build());
		event.put(ALEX_JAR.get(), AlexJarEntity.createAttributes().build());
		event.put(RARE_CRIMSON_JAR.get(), RareCrimsonJarEntity.createAttributes().build());
		event.put(INK_CAP_BED.get(), InkCapBedEntity.createAttributes().build());
		event.put(BROWN_JAR.get(), BrownJarEntity.createAttributes().build());
		event.put(PUFFBALL_JAR.get(), PuffballJarEntity.createAttributes().build());
		event.put(INFERNAL_JAR.get(), InfernalJarEntity.createAttributes().build());
		event.put(MOLTEN_JAR.get(), MoltenJarEntity.createAttributes().build());
	}
}
