package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.FoodFeature;
import net.heriazone.hzlib.api.entity.features.PlantingFeature;
import net.heriazone.hzlib.api.entity.features.SoundFeature;
import net.heriazone.hzlib.api.entity.features.SpawnFeature;
import net.heriazone.hzlib.api.entity.features.emanation.*;
import net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlaySlot;
import net.heriazone.hzlib.api.entity.features.variants.AnimatorVariantFeature;
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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * <p>Entity type definition for Mandrake entities, supporting three color variants:
 * Cream, Peach, and Teal, each with default and tummy texture variants.</p>
 * <p>
 * <b>Variants:</b> Each color variant (cream, peach, teal) supports both default
 * and tummy textures for the belly progression system.
 * <p>
 * <b>Combat Stats:</b> Flying entities with moderate health (18), low attack (3),
 * and high mobility (0.6 move speed) suitable for aerial combat.
 * <p>
 * <b>Texture Pattern:</b> mandrake_girl_{color}_{variant}.png where color is cream/peach/teal
 * and variant is default/tummy.
 */
public class MandrakeFamily extends MonstersFamily<MandrakeFamily> {

    // -- Overlay Slot Keys --

    /**
     * RANDOM slot (FLOWER variant only): hairstyle chosen once at spawn from the four
     * available hair overlay textures. Persisted in synced entity data and NBT.
     * CHORUS and FRUCTUS have no hair layer assets — this slot is not registered on them.
     */
    public static final String SLOT_HAIR     = "hair";

    /**
     * ALWAYS slot (FLOWER variant only): the permanent emission/glow layer.
     * Rendered unconditionally on top of base texture and hair overlay.
     */
    public static final String SLOT_EMISSIVE = "emissive";

    // -- Constants --

    /**
     * List of all available Mandrake variants for registration and management.
     */
    public static final List<MandrakeFamily> VARIANTS = new ArrayList<>();

    // Mandrake color variants
    public static final MandrakeFamily CHORUS = create("mandrake_chorus")
            .withFeature(FoodFeature.class, new FoodFeature().withFood(Items.CHORUS_FRUIT, 0.6F).withFood(Items.POPPED_CHORUS_FRUIT, 0.6F).withFood(Items.COOKIE, 0.3F))
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mandrake_chorus", "mandrake_chorus_chyra")
                    .withDefault("mandrake_chorus", "mandrake_chorus_chyra"))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,12, 1, 3, BiomesUtils.EndBiomes.toArray(new ResourceKey[0]))
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(Blocks.CHORUS_PLANT).allowedBlocks(Blocks.END_STONE).build()).build())
            .withFeature(EmanationFeature.class, EmanationFeature.builder()
                    // Curse: ender scream — wither, levitation, nausea radiate outward
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_HURT)
                            .effect(EmanationEffects.aoe(8.0f,
                                    EmanationEffects.applyToTarget(MobEffects.WITHER,    100, 0),
                                    EmanationEffects.applyToTarget(MobEffects.LEVITATION,  60, 0),
                                    EmanationEffects.applyToTarget(MobEffects.CONFUSION,  100, 0)))
                            .build())
                    // Blessings — she was made happy, her joy flows outward
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.COOKIE))
                            .effect(EmanationEffects.applyToGiver(MobEffects.REGENERATION, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.CHORUS_FRUIT))
                            .effect(EmanationEffects.applyToGiver(MobEffects.REGENERATION, 200, 0))
                            .effect(EmanationEffects.applyToGiver(MobEffects.LEVITATION,    60, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.POPPED_CHORUS_FRUIT))
                            .effect(EmanationEffects.applyToGiver(MobEffects.DAMAGE_RESISTANCE, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.BONE_MEAL))
                            .effect(EmanationEffects.applyToGiver(MobEffects.DAMAGE_BOOST, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.CLAY_BALL))
                            .effect(EmanationEffects.applyToGiver(MobEffects.LUCK, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.WATER_BUCKET))
                            .effect(EmanationEffects.applyToGiver(MobEffects.SATURATION, 40, 0))
                            .consumesGift(true).build())
                    .build())
            .withFeature(SoundFeature.class, new SoundFeature()
                    .withSound(SoundFeature.SoundType.AMBIENT, MonstersSounds.MANDRAKE_CHORUS_AMBIENT.value())
                    .withSound(SoundFeature.SoundType.HURT,    MonstersSounds.MANDRAKE_HURT.value())
                    .withSound(SoundFeature.SoundType.DEATH,   MonstersSounds.MANDRAKE_DEATH.value()));

    public static final MandrakeFamily FLOWER = create("mandrake_flower")
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mandrake_flower", "mandrake_flower_blue", "mandrake_flower_brown", "mandrake_flower_green", "mandrake_flower_yellow")
                    .withDefault("mandrake_flower", "mandrake_flower_brown"))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.COOKIE))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,12, 1, 2, Stream.of(
                            BiomesUtils.ForestBiomesNoConiferous.stream(),
                            BiomesUtils.JungleForestBiomes.stream(),
                            Stream.of(Biomes.MEADOW, Biomes.MANGROVE_SWAMP)
                    ).flatMap(s -> s).toArray(ResourceKey[]::new))
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            // Mandrake Flower plants her namesake block on grass/dirt surfaces.
            // Mirrors the mushroom girl planting pattern — globalCooldown 3600 ticks (3 min).
            // allowedBlocks uses the grass/dirt family so she can plant in any forest biome.
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(Blocks.DANDELION)
                            .allowedBlocks(
                                    Blocks.GRASS_BLOCK,
                                    Blocks.DIRT,
                                    Blocks.COARSE_DIRT,
                                    Blocks.PODZOL,
                                    Blocks.ROOTED_DIRT,
                                    Blocks.MUD,
                                    Blocks.MUDDY_MANGROVE_ROOTS)
                            .build())
                    .build())            .withFeature(OverlayFeature.class, new OverlayFeature()
                    // RANDOM: hairstyle chosen once at spawn, persisted in SynchedEntityData + NBT.
                    // Four hair overlays map 1-to-1 to the authored layer assets.
                    // The base texture has the hair region transparent; these fill it.
                    .addSlot(OverlaySlot.random(SLOT_HAIR,
                            getLayerResource("mandrake_flower", "mandrake_flower_hair_twintails_blue"),
                            getLayerResource("mandrake_flower", "mandrake_flower_hair_twintails_green"),
                            getLayerResource("mandrake_flower", "mandrake_flower_hair_flower_crown_green"),
                            getLayerResource("mandrake_flower", "mandrake_flower_hair_ponytails_yellow")))
                    // ALWAYS: emission/glow layer — rendered unconditionally on top.
                    .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("mandrake_flower", "mandrake_flower_emissive"))))
            .withFeature(EmanationFeature.class, EmanationFeature.builder()
                    // Curse: flower scream — poison, nausea, hunger radiate outward
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_HURT)
                            .effect(EmanationEffects.aoe(8.0f,
                                    EmanationEffects.applyToTarget(MobEffects.POISON,    100, 0),
                                    EmanationEffects.applyToTarget(MobEffects.CONFUSION, 100, 0),
                                    EmanationEffects.applyToTarget(MobEffects.HUNGER,    100, 0)))
                            .build())
                    // Blessings
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.COOKIE))
                            .effect(EmanationEffects.applyToGiver(MobEffects.REGENERATION, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.BONE_MEAL))
                            .effect(EmanationEffects.applyToGiver(MobEffects.DAMAGE_BOOST, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.CLAY_BALL))
                            .effect(EmanationEffects.applyToGiver(MobEffects.LUCK, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.WATER_BUCKET))
                            .effect(EmanationEffects.applyToGiver(MobEffects.HEALTH_BOOST, 200, 0))
                            .consumesGift(true).build())
                    .build())
            .withFeature(SoundFeature.class, new SoundFeature()
                    .withSound(SoundFeature.SoundType.AMBIENT, MonstersSounds.MANDRAKE_FLOWER_AMBIENT.value())
                    .withSound(SoundFeature.SoundType.INTERACT, "sing",  MonstersSounds.MANDRAKE_FLOWER_AMBIENT.value())
                    .withSound(SoundFeature.SoundType.INTERACT, "sing2", MonstersSounds.MANDRAKE_FLOWER_AMBIENT.value())
                    .withSound(SoundFeature.SoundType.HURT,    MonstersSounds.MANDRAKE_HURT.value())
                    .withSound(SoundFeature.SoundType.DEATH,   MonstersSounds.MANDRAKE_DEATH.value()));

    /**
     * Wire Mandrake Fructus ceiling planting — add PlantingFeature to MandrakeFamily.FRUCTUS
     * Plants Cave Vines on the underside of valid ceiling blocks (stone, deepslate, etc.)
     * in Lush Caves and Flower Forest biomes.
     */
    public static final MandrakeFamily FRUCTUS = create("mandrake_fructus")
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mandrake_fructus", "mandrake_fructus_berry", "mandrake_fructus_glow_berry", "mandrake_fructus_glow_berry_twintails")
                    .withDefault("mandrake_fructus", "mandrake_fructus_glow_berry"))
            .withFeature(FoodFeature.class, new FoodFeature().withFood(Items.GLOW_BERRIES, 0.6F).withFood(Items.COOKIE, 0.3F))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,12, 1, 3, Biomes.LUSH_CAVES, Biomes.FLOWER_FOREST)
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    // Ceiling planting: Cave Vines hang from the underside of stone/deepslate/dripstone ceilings.
                    // PlantDirection.UP validates the block ABOVE the candidate (must be a valid ceiling block),
                    // and the candidate itself must be air. tryPlantAt() in MonsterEntity handles the UP branch.
                    .entry(PlantingFeature.PlantItem.of(Blocks.CAVE_VINES)
                            .direction(PlantingFeature.PlantDirection.UP)
                            .allowedBlocks(
                                    Blocks.STONE,
                                    Blocks.DEEPSLATE,
                                    Blocks.COBBLESTONE,
                                    Blocks.MOSSY_COBBLESTONE,
                                    Blocks.DRIPSTONE_BLOCK,
                                    Blocks.CALCITE,
                                    Blocks.TUFF,
                                    Blocks.GRASS_BLOCK,
                                    Blocks.DIRT)
                            .build())
                    .build())
            .withFeature(EmanationFeature.class, EmanationFeature.builder()
                    // Curse: fruity scream — blindness, darkness, slowness radiate outward
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_HURT)
                            .effect(EmanationEffects.aoe(8.0f,
                                    EmanationEffects.applyToTarget(MobEffects.BLINDNESS,         100, 0),
                                    EmanationEffects.applyToTarget(MobEffects.DARKNESS,          100, 0),
                                    EmanationEffects.applyToTarget(MobEffects.MOVEMENT_SLOWDOWN, 100, 0)))
                            .build())
                    // Blessings
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.GLOW_BERRIES))
                            .effect(EmanationEffects.applyToGiver(MobEffects.REGENERATION, 200, 0))
                            .effect(EmanationEffects.applyToGiver(MobEffects.NIGHT_VISION,  200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.BONE_MEAL))
                            .effect(EmanationEffects.applyToGiver(MobEffects.DAMAGE_BOOST, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.CLAY_BALL))
                            .effect(EmanationEffects.applyToGiver(MobEffects.LUCK, 200, 0))
                            .consumesGift(true).build())
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_GIFT)
                            .condition(EmanationConditions.giftIs(Items.WATER_BUCKET))
                            .effect(EmanationEffects.applyToGiver(MobEffects.DIG_SPEED, 200, 0))
                            .consumesGift(true).build())
                    .build())
            .withFeature(SoundFeature.class, new SoundFeature()
                    .withSound(SoundFeature.SoundType.AMBIENT, MonstersSounds.MANDRAKE_FRUCTUS_AMBIENT.value())
                    .withSound(SoundFeature.SoundType.INTERACT, "sing",  MonstersSounds.MANDRAKE_FRUCTUS_AMBIENT.value())
                    .withSound(SoundFeature.SoundType.INTERACT, "sing2", MonstersSounds.MANDRAKE_FRUCTUS_AMBIENT.value())
                    .withSound(SoundFeature.SoundType.HURT,    MonstersSounds.MANDRAKE_HURT.value())
                    .withSound(SoundFeature.SoundType.DEATH,   MonstersSounds.MANDRAKE_DEATH.value()));

    // -- Static Initialization --

    static {
        // Register texture variants for all mandrake colors
        registerVariants();

        // No belly in 1.20.4 — register full texture counts so TextureID is treated
        // as a pure texture index with no belly offset during MigrationStep_V1_MG.
        MigrationStep_V1_MG.registerBaseTextureCount("mandrake_chorus", 1); // single chyra variant
        MigrationStep_V1_MG.registerBaseTextureCount("mandrake_flower", 5); // blue, brown, green, yellow + default
        MigrationStep_V1_MG.registerBaseTextureCount("mandrake_fructus",3); // berry, glow_berry, glow_berry_twintails
    }

    // -- Constructors --

    /**
     * Creates a new Mandrake entity type with the specified key.
     *
     * @param key the unique identifier for this mandrake variant
     */
    public MandrakeFamily(String key) {
        super(key);
        
        // Override combat stats specific to Mandrakes (flying entities)
        withCombatStats(
            18.0f,  // health - moderate for flying entity
            3.0f,   // attack - low damage
            1.2f,   // attack speed
            0.1f,   // armor - minimal
            0.2f,   // toughness - minimal
            0.0f,   // knockback resistance - none
            0.3F    // move speed
        );
    }

    // -- Factory Methods --

    /**
     * <p>Creates and registers a new Mandrake entity type variant.</p>
     * 
     * @param key the unique identifier for the variant
     * @return the created MandrakeFamily instance
     */
    private static MandrakeFamily create(String key) {
        MandrakeFamily variant = new MandrakeFamily(key);
        VARIANTS.add(variant);
        return variant;
    }

    // -- Variant Configuration --

    @Override
    protected void configureVariants() {
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
     * <p>Registers all Mandrake texture variants in the global variant registry.</p>
     * <p>
     * <b>Registration Pattern:</b> Each color variant gets both default and tummy textures
     * registered in the global texture variant registry for dynamic access.
     */
    private static void registerVariants() {
        // Register Cream Mandrake variants
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_chorus_chyra", "Chorus Mandrake Chyra", getTextureResource("mandrake_chorus", "mandrake_chorus_chyra"),1));

        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_flower_blue", "Flower Mandrake Blue", getTextureResource("mandrake_flower", "mandrake_flower_blue"),1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_flower_brown", "Flower Mandrake Brown", getTextureResource("mandrake_flower", "mandrake_flower_brown"), 2));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_flower_brown_twintails", "Flower Mandrake brown", getTextureResource("mandrake_flower", "mandrake_flower_brown_twintails"), 3));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_flower_green", "Flower Mandrake Green", getTextureResource("mandrake_flower", "mandrake_flower_green"), 4));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_flower_green_twintails", "Flower Mandrake Green Twintails", getTextureResource("mandrake_flower", "mandrake_flower_green_twintails"), 5));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_flower_yellow_ponytail", "Flower Mandrake Yellow Ponytail", getTextureResource("mandrake_flower", "mandrake_flower_yellow_ponytail"), 6));

        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_fructus_berry", "Fructus Mandrake Berry", getTextureResource("mandrake_fructus", "mandrake_fructus_berry"), 1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_fructus_glow_berry", "Fructus Mandrake Glow Berry", getTextureResource("mandrake_fructus", "mandrake_fructus_glow_berry"), 2));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mandrake_fructus_glow_berry_twintails", "Fructus Mandrake Glow Berry Twintails", getTextureResource("mandrake_fructus", "mandrake_fructus_glow_berry_twintails"), 3));

        // Register shared model variant (all mandrakes use the same model)
        VariantRegistries.MODELS.register(new StandardModelVariant("mandrake_chorus_default",  "Chorus Mandrake Model",  getModelResource("mandrake_chorus_girl"),  1));
        VariantRegistries.MODELS.register(new StandardModelVariant("mandrake_flower_default",  "Flower Mandrake Model",  getModelResource("mandrake_flower_girl"),  1));
        VariantRegistries.MODELS.register(new StandardModelVariant("mandrake_fructus_default", "Fructus Mandrake Model", getModelResource("mandrake_fructus_girl"), 1));

        // -- Animator profiles --
        // mandrake_chorus_girl:  idle, ride, rest, walk, hurt
        // hurtSpeed = animation_length / sound_duration = 1.04s / 1.36s ≈ 0.765
        // This slows the hurt animation, so it ends exactly when mandrake_hurt.ogg ends.
        AnimationProfile CHORUS_PROFILE = AnimationProfile.builder()
                .idle("idle")
                .walk("walk")
                .rest("rest")
                .sit("ride")
                .hurt("hurt")
                .hurtSpeed(1.04 / 1.36)
                .build();

        // mandrake_flower_girl:  idle, idle2, ride, walk, hurt, sing, sing2
        // sing  = PLAY_ONCE: a short musical phrase, plays once and returns to idle
        // sing2 = LOOP: sustained humming, loops until entity moves or is interrupted
        // hurtSpeed = 1.04s animation / 1.36s sound = 0.765 — syncs animation end with scream end
        AnimationProfile FLOWER_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle",  4, LoopBehavior.LOOP)
                            .add("idle2", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk("walk")
                .sit("ride")
                .hurt("hurt")
                .hurtSpeed(1.04 / 1.36)
                .special("idle_specials", AnimationPool.builder()
                        .add("sing",  3, LoopBehavior.PLAY_ONCE)
                        .add("sing2", 1, LoopBehavior.LOOP)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        // mandrake_fructus_girl: idle, ride, walk, hurt, sing, sing2
        // sing  = PLAY_ONCE: short phrase; sing2 = LOOP: sustained hum
        // hurtSpeed = 1.04s animation / 1.36s sound = 0.765
        AnimationProfile FRUCTUS_PROFILE = AnimationProfile.builder()
                .idle("idle")
                .walk("walk")
                .sit("ride")
                .hurt("hurt")
                .hurtSpeed(1.04 / 1.36)
                .special("idle_specials", AnimationPool.builder()
                        .add("sing",  3, LoopBehavior.PLAY_ONCE)
                        .add("sing2", 1, LoopBehavior.LOOP)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mandrake_chorus_default",  "Chorus Mandrake Animations",  getAnimatorResource("mandrake_chorus_girl"),  CHORUS_PROFILE,  1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mandrake_flower_default",  "Flower Mandrake Animations",  getAnimatorResource("mandrake_flower_girl"),  FLOWER_PROFILE,  1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mandrake_fructus_default", "Fructus Mandrake Animations", getAnimatorResource("mandrake_fructus_girl"), FRUCTUS_PROFILE, 1));
    } // registerVariants ()

} // Class: MandrakeFamily