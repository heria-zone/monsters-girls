package net.msymbios.monsters_girls.block;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.item.ModItemsGroup;

public class ModBlocks {

    // -- Variables --
    public static final Block SOUL_SHROOMLIGHT = registerBlock("soul_shroomlight", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.BLUE).strength(1.0F).sounds(BlockSoundGroup.SHROOMLIGHT).luminance(15)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_FUNGUS = registerBlock("soul_wanderer_fungus", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0F)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_PLANKS = registerBlock("soul_wanderer_planks", new Block(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_STAIRS = registerBlock("soul_wanderer_stairs", new StairsBlock(ModBlocks.SOUL_WANDERER_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.DARK_AQUA).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_SLAB = registerBlock("soul_wanderer_slab", new SlabBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_STEM = registerBlock("soul_wanderer_stem", new PillarBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0F)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_FENCE = registerBlock("soul_wanderer_fence", new FenceBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_FENCE_GATE = registerBlock("soul_wanderer_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_PRESSURE_PLATE = registerBlock("soul_wanderer_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.NETHER_WOOD).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_BUTTON = registerBlock("soul_wanderer_button", new StoneButtonBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM).noCollision()), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_DOOR = registerBlock("soul_wanderer_door", new DoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2.0F)), ModItemsGroup.MONSTERS_GIRLS);
    public static final Block SOUL_WANDERER_TRAPDOOR = registerBlock("soul_wanderer_trapdoor", new TrapdoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2.0F)), ModItemsGroup.MONSTERS_GIRLS);


    // -- Methods --
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MonstersGirlsMod.MODID, name), block);
    } // registerBlock ()

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MonstersGirlsMod.MODID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    } // registerBlockItem ()

    public static void registerBlockRender() {
        registerRender(SOUL_WANDERER_DOOR);
        registerRender(SOUL_WANDERER_TRAPDOOR);
    } // registerBlockRender ()

    public static void registerModBlocks() {
        MonstersGirlsMod.LOGGER.debug(MonstersGirlsMod.MODID + ": Registering Blocks");
    } // registerModBlocks ()

    // Utility
    public static void registerRender(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    } // registerRender ()

} // Class ModBlocks