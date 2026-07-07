
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.monstersandgirls.world.features.plants.SoulWandererMushroomFeature;
import net.mcreator.monstersandgirls.world.features.plants.MoltenFungusFeature;
import net.mcreator.monstersandgirls.world.features.plants.MandrakeFeature;
import net.mcreator.monstersandgirls.world.features.plants.InkCapMushroomFeature;
import net.mcreator.monstersandgirls.world.features.plants.GlowBerryBushUnlitFeature;
import net.mcreator.monstersandgirls.world.features.plants.GlowBerryBushFeature;
import net.mcreator.monstersandgirls.world.features.plants.EndPuffballFeature;
import net.mcreator.monstersandgirls.world.features.ores.HugeEnderPuffballFeature;
import net.mcreator.monstersandgirls.world.features.SpookyHouseFeature;
import net.mcreator.monstersandgirls.world.features.SpookDungeonLushFeature;
import net.mcreator.monstersandgirls.world.features.SpookDungeonFeature;
import net.mcreator.monstersandgirls.world.features.SpookDungeonDripstoneFeature;
import net.mcreator.monstersandgirls.world.features.SoulWanderer3Feature;
import net.mcreator.monstersandgirls.world.features.SoulWanderer2Feature;
import net.mcreator.monstersandgirls.world.features.SoulWanderer1Feature;
import net.mcreator.monstersandgirls.world.features.ScarecrowFeature;
import net.mcreator.monstersandgirls.world.features.PumpkinFeature;
import net.mcreator.monstersandgirls.world.features.MoltenFungus3Feature;
import net.mcreator.monstersandgirls.world.features.MoltenFungus2Feature;
import net.mcreator.monstersandgirls.world.features.MoltenFungus1Feature;
import net.mcreator.monstersandgirls.world.features.LanternFeature;
import net.mcreator.monstersandgirls.world.features.Enderpuffball6Feature;
import net.mcreator.monstersandgirls.world.features.Enderpuffball4Feature;
import net.mcreator.monstersandgirls.world.features.Enderpuffball3Feature;
import net.mcreator.monstersandgirls.world.features.Enderpuffball1Feature;
import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

@Mod.EventBusSubscriber
public class MonstersAndGirlsModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, MonstersAndGirlsMod.MODID);
	public static final RegistryObject<Feature<?>> HUGE_ENDER_PUFFBALL = REGISTRY.register("huge_ender_puffball", HugeEnderPuffballFeature::feature);
	public static final RegistryObject<Feature<?>> INK_CAP_MUSHROOM = REGISTRY.register("ink_cap_mushroom", InkCapMushroomFeature::feature);
	public static final RegistryObject<Feature<?>> END_PUFFBALL = REGISTRY.register("end_puffball", EndPuffballFeature::feature);
	public static final RegistryObject<Feature<?>> SOUL_WANDERER_MUSHROOM = REGISTRY.register("soul_wanderer_mushroom", SoulWandererMushroomFeature::feature);
	public static final RegistryObject<Feature<?>> MOLTEN_FUNGUS = REGISTRY.register("molten_fungus", MoltenFungusFeature::feature);
	public static final RegistryObject<Feature<?>> MANDRAKE = REGISTRY.register("mandrake", MandrakeFeature::feature);
	public static final RegistryObject<Feature<?>> ENDERPUFFBALL_1 = REGISTRY.register("enderpuffball_1", Enderpuffball1Feature::feature);
	public static final RegistryObject<Feature<?>> ENDERPUFFBALL_3 = REGISTRY.register("enderpuffball_3", Enderpuffball3Feature::feature);
	public static final RegistryObject<Feature<?>> ENDERPUFFBALL_4 = REGISTRY.register("enderpuffball_4", Enderpuffball4Feature::feature);
	public static final RegistryObject<Feature<?>> ENDERPUFFBALL_6 = REGISTRY.register("enderpuffball_6", Enderpuffball6Feature::feature);
	public static final RegistryObject<Feature<?>> SOUL_WANDERER_1 = REGISTRY.register("soul_wanderer_1", SoulWanderer1Feature::feature);
	public static final RegistryObject<Feature<?>> SOUL_WANDERER_2 = REGISTRY.register("soul_wanderer_2", SoulWanderer2Feature::feature);
	public static final RegistryObject<Feature<?>> SOUL_WANDERER_3 = REGISTRY.register("soul_wanderer_3", SoulWanderer3Feature::feature);
	public static final RegistryObject<Feature<?>> MOLTEN_FUNGUS_1 = REGISTRY.register("molten_fungus_1", MoltenFungus1Feature::feature);
	public static final RegistryObject<Feature<?>> MOLTEN_FUNGUS_2 = REGISTRY.register("molten_fungus_2", MoltenFungus2Feature::feature);
	public static final RegistryObject<Feature<?>> MOLTEN_FUNGUS_3 = REGISTRY.register("molten_fungus_3", MoltenFungus3Feature::feature);
	public static final RegistryObject<Feature<?>> GLOW_BERRY_BUSH = REGISTRY.register("glow_berry_bush", GlowBerryBushFeature::feature);
	public static final RegistryObject<Feature<?>> GLOW_BERRY_BUSH_UNLIT = REGISTRY.register("glow_berry_bush_unlit", GlowBerryBushUnlitFeature::feature);
	public static final RegistryObject<Feature<?>> SPOOKY_HOUSE = REGISTRY.register("spooky_house", SpookyHouseFeature::feature);
	public static final RegistryObject<Feature<?>> SCARECROW = REGISTRY.register("scarecrow", ScarecrowFeature::feature);
	public static final RegistryObject<Feature<?>> PUMPKIN = REGISTRY.register("pumpkin", PumpkinFeature::feature);
	public static final RegistryObject<Feature<?>> LANTERN = REGISTRY.register("lantern", LanternFeature::feature);
	public static final RegistryObject<Feature<?>> SPOOK_DUNGEON = REGISTRY.register("spook_dungeon", SpookDungeonFeature::feature);
	public static final RegistryObject<Feature<?>> SPOOK_DUNGEON_LUSH = REGISTRY.register("spook_dungeon_lush", SpookDungeonLushFeature::feature);
	public static final RegistryObject<Feature<?>> SPOOK_DUNGEON_DRIPSTONE = REGISTRY.register("spook_dungeon_dripstone", SpookDungeonDripstoneFeature::feature);
}
