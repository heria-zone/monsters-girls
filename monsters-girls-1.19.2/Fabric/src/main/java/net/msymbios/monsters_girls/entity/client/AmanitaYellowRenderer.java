package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.AmanitaYellowEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AmanitaYellowRenderer extends GeoEntityRenderer<AmanitaYellowEntity> {

    // -- Constructor --
    public AmanitaYellowRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new AmanitaYellowModel());
        this.shadowRadius = 0.3F;
    } // Constructor AmanitaYellowRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(AmanitaYellowEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class AmanitaYellowRenderer