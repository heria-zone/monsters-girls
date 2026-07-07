package net.heriazone.monsters_girls.source;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

/**
 * <p>Client-side render layer registration for all custom Monsters &amp; Girls blocks.<p>
 * <p>
 * <b>Why CUTOUT:</b> Any block texture with transparent pixels must be in {@code CUTOUT}
 * or {@code CUTOUT_MIPPED} — otherwise transparent areas render as an opaque black quad,
 * breaking the silhouette. This covers four categories:
 * <ul>
 *   <li>Cross-sprite plants (mushrooms, glow berry bush)</li>
 *   <li>Doors and trapdoors (have transparent cutout pixels at edges)</li>
 *   <li>Huge decorative mushroom blocks (custom OBJ geometry with alpha)</li>
 *   <li>Jar and Urn blocks (glass-like geometry with alpha cutout)</li>
 * </ul>
 * <p>
 * <b>Architecture:</b> Render layer registration touches client rendering infrastructure
 * and must live in a loader-specific module. Common block registration lives in
 * {@link MonstersBlocks}; this class is the Fabric client-side complement.
 * Called from {@code MonstersGirls.onInitializeClient()}.
 */
public class MonstersBlocksClient {

    /**
     * Registers CUTOUT render layers for all blocks with transparent pixel content.
     * <p>
     * Call from {@code MonstersGirls.onInitializeClient()} — blocks must be registered first.
     */
    public static void registerRenderLayers() {

        // -- Plant blocks (cross-sprite, transparent background) --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.INKCAP_MUSHROOM,          RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.MOLTEN_FUNGUS,            RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.ENDER_MUSHROOM,           RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.SNOWBALL_MUSHROOM,        RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.SOUL_WANDERER_FUNGUS,     RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.MANDRAKE_FLOWER_PLANT,    RenderType.cutout());

        // -- Potted variants (cross-sprite inside flower pot) --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.POTTED_INKCAP_MUSHROOM,     RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.POTTED_MOLTEN_FUNGUS,        RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.POTTED_ENDER_MUSHROOM,       RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.POTTED_SNOWBALL_MUSHROOM,    RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.POTTED_SOUL_WANDERER_FUNGUS, RenderType.cutout());

        // -- Doors (3 families — door textures have transparent cutout edges) --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.ENDER_PUFFBALL_DOOR,  RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.MOLTEN_FUNGUS_DOOR,   RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.SOUL_WANDERER_DOOR,   RenderType.cutout());

        // -- Trapdoors (3 families — same reason as doors) --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.ENDER_PUFFBALL_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.MOLTEN_FUNGUS_TRAPDOOR,  RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.SOUL_WANDERER_TRAPDOOR,  RenderType.cutout());

        // -- Huge decorative mushroom blocks (custom OBJ geometry, cutout_mipped for mipmapped alpha) --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_BROWN_MUSHROOM,          RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_CRIMSON_FUNGUS,          RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_CRIMSON_RARE_FUNGUS,     RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_ENDER_PUFFBALL,          RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_FLY_RED_AGARIC,          RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_FLY_YELLOW_AGARIC,       RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_INFERNAL_MUSHROOM,       RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_INK_CAP_MUSHROOM,        RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_MOLTEN_FUNGUS,           RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_SOUL_WANDERER,           RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_WARPED_FUNGUS,           RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.HUGE_WARPED_RARE_FUNGUS,      RenderType.cutoutMipped());

        // -- Glow Berry Bush (cross-sprite plant) --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.GLOW_BERRY_BUSH, RenderType.cutout());

        // -- Jar and Urns (glass-like transparent geometry) --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.JAR,        RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.URN_MOLTEN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.URN_CRIMSON, RenderType.cutout());

        // -- Snowball Mushroom doors + trapdoor --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.SNOWBALL_DOOR,     RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.SNOWBALL_TRAPDOOR, RenderType.cutout());

        // -- Ender Willow doors, trapdoor, leaves, sapling --
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.ENDER_WILLOW_DOOR,      RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.ENDER_WILLOW_TRAPDOOR,  RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.ENDER_WILLOW_LEAVES,    RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MonstersBlocks.ENDER_WILLOW_SAPLING,   RenderType.cutout());

    } // registerRenderLayers ()

} // Class: MonstersBlocksClient
