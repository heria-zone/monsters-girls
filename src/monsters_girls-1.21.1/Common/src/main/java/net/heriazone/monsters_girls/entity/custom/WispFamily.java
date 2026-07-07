package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.DropFeature;
import net.heriazone.hzlib.api.entity.features.FoodFeature;
import net.heriazone.hzlib.api.entity.features.SoundFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlaySlot;
import net.heriazone.hzlib.api.entity.features.variants.AnimatorVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.ModelVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.TextureVariantFeature;
import net.heriazone.hzlib.api.rendering.RenderConditions;
import net.heriazone.monsters_girls.entity.BellyLevel;
import net.heriazone.monsters_girls.entity.feature.BellyFeature;
import net.heriazone.hzlib.api.animation.AnimationPool;
import net.heriazone.hzlib.api.animation.AnimationProfile;
import net.heriazone.hzlib.api.animation.LoopBehavior;
import net.heriazone.hzlib.api.animation.SelectionStrategy;
import net.heriazone.hzlib.framework.entity.variants.StandardAnimatorVariant;
import net.heriazone.hzlib.framework.entity.variants.StandardModelVariant;
import net.heriazone.hzlib.framework.entity.variants.StandardTextureVariant;
import net.heriazone.hzlib.api.entity.variants.VariantRegistries;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG;
import net.heriazone.monsters_girls.source.MonstersSounds;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Entity type definition for Wisp entities, supporting three color variants:
 * Green, Blue, and Yellow, each with default and tummy texture variants.</p>
 * <p>
 * <b>Variants:</b> Each color variant (green, blue, yellow) supports both default
 * and tummy textures for the belly progression system.
 * <p>
 * <b>Combat Stats:</b> Flying entities with moderate health (18), low attack (3),
 * and high mobility (0.6 move speed) suitable for aerial combat.
 * <p>
 * <b>Texture Pattern:</b> wisp_girl_{color}_{variant}.png where color is green/blue/yellow
 * and variant is default/tummy.
 */
public class WispFamily extends MonstersFamily<WispFamily> {

    // -- Constants --
    
    /** ALWAYS slot: per-color emissive glow rendered unconditionally on top of the base texture. */
    public static final String SLOT_EMISSIVE = "emissive";

    /** CONDITIONAL slot: belly overlay rendered when belly level >= 2 (TUMMY). */
    public static final String SLOT_BELLY = "belly";

    /**
     * List of all available Wisp variants for registration and management.
     */
    public static final List<WispFamily> VARIANTS = new ArrayList<>();

    // Wisp color variants
    public static final WispFamily GREEN  = create("wisp_girl_green") .withFeature(DropFeature.class, new DropFeature(Items.EMERALD));
    public static final WispFamily BLUE   = create("wisp_girl_blue")  .withFeature(DropFeature.class, new DropFeature(Items.DIAMOND));
    public static final WispFamily YELLOW = create("wisp_girl_yellow").withFeature(DropFeature.class, new DropFeature(Items.EMERALD));

    // -- Static Initialization --
    
    static {
        // Register texture variants for all wisp colors
        registerWispVariants();

        // Register base texture counts for MigrationStep_V1_MG.
        // Each Wisp key had 1 base texture in the 1.20.4 save format (DEFAULT = TextureID 0).
        // Belly offset started at TextureID 1. So baseTextureCount = 1 per variant key.
        MigrationStep_V1_MG.registerBaseTextureCount("wisp_girl_green",  1);
        MigrationStep_V1_MG.registerBaseTextureCount("wisp_girl_blue",   1);
        MigrationStep_V1_MG.registerBaseTextureCount("wisp_girl_yellow", 1);

        // BellyFeature: TUMMY cap — one authored belly texture per color.
        // OverlayFeature: belly CONDITIONAL (renders at level >= TUMMY) + emissive ALWAYS.
        // Layer order: belly first, emissive last (topmost).
        GREEN.withFeature(BellyFeature.class, new BellyFeature()
                .maxLevel(BellyLevel.TUMMY)
                .texture(BellyLevel.TUMMY, getLayerResource("wisp", "wisp_green_belly_tummy")));
        GREEN.withFeature(OverlayFeature.class, new OverlayFeature()
                .addSlot(OverlaySlot.conditional(SLOT_BELLY,
                        OverlaySlot.entry(getLayerResource("wisp", "wisp_green_belly_tummy"),
                                RenderConditions.bellyAtLeast(BellyLevel.TUMMY.getLevel()))))
                .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("wisp", "wisp_green_emissive")).asEmissive()));

        BLUE.withFeature(BellyFeature.class, new BellyFeature()
                .maxLevel(BellyLevel.TUMMY)
                .texture(BellyLevel.TUMMY, getLayerResource("wisp", "wisp_blue_belly_tummy")));
        BLUE.withFeature(OverlayFeature.class, new OverlayFeature()
                .addSlot(OverlaySlot.conditional(SLOT_BELLY,
                        OverlaySlot.entry(getLayerResource("wisp", "wisp_blue_belly_tummy"),
                                RenderConditions.bellyAtLeast(BellyLevel.TUMMY.getLevel()))))
                .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("wisp", "wisp_blue_emissive")).asEmissive()));

        YELLOW.withFeature(BellyFeature.class, new BellyFeature()
                .maxLevel(BellyLevel.TUMMY)
                .texture(BellyLevel.TUMMY, getLayerResource("wisp", "wisp_yellow_belly_tummy")));
        YELLOW.withFeature(OverlayFeature.class, new OverlayFeature()
                .addSlot(OverlaySlot.conditional(SLOT_BELLY,
                        OverlaySlot.entry(getLayerResource("wisp", "wisp_yellow_belly_tummy"),
                                RenderConditions.bellyAtLeast(BellyLevel.TUMMY.getLevel()))))
                .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("wisp", "wisp_yellow_emissive")).asEmissive()));
    }

    // -- Constructors --

    /**
     * Creates a new Wisp entity type with the specified key.
     * 
     * @param key the unique identifier for this wisp variant
     */
    public WispFamily(String key) {
        super(key);
        
        // Override combat stats specific to Wisps (flying entities)
        withCombatStats(
            18.0F,  // health - moderate for flying entity
            3.0F,   // attack - low damage
            1.2F,   // attack speed
            0.1F,   // armor - minimal
            0.2F,   // toughness - minimal
            0.0F,   // knockback resistance - none
            0.6F    // move speed - high mobility for flying
        );
        withFeature(SoundFeature.class, new SoundFeature()
                .withSound(SoundFeature.SoundType.AMBIENT, MonstersSounds.WISP_AMBIENT.value())
                .withSound(SoundFeature.SoundType.HURT,    MonstersSounds.WISP_HURT.value())
                .withSound(SoundFeature.SoundType.DEATH,   MonstersSounds.WISP_DEATH.value()));
    }

    // -- Factory Methods --

    /**
     * <p>Creates and registers a new Wisp entity type variant.</p>
     * 
     * @param key the unique identifier for the variant
     * @return the created WispFamily instance
     */
    private static WispFamily create(String key) {
        WispFamily variant = new WispFamily(key);
        VARIANTS.add(variant);
        return variant;
    }

    // -- Variant Configuration --

    @Override
    protected void configureVariants() {
        // Base texture key matches the actual file on disk: wisp_girl_{color}.png
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
                .withFoods(Items.GOLD_NUGGET, Items.GOLD_INGOT, Items.RAW_GOLD)
                .withTemptingItems(Items.RAW_GOLD, Items.GOLD_NUGGET, Items.GOLD_INGOT, Items.GOLD_BLOCK));
    } // configureVariants ()

    // -- Static Registration Methods --

    /**
     * <p>Registers all Wisp texture variants in the global variant registry.</p>
     * <p>
     * <b>Registration Pattern:</b> Each color variant gets both default and tummy textures
     * registered in the global texture variant registry for dynamic access.
     */
    private static void registerWispVariants() {
        // Register Green Wisp variants — key matches actual file: wisp_girl_green.png
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("wisp_girl_green", "Green Wisp", getTextureResource("wisp", "wisp_girl_green"), 1));

        // Register Blue Wisp variants — key matches actual file: wisp_girl_blue.png
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("wisp_girl_blue", "Blue Wisp", getTextureResource("wisp", "wisp_girl_blue"), 1));

        // Register Yellow Wisp variants — key matches actual file: wisp_girl_yellow.png
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("wisp_girl_yellow", "Yellow Wisp", getTextureResource("wisp", "wisp_girl_yellow"), 1));

        // Register shared model variant (all wisps use the same model)
        VariantRegistries.MODELS.register(new StandardModelVariant("wisp_girl_blue_default",   "Wisp Blue Model",   getModelResource("wisp_girl"), 1));
        VariantRegistries.MODELS.register(new StandardModelVariant("wisp_girl_green_default",  "Wisp Green Model",  getModelResource("wisp_girl"), 1));
        VariantRegistries.MODELS.register(new StandardModelVariant("wisp_girl_yellow_default", "Wisp Yellow Model", getModelResource("wisp_girl"), 1));

        // -- Shared animator profile (all wisps use the same rig) --
        // wisp_girl: idle, idle2, ride, rest, walk, attack, yipee
        // idle2 is a calm floaty variant. yipee is an expressive idle special — rare.
        // rest is their standby resting state.
        AnimationProfile WISP_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle",  4, LoopBehavior.LOOP)
                            .add("idle2", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk("walk")
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .rest("rest")
                .special("idle_specials", AnimationPool.builder()
                        .add("yipee", 1, LoopBehavior.PLAY_ONCE)
                        .build())
                .build();

        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("wisp_girl_blue_default",   "Wisp Blue Animations",   getAnimatorResource("wisp_girl"), WISP_PROFILE, 1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("wisp_girl_green_default",  "Wisp Green Animations",  getAnimatorResource("wisp_girl"), WISP_PROFILE, 1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("wisp_girl_yellow_default", "Wisp Yellow Animations", getAnimatorResource("wisp_girl"), WISP_PROFILE, 1));
    } // registerWispVariants ()

} // Class: WispFamily