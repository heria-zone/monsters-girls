package net.msymbios.monsters_girls.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    // -- Variables --
    private static final PlacementModifier UNIVERSAL_MODIFIER = PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP;
    public static final RegistryEntry<PlacedFeature> ENDER_PUFFBALL = register("mushroom_ender_puffball_placed", ModConfiguredFeatures.ENDER_PUFFBALL, 1, UNIVERSAL_MODIFIER);
    public static final RegistryEntry<PlacedFeature> INK_CAP_MUSHROOM = register("mushroom_ink_cap_placed", ModConfiguredFeatures.INK_CAP_MUSHROOM, 1, UNIVERSAL_MODIFIER);
    public static final RegistryEntry<PlacedFeature> MOLTEN_FUNGUS = register("mushroom_molten_fungus_placed", ModConfiguredFeatures.MOLTEN_FUNGUS, 1, UNIVERSAL_MODIFIER);
    public static final RegistryEntry<PlacedFeature> MANDRAKE_FLOWER = register("flower_mandrake_placed", ModConfiguredFeatures.MANDRAKE_FLOWER, 1, UNIVERSAL_MODIFIER);
    public static final RegistryEntry<PlacedFeature> SOUL_WANDERER_FUNGUS = register("mushroom_soul_wanderer_fungus_placed", ModConfiguredFeatures.SOUL_WANDERER_FUNGUS, 1, UNIVERSAL_MODIFIER);

    public static final RegistryEntry<PlacedFeature> GLOW_BERRY_BUSH = register("glow_berry_bush_placed", ModConfiguredFeatures.GLOW_BERRY_BUSH, 2, UNIVERSAL_MODIFIER);


    // -- Methods --
    public static RegistryEntry<PlacedFeature> register (String name, RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> feature, int chance, PlacementModifier modifier) {
        return PlacedFeatures.register(name, feature, RarityFilterPlacementModifier.of(chance), SquarePlacementModifier.of(), modifier, BiomePlacementModifier.of());
    } // register ()

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    } // modifiers ()

    private static List<PlacementModifier> modifiers(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    } // modifiers ()

    private static List<PlacementModifier> modifiers(PlacementModifier heightModifier, int chance) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    } // modifiers ()

} // Class ModPlacedFeatures