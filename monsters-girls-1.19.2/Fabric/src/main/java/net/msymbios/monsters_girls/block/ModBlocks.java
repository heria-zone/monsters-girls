package net.msymbios.monsters_girls.block;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.block.custom.DirectionalBlock;
import net.msymbios.monsters_girls.block.internal.VoxelCollision;
import net.msymbios.monsters_girls.item.ModItemsGroup;

public class ModBlocks {

    // -- Variables --
    public static final MapColor ENDER_COLOR = MapColor.PALE_PURPLE, MOLTEN_COLOR = MapColor.DARK_CRIMSON, SOUL_COLOR = MapColor.DARK_AQUA;
    public static final float STRENGTH = 1.0F, RESISTANCE = 10.0F;
    public static final int LUMINANCE = 5;

    public static final Block ENDER_SHROOMLIGHT = registerBlock("ender_shroomlight", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, ENDER_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.SHROOMLIGHT).luminance(15)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_BLOCK = registerBlock("ender_puffball_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(STRENGTH)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_STEM = registerBlock("ender_puffball_stem", new PillarBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, ENDER_COLOR).strength(STRENGTH).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_PLANKS = registerBlock("ender_puffball_planks", new Block(FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_STAIRS = registerBlock("ender_puffball_stairs", new StairsBlock(ModBlocks.ENDER_PUFFBALL_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_SLAB = registerBlock("ender_puffball_slab", new SlabBlock(FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_FENCE = registerBlock("ender_puffball_fence", new FenceBlock(FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_FENCE_GATE = registerBlock("ender_puffball_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_PRESSURE_PLATE = registerBlock("ender_puffball_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_BUTTON = registerBlock("ender_puffball_button", new StoneButtonBlock(FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE).noCollision()), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_DOOR = registerBlock("ender_puffball_door", new DoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).nonOpaque().luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block ENDER_PUFFBALL_TRAPDOOR = registerBlock("ender_puffball_trapdoor", new TrapdoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, ENDER_COLOR).strength(STRENGTH).nonOpaque().luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);

    public static final Block ENDER_MOSS = registerBlock("ender_moss", new GrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(0.6F).ticksRandomly().sounds(BlockSoundGroup.GRASS)), ModItemsGroup.MONSTERS_GIRLS);

    public static final Block MOLTEN_SHROOMLIGHT = registerBlock("molten_shroomlight", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MOLTEN_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.SHROOMLIGHT).luminance(15)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_BLOCK = registerBlock("molten_fungus_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(STRENGTH)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_STEM = registerBlock("molten_fungus_stem", new PillarBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MOLTEN_COLOR).strength(STRENGTH).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_PLANKS = registerBlock("molten_fungus_planks", new Block(FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_STAIRS = registerBlock("molten_fungus_stairs", new StairsBlock(ModBlocks.MOLTEN_FUNGUS_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_SLAB = registerBlock("molten_fungus_slab", new SlabBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_FENCE = registerBlock("molten_fungus_fence", new FenceBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_FENCE_GATE = registerBlock("molten_fungus_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_PRESSURE_PLATE = registerBlock("molten_fungus_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_BUTTON = registerBlock("molten_fungus_button", new StoneButtonBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE).noCollision()), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_DOOR = registerBlock("molten_fungus_door", new DoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).nonOpaque().luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block MOLTEN_FUNGUS_TRAPDOOR = registerBlock("molten_fungus_trapdoor", new TrapdoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MOLTEN_COLOR).strength(STRENGTH).nonOpaque().luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);

    public static final Block SOUL_SHROOMLIGHT = registerBlock("soul_shroomlight", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.SHROOMLIGHT).luminance(15)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_BLOCK = registerBlock("soul_wanderer_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(STRENGTH)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_STEM = registerBlock("soul_wanderer_stem", new PillarBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_PLANKS = registerBlock("soul_wanderer_planks", new Block(FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_STAIRS = registerBlock("soul_wanderer_stairs", new StairsBlock(ModBlocks.SOUL_WANDERER_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_SLAB = registerBlock("soul_wanderer_slab", new SlabBlock(FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_FENCE = registerBlock("soul_wanderer_fence", new FenceBlock(FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_FENCE_GATE = registerBlock("soul_wanderer_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_PRESSURE_PLATE = registerBlock("soul_wanderer_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_BUTTON = registerBlock("soul_wanderer_button", new StoneButtonBlock(FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).sounds(BlockSoundGroup.NETHER_STEM).luminance(LUMINANCE).noCollision()), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_DOOR = registerBlock("soul_wanderer_door", new DoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).nonOpaque().luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_TRAPDOOR = registerBlock("soul_wanderer_trapdoor", new TrapdoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, SOUL_COLOR).strength(STRENGTH).nonOpaque().luminance(LUMINANCE)), ModItemsGroup.MONSTERS_GIRLS);

    public static final Block INK_CAP_BLACK_MUSHROOM_BLOCK = registerBlock("ink_cap_black_mushroom_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(STRENGTH)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block INK_CAP_GREY_MUSHROOM_BLOCK = registerBlock("ink_cap_grey_mushroom_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(STRENGTH)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK = registerBlock("ink_cap_light_grey_mushroom_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(STRENGTH)), ModItemsGroup.MONSTERS_GIRLS);

    public static final Block HUGE_BROWN_MUSHROOM = registerBlock("huge_brown_mushroom", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_MUSHROOM), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_CRIMSON_FUNGUS = registerBlock("huge_crimson_fungus", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_FUNGUS), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_CRIMSON_RARE_FUNGUS = registerBlock("huge_crimson_rare_fungus", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_FUNGUS), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_ENDER_PUFFBALL = registerBlock("huge_ender_puffball", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_MUSHROOM), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_FLY_RED_AGARIC = registerBlock("huge_fly_red_agaric", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.MEDIUM_MUSHROOM), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_FLY_YELLOW_AGARIC = registerBlock("huge_fly_yellow_agaric", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.MEDIUM_MUSHROOM), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_INFERNAL_MUSHROOM = registerBlock("huge_infernal_mushroom", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_MUSHROOM), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_INK_CAP_MUSHROOM = registerBlock("huge_ink_cap_mushroom", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_FUNGUS_VARIANT), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_MOLTEN_FUNGUS = registerBlock("huge_molten_fungus", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_MUSHROOM), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_SOUL_WANDERER = registerBlock("huge_soul_wanderer", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.HUGE_FUNGUS), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_WARPED_FUNGUS = registerBlock("huge_warped_fungus", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.SMALL_MUSHROOM), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block HUGE_WARPED_RARE_FUNGUS = registerBlock("huge_warped_rare_fungus", new DirectionalBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, SOUL_COLOR).strength(STRENGTH, RESISTANCE).sounds(BlockSoundGroup.FUNGUS).nonOpaque(), VoxelCollision.SMALL_MUSHROOM), ModItemsGroup.MONSTERS_GIRLS);

    public static final Block ENDER_PUFFBALL = registerBlock("ender_puffball", new FlowerBlock(StatusEffects.LEVITATION, 5, FabricBlockSettings.of(Material.PLANT, MapColor.PALE_PURPLE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(2)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block POTTED_ENDER_PUFFBALL = registerBlockWithoutGroup("potted_ender_puffball", new FlowerPotBlock(ModBlocks.ENDER_PUFFBALL, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque().luminance(2)));
    public static final Block INK_CAP_MUSHROOM = registerBlock("ink_cap_mushroom", new FlowerBlock(StatusEffects.ABSORPTION, 5, FabricBlockSettings.of(Material.PLANT, MapColor.OFF_WHITE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(2)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block POTTED_INK_CAP_MUSHROOM = registerBlockWithoutGroup("potted_ink_cap_mushroom", new FlowerPotBlock(ModBlocks.INK_CAP_MUSHROOM, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque().luminance(2)));
    public static final Block MOLTEN_FUNGUS = registerBlock("molten_fungus", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 5, FabricBlockSettings.of(Material.PLANT, MapColor.GOLD).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(2)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block POTTED_MOLTEN_FUNGUS = registerBlockWithoutGroup("potted_molten_fungus", new FlowerPotBlock(ModBlocks.MOLTEN_FUNGUS, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque().luminance(2)));
    public static final Block MANDRAKE = registerBlock("mandrake", new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.of(Material.PLANT, MapColor.PALE_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_FUNGUS = registerBlock("soul_wanderer_fungus", new FlowerBlock(StatusEffects.SLOWNESS, 5, FabricBlockSettings.of(Material.PLANT, MapColor.DARK_AQUA).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(2)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block POTTED_SOUL_WANDERER_FUNGUS = registerBlockWithoutGroup("potted_soul_wanderer_fungus", new FlowerPotBlock(ModBlocks.SOUL_WANDERER_FUNGUS, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque().luminance(2)));

    // -- Methods --
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MonstersGirlsMod.MODID, name), block);
    } // registerBlock ()

    private static Block registerBlockWithoutGroup(String name, Block block) {
        registerBlockItemWithoutGroup(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(MonstersGirlsMod.MODID, name), block);
    } // registerBlockWithoutGroup ()

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MonstersGirlsMod.MODID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    } // registerBlockItem ()

    private static Item registerBlockItemWithoutGroup(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(MonstersGirlsMod.MODID, name), new BlockItem(block, new FabricItemSettings()));
    } // registerBlockItem ()

    public static void registerModBlocks() {
        MonstersGirlsMod.LOGGER.debug(MonstersGirlsMod.MODID + ": Registering Blocks");
    } // registerModBlocks ()

    public static void registerBlockRender() {
        registerRender(ENDER_PUFFBALL_DOOR);
        registerRender(ENDER_PUFFBALL_TRAPDOOR);

        registerRender(MOLTEN_FUNGUS_TRAPDOOR);

        registerRender(SOUL_WANDERER_DOOR);
        registerRender(SOUL_WANDERER_TRAPDOOR);

        registerRender(ENDER_PUFFBALL);
        registerRender(INK_CAP_MUSHROOM);
        registerRender(MOLTEN_FUNGUS);
        registerRender(MANDRAKE);
        registerRender(SOUL_WANDERER_FUNGUS);

        registerRender(POTTED_ENDER_PUFFBALL);
        registerRender(POTTED_INK_CAP_MUSHROOM);
        registerRender(POTTED_MOLTEN_FUNGUS);
        registerRender(POTTED_SOUL_WANDERER_FUNGUS);
    } // registerBlockRender ()

    // Utility
    public static void registerRender(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    } // registerRender ()

} // Class ModBlocks