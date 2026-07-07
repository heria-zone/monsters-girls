package net.heriazone.monsters_girls.item;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

/**
 * GeckoLib armor renderer shared by all 12 mushroom hat variants.
 * <p>
 * <b>Architecture:</b> One renderer, one geo model, 12 textures. The renderer
 * activates only the bone matching the worn hat's {@link MushroomHatItem.HatShape} each frame.
 * Texture is pulled per-item from {@link MushroomHatItem#getWornTexture()} — each hat points
 * to its family's huge mushroom block texture in {@code monsters_girls:block/huge_*}.
 */
public class MushroomHatRenderer extends GeoArmorRenderer<MushroomHatItem> {

    public MushroomHatRenderer() {
        super(new MushroomHatModel());
    } // Constructor: MushroomHatRenderer ()

    @Override
    public ResourceLocation getTextureLocation(MushroomHatItem animatable) {
        return animatable.getWornTexture();
    } // getTextureLocation ()

    // -------------------------------------------------------------------------
    // Inner model class — uses DefaultedItemGeoModel to avoid deprecated API
    // -------------------------------------------------------------------------

    /**
     * Supplies the shared geo path to GeckoLib. {@link #getTextureResource} is overridden
     * because the hat textures live in {@code block/} not {@code item/} and differ per hat.
     * <p>
     * {@link DefaultedItemGeoModel} handles model/animation path resolution by convention —
     * the constructor {@link ResourceLocation} defines the base path only; the actual path
     * returned by {@link #getModelResource} is built from it as {@code geo/{path}.geo.json}.
     * We bypass that convention for the texture only.
     */
    public static class MushroomHatModel extends DefaultedItemGeoModel<MushroomHatItem> {

        public MushroomHatModel() {
            super(ResourceLocation.fromNamespaceAndPath("monsters_girls", "mushroomhat"));
        } // Constructor: MushroomHatModel ()

        @Override
        public ResourceLocation getAnimationResource(MushroomHatItem animatable) {
            return null; // Static model — no animation file.
        } // getAnimationResource ()

        @Override
        public ResourceLocation getTextureResource(MushroomHatItem animatable) {
            // Override: texture is block/huge_* not the item default path
            return animatable.getWornTexture();
        } // getTextureResource ()

    } // Class: MushroomHatModel

} // Class: MushroomHatRenderer
