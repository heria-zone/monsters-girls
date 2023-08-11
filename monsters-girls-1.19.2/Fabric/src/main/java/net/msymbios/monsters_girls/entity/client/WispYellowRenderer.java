package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.WispYellowEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WispYellowRenderer extends GeoEntityRenderer<WispYellowEntity> {

    // -- Constructor --
    public WispYellowRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WispYellowModel());
        this.shadowRadius = 0.3F;
    } // Constructor WispYellowRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(WispYellowEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class WispYellowRenderer