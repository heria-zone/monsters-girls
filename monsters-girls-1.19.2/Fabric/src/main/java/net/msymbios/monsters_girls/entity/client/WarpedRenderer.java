package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.WarpedEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WarpedRenderer extends GeoEntityRenderer<WarpedEntity> {

    // -- Constructor --
    public WarpedRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WarpedModel());
        this.shadowRadius = 0.3F;
    } // Constructor VanillaRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(WarpedEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class WarpedRenderer