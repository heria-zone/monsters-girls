package net.msymbios.monsters_girls.block;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.block.custom.DirectionalBlock;
import net.msymbios.monsters_girls.block.custom.GlowBerryBush;
import net.msymbios.monsters_girls.block.internal.VoxelCollision;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.item.MonstersGirlsItems;

public class MonstersGirlsBlocks {

    // -- Variables --
    public static final MapColor ENDER_COLOR = MapColor.PALE_PURPLE, MOLTEN_COLOR = MapColor.DARK_CRIMSON, SOUL_COLOR = MapColor.DARK_AQUA;
    public static final float STRENGTH = 1.0F, RESISTANCE = 10.0F;
    public static final int LUMINANCE = 5;

    public static final Block INK_CAP_BLACK_MUSHROOM_BLOCK = register(MonstersGirlsID.INK_CAP_BLACK_MUSHROOM_BLOCK, new MushroomBlock(FabricBlockSettings.copy(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(MapColor.BLACK)));
    public static final Block INK_CAP_GREY_MUSHROOM_BLOCK = register(MonstersGirlsID.INK_CAP_GREY_MUSHROOM_BLOCK, new MushroomBlock(FabricBlockSettings.copy(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(MapColor.BLACK)));
    public static final Block INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK = register(MonstersGirlsID.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK, new MushroomBlock(FabricBlockSettings.copy(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(MapColor.BLACK)));

    public static final Block SHROOMLIGHT_ENDER = register(MonstersGirlsID.SHROOMLIGHT_ENDER, new Block(FabricBlockSettings.copy(Blocks.SHROOMLIGHT).mapColor(ENDER_COLOR)));
    public static final Block SHROOMLIGHT_MOLTEN = register(MonstersGirlsID.SHROOMLIGHT_MOLTEN, new Block(FabricBlockSettings.copy(Blocks.SHROOMLIGHT).mapColor(MOLTEN_COLOR)));
    public static final Block SHROOMLIGHT_SOUL = register(MonstersGirlsID.SHROOMLIGHT_SOUL, new Block(FabricBlockSettings.copy(Blocks.SHROOMLIGHT).mapColor(SOUL_COLOR)));

    public static final Block ENDER_PUFFBALL_BLOCK = register(MonstersGirlsID.ENDER_PUFFBALL_BLOCK, new MushroomBlock(FabricBlockSettings.copy(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_BLOCK = register(MonstersGirlsID.MOLTEN_FUNGUS_BLOCK, new MushroomBlock(FabricBlockSettings.copy(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_BLOCK = register(MonstersGirlsID.SOUL_WANDERER_BLOCK, new MushroomBlock(FabricBlockSettings.copy(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_STEM = register(MonstersGirlsID.ENDER_PUFFBALL_STEM, new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_STEM).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_STEM = register(MonstersGirlsID.MOLTEN_FUNGUS_STEM, new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_STEM).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_STEM = register(MonstersGirlsID.SOUL_WANDERER_STEM, new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_STEM).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_HYPHAE = register(MonstersGirlsID.ENDER_PUFFBALL_HYPHAE, new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_HYPHAE).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_HYPHAE = register(MonstersGirlsID.MOLTEN_FUNGUS_HYPHAE, new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_HYPHAE).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_HYPHAE = register(MonstersGirlsID.SOUL_WANDERER_HYPHAE, new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_HYPHAE).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_STRIPPED_STEM = register(MonstersGirlsID.ENDER_PUFFBALL_STRIPPED_STEM, new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_CRIMSON_STEM).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_STRIPPED_STEM = register(MonstersGirlsID.MOLTEN_FUNGUS_STRIPPED_STEM, new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_CRIMSON_STEM).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_STRIPPED_STEM = register(MonstersGirlsID.SOUL_WANDERER_STRIPPED_STEM, new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_CRIMSON_STEM).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_STRIPPED_HYPHAE = register(MonstersGirlsID.ENDER_PUFFBALL_STRIPPED_HYPHAE, new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_CRIMSON_HYPHAE).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_STRIPPED_HYPHAE = register(MonstersGirlsID.MOLTEN_FUNGUS_STRIPPED_HYPHAE, new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_CRIMSON_HYPHAE).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_STRIPPED_HYPHAE = register(MonstersGirlsID.SOUL_WANDERER_STRIPPED_HYPHAE, new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_CRIMSON_HYPHAE).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_PLANKS = register(MonstersGirlsID.ENDER_PUFFBALL_PLANKS, new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_PLANKS = register(MonstersGirlsID.MOLTEN_FUNGUS_PLANKS, new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_PLANKS = register(MonstersGirlsID.SOUL_WANDERER_PLANKS, new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_STAIRS = register(MonstersGirlsID.ENDER_PUFFBALL_STAIRS, new StairsBlock(ENDER_PUFFBALL_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_STAIRS = register(MonstersGirlsID.MOLTEN_FUNGUS_STAIRS, new StairsBlock(MOLTEN_FUNGUS_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_STAIRS = register(MonstersGirlsID.SOUL_WANDERER_STAIRS, new StairsBlock(SOUL_WANDERER_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_SLAB = register(MonstersGirlsID.ENDER_PUFFBALL_SLAB, new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_SLAB = register(MonstersGirlsID.MOLTEN_FUNGUS_SLAB, new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_SLAB = register(MonstersGirlsID.SOUL_WANDERER_SLAB, new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_FENCE = register(MonstersGirlsID.ENDER_PUFFBALL_FENCE, new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(ENDER_COLOR)));
    public static final Block MOLTEN_FUNGUS_FENCE = register(MonstersGirlsID.MOLTEN_FUNGUS_FENCE, new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MOLTEN_COLOR)));
    public static final Block SOUL_WANDERER_FENCE = register(MonstersGirlsID.SOUL_WANDERER_FENCE, new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE)));

    public static final Block ENDER_PUFFBALL_FENCE_GATE = register(MonstersGirlsID.ENDER_PUFFBALL_FENCE_GATE, new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(ENDER_COLOR), WoodType.OAK));
    public static final Block MOLTEN_FUNGUS_FENCE_GATE = register(MonstersGirlsID.MOLTEN_FUNGUS_FENCE_GATE, new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MOLTEN_COLOR), WoodType.OAK));
    public static final Block SOUL_WANDERER_FENCE_GATE = register(MonstersGirlsID.SOUL_WANDERER_FENCE_GATE, new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE), WoodType.OAK));

    public static final Block ENDER_PUFFBALL_PRESSURE_PLATE = register(MonstersGirlsID.ENDER_PUFFBALL_PRESSURE_PLATE, new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(ENDER_COLOR), BlockSetType.OAK));
    public static final Block MOLTEN_FUNGUS_PRESSURE_PLATE = register(MonstersGirlsID.MOLTEN_FUNGUS_PRESSURE_PLATE, new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MOLTEN_COLOR), BlockSetType.OAK));
    public static final Block SOUL_WANDERER_PRESSURE_PLATE = register(MonstersGirlsID.SOUL_WANDERER_PRESSURE_PLATE, new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(SOUL_COLOR).luminance(state -> LUMINANCE), BlockSetType.OAK));

    public static final Block ENDER_PUFFBALL_BUTTON = register(MonstersGirlsID.ENDER_PUFFBALL_BUTTON, Blocks.createWoodenButtonBlock(BlockSetType.OAK));
    public static final Block MOLTEN_FUNGUS_BUTTON = register(MonstersGirlsID.MOLTEN_FUNGUS_BUTTON, Blocks.createWoodenButtonBlock(BlockSetType.OAK));
    public static final Block SOUL_WANDERER_BUTTON = register(MonstersGirlsID.SOUL_WANDERER_BUTTON, Blocks.createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block ENDER_PUFFBALL_DOOR = register(MonstersGirlsID.ENDER_PUFFBALL_DOOR, new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(ENDER_COLOR), BlockSetType.OAK));
    public static final Block MOLTEN_FUNGUS_DOOR = register(MonstersGirlsID.MOLTEN_FUNGUS_DOOR, new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MOLTEN_COLOR), BlockSetType.OAK));
    public static final Block SOUL_WANDERER_DOOR = register(MonstersGirlsID.SOUL_WANDERER_DOOR, new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(SOUL_COLOR), BlockSetType.OAK));

    public static final Block ENDER_PUFFBALL_TRAPDOOR = register(MonstersGirlsID.ENDER_PUFFBALL_TRAPDOOR, new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(ENDER_COLOR), BlockSetType.OAK));
    public static final Block MOLTEN_FUNGUS_TRAPDOOR = register(MonstersGirlsID.MOLTEN_FUNGUS_TRAPDOOR, new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MOLTEN_COLOR), BlockSetType.OAK));
    public static final Block SOUL_WANDERER_TRAPDOOR = register(MonstersGirlsID.SOUL_WANDERER_TRAPDOOR, new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(SOUL_COLOR), BlockSetType.OAK));

    public static final Block ENDER_MOSS = register(MonstersGirlsID.ENDER_MOSS, new GrassBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).strength(3.0F, 9.0F).ticksRandomly().sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block HUGE_BROWN_MUSHROOM = register(MonstersGirlsID.HUGE_BROWN_MUSHROOM, new DirectionalBlock(FabricBlockSettings.create().mapColor(MapColor.BROWN).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_MUSHROOM));
    public static final Block HUGE_CRIMSON_FUNGUS = register(MonstersGirlsID.HUGE_CRIMSON_FUNGUS, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.DARK_RED), VoxelCollision.HUGE_FUNGUS));
    public static final Block HUGE_CRIMSON_RARE_FUNGUS = register(MonstersGirlsID.HUGE_CRIMSON_RARE_FUNGUS, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.BRIGHT_RED), VoxelCollision.HUGE_FUNGUS));
    public static final Block HUGE_ENDER_PUFFBALL = register(MonstersGirlsID.HUGE_ENDER_PUFFBALL, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.PALE_PURPLE), VoxelCollision.HUGE_MUSHROOM));
    public static final Block HUGE_FLY_RED_AGARIC = register(MonstersGirlsID.HUGE_FLY_RED_AGARIC, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.RED), VoxelCollision.MEDIUM_MUSHROOM));
    public static final Block HUGE_FLY_YELLOW_AGARIC = register(MonstersGirlsID.HUGE_FLY_YELLOW_AGARIC, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.YELLOW), VoxelCollision.MEDIUM_MUSHROOM));
    public static final Block HUGE_INFERNAL_MUSHROOM = register(MonstersGirlsID.HUGE_INFERNAL_MUSHROOM, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.ORANGE), VoxelCollision.HUGE_MUSHROOM));
    public static final Block HUGE_INK_CAP_MUSHROOM = register(MonstersGirlsID.HUGE_INK_CAP_MUSHROOM, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.BLACK), VoxelCollision.HUGE_FUNGUS_VARIANT));
    public static final Block HUGE_MOLTEN_FUNGUS = register(MonstersGirlsID.HUGE_MOLTEN_FUNGUS, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.GOLD), VoxelCollision.HUGE_MUSHROOM));
    public static final Block HUGE_SOUL_WANDERER = register(MonstersGirlsID.HUGE_SOUL_WANDERER, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.DIAMOND_BLUE), VoxelCollision.HUGE_FUNGUS));
    public static final Block HUGE_WARPED_FUNGUS = register(MonstersGirlsID.HUGE_WARPED_FUNGUS, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.LIGHT_BLUE), VoxelCollision.SMALL_MUSHROOM));
    public static final Block HUGE_WARPED_RARE_FUNGUS = register(MonstersGirlsID.HUGE_WARPED_RARE_FUNGUS, new DirectionalBlock(FabricBlockSettings.copy(HUGE_BROWN_MUSHROOM).mapColor(MapColor.WATER_BLUE), VoxelCollision.SMALL_MUSHROOM));

    public static final Block MANDRAKE_FLOWER = register(MonstersGirlsID.MANDRAKE_FLOWER, new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copy(Blocks.DANDELION).mapColor(MapColor.PALE_GREEN)));
    public static final Block ENDER_PUFFBALL_MUSHROOM = register(MonstersGirlsID.ENDER_PUFFBALL_MUSHROOM, new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copy(Blocks.DANDELION).mapColor(MapColor.PALE_PURPLE)));
    public static final Block INK_CAP_MUSHROOM = register(MonstersGirlsID.INK_CAP_MUSHROOM, new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copy(Blocks.DANDELION).mapColor(MapColor.BLACK)));
    public static final Block MOLTEN_FUNGUS = register(MonstersGirlsID.MOLTEN_FUNGUS, new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copy(Blocks.DANDELION).mapColor(MapColor.GOLD)));
    public static final Block SOUL_WANDERER_FUNGUS = register(MonstersGirlsID.SOUL_WANDERER_FUNGUS, new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copy(Blocks.DANDELION).mapColor(MapColor.DIAMOND_BLUE)));

    public static final Block POTTED_ENDER_PUFFBALL_MUSHROOM = register(MonstersGirlsID.POTTED_ENDER_PUFFBALL_MUSHROOM, new FlowerPotBlock(ENDER_PUFFBALL_MUSHROOM, FabricBlockSettings.create().breakInstantly().nonOpaque().luminance(2)));
    public static final Block POTTED_INK_CAP_MUSHROOM = register(MonstersGirlsID.POTTED_INK_CAP_MUSHROOM, new FlowerPotBlock(INK_CAP_MUSHROOM, FabricBlockSettings.create().breakInstantly().nonOpaque().luminance(2)));
    public static final Block POTTED_MOLTEN_FUNGUS = register(MonstersGirlsID.POTTED_MOLTEN_FUNGUS, new FlowerPotBlock(MOLTEN_FUNGUS, FabricBlockSettings.create().breakInstantly().nonOpaque().luminance(2)));
    public static final Block POTTED_SOUL_WANDERER_FUNGUS = register(MonstersGirlsID.POTTED_SOUL_WANDERER_FUNGUS, new FlowerPotBlock(SOUL_WANDERER_FUNGUS, FabricBlockSettings.create().breakInstantly().nonOpaque().luminance(2)));

    public static final Block GLOW_BERRY_BUSH = register(MonstersGirlsID.GLOW_BERRY_BUSH, new GlowBerryBush(FabricBlockSettings.create().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque().noCollision()));

    public static final Block JAR = register(MonstersGirlsID.JAR, new DirectionalBlock(FabricBlockSettings.create().mapColor(MapColor.WATER_BLUE).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.GLASS).nonOpaque(), VoxelCollision.JAR));
    public static final Block URN_MOLTEN = register(MonstersGirlsID.URN_MOLTEN, new DirectionalBlock(FabricBlockSettings.copy(JAR).mapColor(MapColor.WATER_BLUE), VoxelCollision.BIG_URN));
    public static final Block URN_CRIMSON = register(MonstersGirlsID.URN_CRIMSON, new DirectionalBlock(FabricBlockSettings.copy(JAR).mapColor(MapColor.WATER_BLUE), VoxelCollision.SMALL_URN));

    // -- Methods --
    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MonstersGirls.MODID, name), block);
    } // register

    public static void registerRender() {
        registerRender(ENDER_PUFFBALL_DOOR);
        registerRender(ENDER_PUFFBALL_TRAPDOOR);

        registerRender(MOLTEN_FUNGUS_TRAPDOOR);

        registerRender(SOUL_WANDERER_DOOR);
        registerRender(SOUL_WANDERER_TRAPDOOR);

        registerRender(HUGE_BROWN_MUSHROOM);
        registerRender(HUGE_CRIMSON_FUNGUS);
        registerRender(HUGE_CRIMSON_RARE_FUNGUS);
        registerRender(HUGE_ENDER_PUFFBALL);
        registerRender(HUGE_FLY_RED_AGARIC);
        registerRender(HUGE_FLY_YELLOW_AGARIC);
        registerRender(HUGE_INFERNAL_MUSHROOM);
        registerRender(HUGE_INK_CAP_MUSHROOM);
        registerRender(HUGE_MOLTEN_FUNGUS);
        registerRender(HUGE_SOUL_WANDERER);
        registerRender(HUGE_WARPED_FUNGUS);
        registerRender(HUGE_WARPED_RARE_FUNGUS);

        registerRender(MANDRAKE_FLOWER);
        registerRender(ENDER_PUFFBALL_MUSHROOM);
        registerRender(INK_CAP_MUSHROOM);
        registerRender(MOLTEN_FUNGUS);
        registerRender(SOUL_WANDERER_FUNGUS);

        registerRender(POTTED_ENDER_PUFFBALL_MUSHROOM);
        registerRender(POTTED_INK_CAP_MUSHROOM);
        registerRender(POTTED_MOLTEN_FUNGUS);
        registerRender(POTTED_SOUL_WANDERER_FUNGUS);

        registerRender(GLOW_BERRY_BUSH);

        registerRender(JAR);
        registerRender(URN_MOLTEN);
        registerRender(URN_CRIMSON);
    } // registerRender ()

    public static void register() {
        MonstersGirls.LOGGER.info("Registering Blocks: " + MonstersGirls.MODID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(MonstersGirlsBlocks::addItemsToBuildingBlocksGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(MonstersGirlsBlocks::addItemsToNaturalGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(MonstersGirlsBlocks::addItemsToFoodGroup);
    } // register ()

    // UTILITY
    private static void addItemsToBuildingBlocksGroup(FabricItemGroupEntries entries) {
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STEM);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_HYPHAE);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_STEM);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_HYPHAE);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STAIRS);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_SLAB);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_FENCE);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_FENCE_GATE);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_PRESSURE_PLATE);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_BUTTON);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_DOOR);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_TRAPDOOR);

        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STEM);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_HYPHAE);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_STEM);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_HYPHAE);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STAIRS);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_SLAB);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_FENCE);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_FENCE_GATE);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_PRESSURE_PLATE);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_BUTTON);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_DOOR);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_TRAPDOOR);

        entries.add(MonstersGirlsItems.SOUL_WANDERER_STEM);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_HYPHAE);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_STRIPPED_STEM);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_STRIPPED_HYPHAE);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_PLANKS);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_STAIRS);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_SLAB);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_FENCE);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_FENCE_GATE);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_PRESSURE_PLATE);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_BUTTON);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_DOOR);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_TRAPDOOR);
    } // addItemsToBuildingBlocksGroup ()

    private static void addItemsToNaturalGroup(FabricItemGroupEntries entries) {
        entries.add(MonstersGirlsItems.SHROOMLIGHT_ENDER);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_BLOCK);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STEM);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_HYPHAE);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_STEM);
        entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_HYPHAE);

        entries.add(MonstersGirlsItems.INK_CAP_BLACK_MUSHROOM_BLOCK);
        entries.add(MonstersGirlsItems.INK_CAP_GREY_MUSHROOM_BLOCK);
        entries.add(MonstersGirlsItems.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK);

        entries.add(MonstersGirlsItems.SHROOMLIGHT_MOLTEN);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_BLOCK);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STEM);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_HYPHAE);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_STEM);
        entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_HYPHAE);

        entries.add(MonstersGirlsItems.SHROOMLIGHT_SOUL);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_BLOCK);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_STEM);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_HYPHAE);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_STRIPPED_STEM);
        entries.add(MonstersGirlsItems.SOUL_WANDERER_STRIPPED_HYPHAE);
    } // addItemsToNaturalGroup ()

    private static void addItemsToFoodGroup (FabricItemGroupEntries entries) {
        entries.add(MonstersGirlsItems.SPECTRAL_CAKE);
    } // addItemsToFoodGroup ()

    private static void registerRender(Block block) { BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()); } // registerRender ()

} // Class MonstersGirlsBlocks