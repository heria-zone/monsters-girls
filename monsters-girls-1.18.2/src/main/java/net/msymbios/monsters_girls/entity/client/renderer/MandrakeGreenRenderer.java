package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MandrakeGreenModel;
import net.msymbios.monsters_girls.entity.custom.MandrakeGreenEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MandrakeGreenRenderer extends GeoEntityRenderer<MandrakeGreenEntity> {

    // -- Constructor --
    public MandrakeGreenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeGreenModel());
        this.shadowRadius = 0.3F;
    } // Constructor MandrakeGreenRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MandrakeGreenEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MandrakeGreenRenderer