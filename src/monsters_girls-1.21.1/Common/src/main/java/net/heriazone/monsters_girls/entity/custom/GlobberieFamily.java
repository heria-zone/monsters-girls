package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.variants.AnimatorVariantFeature;
import net.heriazone.hzlib.api.entity.features.FoodFeature;
import net.heriazone.hzlib.api.entity.features.SoundFeature;
import net.heriazone.hzlib.api.entity.features.SpawnFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlaySlot;
import net.heriazone.hzlib.api.entity.features.variants.ModelVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.TextureVariantFeature;
import net.heriazone.hzlib.api.animation.AnimationPool;
import net.heriazone.hzlib.api.animation.AnimationProfile;
import net.heriazone.hzlib.api.animation.LoopBehavior;
import net.heriazone.hzlib.api.animation.SelectionStrategy;
import net.heriazone.hzlib.api.entity.variants.VariantRegistries;
import net.heriazone.hzlib.framework.entity.variants.StandardAnimatorVariant;
import net.heriazone.hzlib.framework.entity.variants.StandardModelVariant;
import net.heriazone.hzlib.framework.entity.variants.StandardTextureVariant;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG;
import net.heriazone.monsters_girls.source.MonstersSounds;
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
 * <p>Entity type definitions for all Globberie entity variants.</p>
 * <p>
 * <b>Variants:</b> Pink (with twintails) and Yellow color families, each with
 * slim, normal, and tummy texture stages for belly progression.
 * <p>
 * <b>Texture Pattern:</b> {@code globberie/globberie_{color}[_twintails]_{slim|normal|tummy}.png}
 */
public class GlobberieFamily extends MonstersFamily<GlobberieFamily> {

    // -- Constants --

    /** ALWAYS slot: shared emissive glow rendered unconditionally on top of the base texture. */
    public static final String SLOT_EMISSIVE = "emissive";

    /** List of all available Globberie variants for registration and management. */
    public static final List<GlobberieFamily> VARIANTS = new ArrayList<>();

    // -- Shared emissive overlay (all Globberie variants use the same glow texture) --

    private static final OverlayFeature GLOBBERIE_EMISSIVE = new OverlayFeature()
            .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("globberie", "globberie_default_emissive")).asEmissive());

    // -- Pink family --
    /**
     * Spawns in all End biomes — floats in the void-sky environment of The End.
     * Weight 8, groups of 1–2 (rare, thematic End encounters).
     */
    public static final GlobberieFamily GLOBBERIE = create("globberie_girl")
            // Texture variants must match keys registered in registerVariants() exactly
            // so NativeModel resolves a non-null ResourceLocation at render time.
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("globberie_girl","globberie_pink", "globberie_pink_twintails", "globberie_yellow")
                    .withDefault("globberie_girl", "globberie_pink"))
            .withFeature(OverlayFeature.class, GLOBBERIE_EMISSIVE)
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE, 8, 1, 2,
                            BiomesUtils.EndBiomes.toArray(new ResourceKey[0]))
                    .withPlacements(SpawnPlacementTypes.ON_GROUND,
                            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) ->
                                    world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)));

    // -- Static Initialization --

    static {registerVariants();}

    // -- Constructors --

    /**
     * Creates a new Globberie entity type with the specified key.
     *
     * @param key the unique identifier for this globberie variant
     */
    public GlobberieFamily(String key) {
        super(key);

        withCombatStats(
            18.0f,  // health
            3.0f,   // attack
            1.2f,   // attack speed
            0.1f,   // armor
            0.2f,   // toughness
            0.0f,   // knockback resistance
            0.5f    // move speed
        );
        withFeature(SoundFeature.class, new SoundFeature()
                .withSound(SoundFeature.SoundType.DEATH, MonstersSounds.GLOBBERIE_DEATH.value()));
    } // Constructor: GlobberieFamily ()

    // -- Factory Methods --

    private static GlobberieFamily create(String key) {
        GlobberieFamily variant = new GlobberieFamily(key);
        VARIANTS.add(variant);
        return variant;
    } // create ()

    // -- Variant Configuration --

    @Override
    protected void configureVariants() {
        withFeature(ModelVariantFeature.class, new ModelVariantFeature()
                .withVariants(key, "globberie_default")
                .withDefault(key, "globberie_default"));

        withFeature(AnimatorVariantFeature.class, new AnimatorVariantFeature()
                .withVariants(key, "globberie_default")
                .withDefault(key, "globberie_default"));
    } // configureVariants ()

    // -- Static Registration Methods --

    /**
     * Registers all Globberie texture, model, and animator variants in the global registries.
     * <p>
     * <b>Belly Stages:</b> slim → normal → tummy progression for all color families.
     */
    private static void registerVariants() {
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("globberie_pink",   "Globberie Pink",   getTextureResource("globberie", "globberie_pink"),   1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("globberie_pink_twintails",   "Globberie Pink Twintails",   getTextureResource("globberie", "globberie_pink_twintails"),   2));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("globberie_yellow",   "Globberie Yellow",   getTextureResource("globberie", "globberie_yellow"),   3));
        VariantRegistries.MODELS.register(new StandardModelVariant(   "globberie_default",    "Globberie Model",      getModelResource("globberie_girl"),    1));

        // -- Shared animator profile (all three globberie families use the same rig) --
        // globberie_girl: idle, idle2, eat, eat (aggro variant), ride, ride2,
        //                 walk, attack, attack2, aggro, death, death2
        // idle2 is a subtle idle variant. attack2/aggro are alternate combat animations.
        // eat/aggro/death are specials — not mapped to locomotion slots.
        AnimationProfile GLOBBERIE_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle",  3, LoopBehavior.LOOP)
                            .add("idle2", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk("walk")
                .attack(b -> b.add("attack",  2, LoopBehavior.INTERRUPT)
                              .add("attack2", 1, LoopBehavior.INTERRUPT)
                              .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .sit("ride")
                .ride("ride2")
                .special("idle_specials", AnimationPool.builder()
                        .add("eat",   3, LoopBehavior.PLAY_ONCE)
                        .add("aggro", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("globberie_default",          "Globberie Animations",          getAnimatorResource("globberie_girl"), GLOBBERIE_PROFILE, 1));
    } // registerVariants ()

} // Class: GlobberieFamily