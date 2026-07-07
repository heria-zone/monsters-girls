package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.variants.AnimatorVariantFeature;
import net.heriazone.hzlib.api.entity.features.FoodFeature;
import net.heriazone.hzlib.api.entity.features.SoundFeature;
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
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Entity type definitions for all Slime entity variants.</p>
 * <p>
 * <b>Variants:</b> Blue slime variant using the {@code slime_girl} model and animations.
 */
public class SlimeFamily extends MonstersFamily<SlimeFamily> {

    // -- Constants --

    /** List of all available Slime variants for registration and management. */
    public static final List<SlimeFamily> VARIANTS = new ArrayList<>();

    public static final SlimeFamily BLUE = create("slime_blue")
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("slime_blue", "slime_girl_blue")
                    .withDefault("slime_blue", "slime_girl_blue"));

    // -- Static Initialization --

    static {
        registerVariants();

        // No belly in 1.20.4 — 1 base texture, no belly offset.
        MigrationStep_V1_MG.registerBaseTextureCount("slime_blue", 1);
    }

    // -- Constructors --

    /**
     * Creates a new Slime entity type with the specified key.
     *
     * @param key the unique identifier for this slime variant
     */
    public SlimeFamily(String key) {
        super(key);

        withCombatStats(
            20.0f,  // health
            4.0f,   // attack
            1.0f,   // attack speed
            0.2f,   // armor
            0.3f,   // toughness
            0.1f,   // knockback resistance
            0.5f    // move speed
        );
        withFeature(SoundFeature.class, new SoundFeature()
                .withSound(SoundFeature.SoundType.AMBIENT, MonstersSounds.SLIME_AMBIENT.value())
                .withSound(SoundFeature.SoundType.HURT,    MonstersSounds.SLIME_HURT.value()));
    } // Constructor: SlimeFamily ()

    // -- Factory Methods --

    private static SlimeFamily create(String key) {
        SlimeFamily variant = new SlimeFamily(key);
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
                .withFoods(Items.SLIME_BALL));
    } // configureVariants ()

    // -- Static Registration Methods --

    private static void registerVariants() {
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("slime_girl_blue",   "Slime Blue",       getTextureResource("slime", "slime_girl_blue"), 1));
        VariantRegistries.MODELS.register(   new StandardModelVariant( "slime_blue_default","Slime Blue Model", getModelResource("slime_girl"),                1));

        // slime_girl: idle, idle2, walk, ride, boom, boom2, death, attack
        // idle2 is a subtle variant. boom/boom2 are special attack-like explosions — mapped as specials.
        AnimationProfile SLIME_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle",  3, LoopBehavior.LOOP)
                            .add("idle2", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk("walk")
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .special("idle_specials", AnimationPool.builder()
                        .add("boom",  2, LoopBehavior.PLAY_ONCE)
                        .add("boom2", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("slime_blue_default","Slime Blue Animations", getAnimatorResource("slime_girl"), SLIME_PROFILE, 1));
    } // registerVariants ()

} // Class: SlimeFamily
