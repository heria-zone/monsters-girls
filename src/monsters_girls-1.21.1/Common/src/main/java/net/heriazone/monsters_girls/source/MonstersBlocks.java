package net.heriazone.monsters_girls.source;

import net.heriazone.monsters_girls.MonstersConstant;
import net.heriazone.monsters_girls.MonstersIdentifier;
import net.heriazone.monsters_girls.block.BlockShapes;
import net.heriazone.monsters_girls.block.DirectionalBlock;
import net.heriazone.monsters_girls.block.FungalWoodBlocks;
import net.heriazone.monsters_girls.block.GlowBerryBushBlock;
import net.heriazone.monsters_girls.block.MushroomPlantBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;

/**
 * <p>Registers all custom blocks for Monsters &amp; Girls.<p>
 * <p>
 * <b>Architecture:</b> Uses vanilla {@link BuiltInRegistries#BLOCK} directly —
 * no loader-specific API required. Lives in Common so block references can be
 * used in Common code (genesis triggers, planting targets, item registration).
 * <p>
 * <b>Registration order:</b> Plant blocks → potted variants → wood sets →
 * Inkcap variants → huge decorative blocks → decoration blocks. Order matters
 * inside each group (e.g. stairs reference the planks block state).
 * <p>
 * <b>Render layers:</b> Plant blocks, doors, trapdoors, huge blocks, jar, urns,
 * and the glow berry bush all require {@code CUTOUT}. Registered client-side
 * via {@code MonstersBlocksClient.registerRenderLayers()}.
 * <p>
 * <b>Initialization:</b> Call {@link #register()} from {@code Monsters.init()},
 * before any item or entity registration that references these blocks.
 */
public class MonstersBlocks {

    // -------------------------------------------------------------------------
    // Plant blocks (MushroomPlantBlock — small cross-shaped, no collision)
    // -------------------------------------------------------------------------

    /**
     * Mandrake flower plant — placeable block planted by the Mandrake Flower entity via PlantingFeature.
     * <p>Valid surfaces: grass, dirt, mycelium ({@code minecraft:dirt} tag via default BushBlock placement).
     */
    public static Block MANDRAKE_FLOWER_PLANT;

    /**
     * Inkcap mushroom — genesis trigger and planting target for Inkcap Gal.
     * <p>Valid surfaces: grass, mycelium, podzol (overworld, {@code minecraft:mushroom_grow_block}).
     */
    public static Block INKCAP_MUSHROOM;

    /**
     * Molten fungus — genesis trigger and planting target for Molten Gal.
     * <p>Valid surfaces: any nylium, magma block, basalt, blackstone.
     * Uses {@code minecraft:nylium} tag for the primary nether surfaces.
     */
    public static Block MOLTEN_FUNGUS;

    /**
     * Ender mushroom — genesis trigger and planting target for Puffball Gal.
     * <p>Valid surfaces: end stone (no standard tag — uses default BushBlock placement).
     */
    public static Block ENDER_MUSHROOM;

    /**
     * Snowball mushroom — genesis trigger and planting target for Snowball Gal.
     * <p>Valid surfaces: snow, ice, mycelium (no tight tag — uses default BushBlock placement).
     */
    public static Block SNOWBALL_MUSHROOM;

    /**
     * Soul wanderer fungus — genesis trigger and planting target for Soul Wanderer Gal.
     * <p>Valid surfaces: soul sand, soul soil ({@code minecraft:soul_fire_base_blocks} tag).
     */
    public static Block SOUL_WANDERER_FUNGUS;

    // -------------------------------------------------------------------------
    // Potted variants (FlowerPotBlock — decorative only, no placement restriction)
    // -------------------------------------------------------------------------

    /** Potted inkcap mushroom. */
    public static Block POTTED_INKCAP_MUSHROOM;

    /** Potted molten fungus. Emits light (luminance 4). */
    public static Block POTTED_MOLTEN_FUNGUS;

    /** Potted ender mushroom. */
    public static Block POTTED_ENDER_MUSHROOM;

    /** Potted snowball mushroom. */
    public static Block POTTED_SNOWBALL_MUSHROOM;

    /** Potted soul wanderer fungus. Emits light (luminance 4). */
    public static Block POTTED_SOUL_WANDERER_FUNGUS;

    // -------------------------------------------------------------------------
    // Thematic MapColor constants (shared across wood sets and huge blocks)
    // -------------------------------------------------------------------------

    private static final MapColor ENDER_COLOR  = MapColor.COLOR_PURPLE;
    private static final MapColor MOLTEN_COLOR = MapColor.COLOR_RED;
    private static final MapColor SOUL_COLOR   = MapColor.COLOR_CYAN;
    /** Light level for Soul Wanderer blocks — emissive but not blinding. */
    private static final int SOUL_LUMINANCE = 5;

    // -------------------------------------------------------------------------
    // Ender Puffball wood set (15 blocks — full vanilla-parity fungal set)
    // -------------------------------------------------------------------------

    public static Block ENDER_PUFFBALL_BLOCK;
    public static Block ENDER_PUFFBALL_STEM;
    public static Block ENDER_PUFFBALL_HYPHAE;
    public static Block ENDER_PUFFBALL_STRIPPED_STEM;
    public static Block ENDER_PUFFBALL_STRIPPED_HYPHAE;
    public static Block ENDER_PUFFBALL_PLANKS;
    public static Block ENDER_PUFFBALL_STAIRS;
    public static Block ENDER_PUFFBALL_SLAB;
    public static Block ENDER_PUFFBALL_FENCE;
    public static Block ENDER_PUFFBALL_FENCE_GATE;
    public static Block ENDER_PUFFBALL_PRESSURE_PLATE;
    public static Block ENDER_PUFFBALL_BUTTON;
    public static Block ENDER_PUFFBALL_DOOR;
    public static Block ENDER_PUFFBALL_TRAPDOOR;
    public static Block SHROOMLIGHT_ENDER;

    // -------------------------------------------------------------------------
    // Molten Fungus wood set (15 blocks)
    // -------------------------------------------------------------------------

    public static Block MOLTEN_FUNGUS_BLOCK;
    public static Block MOLTEN_FUNGUS_STEM;
    public static Block MOLTEN_FUNGUS_HYPHAE;
    public static Block MOLTEN_FUNGUS_STRIPPED_STEM;
    public static Block MOLTEN_FUNGUS_STRIPPED_HYPHAE;
    public static Block MOLTEN_FUNGUS_PLANKS;
    public static Block MOLTEN_FUNGUS_STAIRS;
    public static Block MOLTEN_FUNGUS_SLAB;
    public static Block MOLTEN_FUNGUS_FENCE;
    public static Block MOLTEN_FUNGUS_FENCE_GATE;
    public static Block MOLTEN_FUNGUS_PRESSURE_PLATE;
    public static Block MOLTEN_FUNGUS_BUTTON;
    public static Block MOLTEN_FUNGUS_DOOR;
    public static Block MOLTEN_FUNGUS_TRAPDOOR;
    public static Block SHROOMLIGHT_MOLTEN;

    // -------------------------------------------------------------------------
    // Soul Wanderer wood set (15 blocks — all non-interactive blocks emit light)
    // -------------------------------------------------------------------------

    public static Block SOUL_WANDERER_BLOCK;
    public static Block SOUL_WANDERER_STEM;
    public static Block SOUL_WANDERER_HYPHAE;
    public static Block SOUL_WANDERER_STRIPPED_STEM;
    public static Block SOUL_WANDERER_STRIPPED_HYPHAE;
    public static Block SOUL_WANDERER_PLANKS;
    public static Block SOUL_WANDERER_STAIRS;
    public static Block SOUL_WANDERER_SLAB;
    public static Block SOUL_WANDERER_FENCE;
    public static Block SOUL_WANDERER_FENCE_GATE;
    public static Block SOUL_WANDERER_PRESSURE_PLATE;
    public static Block SOUL_WANDERER_BUTTON;
    public static Block SOUL_WANDERER_DOOR;
    public static Block SOUL_WANDERER_TRAPDOOR;
    public static Block SHROOMLIGHT_SOUL;

    // -------------------------------------------------------------------------
    // Inkcap mushroom block variants (3 blocks — HugeMushroomBlock colour variants)
    // -------------------------------------------------------------------------

    public static Block INK_CAP_BLACK_MUSHROOM_BLOCK;
    public static Block INK_CAP_GREY_MUSHROOM_BLOCK;
    public static Block INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK;

    // -------------------------------------------------------------------------
    // Huge decorative mushroom / fungus blocks (12 blocks — DirectionalBlock)
    // -------------------------------------------------------------------------

    public static Block HUGE_BROWN_MUSHROOM;
    public static Block HUGE_CRIMSON_FUNGUS;
    public static Block HUGE_CRIMSON_RARE_FUNGUS;
    public static Block HUGE_ENDER_PUFFBALL;
    public static Block HUGE_FLY_RED_AGARIC;
    public static Block HUGE_FLY_YELLOW_AGARIC;
    public static Block HUGE_INFERNAL_MUSHROOM;
    public static Block HUGE_INK_CAP_MUSHROOM;
    public static Block HUGE_MOLTEN_FUNGUS;
    public static Block HUGE_SOUL_WANDERER;
    public static Block HUGE_WARPED_FUNGUS;
    public static Block HUGE_WARPED_RARE_FUNGUS;

    // -------------------------------------------------------------------------
    // Decoration blocks (5 blocks)
    // -------------------------------------------------------------------------

    /** End ground cover — drops end stone without silk touch. */
    public static Block ENDER_MOSS;

    /** Glow berry bush — grows over time, applies Regeneration on contact. */
    public static Block GLOW_BERRY_BUSH;

    /** Decorative glass jar — directional, drops loot when broken without silk touch. */
    public static Block JAR;

    /** Crimson urn — directional, drops treasure loot without silk touch. */
    public static Block URN_CRIMSON;

    /** Molten urn — directional, drops treasure loot without silk touch. */
    public static Block URN_MOLTEN;

    // -------------------------------------------------------------------------
    // Snowball Mushroom wood set (15 blocks — snow/ice theme, no hyphae variant)
    // -------------------------------------------------------------------------

    public static Block SNOWBALL_LOG;
    public static Block SNOWBALL_WOOD;
    public static Block SNOWBALL_STRIPPED_LOG;
    public static Block SNOWBALL_STRIPPED_WOOD;
    public static Block SNOWBALL_PLANKS;
    public static Block SNOWBALL_STAIRS;
    public static Block SNOWBALL_SLAB;
    public static Block SNOWBALL_FENCE;
    public static Block SNOWBALL_FENCE_GATE;
    public static Block SNOWBALL_PRESSURE_PLATE;
    public static Block SNOWBALL_BUTTON;
    public static Block SNOWBALL_DOOR;
    public static Block SNOWBALL_TRAPDOOR;
    public static Block SNOWBALL_MUSHROOM_BLOCK;
    public static Block SNOWBALL_SHROOMLIGHT;

    // -------------------------------------------------------------------------
    // Ender Willow wood set (15 blocks — tree set, End theme, has leaves + sapling)
    // -------------------------------------------------------------------------

    public static Block ENDER_WILLOW_LOG;
    public static Block ENDER_WILLOW_WOOD;
    public static Block ENDER_WILLOW_STRIPPED_LOG;
    public static Block ENDER_WILLOW_STRIPPED_WOOD;
    public static Block ENDER_WILLOW_PLANKS;
    public static Block ENDER_WILLOW_STAIRS;
    public static Block ENDER_WILLOW_SLAB;
    public static Block ENDER_WILLOW_FENCE;
    public static Block ENDER_WILLOW_FENCE_GATE;
    public static Block ENDER_WILLOW_PRESSURE_PLATE;
    public static Block ENDER_WILLOW_BUTTON;
    public static Block ENDER_WILLOW_DOOR;
    public static Block ENDER_WILLOW_TRAPDOOR;
    public static Block ENDER_WILLOW_LEAVES;
    public static Block ENDER_WILLOW_SAPLING;

    // -------------------------------------------------------------------------
    // Registration
    // -------------------------------------------------------------------------

    /**
     * Registers all custom blocks into {@link BuiltInRegistries#BLOCK}.
     * <p>
     * Plant blocks are registered before their potted variants (FlowerPotBlock
     * constructor requires the plant block to already exist).
     */
    public static void register() {

        // -- Plant blocks --
        // Properties copy the closest vanilla equivalent for matching sound/hardness/resistance.
        // mapColor and lightLevel are overridden per family for thematic identity.

        // Mandrake flower plant — cross-sprite decorative plant placed by Mandrake Flower entity.
        // Grows on any grass/dirt surface; no tag restriction so it can be placed broadly.
        MANDRAKE_FLOWER_PLANT = registerBlock(MonstersConstant.MANDRAKE_FLOWER_PLANT,
                new MushroomPlantBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)
                                .mapColor(MapColor.COLOR_GREEN)));

        // Inkcap: grows on mushroom-suitable ground (grass, mycelium, podzol)
        INKCAP_MUSHROOM = registerBlock(MonstersConstant.INKCAP_MUSHROOM,
                new MushroomPlantBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
                                .mapColor(MapColor.COLOR_GRAY),
                        BlockTags.MUSHROOM_GROW_BLOCK));

        // Molten: grows on nylium (the nether equivalent of mycelium)
        MOLTEN_FUNGUS = registerBlock(MonstersConstant.MOLTEN_FUNGUS,
                new MushroomPlantBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FUNGUS)
                                .mapColor(MapColor.COLOR_ORANGE)
                                .lightLevel(state -> 4),
                        BlockTags.NYLIUM));

        // Ender: grows on end stone — no standard tag for end stone, use BushBlock default
        // which accepts any solid surface; placement correctness is enforced by the entity
        // PlantingFeature's allowedBlocks list.
        ENDER_MUSHROOM = registerBlock(MonstersConstant.ENDER_MUSHROOM,
                new MushroomPlantBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
                                .mapColor(MapColor.COLOR_PURPLE)));

        // Snowball: grows on snowy surfaces — no standard tag, use BushBlock default
        SNOWBALL_MUSHROOM = registerBlock(MonstersConstant.SNOWBALL_MUSHROOM,
                new MushroomPlantBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
                                .mapColor(MapColor.SNOW)));

        // Soul Wanderer: grows on soul fire base blocks (soul sand + soul soil)
        SOUL_WANDERER_FUNGUS = registerBlock(MonstersConstant.SOUL_WANDERER_FUNGUS,
                new MushroomPlantBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FUNGUS)
                                .mapColor(MapColor.COLOR_CYAN)
                                .lightLevel(state -> 4),
                        BlockTags.SOUL_FIRE_BASE_BLOCKS));

        // -- Potted variants --

        POTTED_INKCAP_MUSHROOM = registerBlock(MonstersConstant.POTTED_INKCAP_MUSHROOM,
                new FlowerPotBlock(INKCAP_MUSHROOM,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                                .noOcclusion()));

        POTTED_MOLTEN_FUNGUS = registerBlock(MonstersConstant.POTTED_MOLTEN_FUNGUS,
                new FlowerPotBlock(MOLTEN_FUNGUS,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                                .lightLevel(state -> 4)
                                .noOcclusion()));

        POTTED_ENDER_MUSHROOM = registerBlock(MonstersConstant.POTTED_ENDER_MUSHROOM,
                new FlowerPotBlock(ENDER_MUSHROOM,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                                .noOcclusion()));

        POTTED_SNOWBALL_MUSHROOM = registerBlock(MonstersConstant.POTTED_SNOWBALL_MUSHROOM,
                new FlowerPotBlock(SNOWBALL_MUSHROOM,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                                .noOcclusion()));

        POTTED_SOUL_WANDERER_FUNGUS = registerBlock(MonstersConstant.POTTED_SOUL_WANDERER_FUNGUS,
                new FlowerPotBlock(SOUL_WANDERER_FUNGUS,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
                                .lightLevel(state -> 4)
                                .noOcclusion()));

        // -- Ender Puffball wood set --
        // Full 15-block fungal set. ENDER_COLOR (purple) applied to all non-interactive blocks.
        // No luminance — Ender Puffball is a passive End-theme set.

        ENDER_PUFFBALL_BLOCK = registerBlock(MonstersConstant.ENDER_PUFFBALL_BLOCK,
                new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)
                        .mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_STEM = registerBlock(MonstersConstant.ENDER_PUFFBALL_STEM,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM)
                        .mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_HYPHAE = registerBlock(MonstersConstant.ENDER_PUFFBALL_HYPHAE,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HYPHAE)
                        .mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_STRIPPED_STEM = registerBlock(MonstersConstant.ENDER_PUFFBALL_STRIPPED_STEM,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM)
                        .mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_STRIPPED_HYPHAE = registerBlock(MonstersConstant.ENDER_PUFFBALL_STRIPPED_HYPHAE,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_HYPHAE)
                        .mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_PLANKS = registerBlock(MonstersConstant.ENDER_PUFFBALL_PLANKS,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                        .mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_STAIRS = registerBlock(MonstersConstant.ENDER_PUFFBALL_STAIRS,
                new FungalWoodBlocks.Stairs(ENDER_PUFFBALL_PLANKS.defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_SLAB = registerBlock(MonstersConstant.ENDER_PUFFBALL_SLAB,
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_FENCE = registerBlock(MonstersConstant.ENDER_PUFFBALL_FENCE,
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_FENCE_GATE = registerBlock(MonstersConstant.ENDER_PUFFBALL_FENCE_GATE,
                new FenceGateBlock(WoodType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_PRESSURE_PLATE = registerBlock(MonstersConstant.ENDER_PUFFBALL_PRESSURE_PLATE,
                new FungalWoodBlocks.PressurePlate(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_BUTTON = registerBlock(MonstersConstant.ENDER_PUFFBALL_BUTTON,
                new FungalWoodBlocks.Button(BlockSetType.OAK, 30,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

        ENDER_PUFFBALL_DOOR = registerBlock(MonstersConstant.ENDER_PUFFBALL_DOOR,
                new FungalWoodBlocks.Door(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(ENDER_COLOR)));

        ENDER_PUFFBALL_TRAPDOOR = registerBlock(MonstersConstant.ENDER_PUFFBALL_TRAPDOOR,
                new FungalWoodBlocks.Trapdoor(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(ENDER_COLOR)));

        SHROOMLIGHT_ENDER = registerBlock(MonstersConstant.SHROOMLIGHT_ENDER,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SHROOMLIGHT).mapColor(ENDER_COLOR)));

        // -- Molten Fungus wood set --
        // Same pattern as Ender Puffball; MOLTEN_COLOR (red). No luminance on this set.

        MOLTEN_FUNGUS_BLOCK = registerBlock(MonstersConstant.MOLTEN_FUNGUS_BLOCK,
                new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)
                        .mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_STEM = registerBlock(MonstersConstant.MOLTEN_FUNGUS_STEM,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM)
                        .mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_HYPHAE = registerBlock(MonstersConstant.MOLTEN_FUNGUS_HYPHAE,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HYPHAE)
                        .mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_STRIPPED_STEM = registerBlock(MonstersConstant.MOLTEN_FUNGUS_STRIPPED_STEM,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM)
                        .mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_STRIPPED_HYPHAE = registerBlock(MonstersConstant.MOLTEN_FUNGUS_STRIPPED_HYPHAE,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_HYPHAE)
                        .mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_PLANKS = registerBlock(MonstersConstant.MOLTEN_FUNGUS_PLANKS,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_STAIRS = registerBlock(MonstersConstant.MOLTEN_FUNGUS_STAIRS,
                new FungalWoodBlocks.Stairs(MOLTEN_FUNGUS_PLANKS.defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_SLAB = registerBlock(MonstersConstant.MOLTEN_FUNGUS_SLAB,
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_FENCE = registerBlock(MonstersConstant.MOLTEN_FUNGUS_FENCE,
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_FENCE_GATE = registerBlock(MonstersConstant.MOLTEN_FUNGUS_FENCE_GATE,
                new FenceGateBlock(WoodType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_PRESSURE_PLATE = registerBlock(MonstersConstant.MOLTEN_FUNGUS_PRESSURE_PLATE,
                new FungalWoodBlocks.PressurePlate(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_BUTTON = registerBlock(MonstersConstant.MOLTEN_FUNGUS_BUTTON,
                new FungalWoodBlocks.Button(BlockSetType.OAK, 30,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

        MOLTEN_FUNGUS_DOOR = registerBlock(MonstersConstant.MOLTEN_FUNGUS_DOOR,
                new FungalWoodBlocks.Door(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MOLTEN_COLOR)));

        MOLTEN_FUNGUS_TRAPDOOR = registerBlock(MonstersConstant.MOLTEN_FUNGUS_TRAPDOOR,
                new FungalWoodBlocks.Trapdoor(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MOLTEN_COLOR)));

        SHROOMLIGHT_MOLTEN = registerBlock(MonstersConstant.SHROOMLIGHT_MOLTEN,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SHROOMLIGHT).mapColor(MOLTEN_COLOR)));

        // -- Soul Wanderer wood set --
        // SOUL_COLOR (cyan). All non-interactive blocks emit SOUL_LUMINANCE (5) light —
        // buttons and pressure plates are excluded (players touch them; glowing floor plates
        // would be confusing and pressure plates shouldn't emit light by design).

        SOUL_WANDERER_BLOCK = registerBlock(MonstersConstant.SOUL_WANDERER_BLOCK,
                new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_STEM = registerBlock(MonstersConstant.SOUL_WANDERER_STEM,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_HYPHAE = registerBlock(MonstersConstant.SOUL_WANDERER_HYPHAE,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HYPHAE)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_STRIPPED_STEM = registerBlock(MonstersConstant.SOUL_WANDERER_STRIPPED_STEM,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_STRIPPED_HYPHAE = registerBlock(MonstersConstant.SOUL_WANDERER_STRIPPED_HYPHAE,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_HYPHAE)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_PLANKS = registerBlock(MonstersConstant.SOUL_WANDERER_PLANKS,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_STAIRS = registerBlock(MonstersConstant.SOUL_WANDERER_STAIRS,
                new FungalWoodBlocks.Stairs(SOUL_WANDERER_PLANKS.defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)
                                .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_SLAB = registerBlock(MonstersConstant.SOUL_WANDERER_SLAB,
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_FENCE = registerBlock(MonstersConstant.SOUL_WANDERER_FENCE,
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_FENCE_GATE = registerBlock(MonstersConstant.SOUL_WANDERER_FENCE_GATE,
                new FenceGateBlock(WoodType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
                                .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        // Pressure plate and button intentionally have no luminance — interactive blocks
        // that glow create confusing UX (player expects an unlit plate = not activated).
        SOUL_WANDERER_PRESSURE_PLATE = registerBlock(MonstersConstant.SOUL_WANDERER_PRESSURE_PLATE,
                new FungalWoodBlocks.PressurePlate(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(SOUL_COLOR)));

        SOUL_WANDERER_BUTTON = registerBlock(MonstersConstant.SOUL_WANDERER_BUTTON,
                new FungalWoodBlocks.Button(BlockSetType.OAK, 30,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

        SOUL_WANDERER_DOOR = registerBlock(MonstersConstant.SOUL_WANDERER_DOOR,
                new FungalWoodBlocks.Door(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)
                                .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SOUL_WANDERER_TRAPDOOR = registerBlock(MonstersConstant.SOUL_WANDERER_TRAPDOOR,
                new FungalWoodBlocks.Trapdoor(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)
                                .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        SHROOMLIGHT_SOUL = registerBlock(MonstersConstant.SHROOMLIGHT_SOUL,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SHROOMLIGHT)
                        .mapColor(SOUL_COLOR).lightLevel(state -> SOUL_LUMINANCE)));

        // -- Inkcap mushroom block variants --
        // HugeMushroomBlock gives correct blockstate (26 face-connection variants).

        INK_CAP_BLACK_MUSHROOM_BLOCK = registerBlock(MonstersConstant.INK_CAP_BLACK_MUSHROOM_BLOCK,
                new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)
                        .mapColor(MapColor.COLOR_BLACK)));

        INK_CAP_GREY_MUSHROOM_BLOCK = registerBlock(MonstersConstant.INK_CAP_GREY_MUSHROOM_BLOCK,
                new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)
                        .mapColor(MapColor.COLOR_GRAY)));

        INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK = registerBlock(MonstersConstant.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK,
                new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)
                        .mapColor(MapColor.COLOR_LIGHT_GRAY)));

        // -- Huge decorative mushroom / fungus blocks --
        // All use DirectionalBlock + the matching BlockShapes constant.
        // Base properties: strength 1/10 (decorative — easy to break but durable),
        // SoundType.FUNGUS, noOcclusion so adjacent faces render.

        HUGE_BROWN_MUSHROOM = registerBlock(MonstersConstant.HUGE_BROWN_MUSHROOM,
                new DirectionalBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_BROWN).strength(1.0F, 10.0F)
                        .sound(SoundType.FUNGUS).noOcclusion(),
                        BlockShapes.HUGE_MUSHROOM));

        HUGE_CRIMSON_FUNGUS = registerBlock(MonstersConstant.HUGE_CRIMSON_FUNGUS,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.COLOR_RED), BlockShapes.HUGE_FUNGUS));

        HUGE_CRIMSON_RARE_FUNGUS = registerBlock(MonstersConstant.HUGE_CRIMSON_RARE_FUNGUS,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.FIRE), BlockShapes.HUGE_FUNGUS));

        HUGE_ENDER_PUFFBALL = registerBlock(MonstersConstant.HUGE_ENDER_PUFFBALL,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(ENDER_COLOR), BlockShapes.HUGE_MUSHROOM));

        HUGE_FLY_RED_AGARIC = registerBlock(MonstersConstant.HUGE_FLY_RED_AGARIC,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.COLOR_RED), BlockShapes.MEDIUM_MUSHROOM));

        HUGE_FLY_YELLOW_AGARIC = registerBlock(MonstersConstant.HUGE_FLY_YELLOW_AGARIC,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.COLOR_YELLOW), BlockShapes.MEDIUM_MUSHROOM));

        HUGE_INFERNAL_MUSHROOM = registerBlock(MonstersConstant.HUGE_INFERNAL_MUSHROOM,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.COLOR_ORANGE), BlockShapes.HUGE_MUSHROOM));

        HUGE_INK_CAP_MUSHROOM = registerBlock(MonstersConstant.HUGE_INK_CAP_MUSHROOM,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.COLOR_BLACK), BlockShapes.HUGE_FUNGUS_VARIANT));

        HUGE_MOLTEN_FUNGUS = registerBlock(MonstersConstant.HUGE_MOLTEN_FUNGUS,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.GOLD), BlockShapes.HUGE_MUSHROOM));

        HUGE_SOUL_WANDERER = registerBlock(MonstersConstant.HUGE_SOUL_WANDERER,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.DIAMOND).lightLevel(state -> SOUL_LUMINANCE),
                        BlockShapes.HUGE_FUNGUS));

        HUGE_WARPED_FUNGUS = registerBlock(MonstersConstant.HUGE_WARPED_FUNGUS,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.COLOR_CYAN), BlockShapes.SMALL_MUSHROOM));

        HUGE_WARPED_RARE_FUNGUS = registerBlock(MonstersConstant.HUGE_WARPED_RARE_FUNGUS,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(HUGE_BROWN_MUSHROOM)
                        .mapColor(MapColor.WATER), BlockShapes.SMALL_MUSHROOM));

        // -- Decoration blocks --

        // Ender Moss: End ground cover. Drops end stone without silk touch (see loot table).
        // requiresCorrectToolForDrops so it doesn't drop by hand — must use pickaxe.
        ENDER_MOSS = registerBlock(MonstersConstant.ENDER_MOSS,
                new Block(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_PURPLE).strength(3.0F, 9.0F)
                        .sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Glow Berry Bush: random-ticking plant. noCollission so entities walk through and
        // trigger entityInside (Regeneration effect). noOcclusion for transparent cross-sprite.
        GLOW_BERRY_BUSH = registerBlock(MonstersConstant.GLOW_BERRY_BUSH,
                new GlowBerryBushBlock(BlockBehaviour.Properties.of()
                        .randomTicks().sound(SoundType.SWEET_BERRY_BUSH)
                        .noOcclusion().noCollission()));

        // Jar: directional decorative glass. noOcclusion for transparency.
        JAR = registerBlock(MonstersConstant.JAR,
                new DirectionalBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WATER).strength(1.0F, 10.0F)
                        .sound(SoundType.GLASS).noOcclusion(),
                        BlockShapes.JAR));

        // Urns: same base properties as jar, colour and shape differ by family.
        URN_MOLTEN = registerBlock(MonstersConstant.URN_MOLTEN,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(JAR)
                        .mapColor(MOLTEN_COLOR), BlockShapes.BIG_URN));

        URN_CRIMSON = registerBlock(MonstersConstant.URN_CRIMSON,
                new DirectionalBlock(BlockBehaviour.Properties.ofFullCopy(JAR)
                        .mapColor(MapColor.COLOR_RED), BlockShapes.SMALL_URN));

        // -- Snowball Mushroom wood set --
        // Snow/ice theme. Uses RotatedPillarBlock for logs/wood (no hyphae in the 1.3.4.3 archive).
        // The mushroom_block variant reuses HugeMushroomBlock (connection-aware cap block).

        SNOWBALL_LOG = registerBlock(MonstersConstant.SNOWBALL_LOG,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
                        .mapColor(MapColor.SNOW)));

        SNOWBALL_WOOD = registerBlock(MonstersConstant.SNOWBALL_WOOD,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
                        .mapColor(MapColor.SNOW)));

        SNOWBALL_STRIPPED_LOG = registerBlock(MonstersConstant.SNOWBALL_STRIPPED_LOG,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
                        .mapColor(MapColor.SNOW)));

        SNOWBALL_STRIPPED_WOOD = registerBlock(MonstersConstant.SNOWBALL_STRIPPED_WOOD,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
                        .mapColor(MapColor.SNOW)));

        SNOWBALL_PLANKS = registerBlock(MonstersConstant.SNOWBALL_PLANKS,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                        .mapColor(MapColor.SNOW)));

        SNOWBALL_STAIRS = registerBlock(MonstersConstant.SNOWBALL_STAIRS,
                new FungalWoodBlocks.Stairs(SNOWBALL_PLANKS.defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.SNOW)));

        SNOWBALL_SLAB = registerBlock(MonstersConstant.SNOWBALL_SLAB,
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.SNOW)));

        SNOWBALL_FENCE = registerBlock(MonstersConstant.SNOWBALL_FENCE,
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.SNOW)));

        SNOWBALL_FENCE_GATE = registerBlock(MonstersConstant.SNOWBALL_FENCE_GATE,
                new FenceGateBlock(WoodType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.SNOW)));

        SNOWBALL_PRESSURE_PLATE = registerBlock(MonstersConstant.SNOWBALL_PRESSURE_PLATE,
                new FungalWoodBlocks.PressurePlate(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.SNOW)));

        SNOWBALL_BUTTON = registerBlock(MonstersConstant.SNOWBALL_BUTTON,
                new FungalWoodBlocks.Button(BlockSetType.OAK, 30,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

        SNOWBALL_DOOR = registerBlock(MonstersConstant.SNOWBALL_DOOR,
                new FungalWoodBlocks.Door(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.SNOW)));

        SNOWBALL_TRAPDOOR = registerBlock(MonstersConstant.SNOWBALL_TRAPDOOR,
                new FungalWoodBlocks.Trapdoor(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.SNOW)));

        SNOWBALL_MUSHROOM_BLOCK = registerBlock(MonstersConstant.SNOWBALL_MUSHROOM_BLOCK,
                new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)
                        .mapColor(MapColor.SNOW)));

        SNOWBALL_SHROOMLIGHT = registerBlock(MonstersConstant.SNOWBALL_SHROOMLIGHT,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SHROOMLIGHT)
                        .mapColor(MapColor.SNOW)));

        // -- Ender Willow wood set --
        // End-theme tree set (oak-equivalent). Has leaves and sapling unlike fungal sets.
        // ENDER_COLOR (purple) throughout; leaves are transparent (CUTOUT render layer).

        ENDER_WILLOW_LOG = registerBlock(MonstersConstant.ENDER_WILLOW_LOG,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
                        .mapColor(ENDER_COLOR)));

        ENDER_WILLOW_WOOD = registerBlock(MonstersConstant.ENDER_WILLOW_WOOD,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
                        .mapColor(ENDER_COLOR)));

        ENDER_WILLOW_STRIPPED_LOG = registerBlock(MonstersConstant.ENDER_WILLOW_STRIPPED_LOG,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
                        .mapColor(ENDER_COLOR)));

        ENDER_WILLOW_STRIPPED_WOOD = registerBlock(MonstersConstant.ENDER_WILLOW_STRIPPED_WOOD,
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
                        .mapColor(ENDER_COLOR)));

        ENDER_WILLOW_PLANKS = registerBlock(MonstersConstant.ENDER_WILLOW_PLANKS,
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                        .mapColor(ENDER_COLOR)));

        ENDER_WILLOW_STAIRS = registerBlock(MonstersConstant.ENDER_WILLOW_STAIRS,
                new FungalWoodBlocks.Stairs(ENDER_WILLOW_PLANKS.defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(ENDER_COLOR)));

        ENDER_WILLOW_SLAB = registerBlock(MonstersConstant.ENDER_WILLOW_SLAB,
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(ENDER_COLOR)));

        ENDER_WILLOW_FENCE = registerBlock(MonstersConstant.ENDER_WILLOW_FENCE,
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(ENDER_COLOR)));

        ENDER_WILLOW_FENCE_GATE = registerBlock(MonstersConstant.ENDER_WILLOW_FENCE_GATE,
                new FenceGateBlock(WoodType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(ENDER_COLOR)));

        ENDER_WILLOW_PRESSURE_PLATE = registerBlock(MonstersConstant.ENDER_WILLOW_PRESSURE_PLATE,
                new FungalWoodBlocks.PressurePlate(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(ENDER_COLOR)));

        ENDER_WILLOW_BUTTON = registerBlock(MonstersConstant.ENDER_WILLOW_BUTTON,
                new FungalWoodBlocks.Button(BlockSetType.OAK, 30,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

        ENDER_WILLOW_DOOR = registerBlock(MonstersConstant.ENDER_WILLOW_DOOR,
                new FungalWoodBlocks.Door(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(ENDER_COLOR)));

        ENDER_WILLOW_TRAPDOOR = registerBlock(MonstersConstant.ENDER_WILLOW_TRAPDOOR,
                new FungalWoodBlocks.Trapdoor(BlockSetType.OAK,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(ENDER_COLOR)));

        // Leaves: CUTOUT render layer required (transparent edges). noOcclusion so sky is visible through.
        ENDER_WILLOW_LEAVES = registerBlock(MonstersConstant.ENDER_WILLOW_LEAVES,
                new FungalWoodBlocks.Leaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
                        .mapColor(ENDER_COLOR)));

        // Sapling: cross-sprite plant, noCollission, CUTOUT render layer.
        ENDER_WILLOW_SAPLING = registerBlock(MonstersConstant.ENDER_WILLOW_SAPLING,
                new MushroomPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)
                        .mapColor(ENDER_COLOR)));

    } // register ()

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    private static Block registerBlock(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, MonstersIdentifier.getId(name), block);
    } // registerBlock ()

} // Class: MonstersBlocks
