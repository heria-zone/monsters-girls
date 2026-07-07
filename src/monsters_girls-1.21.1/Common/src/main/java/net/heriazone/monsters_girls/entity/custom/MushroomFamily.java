package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.*;
import net.heriazone.hzlib.api.entity.features.SoundFeature;
import net.heriazone.hzlib.api.entity.features.RangedAttackFeature;
import net.heriazone.hzlib.api.entity.features.exchange.*;
import net.heriazone.hzlib.api.entity.features.emanation.*;
import net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlaySlot;
import net.heriazone.hzlib.api.entity.features.variants.*;
import net.heriazone.hzlib.api.rendering.RenderConditions;
import net.heriazone.hzlib.api.animation.AnimationPool;
import net.heriazone.hzlib.api.animation.AnimationProfile;
import net.heriazone.hzlib.api.animation.LoopBehavior;
import net.heriazone.hzlib.api.animation.SelectionStrategy;
import net.heriazone.hzlib.api.entity.NativeEntity;
import net.heriazone.hzlib.api.entity.variants.VariantRegistries;
import net.heriazone.monsters_girls.entity.BellyLevel;
import net.heriazone.monsters_girls.entity.feature.BellyFeature;
import net.heriazone.hzlib.framework.entity.variants.*;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG;
import net.heriazone.monsters_girls.entity.feature.GenesisFeature;
import net.heriazone.monsters_girls.source.MonstersBlocks;
import net.heriazone.monsters_girls.source.MonstersSounds;
import net.heriazone.monsters_girls.world.BiomesUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * <p>Entity type definitions for all Mushroom entity families.</p>
 * <p>
 * <b>Model Groups:</b> Mushroom types share models across families to reduce asset overhead.
 * Brown/Molten/Infernal use {@code mushroom_brown_girl}; Amanita/Crimson/Warped use
 * {@code mushroom_girl_default}; Inkcaps, Puffball, Snowball, and Soul Wanderer each
 * have their own dedicated model.
 * <p>
 * <b>Texture Pattern:</b> {@code mushroom_{family}/{mushroom_family_variant}.png}
 */
@SuppressWarnings("unchecked")
public class MushroomFamily extends MonstersFamily<MushroomFamily> {

    // -- Overlay Slot Keys --

    /**
     * RANDOM slot: Halloween costume chosen once at spawn, persisted in synced entity
     * data + NBT. One of three pumpkin costume variants (black / orange / white) is
     * picked uniformly. Applies to all variants that use either the {@code mushroom_brown_girl}
     * or {@code mushroom_girl_default} model group.
     * <p>
     * The stored value is the full texture path of the chosen hat. The {@code SLOT_COSTUME}
     * CONDITIONAL slot reads this at render time and shows it only in October.
     */
    public static final String SLOT_COSTUME  = "costume";

    /**
     * ALWAYS slot: per-variant emissive glow rendered unconditionally on top of all
     * other layers. Used by Crimson, Molten, Puffball, Snowball, Soul Wanderer, and Warped.
     */
    public static final String SLOT_EMISSIVE = "emissive";

    /**
     * CONDITIONAL slot: belly overlay for Warped mushrooms — CHUBBY at level >= 1,
     * TUMMY at level >= 2 (first-match wins, highest level listed first).
     */
    public static final String SLOT_BELLY    = "belly";

    // -- Constants --

    /** All registered Mushroom variants — used for iteration during attribute/renderer registration. */
    public static final List<MushroomFamily> VARIANTS = new ArrayList<>();

    // -- Shared OverlayFeature instances --

    /**
     * Halloween costume overlay for mushrooms that use the {@code mushroom_brown_girl} model
     * (Brown, Infernal). Three pumpkin hat colour variants; one is chosen at spawn
     * and persisted. Shown only in October.
     * <p>
     * <b>Emissive note:</b> Brown and Infernal have no authored emissive textures, so this
     * instance contains only the costume slot. Molten uses its own instance that also
     * includes an emissive slot.
     */
    public static final OverlayFeature BROWN_GIRL_COSTUME = new OverlayFeature()
            .addSlot(OverlaySlot.random(SLOT_COSTUME,
                    "monsters_girls:textures/layer/mushroom_brown_girl/custume-pumpkin-black.png",
                    "monsters_girls:textures/layer/mushroom_brown_girl/custume-pumpkin-orange.png",
                    "monsters_girls:textures/layer/mushroom_brown_girl/custume-pumpkin-white.png")
                    .withRenderCondition(RenderConditions.inMonth(Month.OCTOBER))); // Month.OCTOBER

    /**
     * Halloween costume overlay for mushrooms that use the {@code mushroom_girl_default} model
     * (Amanita). Three witch hat colour variants; one chosen at spawn and shown only in October.
     * <p>
     * <b>Emissive note:</b> Amanita has no authored emissive texture. Crimson, Soul Wanderer,
     * and Warped each have their own instances that include both costume and emissive slots.
     */
    public static final OverlayFeature DEFAULT_GIRL_COSTUME = new OverlayFeature()
            .addSlot(OverlaySlot.random(SLOT_COSTUME,
                    "monsters_girls:textures/layer/mushroom_girl_default/witch-blue.png",
                    "monsters_girls:textures/layer/mushroom_girl_default/witch-purple.png",
                    "monsters_girls:textures/layer/mushroom_girl_default/witch-red.png")
                    .withRenderCondition(RenderConditions.inMonth(Month.OCTOBER))); // Month.OCTOBER

    // -- Amanita family --

    public static final MushroomFamily AMANITA = create("mushroom_amanita")
            .withFeature(GenesisFeature.class, new GenesisFeature(Blocks.RED_MUSHROOM, Level.OVERWORLD))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.COOKIE))
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_amanita", "mushroom_amanita_pharia", "mushroom_amanita_red", "mushroom_amanita_yellow")
                    .withDefault("mushroom_amanita", "mushroom_amanita_red"))
            .withFeature(ConditionalAppearanceFeature.class, ConditionalAppearanceFeature.builder()
                    // Most-specific rules first — jungle/lush/mangrove must be checked before
                    // the broad ForestBiomesNoConiferous catch-all, which also contains these biomes.
                    .when(AppearanceConditions.inBiome(Biomes.LUSH_CAVES, Biomes.MANGROVE_SWAMP, Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE, Biomes.SPARSE_JUNGLE), "mushroom_amanita_pharia")
                    .when(AppearanceConditions.inBiome(BiomesUtils.ConiferousBiomes.toArray(new ResourceKey[0])),         "mushroom_amanita_yellow")
                    .when(AppearanceConditions.inBiome(BiomesUtils.ForestBiomesNoConiferous.toArray(new ResourceKey[0])), "mushroom_amanita_red")
                    .withDefault("mushroom_amanita_red").build())
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,12, 1, 2, Stream.of(
                            BiomesUtils.ForestBiomesNoConiferous.stream(),
                            BiomesUtils.ConiferousBiomes.stream(),
                            BiomesUtils.JungleForestBiomes.stream(),
                            Stream.of(Biomes.LUSH_CAVES, Biomes.MANGROVE_SWAMP)
                    ).flatMap(s -> s).toArray(ResourceKey[]::new))
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(Blocks.RED_MUSHROOM).allowedBlocks(Blocks.GRASS_BLOCK, Blocks.MYCELIUM, Blocks.PODZOL).build()).build())
            .withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                    .ownerOnly()
                    .globalFeedback(ExchangeFeedback.builder()
                            .sound(SoundEvents.BUCKET_FILL)
                            .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                            .build())
                    // Flower biome → suspicious stew (more specific rule first)
                    .rule(ExchangeRule.builder()
                            .inputs(Items.BOWL)
                            .condition(ExchangeConditions.inBiome(
                                    Biomes.FLOWER_FOREST, Biomes.SUNFLOWER_PLAINS, Biomes.CHERRY_GROVE))
                            .output(MushroomFamily::buildSuspiciousStew)
                            .cooldown(6000)
                            .build())
                    // Anywhere else → plain suspicious stew fallback
                    .rule(ExchangeRule.builder()
                            .inputs(Items.BOWL)
                            .output(() -> new ItemStack(Items.MUSHROOM_STEW))
                            .cooldown(6000)
                            .build())
                    .build())
            .withFeature(OverlayFeature.class, DEFAULT_GIRL_COSTUME);

    // -- Brown family --

    public static final MushroomFamily BROWN = create("mushroom_brown")
            .withFeature(GenesisFeature.class, new GenesisFeature(Blocks.BROWN_MUSHROOM, Level.OVERWORLD))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.COOKIE))
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_brown", "mushroom_brown_boletus", "mushroom_brown_orange_birch", "mushroom_brown_ruby", "mushroom_brown_scarlatina")
                    .withDefault("mushroom_brown", "mushroom_brown_boletus"))
            .withFeature(ConditionalAppearanceFeature.class, ConditionalAppearanceFeature.builder()
                    .when(AppearanceConditions.inBiome(BiomesUtils.ConiferousBiomes.toArray(new ResourceKey[0])),   "mushroom_brown_ruby")
                    .when(AppearanceConditions.inBiome(Biomes.DARK_FOREST),                                         "mushroom_brown_scarlatina")
                    .when(AppearanceConditions.inBiome(BiomesUtils.BirchForestBiomes.toArray(new ResourceKey[0])), "mushroom_brown_orange_birch")
                    .withDefault("mushroom_brown_boletus").build())
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,12, 1, 3, Stream.of(
                            BiomesUtils.ConiferousBiomes.stream(),
                            BiomesUtils.BirchForestBiomes.stream(),
                            Stream.of(Biomes.DARK_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW)
                    ).flatMap(s -> s).toArray(ResourceKey[]::new))
                    .withPlacements(
                            SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(Blocks.BROWN_MUSHROOM).allowedBlocks(Blocks.GRASS_BLOCK, Blocks.MYCELIUM, Blocks.PODZOL).build()).build())
            .withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                    .ownerOnly()
                    .globalFeedback(ExchangeFeedback.builder()
                            .sound(SoundEvents.BUCKET_FILL)
                            .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                            .build())
                    .rule(ExchangeRule.builder()
                            .inputs(Items.BOWL)
                            .output(() -> new ItemStack(Items.MUSHROOM_STEW))
                            .cooldown(6000)
                            .build())
                    .build())
            .withFeature(OverlayFeature.class, BROWN_GIRL_COSTUME);

    // -- Crimson family --

    public static final MushroomFamily CRIMSON = create("mushroom_crimson")
            .withFeature(GenesisFeature.class, new GenesisFeature(Blocks.CRIMSON_FUNGUS))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.COOKIE))
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_crimson", "mushroom_crimson_red", "mushroom_crimson_pink")
                    .withDefault("mushroom_crimson", "mushroom_crimson_red"))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE, 8, 1, 2, Biomes.CRIMSON_FOREST)
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(Blocks.CRIMSON_FUNGUS).allowedBlocks(Blocks.CRIMSON_NYLIUM).build())
                    .build())
            .withFeature(OverlayFeature.class, new OverlayFeature()
                    // RANDOM: Halloween witch hat — same three-colour pool as other default-model mushrooms.
                    .addSlot(OverlaySlot.random(SLOT_COSTUME,
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-blue.png",
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-purple.png",
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-red.png")
                            .withRenderCondition(RenderConditions.inMonth(Month.OCTOBER)))
                    // ALWAYS: per-colour emissive — red and pink each have their own texture.
                    // Resolved dynamically from the entity's current TEXTURE_VARIANT key.
                    .addSlot(OverlaySlot.alwaysDynamic(SLOT_EMISSIVE, MushroomFamily::crimsonEmissivePath).asEmissive()));

    // -- Infernal family --

    public static final MushroomFamily INFERNAL = create("mushroom_infernal")
            .withFeature(GenesisFeature.class, new GenesisFeature(Set.of(Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM), Level.NETHER))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.COOKIE))
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_infernal", "mushroom_infernal_red", "mushroom_infernal_yellow")
                    .withDefault("mushroom_infernal", "mushroom_infernal_red"))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,12, 1, 3, Biomes.NETHER_WASTES)
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    // Plants red and brown mushrooms on valid nether surfaces
                    .entry(PlantingFeature.PlantItem.of(Blocks.RED_MUSHROOM).allowedBlocks(Blocks.NETHERRACK, Blocks.SOUL_SAND, Blocks.SOUL_SOIL, Blocks.NETHER_WART_BLOCK).build())
                    .entry(PlantingFeature.PlantItem.of(Blocks.BROWN_MUSHROOM).allowedBlocks(Blocks.NETHERRACK, Blocks.SOUL_SAND, Blocks.SOUL_SOIL, Blocks.NETHER_WART_BLOCK).build())
                    .build())
            .withFeature(OverlayFeature.class, BROWN_GIRL_COSTUME);

    // -- Inkcaps family --

    public static final MushroomFamily INKCAPS = create("mushroom_inkcaps")
            // Genesis-only — does not spawn naturally. Triggered by Inkcap Mushroom block in Overworld.
            .withFeature(GenesisFeature.class, new GenesisFeature(MonstersBlocks.INKCAP_MUSHROOM, Level.OVERWORLD))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.COOKIE))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(MonstersBlocks.INKCAP_MUSHROOM)
                            .allowedBlocks(Blocks.GRASS_BLOCK, Blocks.MYCELIUM, Blocks.PODZOL).build())
                    .build())
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_inkcaps", "mushroom_inkcaps_dark", "mushroom_inkcaps_pale", "mushroom_inkcaps_white")
                    .withDefault("mushroom_inkcaps", "mushroom_inkcaps_dark"));

    // -- Molten family --

    public static final MushroomFamily MOLTEN = create("mushroom_molten")
            .withFeature(GenesisFeature.class, new GenesisFeature(MonstersBlocks.MOLTEN_FUNGUS))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.BLAZE_POWDER))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE, 8, 1, 2, Biomes.BASALT_DELTAS)
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(MonstersBlocks.MOLTEN_FUNGUS)
                            .allowedBlocks(Blocks.MAGMA_BLOCK, Blocks.BASALT, Blocks.BLACKSTONE).build())
                    .build())
            .withFeature(EmanationFeature.class, EmanationFeature.builder()
                    // Her fire nature: what she touches ignites
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_ATTACK)
                            .effect(EmanationEffects.igniteTarget(4))
                            .build())
                    .build())
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_molten", "mushroom_molten_default")
                    .withDefault("mushroom_molten", "mushroom_molten_default"))
            .withFeature(OverlayFeature.class, new OverlayFeature()
                    // RANDOM: Halloween pumpkin hat — same three-colour pool as other brown-model mushrooms.
                    .addSlot(OverlaySlot.random(SLOT_COSTUME,
                            "monsters_girls:textures/layer/mushroom_brown_girl/custume-pumpkin-black.png",
                            "monsters_girls:textures/layer/mushroom_brown_girl/custume-pumpkin-orange.png",
                            "monsters_girls:textures/layer/mushroom_brown_girl/custume-pumpkin-white.png")
                            .withRenderCondition(RenderConditions.inMonth(Month.OCTOBER)))
                    // ALWAYS: single emissive glow texture.
                    .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("mushroom_molten", "mushroom_molten_emissive")).asEmissive()));

    // -- Puffball family --

    public static final MushroomFamily PUFFBALL = create("mushroom_puffball")
            .withFeature(GenesisFeature.class, new GenesisFeature(MonstersBlocks.ENDER_MUSHROOM))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.CHORUS_FRUIT))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE, 8, 1, 2,
                            BiomesUtils.EndBiomes.toArray(new ResourceKey[0]))
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(MonstersBlocks.ENDER_MUSHROOM)
                            .allowedBlocks(Blocks.END_STONE).build())
                    .build())
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_puffball", "mushroom_puffball_default", "mushroom_puffball_pale")
                    .withDefault("mushroom_puffball", "mushroom_puffball_default"))
            .withFeature(OverlayFeature.class, new OverlayFeature()
                    // ALWAYS: per-variant emissive — default and pale each have their own texture,
                    // and the base "mushroom_puffball" key maps to the ender (enderpuffball) variant.
                    .addSlot(OverlaySlot.alwaysDynamic(SLOT_EMISSIVE, MushroomFamily::puffballEmissivePath).asEmissive()));

    /**
     * Fluffball — the End biome flying subspecies of the Puffball mushroom family.
     * <p>
     * <b>Character:</b> Lighter and more ethereal than the ground-dwelling Puffball, Fluffball
     * uses {@code FlyTamableEntity} for flying AI
     * goals and {@code FlyingPathNavigation}. She spawns in the End, plants Ender Mushrooms
     * on End Stone, and hovers around her owner.
     * <p>
     * <b>Assets:</b> Uses {@code ender_puffball_girl.png} as the base texture and
     * {@code enderpuffball_emissive.png} for the always-on emissive layer. Shares the
     * {@code mushroom_puffball_girl} model and animator with PUFFBALL.
     * <p>
     * <b>Variant key:</b> {@code "mushroom_puffball"} is used as the texture variant key
     * so that {@link #puffballEmissivePath} resolves correctly to the ender emissive texture
     * without adding a new path helper.
     */
    public static final MushroomFamily FLUFFBALL = create("mushroom_fluffball")
            .withFeature(GenesisFeature.class, new GenesisFeature(MonstersBlocks.ENDER_MUSHROOM))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.CHORUS_FRUIT))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE, 4, 1, 2,
                            BiomesUtils.EndBiomes.toArray(new ResourceKey[0]))
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(MonstersBlocks.ENDER_MUSHROOM)
                            .allowedBlocks(Blocks.END_STONE).build())
                    .build())
            // Single texture variant — ender_puffball_girl.png.
            // The variant key "mushroom_puffball" reuses puffballEmissivePath which maps the
            // base key to enderpuffball_emissive.png — no extra path helper needed.
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_fluffball", "mushroom_puffball")
                    .withDefault("mushroom_fluffball", "mushroom_puffball"))
            .withFeature(OverlayFeature.class, new OverlayFeature()
                    // ALWAYS: enderpuffball emissive — resolved via the shared puffballEmissivePath helper
                    // which maps the "mushroom_puffball" key to enderpuffball_emissive.png.
                    .addSlot(OverlaySlot.alwaysDynamic(SLOT_EMISSIVE, MushroomFamily::puffballEmissivePath).asEmissive()));

    // -- Snowball family --

    public static final MushroomFamily SNOWBALL = create("mushroom_snowball")
            .withFeature(GenesisFeature.class, new GenesisFeature(MonstersBlocks.SNOWBALL_MUSHROOM, Level.OVERWORLD))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.SNOWBALL, Items.COOKIE))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE, 8, 1, 2,
                            BiomesUtils.SnowyBiomes.toArray(new ResourceKey[0]))
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(MonstersBlocks.SNOWBALL_MUSHROOM)
                            .allowedBlocks(Blocks.SNOW_BLOCK, Blocks.MYCELIUM).build())
                    .build())
            .withFeature(EmanationFeature.class, EmanationFeature.builder()
                    // Her frost nature: what she strikes slows and freezes
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_ATTACK)
                            .effect(EmanationEffects.applyToTarget(MobEffects.MOVEMENT_SLOWDOWN, 100, 1))
                            .effect(EmanationEffects.freezeTarget(70))
                            .build())
                    .build())
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_snowball", "mushroom_snowball_default")
                    .withDefault("mushroom_snowball", "mushroom_snowball_default"))
            .withFeature(OverlayFeature.class, new OverlayFeature()
                    // ALWAYS: single emissive glow texture.
                    .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("mushroom_snowball", "mushroom_snowball_emissive")).asEmissive()));

    // -- Soul Wanderer family --

    public static final MushroomFamily SOUL_WANDERER = create("mushroom_soul_wanderer")
            .withFeature(GenesisFeature.class, new GenesisFeature(MonstersBlocks.SOUL_WANDERER_FUNGUS))
            .withFeature(FoodFeature.class, new FoodFeature()
                    .withFoods(Items.ROTTEN_FLESH, Items.COOKIE, Items.NETHER_WART))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE, 6, 1, 1,
                            BiomesUtils.SoulSandValleyBiomes.toArray(new ResourceKey[0]))
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(MonstersBlocks.SOUL_WANDERER_FUNGUS)
                            .allowedBlocks(Blocks.SOUL_SAND, Blocks.SOUL_SOIL).build())
                    .build())
            .withFeature(EmanationFeature.class, EmanationFeature.builder()
                    // Her soul nature: wither flows into foes, life flows back to herself
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_ATTACK)
                            .effect(EmanationEffects.applyToTarget(MobEffects.WITHER, 60, 0))
                            .effect(EmanationEffects.applyToSelf(MobEffects.REGENERATION, 60, 0))
                            .build())
                    // Undead bonus: soul energy surges against those already claimed by death
                    .rule(EmanationRule.builder()
                            .trigger(EmanationTrigger.ON_ATTACK)
                            .condition(EmanationConditions.targetIsUndead())
                            .effect(EmanationEffects.dealBonusDamage(0.7f))
                            .build())
                    .build())
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_soul_wanderer", "mushroom_soul_wanderer_default")
                    .withDefault("mushroom_soul_wanderer", "mushroom_soul_wanderer_default"))
            .withFeature(OverlayFeature.class, new OverlayFeature()
                    // RANDOM: Halloween witch hat — same pool as other default-model mushrooms.
                    .addSlot(OverlaySlot.random(SLOT_COSTUME,
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-blue.png",
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-purple.png",
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-red.png")
                            .withRenderCondition(RenderConditions.inMonth(Month.OCTOBER)))
                    // ALWAYS: single emissive glow texture.
                    .addSlot(OverlaySlot.always(SLOT_EMISSIVE, getLayerResource("mushroom_soul_wanderer", "mushroom_soul_wanderer_emissive")).asEmissive()));

    // -- Warped family --

    public static final MushroomFamily WARPED = create("mushroom_warped")
            .withFeature(GenesisFeature.class, new GenesisFeature(Blocks.WARPED_FUNGUS, Level.NETHER))
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.COOKIE))
            .withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                    .withVariants("mushroom_warped", "mushroom_warped_green", "mushroom_warped_blue")
                    .withDefault("mushroom_warped", "mushroom_warped_green"))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE, 8, 1, 2, Biomes.WARPED_FOREST)
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)))
            .withFeature(PlantingFeature.class, PlantingFeature.builder()
                    .globalCooldown(3600)
                    .entry(PlantingFeature.PlantItem.of(Blocks.WARPED_FUNGUS).allowedBlocks(Blocks.WARPED_NYLIUM).build())
                    .build())
            // BellyFeature: TUMMY cap — CHUBBY and TUMMY authored per color (blue / green).
            // The texture paths are resolved dynamically at render time via warpedBellyChubbyPath()
            // and warpedBellyTummyPath() in the CONDITIONAL overlay slot below.
            // BellyFeature here only enforces the max-level cap for handleBellyProgression().
            .withFeature(BellyFeature.class, new BellyFeature()
                    .maxLevel(BellyLevel.TUMMY))
            .withFeature(OverlayFeature.class, new OverlayFeature()
                    // RANDOM: Halloween witch hat — same pool as other default-model mushrooms.
                    .addSlot(OverlaySlot.random(SLOT_COSTUME,
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-blue.png",
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-purple.png",
                            "monsters_girls:textures/layer/mushroom_girl_default/witch-red.png")
                            .withRenderCondition(RenderConditions.inMonth(Month.OCTOBER)))
                    // CONDITIONAL: belly — TUMMY first (highest wins), then CHUBBY.
                    // Paths resolved dynamically from the entity's texture variant key (contains "_blue" or "_green").
                    .addSlot(OverlaySlot.conditional(SLOT_BELLY,
                            OverlaySlot.entryDynamicConditional("tummy",
                                    MushroomFamily::warpedBellyTummyPath,
                                    RenderConditions.bellyAtLeast(BellyLevel.TUMMY.getLevel())),
                            OverlaySlot.entryDynamicConditional("chubby",
                                    MushroomFamily::warpedBellyChubbyPath,
                                    RenderConditions.bellyAtLeast(BellyLevel.CHUBBY.getLevel()))))
                    // ALWAYS: per-colour emissive — blue and green each have their own texture.
                    .addSlot(OverlaySlot.alwaysDynamic(SLOT_EMISSIVE, MushroomFamily::warpedEmissivePath).asEmissive()));

    // -- Static Initialization --

    static {
        registerVariants();

        // -- 1.20.4 belly/texture disambiguation for MigrationStep_V1_MG --

        // Mushroom WARPED (Sprint 10): had BellyFeature — 1 base texture per color,
        // belly offset at TextureID 1 (CHUBBY) and 2 (TUMMY).
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_warped_blue",  1);
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_warped_green", 1);
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_warped_red",   1);

        // All other mushroom families had NO belly in 1.20.4 — TextureID is a pure index.
        // Register full texture counts so no ID is misread as a belly offset.
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_amanita",       4); // pharia, red, yellow + default
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_brown",         4); // boletus, orange_birch, ruby, scarlatina
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_crimson",       2); // red, pink
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_infernal",      2); // red, yellow
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_inkcaps",       3); // dark, pale, white
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_molten",        1); // single default
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_puffball",      2); // default, pale
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_snowball",      1); // single default
        MigrationStep_V1_MG.registerBaseTextureCount("mushroom_soul_wanderer", 1); // single default
    }

    // -- Constructors --

    /**
     * Creates a new Mushroom entity type with the specified key.
     *
     * @param key the unique identifier for this mushroom variant
     */
    public MushroomFamily(String key) {
        super(key);
        withCombatStats(
            15.0F,  // health
            2.0F,   // attack
            1.2F,   // attack speed
            0.1F,   // armor
            0.2F,   // toughness
            0.0F,   // knockback resistance
            0.3F    // move speed
        );
        withFeature(SoundFeature.class, new SoundFeature()
                .withSound(SoundFeature.SoundType.AMBIENT, MonstersSounds.MUSHROOM_AMBIENT.value()));
    } // Constructor: MushroomFamily ()

    // -- Factory Methods --

    /**
     * Creates and registers a new Mushroom entity type variant.
     *
     * @param key the unique identifier for the variant
     * @return the created MushroomFamily instance
     */
    private static MushroomFamily create(String key) {
        MushroomFamily variant = new MushroomFamily(key);
        VARIANTS.add(variant);
        return variant;
    } // create ()

    // -- Variant Configuration --

    @Override
    protected void configureVariants() {
        // Model and animator are resolved per-family in registerMushroomVariants();
        // configureVariants() sets the default key-based entries used as fallback.
        withFeature(ModelVariantFeature.class, new ModelVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));

        withFeature(AnimatorVariantFeature.class, new AnimatorVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));

        withFeature(FoodFeature.class, new FoodFeature()
                .withFoods(Items.COOKIE));
    } // configureVariants ()

    // -- Static Registration Methods --

    /**
     * Registers all Mushroom texture, model, and animator variants in the global registries.
     * <p>
     * <b>Model Sharing:</b> Brown/Molten/Infernal share {@code mushroom_brown_girl};
     * Amanita/Crimson/Warped share {@code mushroom_girl_default}.
     * Inkcaps, Puffball, Snowball, and Soul Wanderer each have dedicated assets.
     */
    private static void registerVariants() {

        // =====================================================================
        // Animation Profiles — one per animation file.
        // Specials are consolidated into a single weighted pool per family so
        // pickRandomSpecial() applies the same weighted strategy as idle/walk.
        // =====================================================================

        // -- mushroom_brown_girl: idle, idle3, walk, walk2, ride, attack, wave, belly --
        // idle3 plays occasionally; wave is the most common special, belly is rarer
        AnimationProfile BROWN_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle", 4, LoopBehavior.LOOP)
                            .add("idle3", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk(b -> b.add("walk", 3, LoopBehavior.LOOP)
                            .add("walk2", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .special("idle_specials", AnimationPool.builder()
                        .add("wave",  3, LoopBehavior.PLAY_ONCE)
                        .add("belly", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        // -- mushroom_girl_default: idle, idle2, idle3, walk, ride, attack, wave --
        // Three idle variants with decreasing weight; wave is the only special
        AnimationProfile DEFAULT_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle",  5, LoopBehavior.LOOP)
                            .add("idle2", 2, LoopBehavior.LOOP)
                            .add("idle3", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk("walk")
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .special("idle_specials", AnimationPool.builder()
                        .add("wave", 1, LoopBehavior.PLAY_ONCE)
                        .build())
                .build();

        // -- mushroom_molten_girl: idle, walk, attack, wave, belly --
        // Used by Molten and Infernal. No ride. Wave and belly as weighted specials.
        AnimationProfile MOLTEN_PROFILE = AnimationProfile.builder()
                .idle("idle")
                .walk("walk")
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .special("idle_specials", AnimationPool.builder()
                        .add("wave",  3, LoopBehavior.PLAY_ONCE)
                        .add("belly", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        // -- mushroom_inkcaps_girl: idle, idle2, idle3, walk, ride, attack, wave --
        AnimationProfile INKCAPS_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle",  5, LoopBehavior.LOOP)
                            .add("idle2", 2, LoopBehavior.LOOP)
                            .add("idle3", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk("walk")
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .special("idle_specials", AnimationPool.builder()
                        .add("wave", 1, LoopBehavior.PLAY_ONCE)
                        .build())
                .build();

        // -- mushroom_puffball_girl: idle, idle2, walk, walk2, ride, fly, attack, attack2, wave, belly, puff, puff2 --
        // fly is used when riding (airborne); attack has two variants; puff animations are rare
        AnimationProfile PUFFBALL_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle",  4, LoopBehavior.LOOP)
                            .add("idle2", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk(b -> b.add("walk",  3, LoopBehavior.LOOP)
                            .add("walk2", 1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .attack(b -> b.add("attack",  2, LoopBehavior.INTERRUPT)
                              .add("attack2", 1, LoopBehavior.INTERRUPT)
                              .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .sit("ride")
                .ride("fly")
                .special("idle_specials", AnimationPool.builder()
                        .add("wave",  4, LoopBehavior.PLAY_ONCE)
                        .add("belly", 2, LoopBehavior.PLAY_ONCE)
                        .add("puff",  1, LoopBehavior.PLAY_ONCE)
                        .add("puff2", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        // -- mushroom_snowball_girl: idle, walk, ride, attack, wave, eepy --
        // eepy (drowsy/sleepy idle) is a rare special
        AnimationProfile SNOWBALL_PROFILE = AnimationProfile.builder()
                .idle("idle")
                .walk("walk")
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .special("idle_specials", AnimationPool.builder()
                        .add("wave", 3, LoopBehavior.PLAY_ONCE)
                        .add("eepy", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        // -- mushroom_soul_girl: idle, idle_alt, idle2, walk, ride, attack, wave --
        // idle_alt is a more dramatic idle; idle2 is subtle. Both pooled into idle.
        AnimationProfile SOUL_PROFILE = AnimationProfile.builder()
                .idle(b -> b.add("idle",     6, LoopBehavior.LOOP)
                            .add("idle_alt", 2, LoopBehavior.LOOP)
                            .add("idle2",    1, LoopBehavior.LOOP)
                            .strategy(SelectionStrategy.WEIGHTED_RANDOM))
                .walk("walk")
                .attack(b -> b.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .special("idle_specials", AnimationPool.builder()
                        .add("wave", 1, LoopBehavior.PLAY_ONCE)
                        .build())
                .build();

        // =====================================================================
        // Variant registrations — textures, models, animators (with profiles)
        // =====================================================================

        // -- Brown --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_brown_boletus",        "Brown Mushroom Boletus",        getTextureResource("mushroom_brown", "mushroom_brown_boletus"),        1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_brown_orange_birch",   "Brown Mushroom Orange Birch",   getTextureResource("mushroom_brown", "mushroom_brown_orange_birch"),   2));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_brown_ruby",           "Brown Mushroom Ruby",           getTextureResource("mushroom_brown", "mushroom_brown_ruby"),           3));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_brown_scarlatina",     "Brown Mushroom Scarlatina",     getTextureResource("mushroom_brown", "mushroom_brown_scarlatina"),     4));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_brown_default",      "Brown Mushroom Model",          getModelResource("mushroom_brown_girl"),                               1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_brown_default",      "Brown Mushroom Animations",     getAnimatorResource("mushroom_brown_girl"),    BROWN_PROFILE,           1));

        // -- Amanita (mushroom_girl_default model) --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_amanita_pharia",  "Amanita Pharia",  getTextureResource("mushroom_amanita", "mushroom_amanita_pharia"),  1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_amanita_red",     "Amanita Red",     getTextureResource("mushroom_amanita", "mushroom_amanita_red"),     2));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_amanita_yellow",  "Amanita Yellow",  getTextureResource("mushroom_amanita", "mushroom_amanita_yellow"),  3));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_amanita_default", "Amanita Model",   getModelResource("mushroom_girl_default"),                          1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_amanita_default","Amanita Animations", getAnimatorResource("mushroom_girl_default"), DEFAULT_PROFILE,   1));

        // -- Crimson (mushroom_girl_default model) --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_crimson_red",   "Crimson Red",   getTextureResource("mushroom_crimson", "mushroom_crimson_red"),   1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_crimson_pink",  "Crimson Pink",  getTextureResource("mushroom_crimson", "mushroom_crimson_pink"),  2));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_crimson_default", "Crimson Model", getModelResource("mushroom_girl_default"),                       1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_crimson_default","Crimson Animations", getAnimatorResource("mushroom_girl_default"), DEFAULT_PROFILE, 1));

        // -- Infernal (mushroom_brown_girl model, mushroom_molten_girl animations) --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_infernal_red",     "Infernal Red",     getTextureResource("mushroom_infernal", "mushroom_infernal_red"),     1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_infernal_yellow",  "Infernal Yellow",  getTextureResource("mushroom_infernal", "mushroom_infernal_yellow"),  2));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_infernal_default", "Infernal Model",   getModelResource("mushroom_brown_girl"),                              1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_infernal_default","Infernal Animations", getAnimatorResource("mushroom_molten_girl"), MOLTEN_PROFILE,       1));

        // -- Inkcaps --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_inkcaps_dark",   "Inkcaps Dark",   getTextureResource("mushroom_inkcaps", "mushroom_inkcaps_dark"),   1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_inkcaps_pale",   "Inkcaps Pale",   getTextureResource("mushroom_inkcaps", "mushroom_inkcaps_pale"),   2));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_inkcaps_white",  "Inkcaps White",  getTextureResource("mushroom_inkcaps", "mushroom_inkcaps_white"),  3));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_inkcaps_default","Inkcaps Model",  getModelResource("mushroom_inkcaps_girl"),                          1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_inkcaps_default","Inkcaps Animations", getAnimatorResource("mushroom_inkcaps_girl"), INKCAPS_PROFILE, 1));

        // -- Molten (mushroom_brown_girl model) --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_molten_default",  "Molten Default",  getTextureResource("mushroom_molten", "mushroom_molten_default"),  1));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_molten_default", "Molten Model",    getModelResource("mushroom_brown_girl"),                            1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_molten_default","Molten Animations", getAnimatorResource("mushroom_molten_girl"), MOLTEN_PROFILE,     1));

        // -- Puffball --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_puffball_default","Puffball Default", getTextureResource("mushroom_puffball", "mushroom_puffball_default"), 1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_puffball_pale",   "Puffball Pale",    getTextureResource("mushroom_puffball", "mushroom_puffball_pale"),    2));
        // Fluffball reuses the ender_puffball_girl.png texture — registered under the shared key
        // "mushroom_puffball" so that puffballEmissivePath() resolves the ender emissive correctly.
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_puffball",        "Fluffball (Ender)", getTextureResource("mushroom_puffball", "ender_puffball_girl"),     3));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_puffball_default","Puffball Model",  getModelResource("mushroom_puffball_girl"),                            1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_puffball_default","Puffball Animations", getAnimatorResource("mushroom_puffball_girl"), PUFFBALL_PROFILE, 1));

        // -- Snowball --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_snowball_default","Snowball Default", getTextureResource("mushroom_snowball", "mushroom_snowball_default"), 1));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_snowball_default","Snowball Model",  getModelResource("mushroom_snowball_girl"),                            1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_snowball_default","Snowball Animations", getAnimatorResource("mushroom_snowball_girl"), SNOWBALL_PROFILE, 1));

        // -- Soul Wanderer (mushroom_girl_default model, mushroom_soul_girl animations) --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_soul_wanderer_default","Soul Wanderer Default", getTextureResource("mushroom_soul_wanderer", "mushroom_soul_wanderer_default"), 1));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_soul_wanderer_default","Soul Wanderer Model",  getModelResource("mushroom_girl_default"),                                      1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_soul_wanderer_default","Soul Wanderer Animations", getAnimatorResource("mushroom_soul_girl"), SOUL_PROFILE, 1));

        // -- Warped (mushroom_girl_default model) --
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_warped_green",   "Mushroom Warped Green ",   getTextureResource("mushroom_warped", "mushroom_warped_green"),   1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("mushroom_warped_blue",    "Mushroom Warped Blue",    getTextureResource("mushroom_warped", "mushroom_warped_blue"),    2));
        VariantRegistries.MODELS.register(   new StandardModelVariant(   "mushroom_warped_default",    "Mushroom Warped Model",        getModelResource("mushroom_girl_default"),                               1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("mushroom_warped_default",    "Mushroom Warped Animations",   getAnimatorResource("mushroom_girl_default"), DEFAULT_PROFILE,           1));

    } // registerVariants ()

    // -- Utility Methods --

    /**
     * <p>Checks if this mushroom variant supports the tummy texture.</p>
     * <p>
     * <b>Note:</b> Returns {@code false} by default — no mushroom tummy texture assets
     * have been authored yet. This method is the extension point for when they are added.
     * Override in specific variants once the tummy texture asset exists.
     *
     * @return true if a tummy texture asset is available for this variant
     */
    public boolean supportsTummyTexture() {
        return false; // No tummy textures authored yet — override when assets are added
    } // supportsTummyTexture ()

    /**
     * <p>Gets the appropriate texture variant key based on belly state.</p>
     *
     * @param hasBelly whether the entity currently has a belly
     * @return the texture variant key to use
     */
    public String getTextureVariantForBellyState(boolean hasBelly) {
        return hasBelly && supportsTummyTexture() ? key + "_tummy" : key + "_slim";
    } // getTextureVariantForBellyState ()

    // -- Emissive Path Helpers --

    /**
     * Resolves the emissive texture path for {@link #CRIMSON} based on the entity's
     * current texture variant. Red and pink each have distinct emissive assets.
     *
     * @param entity entity being rendered
     * @return resource location string for the per-colour crimson emissive texture
     */
    private static String crimsonEmissivePath(NativeEntity entity) {
        String variant = entity.getTextureVariant(); // e.g. "mushroom_crimson_red"
        // Strip the family prefix to get the colour segment ("red" or "pink").
        // Fallback to "red" for the bare key "mushroom_crimson".
        String colour = variant.startsWith("mushroom_crimson_")
                ? variant.substring("mushroom_crimson_".length())
                : "red";
        return "monsters_girls:textures/layer/mushroom_crimson/mushroom_crimson_" + colour + "_emissive.png";
    } // crimsonEmissivePath ()

    /**
     * Resolves the emissive texture path for {@link #PUFFBALL} based on the entity's
     * current texture variant.
     * <ul>
     *   <li>{@code mushroom_puffball_default} → {@code mushroom_puffball_default_emissive.png}</li>
     *   <li>{@code mushroom_puffball_pale}    → {@code mushroom_puffball_pale_emissive.png}</li>
     *   <li>{@code mushroom_puffball} (base)  → {@code enderpuffball_emissive.png}</li>
     * </ul>
     *
     * @param entity entity being rendered
     * @return resource location string for the per-variant puffball emissive texture
     */
    private static String puffballEmissivePath(NativeEntity entity) {
        String variant = entity.getTextureVariant();
        if ("mushroom_puffball_default".equals(variant)) {
            return "monsters_girls:textures/layer/mushroom_puffball/mushroom_puffball_default_emissive.png";
        } else if ("mushroom_puffball_pale".equals(variant)) {
            return "monsters_girls:textures/layer/mushroom_puffball/mushroom_puffball_pale_emissive.png";
        }
        // Base key "mushroom_puffball" is the ender/glowing variant.
        return "monsters_girls:textures/layer/mushroom_puffball/enderpuffball_emissive.png";
    } // puffballEmissivePath ()

    /**
     * Resolves the emissive texture path for {@link #WARPED} based on the entity's
     * current texture variant. Blue and green each have distinct emissive assets.
     * The colour is extracted from the variant key (e.g. {@code "mushroom_warped_blue"} → blue).
     *
     * @param entity entity being rendered
     * @return resource location string for the per-colour warped emissive texture
     */
    private static String warpedEmissivePath(NativeEntity entity) {
        String variant = entity.getTextureVariant(); // e.g. "mushroom_warped_blue"
        String colour = variant.contains("_blue") ? "blue" : "green";
        return "monsters_girls:textures/layer/mushroom_warped/mushroom_warped_" + colour + "_emissive.png";
    } // warpedEmissivePath ()

    /**
     * Resolves the CHUBBY belly overlay texture for {@link #WARPED}, colour-keyed from
     * the entity's current texture variant.
     *
     * @param entity entity being rendered
     * @return resource location string for the per-colour warped belly CHUBBY texture
     */
    private static String warpedBellyChubbyPath(NativeEntity entity) {
        String colour = entity.getTextureVariant().contains("_blue") ? "blue" : "green";
        return "monsters_girls:textures/layer/mushroom_warped/mushroom_warped_" + colour + "_belly_chubby.png";
    } // warpedBellyChubbyPath ()

    /**
     * Resolves the TUMMY belly overlay texture for {@link #WARPED}, colour-keyed from
     * the entity's current texture variant.
     *
     * @param entity entity being rendered
     * @return resource location string for the per-colour warped belly TUMMY texture
     */
    private static String warpedBellyTummyPath(NativeEntity entity) {
        String colour = entity.getTextureVariant().contains("_blue") ? "blue" : "green";
        return "monsters_girls:textures/layer/mushroom_warped/mushroom_warped_" + colour + "_belly_tummy.png";
    } // warpedBellyTummyPath ()

    // -- Stew Factories --

    /**
     * <p>Builds a {@link Items#SUSPICIOUS_STEW} with a randomly selected flower effect.<p>
     * <p>
     * <b>Design:</b> Mirrors the vanilla flower→stew crafting table, where each flower
     * produces a distinct effect and duration. One entry is chosen uniformly at random
     * per call, so repeated exchanges with the Amanita Gal can yield any of the 16
     * possible outcomes.
     * <p>
     * <b>Effect table (Java Edition durations):</b>
     * <pre>
     *  Allium            → Fire Resistance   4 s  ( 80 ticks)
     *  Azure Bluet       → Blindness         8 s  (160 ticks)
     *  Blue Orchid       → Saturation        0.35s(  7 ticks)
     *  Cornflower        → Jump Boost        6 s  (120 ticks)
     *  Dandelion         → Saturation        0.35s(  7 ticks)
     *  Lily of the Valley→ Poison           12 s  (240 ticks)
     *  Open Eyeblossom   → Fire Resistance   0.35s(  7 ticks)
     *  Closed Eyeblossom → Nausea            7 s  (140 ticks)
     *  Oxeye Daisy       → Regeneration      8 s  (160 ticks)
     *  Poppy             → Night Vision       5 s  (100 ticks)
     *  Torchflower       → Night Vision       5 s  (100 ticks)
     *  Red Tulip         → Weakness           9 s  (180 ticks)
     *  Orange Tulip      → Weakness           9 s  (180 ticks)
     *  White Tulip       → Weakness           9 s  (180 ticks)
     *  Pink Tulip        → Weakness           9 s  (180 ticks)
     *  Wither Rose       → Wither             8 s  (160 ticks)
     * </pre>
     * <p>
     * <b>API note:</b> Uses the 1.21 data-component system —
     * {@code DataComponents.SUSPICIOUS_STEW_EFFECTS} — rather than NBT tags.
     *
     * @return a one-count {@link ItemStack} of suspicious stew with a random effect
     */
    public static ItemStack buildSuspiciousStew() {
        // -- Effect pool: (effect holder, duration ticks) --
        // Each row matches one vanilla flower. Tulips share Weakness; both Eyeblossoms are included.
        // Durations are Java Edition values from the official wiki.
        record Entry(Holder<MobEffect> effect, int durationTicks) {}

        Entry[] pool = {
            new Entry(MobEffects.FIRE_RESISTANCE,    80),   // Allium
            new Entry(MobEffects.BLINDNESS,          160),  // Azure Bluet
            new Entry(MobEffects.SATURATION,           7),  // Blue Orchid
            new Entry(MobEffects.JUMP,               120),  // Cornflower
            new Entry(MobEffects.SATURATION,           7),  // Dandelion
            new Entry(MobEffects.POISON,             240),  // Lily of the Valley
            new Entry(MobEffects.FIRE_RESISTANCE,      7),  // Open Eyeblossom
            new Entry(MobEffects.CONFUSION,          140),  // Closed Eyeblossom
            new Entry(MobEffects.REGENERATION,       160),  // Oxeye Daisy
            new Entry(MobEffects.NIGHT_VISION,       100),  // Poppy
            new Entry(MobEffects.NIGHT_VISION,       100),  // Torchflower
            new Entry(MobEffects.WEAKNESS,           180),  // Red Tulip
            new Entry(MobEffects.WEAKNESS,           180),  // Orange Tulip
            new Entry(MobEffects.WEAKNESS,           180),  // White Tulip
            new Entry(MobEffects.WEAKNESS,           180),  // Pink Tulip
            new Entry(MobEffects.WITHER,             160),  // Wither Rose
        };

        Entry chosen = pool[ThreadLocalRandom.current().nextInt(pool.length)];

        ItemStack stew = new ItemStack(Items.SUSPICIOUS_STEW);
        stew.set(
            DataComponents.SUSPICIOUS_STEW_EFFECTS,
            new SuspiciousStewEffects(List.of(
                new SuspiciousStewEffects.Entry(chosen.effect(), chosen.durationTicks())
            ))
        );
        return stew;
    } // buildSuspiciousStew ()

} // Class: MushroomFamily