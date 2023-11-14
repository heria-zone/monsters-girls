package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.SpookTealModel;
import net.msymbios.monsters_girls.entity.custom.SpookTealEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpookTealRenderer extends GeoEntityRenderer<SpookTealEntity> {

    // -- Constructor --
    public SpookTealRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SpookTealModel());
        this.shadowRadius = 0.3F;
    } // Constructor SpookTealRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(SpookTealEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class SpookTealRenderer