package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.animation.SelectionStrategy;
import net.heriazone.hzlib.api.entity.NativeEntity;
import net.heriazone.hzlib.api.entity.features.*;
import net.heriazone.hzlib.api.entity.features.SoundFeature;
import net.heriazone.hzlib.api.entity.features.emanation.*;
import net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature;
import net.heriazone.hzlib.api.entity.features.overlay.OverlaySlot;
import net.heriazone.hzlib.api.entity.features.variants.CompositeAppearanceFeature;
import net.heriazone.hzlib.api.animation.AnimationPool;
import net.heriazone.hzlib.api.animation.AnimationProfile;
import net.heriazone.hzlib.api.animation.LoopBehavior;
import net.heriazone.hzlib.api.entity.variants.VariantRegistries;
import net.heriazone.hzlib.api.rendering.RenderConditions;
import net.heriazone.hzlib.framework.entity.variants.*;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG;
import net.heriazone.monsters_girls.source.MonstersSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Entity type definitions for the three Gourdragora variants (Golden, Lumina, Jack'O).<p>
 * <p>
 * <b>Appearance variants:</b> Each color family declares three {@link net.heriazone.hzlib.framework.entity.variants.StandardAppearanceVariant}
 * composites (mini/default/big) — each bundling its texture, model, and animator as one
 * coherent unit. Picking one at spawn guarantees all three dimensions are always matched.
 * <p>
 * <b>Size &amp; hitbox:</b> Managed by the shared {@link SizeVariantFeature}, keyed on the
 * model geo file name. The entity re-reads this on pose change for dynamic hitboxes,
 * and re-applies stat multipliers on NBT load.
 * <p>
 * <b>Variants:</b>
 * <ul>
 *   <li>{@link #GOLDEN} — Pumpkin Pie + Bone Meal. Year-round spawn.</li>
 *   <li>{@link #LUMINA} — Pumpkin Pie + Bone Meal. Year-round spawn.</li>
 *   <li>{@link #JACKO}  — Pumpkin Pie + Cake. October-only (gated in spawn registration).</li>
 * </ul>
 */
@SuppressWarnings("unchecked")
public class GourdragoraFamily extends MonstersFamily<GourdragoraFamily> {

    // -- Overlay Slot Keys --

    /**
     * INTERACTIVE slot: carving pattern cycled by player with shears.
     * Empty string at index 0 = uncarved (no overlay rendered).
     * Golden/Lumina entries carry a color provider (grayscale mask × ARGB tint);
     * Jack'o entries use full-color textures with no tint.
     */
    public static final String SLOT_CARVING   = "carving";

    /**
     * CONDITIONAL slot (Jack'o only): shows the solid face-cover texture when
     * the carving slot is empty (uncarved state). Condition: {@code overlaySlotEmpty("carving")}.
     */
    public static final String SLOT_FACE_COVER = "face_cover";

    /**
     * ALWAYS slot: per-size emissive glow — rendered unconditionally on top of all other layers.
     * Texture path is resolved dynamically from the entity's current model variant (size key).
     */
    public static final String SLOT_EMISSIVE  = "emissive";

    // -- Shared SizeVariantFeature --

    /**
     * Size configurations shared across all entity families.
     * Big reuses the default geo file at 2× scale — no separate big geo exists.
     * <p>
     * <b>Spawn weights (normalized 0–1):</b> Mini=0.4 (40 %), Default=0.4 (40 %), Big=0.2 (20 %).
     * Values are passed as floats directly; the {@link SizeVariantFeature.SizeConfig.Builder}
     * accepts values in {@code (0,1]} as-is, or {@code >1} auto-divides by 100.
     */
    public static final SizeVariantFeature SIZE_FEATURE = SizeVariantFeature.builder()
            .size("gourdragora_girl_mini", SizeVariantFeature.SizeConfig.builder("gourdragora_girl_mini")
                    .sizeLabel("mini")
                    .scale(1.0F)
                    .spawnWeight(0.4f)
                    .dimensions(Pose.STANDING,  EntityDimensions.scalable(0.5F, 0.8F))
                    .dimensions(Pose.CROUCHING, EntityDimensions.scalable(0.5F, 0.4F))
                    .defaultDimensions(EntityDimensions.scalable(0.5F, 0.8F))
                    .health(0.75F).attack(0.71F).speed(1.0F).armor(0.33F).knockback(0.0F)
                    .build())
            .size("gourdragora_girl_default", SizeVariantFeature.SizeConfig.builder("gourdragora_girl_default")
                    .sizeLabel("default")
                    .scale(1.0F)
                    .spawnWeight(0.4f)
                    .dimensions(Pose.STANDING,  EntityDimensions.scalable(0.8F, 1.5F))
                    .dimensions(Pose.CROUCHING, EntityDimensions.scalable(0.8F, 0.75F))
                    .defaultDimensions(EntityDimensions.scalable(0.8F, 1.5F))
                    .health(1.0F).attack(1.0F).speed(1.0F).armor(1.0F).knockback(0.2F)
                    .build())
            .size("gourdragora_girl_big", SizeVariantFeature.SizeConfig.builder("gourdragora_girl_default")
                    .sizeLabel("big")
                    .scale(2F)
                    .spawnWeight(0.2f)
                    .dimensions(Pose.STANDING,  EntityDimensions.scalable(1.7F, 2.5F))
                    .dimensions(Pose.CROUCHING, EntityDimensions.scalable(1.7F, 1.25F))
                    .defaultDimensions(EntityDimensions.scalable(1.7F, 2.5F))
                    .health(1.5F).attack(1.71F).speed(1.0F).armor(1.67F).knockback(0.5F)
                    .build())
            .defaultConfig(SizeVariantFeature.SizeConfig.builder("gourdragora_girl_default")
                    .scale(1.0F)
                    .defaultDimensions(EntityDimensions.scalable(0.8F, 1.5F))
                    .build())
            .build();

    // -- Entity Variant Instances --

    /** All Gourdragora entity variants — used for registration and iteration. */
    public static final List<GourdragoraFamily> VARIANTS = new ArrayList<>();

    /**
     * Shared emanation for all Gourdragora families.
     * <p>
     * <b>On-hurt retaliation:</b> She bites back — pain radiates outward as a burst
     * of debuffs on whoever struck her.<br>
     * <b>Survival instinct:</b> When critically low, her will to live triggers
     * regeneration. Cooldown prevents spam while health stays in the danger zone.
     */
    public static final EmanationFeature GOURDRAGORA_EMANATION = EmanationFeature.builder()
            // Survival instinct — regen when critically low
            .rule(EmanationRule.builder()
                    .trigger(EmanationTrigger.ON_THRESHOLD)
                    .condition(EmanationConditions.healthAtMost(3.0f))
                    .effect(EmanationEffects.applyToSelf(MobEffects.REGENERATION, 100, 1))
                    .cooldown(200)
                    .build())
            .build();

    public static final GourdragoraFamily GOLDEN = create("gourdragora_golden")
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.CAKE, Items.BONE_MEAL))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,10, 1, 3, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS)
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON))
            )
            .withFeature(EmanationFeature.class, GOURDRAGORA_EMANATION)
            .withFeature(OverlayFeature.class, buildTintedOverlay(0xFF6D320A)); // Golden amber tint

    public static final GourdragoraFamily LUMINA = create("gourdragora_lumina")
            .withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.CAKE, Items.BONE_MEAL))
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,8, 1, 3, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS)
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON))
            )
            .withFeature(EmanationFeature.class, GOURDRAGORA_EMANATION)
            .withFeature(OverlayFeature.class, buildTintedOverlay(0xFF675032)); // Lumina pale yellow tint

    /** October-only spawn restriction is handled in spawn registration, not here. */
    public static final GourdragoraFamily JACKO = create("gourdragora_jacko")
            .withFeature(SpawnFeature.class, new SpawnFeature()
                    .withModifications(MobCategory.CREATURE,10, 1, 3, Biomes.DARK_FOREST)
                    .withPlacements(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON))
            )
            .withFeature(EmanationFeature.class, GOURDRAGORA_EMANATION)
            .withFeature(OverlayFeature.class, buildJackoOverlay());

    // -- Static Initialization --

    static { registerVariants();
        // Gourdragora uses AppearanceVariantFeature — no TextureID belly offset ever existed.
        // Register each appearance key with its texture count to make migration safe if any
        // 1.20.4 save is encountered with a raw TextureID on a Gourdragora entity.
        MigrationStep_V1_MG.registerBaseTextureCount("gourdragora_golden", 3); // mini, default, big
        MigrationStep_V1_MG.registerBaseTextureCount("gourdragora_lumina", 3);
        MigrationStep_V1_MG.registerBaseTextureCount("gourdragora_jacko",  3);
    }

    // -- Constructor --

    public GourdragoraFamily(String key) {
        super(key);
        withCombatStats(20.0F, 7.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.3F);
        withFeature(SizeVariantFeature.class, SIZE_FEATURE);
        // Variant-keyed ambient sounds — Gourdragora uses MODEL_VARIANT as the lookup key.
        // MODEL_VARIANT is set to appearance.getModelKey() at spawn, which returns the
        // SHARED model key (e.g. "gourdragora_girl_big") — NOT the color-prefixed appearance
        // key. Sound keys must match those shared model keys exactly or the lookup silently
        // falls back to null. The three shared keys are: gourdragora_girl_mini,
        // gourdragora_girl_default, and gourdragora_girl_big.
        withFeature(SoundFeature.class, new SoundFeature()
                .withSound(SoundFeature.SoundType.AMBIENT, "gourdragora_girl_mini",    MonstersSounds.GOURDRAGORA_MINI_AMBIENT.value())
                .withSound(SoundFeature.SoundType.AMBIENT, "gourdragora_girl_default", MonstersSounds.GOURDRAGORA_AMBIENT.value())
                .withSound(SoundFeature.SoundType.AMBIENT, "gourdragora_girl_big",     MonstersSounds.GOURDRAGORA_MEGA_AMBIENT.value())
                .withSound(SoundFeature.SoundType.ATTACK,                              MonstersSounds.GOURDRAGORA_ROAR.value())
                // Big variant gets a heavy step sound — placeholder using iron golem step
                // until a custom Gourdragora stomp OGG is authored.
                // Mini and default intentionally use Minecraft's default block surface sound.
                .withSound(SoundFeature.SoundType.STEP,   "gourdragora_girl_big",      SoundEvents.RAVAGER_STEP));
    } // Constructor: GourdragoraFamily ()

    // -- Overlay Feature Builders --

    /**
     * Builds the {@link OverlayFeature} for Golden and Lumina variants.
     * <p>
     * <b>Architecture:</b> Carving textures are grayscale masks shared across both color
     * families. A fixed ARGB tint color is applied at render time via the color provider
     * on each entry — one grayscale texture set serves all colors.
     * <p>
     * <b>Size-dependent paths:</b> Textures are authored per size (mini / default / big).
     * A dynamic path resolver strips the {@code "gourdragora_girl_"} prefix from the
     * entity's current {@code MODEL_VARIANT} to derive the size segment, then builds
     * the correct layer path. If the model variant is unrecognised, {@code "default"} is used.
     * <p>
     * <b>Layer order:</b>
     * <ol>
     *   <li>INTERACTIVE carving — first so emissive renders on top</li>
     *   <li>ALWAYS emissive — always-on glow, size-dependent path</li>
     * </ol>
     *
     * @param tintArgb ARGB color to tint the grayscale carving mask (e.g. {@code 0xFFD4A017})
     * @return configured overlay feature for this color family
     */
    private static OverlayFeature buildTintedOverlay(int tintArgb) {
        return new OverlayFeature()
                // INTERACTIVE: carving slot — cycles through 5 patterns via shears.
                // Stage key ("stage_01"…"stage_05") is stored in SynchedEntityData;
                // the path resolver derives the actual texture from the entity's current size.
                // Entry 0 = empty sentinel (uncarved, no render pass).
                .addSlot(OverlaySlot.interactive(SLOT_CARVING,
                        OverlaySlot.entry(""),              // index 0: uncarved
                        OverlaySlot.entryDynamic("stage_01", e -> carvingPath(e, "01"), e -> tintArgb),
                        OverlaySlot.entryDynamic("stage_02", e -> carvingPath(e, "02"), e -> tintArgb),
                        OverlaySlot.entryDynamic("stage_03", e -> carvingPath(e, "03"), e -> tintArgb),
                        OverlaySlot.entryDynamic("stage_04", e -> carvingPath(e, "04"), e -> tintArgb),
                        OverlaySlot.entryDynamic("stage_05", e -> carvingPath(e, "05"), e -> tintArgb)))
                // ALWAYS: per-size emissive glow — always on top.
                .addSlot(OverlaySlot.alwaysDynamic(SLOT_EMISSIVE, e -> emissivePath(e, false)));
    } // buildTintedOverlay ()

    /**
     * Builds the {@link OverlayFeature} for the Jack'o variant.
     * <p>
     * <b>Architecture:</b> Jack'o uses full-color carving textures (no grayscale tint).
     * The face region on the Jack'o base texture is permanently transparent. Two layers
     * fill that region under mutually exclusive conditions:
     * <ul>
     *   <li>{@code face_cover} — the solid cover shown when NOT carved (slot empty check)</li>
     *   <li>{@code carving}    — the carved-face art shown when a carving IS active</li>
     * </ul>
     * <b>Layer order:</b>
     * <ol>
     *   <li>CONDITIONAL face_cover — renders when carving = empty</li>
     *   <li>INTERACTIVE carving — renders when carving ≠ empty (index 0 is empty sentinel)</li>
     *   <li>ALWAYS emissive — Jack'o glow, always on top</li>
     * </ol>
     *
     * @return configured overlay feature for Jack'o
     */
    private static OverlayFeature buildJackoOverlay() {
        return new OverlayFeature()
                // CONDITIONAL: face_cover — fills the transparent face region when uncarved.
                // Texture path resolves dynamically based on entity's current size.
                .addSlot(OverlaySlot.conditional(SLOT_FACE_COVER,
                        OverlaySlot.entryDynamicConditional("face_cover",
                                GourdragoraFamily::faceCoverPath,
                                RenderConditions.overlaySlotEmpty(SLOT_CARVING))))
                // INTERACTIVE: carving slot — full-color Jack'o carving patterns, 6 stages.
                // Index 0 = empty sentinel (uncarved → face_cover takes over).
                .addSlot(OverlaySlot.interactive(SLOT_CARVING,
                        OverlaySlot.entry(""),              // index 0: uncarved
                        OverlaySlot.entryDynamic("stage_01", e -> carvingJackoPath(e, "01")),
                        OverlaySlot.entryDynamic("stage_02", e -> carvingJackoPath(e, "02")),
                        OverlaySlot.entryDynamic("stage_03", e -> carvingJackoPath(e, "03")),
                        OverlaySlot.entryDynamic("stage_04", e -> carvingJackoPath(e, "04")),
                        OverlaySlot.entryDynamic("stage_05", e -> carvingJackoPath(e, "05"))))
                        //OverlaySlot.entryDynamic("stage_06", e -> carvingJackoPath(e, "06")))) // The mini & default has no 6, so it gets added and creates a null texture
                // ALWAYS: per-size Jack'o emissive glow.
                .addSlot(OverlaySlot.alwaysDynamic(SLOT_EMISSIVE, e -> emissivePath(e, true)));
    } // buildJackoOverlay ()

    // -- Dynamic Path Helpers --

    /**
     * Extracts the size segment ({@code "mini"}, {@code "default"}, or {@code "big"})
     * from the entity's current {@code MODEL_VARIANT} key.
     * <p>
     * The model variant key has the form {@code "gourdragora_girl_{size}"}. This strips
     * the {@code "gourdragora_girl_"} prefix to get the raw size word. Falls back to
     * {@code "default"} for any unrecognised key.
     *
     * @param entity the entity being rendered
     * @return size segment suitable for use in a layer texture path
     */
    private static String sizeSegment(NativeEntity entity) {
        String modelKey = entity.getModelVariant();
        if (modelKey.startsWith("gourdragora_girl_")) {
            return modelKey.substring("gourdragora_girl_".length()); // "mini" / "default" / "big"
        }
        return "default";
    } // sizeSegment ()

    /**
     * Builds the full resource location string for a Golden/Lumina carving mask texture.
     *
     * @param entity entity being rendered (provides model variant for size)
     * @param stage  two-digit stage string, e.g. {@code "01"} through {@code "05"}
     * @return resource location string, e.g. {@code "monsters_girls:textures/layer/gourdragora/gourdragora_default_carvings_01.png"}
     */
    public static String carvingPath(NativeEntity entity, String stage) {
        return "monsters_girls:textures/layer/gourdragora/gourdragora_"
                + sizeSegment(entity) + "_carvings_" + stage + ".png";
    } // carvingPath ()

    /**
     * Builds the full resource location string for a Jack'o carving texture.
     *
     * @param entity entity being rendered
     * @param stage  two-digit stage string, e.g. {@code "01"} through {@code "06"}
     * @return resource location string with {@code _jacko} suffix
     */
    public static String carvingJackoPath(NativeEntity entity, String stage) {
        return "monsters_girls:textures/layer/gourdragora/gourdragora_"
                + sizeSegment(entity) + "_carvings_" + stage + "_jacko.png";
    } // carvingJackoPath ()

    /**
     * Builds the full resource location string for the Jack'o face-cover texture.
     * The {@code _00_jacko} file fills the face region when the carving slot is empty.
     *
     * @param entity entity being rendered
     * @return resource location string for the face-cover texture
     */
    public static String faceCoverPath(NativeEntity entity) {
        return "monsters_girls:textures/layer/gourdragora/gourdragora_"
                + sizeSegment(entity) + "_carvings_00_jacko.png";
    } // faceCoverPath ()

    /**
     * Builds the full resource location string for the Gourdragora emissive glow texture.
     *
     * @param entity  entity being rendered
     * @param isJacko {@code true} for Jack'o (uses {@code _emissive_jacko.png} variant)
     * @return resource location string for the emissive texture
     */
    public static String emissivePath(NativeEntity entity, boolean isJacko) {
        String suffix = isJacko ? "_emissive_jacko.png" : "_emissive.png";
        return "monsters_girls:textures/layer/gourdragora/gourdragora_"
                + sizeSegment(entity) + suffix;
    } // emissivePath ()

    // -- Factory --

    private static GourdragoraFamily create(String key) {
        GourdragoraFamily variant = new GourdragoraFamily(key);
        VARIANTS.add(variant);
        return variant;
    } // create ()

    // -- Variant Configuration --

    /**
     * Declares the three size-coupled composite appearances for this color family.
     * <p>
     * <b>Architecture:</b> Uses {@link CompositeAppearanceFeature} (Lane B) — texture,
     * model, animator, and size are a fully-coupled unit. Picking one key at spawn
     * guarantees all three dimensions and the physical size configuration are always
     * consistent. {@code getSizeConfig()} on each entry returns the matching
     * {@link SizeVariantFeature.SizeConfig} directly — no secondary lookup needed.
     */
    @Override
    protected void configureVariants() {
        withFeature(CompositeAppearanceFeature.class, new CompositeAppearanceFeature()
                .withVariants(key, key + "_mini", key + "_default", key + "_big")
                .withDefault(key, key + "_default"));
    } // configureVariants ()

    // -- Registry --

    /**
     * Registers all Gourdragora variants into the global registries.
     * <p>
     * Individual textures, models, and animators are still registered separately so
     * {@link net.heriazone.hzlib.api.entity.variants.interfaces.IAppearanceVariant}
     * resource resolution methods can delegate to their respective registries.
     * Appearance composites are registered in {@code VariantRegistries.APPEARANCES}.
     */
    private static void registerVariants() {
        // Retrieve the three SizeConfig instances declared on SIZE_FEATURE — they carry
        // stat multipliers, hitbox dimensions, and scale. Each appearance entry holds a
        // direct reference so getSizeConfig() returns it without a secondary lookup.
        SizeVariantFeature.SizeConfig miniConfig    = SIZE_FEATURE.getConfig("gourdragora_girl_mini");
        SizeVariantFeature.SizeConfig defaultConfig = SIZE_FEATURE.getConfig("gourdragora_girl_default");
        SizeVariantFeature.SizeConfig bigConfig     = SIZE_FEATURE.getConfig("gourdragora_girl_big");

        for (String color : new String[]{"gourdragora_golden", "gourdragora_lumina", "gourdragora_jacko"}) {
            // -- Textures (per color, per size) --
            VariantRegistries.TEXTURES.register(new StandardTextureVariant(color + "_mini",    color + " Mini",    getTextureResource("gourdragora", color + "_mini"),    1));
            VariantRegistries.TEXTURES.register(new StandardTextureVariant(color + "_default", color + " Default", getTextureResource("gourdragora", color + "_default"), 2));
            VariantRegistries.TEXTURES.register(new StandardTextureVariant(color + "_big",     color + " Big",     getTextureResource("gourdragora", color + "_big"),     3));

            // -- Composite appearances (per color, size-coupled) --
            // Model and animator keys point to the shared geo files registered below.
            // SizeConfig is carried on the appearance entry — the entity calls
            // appearance.getSizeConfig().ifPresent(sc -> sc.applyTo(this)) at spawn and on load.
            VariantRegistries.APPEARANCES.register(new GourdragoraAppearance(
                    color + "_mini",    color + " Mini",
                    color + "_mini",    "gourdragora_girl_mini",    "gourdragora_girl_mini",    1, miniConfig));
            VariantRegistries.APPEARANCES.register(new GourdragoraAppearance(
                    color + "_default", color + " Default",
                    color + "_default", "gourdragora_girl_default", "gourdragora_girl_default", 2, defaultConfig));
            VariantRegistries.APPEARANCES.register(new GourdragoraAppearance(
                    color + "_big",     color + " Big",
                    color + "_big",     "gourdragora_girl_big",     "gourdragora_girl_big",     3, bigConfig));
        }

        // -- Models (shared across color families) --
        VariantRegistries.MODELS.register(new StandardModelVariant("gourdragora_girl_mini",    "Gourdragora Mini",    getModelResource("gourdragora_girl_mini"),    1));
        VariantRegistries.MODELS.register(new StandardModelVariant("gourdragora_girl_default", "Gourdragora Default", getModelResource("gourdragora_girl_default"), 2));
        VariantRegistries.MODELS.register(new StandardModelVariant("gourdragora_girl_big",     "Gourdragora Big",     getModelResource("gourdragora_girl_default"), 3)); // big reuses default geo at 2× scale

        // -- Animators with profiles (shared across color families) --
        // gourdragora_girl_default: idle, walk, attack, ride, hurt, smile, jump, dig
        AnimationProfile GOURDRAGORA_DEFAULT_PROFILE = AnimationProfile.builder()
                .idle("idle")
                .walk("walk")
                .attack(pool -> pool.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .hurt("hurt")
                .special("idle_specials", AnimationPool.builder()
                        .add("smile",  3, LoopBehavior.PLAY_ONCE)
                        .add("dig", 2, LoopBehavior.PLAY_ONCE)
                        .add("jump", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        // gourdragora_girl_mini: idle, walk, attack, hurt, ride, smile, jump, dig (no pose)
        AnimationProfile GOURDRAGORA_MINI_PROFILE = AnimationProfile.builder()
                .idle("idle")
                .walk("walk")
                .attack(pool -> pool.add("attack", LoopBehavior.INTERRUPT))
                .sit("ride")
                .hurt("hurt")
                .special("idle_specials", AnimationPool.builder()
                        .add("smile",  3, LoopBehavior.PLAY_ONCE)
                        .add("dig", 2, LoopBehavior.PLAY_ONCE)
                        .add("jump", 1, LoopBehavior.PLAY_ONCE)
                        .strategy(SelectionStrategy.WEIGHTED_RANDOM)
                        .build())
                .build();

        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("gourdragora_girl_mini",    "Gourdragora Mini Animations",    getAnimatorResource("gourdragora_girl_mini"),    GOURDRAGORA_MINI_PROFILE,    1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("gourdragora_girl_default", "Gourdragora Default Animations", getAnimatorResource("gourdragora_girl_default"), GOURDRAGORA_DEFAULT_PROFILE, 2));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant("gourdragora_girl_big",     "Gourdragora Big Animations",     getAnimatorResource("gourdragora_girl_default"), GOURDRAGORA_DEFAULT_PROFILE, 3)); // big reuses default animations
    } // registerVariants ()

} // Class: GourdragoraFamily