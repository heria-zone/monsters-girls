package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.FoodFeature;
import net.heriazone.hzlib.api.entity.features.SpawnFeature;
import net.heriazone.hzlib.api.entity.features.variants.AnimatorVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.ModelVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.TextureVariantFeature;
import net.heriazone.hzlib.api.entity.variants.VariantRegistries;
import net.heriazone.hzlib.framework.entity.variants.StandardAnimatorVariant;
import net.heriazone.hzlib.framework.entity.variants.StandardModelVariant;
import net.heriazone.hzlib.framework.entity.variants.StandardTextureVariant;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG;
import net.heriazone.monsters_girls.world.BiomesUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Entity type definition for the Maiden of the Skies (Amplectobelua) entity.<p>
 * <p>
 * <b>Architecture:</b> Flying entity using the {@code amplectobelua} model and animations.
 * Single variant with a default texture. Uses vanilla colored spawn egg (purple).
 * <p>
 * <b>Spawn:</b> All End biomes — rare flying encounter at weight 5, solo spawns.
 */
public class MaidenFamily extends MonstersFamily<MaidenFamily> {

    // -- Constants --

    /** List of all available Maiden variants for registration and management. */
    public static final List<MaidenFamily> VARIANTS = new ArrayList<>();

    public static final MaidenFamily DEFAULT = create("amplectobelua")
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("amplectobelua", "amplectobelua_default")
                    .withDefault("amplectobelua", "amplectobelua_default"));

    // -- Static Initialization --

    static {
        registerVariants();

        // No belly in 1.20.4 — 1 base texture, no belly offset.
        MigrationStep_V1_MG.registerBaseTextureCount("amplectobelua", 1);
    }

    // -- Constructors --

    /**
     * Creates a new Maiden entity type with the specified key.
     *
     * @param key the unique identifier for this maiden variant
     */
    public MaidenFamily(String key) {
        super(key);

        withCombatStats(
            24.0f,  // health - stronger flying entity
            5.0f,   // attack
            1.2f,   // attack speed
            0.2f,   // armor
            0.3f,   // toughness
            0.0f,   // knockback resistance
            0.7f    // move speed
        );
    } // Constructor: MaidenFamily ()

    // -- Factory Methods --

    private static MaidenFamily create(String key) {
        MaidenFamily variant = new MaidenFamily(key);
        VARIANTS.add(variant);
        return variant;
    } // create ()

    // -- Variant Configuration --

    @Override
    protected void configureVariants() {
        withFeature(ModelVariantFeature.class, new ModelVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));

        withFeature(AnimatorVariantFeature.class, new AnimatorVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));

        withFeature(FoodFeature.class, new FoodFeature()
                .withFoods(Items.COOKIE));

        // End biomes — rare solo encounter, weight 5.
        withFeature(SpawnFeature.class, new SpawnFeature()
                .withModifications(MobCategory.CREATURE, 5, 1, 1,
                        BiomesUtils.EndBiomes.toArray(new ResourceKey[0]))
                .withPlacements(SpawnPlacementTypes.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                        (type, world, reason, pos, random) ->
                                world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)));
    } // configureVariants ()

    // -- Static Registration Methods --

    private static void registerVariants() {
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("amplectobelua_default", "Maiden of the Skies Default", getTextureResource("amplectobelua", "amplectobelua_default"), 1));
        VariantRegistries.MODELS.register(new StandardModelVariant(   "amplectobelua_default",  "Maiden of the Skies Model",   getModelResource("amplectobelua"),    1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("amplectobelua_default","Maiden of the Skies Animations",getAnimatorResource("amplectobelua"),1));
    } // registerVariants ()

} // Class: MaidenFamily
