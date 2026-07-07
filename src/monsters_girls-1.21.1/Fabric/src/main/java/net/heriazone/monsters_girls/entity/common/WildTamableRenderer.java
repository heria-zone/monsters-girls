package net.heriazone.monsters_girls.entity.common;

import net.heriazone.hzlib.api.entity.NativeRenderer;
import net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature;
import net.heriazone.hzlib.api.layer.BaseTextureLayer;
import net.heriazone.hzlib.api.layer.OverlayLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

/**
 * Composable layer-based renderer for all Monsters &amp; Girls tamable entities.
 * <p>
 * <b>Architecture:</b> Layer stack = base texture + overlay slots declared on the
 * entity type's {@link OverlayFeature}. No overlay logic is hardcoded here — adding a
 * new belly, hairstyle, costume, or carving slot to an entity type automatically shows
 * up in-game without touching this renderer.
 * <p>
 * <b>Layer order:</b> Base texture is always first (index 0, driven by
 * {@code getTextureLocation} in the parent). Overlay slots render in the order
 * they were declared on {@link OverlayFeature} — bottom to top.
 */
public class WildTamableRenderer extends NativeRenderer<WildTamableEntity> {

    // -- Constructor --

    public WildTamableRenderer(EntityRendererProvider.Context context) {
        super(context, new WildTamableModel(), 0.4F);

        // Layer 0: base texture — driven by entity.getCurrentTexture() in NativeRenderer
        addLayer(new BaseTextureLayer<>(this));

        // Remaining layers: one OverlayLayer per slot declared on the entity type's OverlayFeature.
        // WildTamableEntity is a shared renderer — the entity type is only known at render time,
        // not at construction time. OverlayLayer reads from entity state each frame, so we
        // cannot add them here without a concrete entity type reference.
        //
        // DESIGN NOTE: When all WildTamableEntities share a single renderer (current setup),
        // overlay layers must be added per-entity-type using a renderer factory per entity
        // registration, or the layers must self-select at render time via OverlayLayer's
        // shouldRender logic which already handles "no active texture → skip".
        //
        // Current resolution: OverlayLayer.shouldRender() returns false when the slot returns
        // an empty path — so pre-registering ALL possible overlay slots from ALL entity types
        // on a shared renderer is safe. Each OverlayLayer simply reads the entity's own slot
        // state and renders nothing if that slot isn't relevant to that entity type.
        //
        // This is handled via buildOverlayLayers() called from each entity type's renderer
        // factory method. See GourdragoraEntity and MandrakeEntity registrations.
    } // Constructor: WildTamableRenderer ()

    /**
     * Adds overlay layers for all slots declared on the given entity type's
     * {@link OverlayFeature}. Called once per entity type during renderer registration.
     * <p>
     * This is the standard bridge between the Common-module {@link OverlayFeature}
     * declaration and the Fabric-side {@link OverlayLayer} render calls.
     *
     * @param feature the entity type's overlay feature
     */
    public void buildOverlayLayers(OverlayFeature feature) {
        if (feature == null) return;
        feature.getSlots().forEach(slot -> addLayer(new OverlayLayer<>(this, slot)));
    } // buildOverlayLayers ()

} // Class: WildTamableRenderer