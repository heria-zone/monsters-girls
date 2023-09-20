package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.WispGreenModel;
import net.msymbios.monsters_girls.entity.custom.WispGreenEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WispGreenRenderer extends GeoEntityRenderer<WispGreenEntity> {

    // -- Constructor --
    public WispGreenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WispGreenModel());
        this.shadowRadius = 0.3F;
    } // Constructor WispGreenRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(WispGreenEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class WispGreenRenderer