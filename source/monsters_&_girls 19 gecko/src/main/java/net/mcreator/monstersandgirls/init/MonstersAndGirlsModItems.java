
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.monstersandgirls.item.YellowAgaricCapItem;
import net.mcreator.monstersandgirls.item.WarpedgirlinajarItem;
import net.mcreator.monstersandgirls.item.WarpedFungusHatItem;
import net.mcreator.monstersandgirls.item.TinyBedItem;
import net.mcreator.monstersandgirls.item.SpectralCakeItem;
import net.mcreator.monstersandgirls.item.SoulWandererMushroomGirlInaJarItem;
import net.mcreator.monstersandgirls.item.SoulWandererHatItem;
import net.mcreator.monstersandgirls.item.RedStationCarpetItem;
import net.mcreator.monstersandgirls.item.RedMushroomHatItem;
import net.mcreator.monstersandgirls.item.RareWarpedgirlinaJarItem;
import net.mcreator.monstersandgirls.item.RareCrimsonGalInaJarItem;
import net.mcreator.monstersandgirls.item.MushroomgirlinaJarItem;
import net.mcreator.monstersandgirls.item.MoltenMushroomGalInaJarItem;
import net.mcreator.monstersandgirls.item.MoltenFungusHatItem;
import net.mcreator.monstersandgirls.item.MizunoWarpedHatItem;
import net.mcreator.monstersandgirls.item.MizunoCrimsonHatItem;
import net.mcreator.monstersandgirls.item.InkCapMushroomGirlInBedItem;
import net.mcreator.monstersandgirls.item.InkCapHatItem;
import net.mcreator.monstersandgirls.item.InfernalMushroomGalInaJarItem;
import net.mcreator.monstersandgirls.item.InfernaMushroomHatItem;
import net.mcreator.monstersandgirls.item.GenesisPowderItem;
import net.mcreator.monstersandgirls.item.FlyAlexgaricInaJarItem;
import net.mcreator.monstersandgirls.item.EnderPuffballHatItem;
import net.mcreator.monstersandgirls.item.EnderPuffballGalInaJarItem;
import net.mcreator.monstersandgirls.item.DebugItem;
import net.mcreator.monstersandgirls.item.CrimsonHatItem;
import net.mcreator.monstersandgirls.item.CrimsonGirlinaJarItem;
import net.mcreator.monstersandgirls.item.BrownMushroomHatItem;
import net.mcreator.monstersandgirls.item.BrownMushroomGirlInAJarItem;
import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

public class MonstersAndGirlsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MonstersAndGirlsMod.MODID);
	public static final RegistryObject<Item> CRIMSON_HAT_HELMET = REGISTRY.register("crimson_hat_helmet", () -> new CrimsonHatItem.Helmet());
	public static final RegistryObject<Item> MIZUNO_CRIMSON_HAT_HELMET = REGISTRY.register("mizuno_crimson_hat_helmet", () -> new MizunoCrimsonHatItem.Helmet());
	public static final RegistryObject<Item> INK_CAP_HAT_HELMET = REGISTRY.register("ink_cap_hat_helmet", () -> new InkCapHatItem.Helmet());
	public static final RegistryObject<Item> BROWN_MUSHROOM_HAT_HELMET = REGISTRY.register("brown_mushroom_hat_helmet", () -> new BrownMushroomHatItem.Helmet());
	public static final RegistryObject<Item> RED_MUSHROOM_HAT_HELMET = REGISTRY.register("red_mushroom_hat_helmet", () -> new RedMushroomHatItem.Helmet());
	public static final RegistryObject<Item> YELLOW_AGARIC_CAP_HELMET = REGISTRY.register("yellow_agaric_cap_helmet", () -> new YellowAgaricCapItem.Helmet());
	public static final RegistryObject<Item> INFERNA_MUSHROOM_HAT_HELMET = REGISTRY.register("inferna_mushroom_hat_helmet", () -> new InfernaMushroomHatItem.Helmet());
	public static final RegistryObject<Item> WARPED_FUNGUS_HAT_HELMET = REGISTRY.register("warped_fungus_hat_helmet", () -> new WarpedFungusHatItem.Helmet());
	public static final RegistryObject<Item> MIZUNO_WARPED_HAT_HELMET = REGISTRY.register("mizuno_warped_hat_helmet", () -> new MizunoWarpedHatItem.Helmet());
	public static final RegistryObject<Item> MOLTEN_FUNGUS_HAT_HELMET = REGISTRY.register("molten_fungus_hat_helmet", () -> new MoltenFungusHatItem.Helmet());
	public static final RegistryObject<Item> SOUL_WANDERER_HAT_HELMET = REGISTRY.register("soul_wanderer_hat_helmet", () -> new SoulWandererHatItem.Helmet());
	public static final RegistryObject<Item> ENDER_PUFFBALL_HAT_HELMET = REGISTRY.register("ender_puffball_hat_helmet", () -> new EnderPuffballHatItem.Helmet());
	public static final RegistryObject<Item> HUGE_CRIMSON_FUNGUS = block(MonstersAndGirlsModBlocks.HUGE_CRIMSON_FUNGUS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_PURPLE = block(MonstersAndGirlsModBlocks.HUGE_PURPLE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_INKY_CAP = block(MonstersAndGirlsModBlocks.HUGE_INKY_CAP, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_BROWN_MUSHROOM = block(MonstersAndGirlsModBlocks.HUGE_BROWN_MUSHROOM, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_TOADSTOOL = block(MonstersAndGirlsModBlocks.HUGE_TOADSTOOL, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_INFERNAL_MUSHROOM = block(MonstersAndGirlsModBlocks.HUGE_INFERNAL_MUSHROOM, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> YELLOW_FLY_AGARIC_HUGE = block(MonstersAndGirlsModBlocks.YELLOW_FLY_AGARIC_HUGE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_WARPED_FUNGUS = block(MonstersAndGirlsModBlocks.HUGE_WARPED_FUNGUS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_GREEN = block(MonstersAndGirlsModBlocks.HUGE_GREEN, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_MAGMA_FUNGUS = block(MonstersAndGirlsModBlocks.HUGE_MAGMA_FUNGUS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_SOUL_WANDERER = block(MonstersAndGirlsModBlocks.HUGE_SOUL_WANDERER, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> HUGE_ENDER_PUFFBALL = block(MonstersAndGirlsModBlocks.HUGE_ENDER_PUFFBALL, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> JAR_TERRARIUM = block(MonstersAndGirlsModBlocks.JAR_TERRARIUM, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> CRIMSON_GIRLINA_JAR = REGISTRY.register("crimson_girlina_jar", () -> new CrimsonGirlinaJarItem());
	public static final RegistryObject<Item> RARE_CRIMSON_GAL_INA_JAR = REGISTRY.register("rare_crimson_gal_ina_jar", () -> new RareCrimsonGalInaJarItem());
	public static final RegistryObject<Item> BROWN_MUSHROOM_GIRL_IN_A_JAR = REGISTRY.register("brown_mushroom_girl_in_a_jar", () -> new BrownMushroomGirlInAJarItem());
	public static final RegistryObject<Item> MUSHROOMGIRLINA_JAR = REGISTRY.register("mushroomgirlina_jar", () -> new MushroomgirlinaJarItem());
	public static final RegistryObject<Item> FLY_ALEXGARIC_INA_JAR = REGISTRY.register("fly_alexgaric_ina_jar", () -> new FlyAlexgaricInaJarItem());
	public static final RegistryObject<Item> INFERNAL_MUSHROOM_GAL_INA_JAR = REGISTRY.register("infernal_mushroom_gal_ina_jar", () -> new InfernalMushroomGalInaJarItem());
	public static final RegistryObject<Item> WARPEDGIRLINAJAR = REGISTRY.register("warpedgirlinajar", () -> new WarpedgirlinajarItem());
	public static final RegistryObject<Item> RARE_WARPEDGIRLINA_JAR = REGISTRY.register("rare_warpedgirlina_jar", () -> new RareWarpedgirlinaJarItem());
	public static final RegistryObject<Item> MOLTEN_MUSHROOM_GAL_INA_JAR = REGISTRY.register("molten_mushroom_gal_ina_jar", () -> new MoltenMushroomGalInaJarItem());
	public static final RegistryObject<Item> SOUL_WANDERER_MUSHROOM_GIRL_INA_JAR = REGISTRY.register("soul_wanderer_mushroom_girl_ina_jar", () -> new SoulWandererMushroomGirlInaJarItem());
	public static final RegistryObject<Item> ENDER_PUFFBALL_GAL_INA_JAR = REGISTRY.register("ender_puffball_gal_ina_jar", () -> new EnderPuffballGalInaJarItem());
	public static final RegistryObject<Item> INKCAP_1 = block(MonstersAndGirlsModBlocks.INKCAP_1, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> INKCAP_2 = block(MonstersAndGirlsModBlocks.INKCAP_2, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> INKCAP_3 = block(MonstersAndGirlsModBlocks.INKCAP_3, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> INK_CAP_MUSHROOM = block(MonstersAndGirlsModBlocks.INK_CAP_MUSHROOM, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> BLOCKOF_ENDER_PUFFBAL = block(MonstersAndGirlsModBlocks.BLOCKOF_ENDER_PUFFBAL, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_SHROOMLIGHT = block(MonstersAndGirlsModBlocks.ENDER_SHROOMLIGHT, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_MUSHROOM_STEM = block(MonstersAndGirlsModBlocks.ENDER_MUSHROOM_STEM, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_PLANKS = block(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_PLANKS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_STAIRS = block(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_STAIRS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_SLAB = block(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_SLAB, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_FENCE = block(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_FENCE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_GATE = block(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_GATE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_PLATE = block(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_PLATE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_BUTTON = block(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_BUTTON, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_DOORS = doubleBlock(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_DOORS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_PUFFBALL_TRAPDOOR = block(MonstersAndGirlsModBlocks.ENDER_PUFFBALL_TRAPDOOR, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> END_PUFFBALL = block(MonstersAndGirlsModBlocks.END_PUFFBALL, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> ENDER_MOSS = block(MonstersAndGirlsModBlocks.ENDER_MOSS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_BLOCK = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_BLOCK, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOULLIGHT = block(MonstersAndGirlsModBlocks.SOULLIGHT, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_STEM = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_STEM, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_PLANKS = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_PLANKS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_STAIRS = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_STAIRS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_SLABS = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_SLABS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_FENCE = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_FENCE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_GATE = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_GATE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_PRESSURE_PLATE = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_PRESSURE_PLATE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_BUTTON = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_BUTTON, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_DOORS = doubleBlock(MonstersAndGirlsModBlocks.SOUL_WANDERER_DOORS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_TRAPDOOR = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_TRAPDOOR, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> SOUL_WANDERER_MUSHROOM = block(MonstersAndGirlsModBlocks.SOUL_WANDERER_MUSHROOM, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_BLOCK = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_BLOCK, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_STEM = block(MonstersAndGirlsModBlocks.MOLTEN_STEM, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_PLANKS = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_PLANKS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_STAIRS = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_STAIRS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_SLABS = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_SLABS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_FENCE = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_FENCE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_GATE = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_GATE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_PLATE = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_PLATE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_BUTTON = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_BUTTON, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_DOORS = doubleBlock(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_DOORS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS_TRAPDOOR = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS_TRAPDOOR, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> MOLTEN_FUNGUS = block(MonstersAndGirlsModBlocks.MOLTEN_FUNGUS, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> GENESIS_POWDER = REGISTRY.register("genesis_powder", () -> new GenesisPowderItem());
	public static final RegistryObject<Item> MANDRAKE = block(MonstersAndGirlsModBlocks.MANDRAKE, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> DEBUG = REGISTRY.register("debug", () -> new DebugItem());
	public static final RegistryObject<Item> POTTED_SOUL_WANDERER = block(MonstersAndGirlsModBlocks.POTTED_SOUL_WANDERER, null);
	public static final RegistryObject<Item> POTTED_MOLTEN_FUNGUS = block(MonstersAndGirlsModBlocks.POTTED_MOLTEN_FUNGUS, null);
	public static final RegistryObject<Item> POTTED_ENDER_PUFFBALL = block(MonstersAndGirlsModBlocks.POTTED_ENDER_PUFFBALL, null);
	public static final RegistryObject<Item> POTTED_INK_CAP = block(MonstersAndGirlsModBlocks.POTTED_INK_CAP, null);
	public static final RegistryObject<Item> FRUITY_MANDRAKE_SPAWN_EGG = REGISTRY.register("fruity_mandrake_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.FRUITY_MANDRAKE, -26880, -9728, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> GLOW_BERRY_BUSH = block(MonstersAndGirlsModBlocks.GLOW_BERRY_BUSH, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> GLOW_BERRY_BUSH_UNLIT = block(MonstersAndGirlsModBlocks.GLOW_BERRY_BUSH_UNLIT, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> RED_STATION_CARPET = REGISTRY.register("red_station_carpet", () -> new RedStationCarpetItem());
	public static final RegistryObject<Item> INK_CAP_MUSHROOM_GIRL_IN_BED = REGISTRY.register("ink_cap_mushroom_girl_in_bed", () -> new InkCapMushroomGirlInBedItem());
	public static final RegistryObject<Item> TINY_BED = REGISTRY.register("tiny_bed", () -> new TinyBedItem());
	public static final RegistryObject<Item> BEE_GIRL_WORKER_SPAWN_EGG = REGISTRY.register("bee_girl_worker_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.BEE_GIRL_WORKER, -11776, -12575488, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> SPECTRAL_CAKE = REGISTRY.register("spectral_cake", () -> new SpectralCakeItem());
	public static final RegistryObject<Item> BROWN_MUSHROOM_GAL_SPAWN_EGG = REGISTRY.register("brown_mushroom_gal_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.BROWN_MUSHROOM_GAL, -6064815, -11916524, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> MOLTEN_MUSHROOM_GAL_SPAWN_EGG = REGISTRY.register("molten_mushroom_gal_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.MOLTEN_MUSHROOM_GAL, -14610930, -20480, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> ENDER_MUSHROOM_GAL_SPAWN_EGG = REGISTRY.register("ender_mushroom_gal_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.ENDER_MUSHROOM_GAL, -10209446, -1139489, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> INFERNAL_MUSHROOM_GAL_SPAWN_EGG = REGISTRY.register("infernal_mushroom_gal_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.INFERNAL_MUSHROOM_GAL, -9895936, -41, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> SPOOK_SPAWN_EGG = REGISTRY.register("spook_spawn_egg", () -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.SPOOK, -7744297, -2298385, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> INK_CAP_SPAWN_EGG = REGISTRY.register("ink_cap_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.INK_CAP, -13421773, -1319, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> RED_MUSHROM_GAL_SPAWN_EGG = REGISTRY.register("red_mushrom_gal_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.RED_MUSHROM_GAL, -2736845, -1062, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> WARPED_MUSHROOM_GAL_SPAWN_EGG = REGISTRY.register("warped_mushroom_gal_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.WARPED_MUSHROOM_GAL, -16410227, -552689, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> WARPED_MUSHROOM_GAL_BIG_SPOTS_SPAWN_EGG = REGISTRY.register("warped_mushroom_gal_big_spots_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.WARPED_MUSHROOM_GAL_BIG_SPOTS, -16758156, -16711698, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> CRIMSON_MUSHROOM_GIRL_BIGSPOTS_SPAWN_EGG = REGISTRY.register("crimson_mushroom_girl_bigspots_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.CRIMSON_MUSHROOM_GIRL_BIGSPOTS, -9367022, -617965, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> CRIMSON_MUSHROOM_GAL_SPAWN_EGG = REGISTRY.register("crimson_mushroom_gal_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.CRIMSON_MUSHROOM_GAL, -5372868, -65343, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> SOUL_WANDERER_GAL_SPAWN_EGG = REGISTRY.register("soul_wanderer_gal_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.SOUL_WANDERER_GAL, -13030877, -16711681, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> FLY_ALEXGARIC_SPAWN_EGG = REGISTRY.register("fly_alexgaric_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.FLY_ALEXGARIC, -16128, -2083, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> URN_1 = block(MonstersAndGirlsModBlocks.URN_1, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> PEACH_SPAWN_EGG = REGISTRY.register("peach_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.PEACH, -26215, -39322, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> URN_2 = block(MonstersAndGirlsModBlocks.URN_2, MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS);
	public static final RegistryObject<Item> BLUE_WISP_SPAWN_EGG = REGISTRY.register("blue_wisp_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.BLUE_WISP, -16737322, -13305601, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> GREEN_WISP_SPAWN_EGG = REGISTRY.register("green_wisp_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.GREEN_WISP, -16472727, -16711829, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> YELLOW_WISP_SPAWN_EGG = REGISTRY.register("yellow_wisp_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.YELLOW_WISP, -21248, -3967, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> BLUE_SLIME_GIRL_SPAWN_EGG = REGISTRY.register("blue_slime_girl_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.BLUE_SLIME_GIRL, -16711681, -3342337, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> GREEN_MANDRAKE_SPAWN_EGG = REGISTRY.register("green_mandrake_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.GREEN_MANDRAKE, -2692690, -12275447, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));
	public static final RegistryObject<Item> BROWN_MANDRAGORA_SPAWN_EGG = REGISTRY.register("brown_mandragora_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersAndGirlsModEntities.BROWN_MANDRAGORA, -3101325, -12275447, new Item.Properties().tab(MonstersAndGirlsModTabs.TAB_MONSTERS_AND_GIRLS)));

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
