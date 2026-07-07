package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.variants.AnimatorVariantFeature;
import net.heriazone.hzlib.api.entity.features.FoodFeature;
import net.heriazone.hzlib.api.entity.features.SoundFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlaySlot;
import net.heriazone.hzlib.api.entity.features.variants.ModelVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.TextureVariantFeature;
import net.heriazone.hzlib.api.rendering.RenderConditions;
import net.heriazone.monsters_girls.entity.BellyLevel;
import net.heriazone.monsters_girls.entity.feature.BellyFeature;
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
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Entity type definition for Spook entities, supporting three color variants:
 * Cream, Peach, and Teal, each with default and tummy texture variants.</p>
 * <p>
 * <b>Variants:</b> Each color variant (cream, peach, teal) supports both default
 * and tummy textures for the belly progression system.
 * <p>
 * <b>Combat Stats:</b> Flying entities with moderate health (18), low attack (3),
 * and high mobility (0.6 move speed) suitable for aerial combat.
 * <p>
 * <b>Texture Pattern:</b> spook_girl_{color}_{variant}.png where color is cream/peach/teal
 * and variant is default/tummy.
 */
public class SpookFamily extends MonstersFamily<SpookFamily> {

    // -- Constants --

    /** ALWAYS slot: emissive glow rendered unconditionally on top of the base texture. */
    public static final String SLOT_EMISSIVE = "emissive";

    /** CONDITIONAL slot: belly overlay — SLIM at level >= 1, TUMMY at level >= 2 (first-match wins). */
    public static final String SLOT_BELLY = "belly";

    /**
     * List of all available Spook variants for registration and management.
     */
    public static final List<SpookFamily> VARIANTS = new ArrayList<>();

    // Spook color variants
    public static final SpookFamily CREAM = create("spook_girl_cream");
    public static final SpookFamily PEACH = create("spook_girl_peach");
    public static final SpookFamily TEAL  = create("spook_girl_teal");

    // -- Static Initialization --

    static {
        // Register texture variants for all spook colors
        registerSpookVariants();

        // Each Spook key had 1 base texture in 1.20.4 (DEFAULT = TextureID 0).
        // Belly offset started at TextureID 1 (SLIM), TextureID 2 (TUMMY).
        MigrationStep_V1_MG.registerBaseTextureCount("spook_girl_cream", 1);
        MigrationStep_V1_MG.registerBaseTextureCount("spook_girl_peach", 1);
        MigrationStep_V1_MG.registerBaseTextureCount("spook_girl_teal",  1);

        // BellyFeature: TUMMY cap — SLIM and TUMMY authored per color.
        // OverlayFeature: belly CONDITIONAL (TUMMY first — highest level wins) + emissive ALWAYS.
        // All three colors (cream, peach, teal) have individual belly texture assets.

        // -- Cream --
        CREAM.withFeature(BellyFeature.class, new BellyFeature()
                .maxLevel(BellyLevel.TUMMY)
                .texture(BellyLevel.SLIM,  getLayerResource("spook", "spook_cream_belly_slim"))
                .texture(BellyLevel.TUMMY, getLayerResource("spook", "spook_cream_belly_tummy")));
        CREAM.withFeature(OverlayFeature.class, new OverlayFeature()
                .addSlot(OverlaySlot.conditional(SLOT_BELLY,
                        OverlaySlot.entry(getLayerResource("spook", "spook_cream_belly_tummy"),
                                RenderConditions.bellyAtLeast(BellyLevel.TUMMY.getLevel())),
                        OverlaySlot.entry(getLayerResource("spook", "spook_cream_belly_slim"),
                                RenderConditions.bellyAtLeast(BellyLevel.SLIM.getLevel()))))
                .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("spook", "spook_girl_emissive")).asEmissive()));

        // -- Peach --
        PEACH.withFeature(BellyFeature.class, new BellyFeature()
                .maxLevel(BellyLevel.TUMMY)
                .texture(BellyLevel.SLIM,  getLayerResource("spook", "spook_peach_belly_slim"))
                .texture(BellyLevel.TUMMY, getLayerResource("spook", "spook_peach_belly_tummy")));
        PEACH.withFeature(OverlayFeature.class, new OverlayFeature()
                .addSlot(OverlaySlot.conditional(SLOT_BELLY,
                        OverlaySlot.entry(getLayerResource("spook", "spook_peach_belly_tummy"),
                                RenderConditions.bellyAtLeast(BellyLevel.TUMMY.getLevel())),
                        OverlaySlot.entry(getLayerResource("spook", "spook_peach_belly_slim"),
                                RenderConditions.bellyAtLeast(BellyLevel.SLIM.getLevel()))))
                .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("spook", "spook_girl_peach_emissive")).asEmissive()));

        // -- Teal --
        TEAL.withFeature(BellyFeature.class, new BellyFeature()
                .maxLevel(BellyLevel.TUMMY)
                .texture(BellyLevel.SLIM,  getLayerResource("spook", "spook_teal_belly_slim"))
                .texture(BellyLevel.TUMMY, getLayerResource("spook", "spook_teal_belly_tummy")));
        TEAL.withFeature(OverlayFeature.class, new OverlayFeature()
                .addSlot(OverlaySlot.conditional(SLOT_BELLY,
                        OverlaySlot.entry(getLayerResource("spook", "spook_teal_belly_tummy"),
                                RenderConditions.bellyAtLeast(BellyLevel.TUMMY.getLevel())),
                        OverlaySlot.entry(getLayerResource("spook", "spook_teal_belly_slim"),
                                RenderConditions.bellyAtLeast(BellyLevel.SLIM.getLevel()))))
                .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("spook", "spook_girl_emissive")).asEmissive()));
    }

    // -- Constructors --

    /**
     * Creates a new Spook entity type with the specified key.
     *
     * @param key the unique identifier for this spook variant
     */
    public SpookFamily(String key) {
        super(key);
        
        // Override combat stats specific to Spooks (flying entities)
        withCombatStats(
            18.0f,  // health - moderate for flying entity
            3.0f,   // attack - low damage
            1.2f,   // attack speed
            0.1f,   // armor - minimal
            0.2f,   // toughness - minimal
            0.0f,   // knockback resistance - none
            0.6f    // move speed - high mobility for flying
        );
        withFeature(SoundFeature.class, new SoundFeature()
                .withSound(SoundFeature.SoundType.AMBIENT, MonstersSounds.SPOOK_AMBIENT.value())
                .withSound(SoundFeature.SoundType.HURT,    MonstersSounds.SPOOK_HURT.value())
                .withSound(SoundFeature.SoundType.ATTACK,  MonstersSounds.SPOOK_ATTACK.value()));
    }

    // -- Factory Methods --

    /**
     * <p>Creates and registers a new Spook entity type variant.</p>
     * 
     * @param key the unique identifier for the variant
     * @return the created SpookFamily instance
     */
    private static SpookFamily create(String key) {
        SpookFamily variant = new SpookFamily(key);
        VARIANTS.add(variant);
        return variant;
    }

    // -- Variant Configuration --

    @Override
    protected void configureVariants() {
        // Base texture key matches the actual file on disk: spook_girl_{color}.png
        // Belly is now an overlay layer (BellyFeature + OverlayFeature) — no _tummy texture variant.
        withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                .withVariants(key, key)
                .withDefault(key, key));

        // Configure model variants - DEFAULT only for most monsters
        withFeature(ModelVariantFeature.class, new ModelVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));

        // Configure animator variants - DEFAULT only for most monsters
        withFeature(AnimatorVariantFeature.class, new AnimatorVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));

        withFeature(FoodFeature.class, new FoodFeature()
                .withFoods(Items.COOKIE));
    } // configureVariants ()

    // -- Static Registration Methods --

    /**
     * <p>Registers all Spook texture variants in the global variant registry.</p>
     * <p>
     * <b>Registration Pattern:</b> Each color variant gets both default and tummy textures
     * registered in the global texture variant registry for dynamic access.
     */
    private static void registerSpookVariants() {
        // Register Cream Spook variant — key matches actual file: spook_girl_cream.png
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("spook_girl_cream", "Cream Spook", getTextureResource("spook", "spook_girl_cream"), 1));

        // Register Peach Spook variant — key matches actual file: spook_girl_peach.png
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("spook_girl_peach", "Peach Spook", getTextureResource("spook", "spook_girl_peach"), 1));

        // Register Teal Spook variant — key matches actual file: spook_girl_teal.png
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("spook_girl_teal", "Teal Spook", getTextureResource("spook", "spook_girl_teal"), 1));

        // Register shared model variant (all spooks use the same model)
        VariantRegistries.MODELS.register(new StandardModelVariant("spook_girl_cream_default", "Spook Cream Model", getModelResource("spook_girl"), 1));
        VariantRegistries.MODELS.register(new StandardModelVariant("spook_girl_peach_default", "Spook Peach Model", getModelResource("spook_girl"), 1));
        VariantRegistries.MODELS.register(new StandardModelVariant("spook_girl_teal_default",  "Spook Teal Model",  getModelResource("spook_girl"), 1));

        // -- Shared animator profile (all spooks use the same rig) --
        // spook_girl: eat_sit, ride, rest, idle, walk, attack, spook.eat, belly
        // eat_sit is a sitting-eat animation → mapped to rest (standby seated).
        // spook.eat and belly are idle-timeout specials.
        AnimationProfile SPOOK_PROFILE = AnimationProfile.builder()
                .idle("idle")
                .walk("walk")
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .rest("eat_sit")
                .special("idle_specials", AnimationPool.builder()
                        .add("belly",     3, LoopBehavior.PLAY_ONCE)
                        .add("spook.eat", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("spook_girl_cream_default", "Spook Cream Animations", getAnimatorResource("spook_girl"), SPOOK_PROFILE, 1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("spook_girl_peach_default", "Spook Peach Animations", getAnimatorResource("spook_girl"), SPOOK_PROFILE, 1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("spook_girl_teal_default",  "Spook Teal Animations",  getAnimatorResource("spook_girl"), SPOOK_PROFILE, 1));
    } // registerSpookVariants ()

} // Class: SpookFamily