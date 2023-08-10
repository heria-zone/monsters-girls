package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.FlyAgaricEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FlyAgaricRenderer extends GeoEntityRenderer<FlyAgaricEntity> {

    // -- Constructor --
    public FlyAgaricRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FlyAgaricModel());
        this.shadowRadius = 0.3F;
    } // Constructor FlyAgaricRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(FlyAgaricEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class FlyAgaricRenderer