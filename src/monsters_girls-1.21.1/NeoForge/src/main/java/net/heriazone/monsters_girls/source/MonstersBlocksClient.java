package net.heriazone.monsters_girls.source;

import net.heriazone.monsters_girls.source.MonstersBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterNamedRenderTypesEvent;
import net.heriazone.monsters_girls.Monsters;

/**
 * <p>NeoForge client-side render type registration for Monsters &amp; Girls blocks.<p>
 * <p>
 * <b>Why CUTOUT / CUTOUT_MIPPED:</b> Blocks with transparent pixels in their textures —
 * doors, trapdoors, cross-sprite plants, huge mushroom OBJ geometry, jar and urns — must
 * be assigned a render layer that discards transparent fragments. Without this they render
 * as solid black quads.
 * <p>
 * <b>NeoForge API:</b> Unlike Fabric's {@code BlockRenderLayerMap}, NeoForge exposes
 * {@link RegisterNamedRenderTypesEvent} on the mod event bus. Registered via
 * {@code @EventBusSubscriber} so NeoForge calls this automatically on client.
 */
@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = Monsters.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MonstersBlocksClient {

    /**
     * Registers CUTOUT render layers for all transparent-pixel blocks.
     * <p>
     * Called automatically by NeoForge on the client mod event bus.
     * No manual wiring needed — the {@code @EventBusSubscriber} annotation handles dispatch.
     */
    @SubscribeEvent
    public static void onRegisterRenderTypes(RegisterNamedRenderTypesEvent event) {
        registerRenderLayers();
    } // onRegisterRenderTypes ()

    /**
     * Core registration logic — separated so it can be called directly in tests or
     * from other setup paths without constructing an event object.
     */
    public static void registerRenderLayers() {
        // -- Plants (cross-sprite) --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.INKCAP_MUSHROOM,          RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.MOLTEN_FUNGUS,            RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.ENDER_MUSHROOM,           RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.SNOWBALL_MUSHROOM,        RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.SOUL_WANDERER_FUNGUS,     RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.MANDRAKE_FLOWER_PLANT,    RenderType.cutout());

        // -- Potted variants --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.POTTED_INKCAP_MUSHROOM,      RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.POTTED_MOLTEN_FUNGUS,         RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.POTTED_ENDER_MUSHROOM,        RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.POTTED_SNOWBALL_MUSHROOM,     RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.POTTED_SOUL_WANDERER_FUNGUS,  RenderType.cutout());

        // -- Doors --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.ENDER_PUFFBALL_DOOR,  RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.MOLTEN_FUNGUS_DOOR,   RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.SOUL_WANDERER_DOOR,   RenderType.cutout());

        // -- Trapdoors --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.ENDER_PUFFBALL_TRAPDOOR, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.MOLTEN_FUNGUS_TRAPDOOR,  RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.SOUL_WANDERER_TRAPDOOR,  RenderType.cutout());

        // -- Huge decorative mushroom blocks (cutout_mipped preserves detail at distance) --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_BROWN_MUSHROOM,          RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_CRIMSON_FUNGUS,          RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_CRIMSON_RARE_FUNGUS,     RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_ENDER_PUFFBALL,          RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_FLY_RED_AGARIC,          RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_FLY_YELLOW_AGARIC,       RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_INFERNAL_MUSHROOM,       RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_INK_CAP_MUSHROOM,        RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_MOLTEN_FUNGUS,           RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_SOUL_WANDERER,           RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_WARPED_FUNGUS,           RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.HUGE_WARPED_RARE_FUNGUS,      RenderType.cutoutMipped());

        // -- Glow Berry Bush --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.GLOW_BERRY_BUSH, RenderType.cutout());

        // -- Mandrake Flower Plant (cross-sprite plant) --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.MANDRAKE_FLOWER_PLANT, RenderType.cutout());

        // -- Jar and Urns (glass-like geometry) --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.JAR,         RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.URN_MOLTEN,  RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.URN_CRIMSON,  RenderType.cutout());

        // -- Snowball Mushroom doors + trapdoor --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.SNOWBALL_DOOR,     RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.SNOWBALL_TRAPDOOR, RenderType.cutout());

        // -- Ender Willow doors, trapdoor, leaves, sapling --
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.ENDER_WILLOW_DOOR,     RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.ENDER_WILLOW_TRAPDOOR, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.ENDER_WILLOW_LEAVES,   RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(MonstersBlocks.ENDER_WILLOW_SAPLING,  RenderType.cutout());
    } // registerRenderLayers ()

} // Class: MonstersBlocksClient
