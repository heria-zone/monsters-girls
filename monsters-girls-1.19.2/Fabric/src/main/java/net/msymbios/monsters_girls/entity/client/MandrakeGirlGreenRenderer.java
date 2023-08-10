package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MandrakeGirlGreenEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MandrakeGirlGreenRenderer extends GeoEntityRenderer<MandrakeGirlGreenEntity> {

    // -- Constructor --
    public MandrakeGirlGreenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeGirlGreenModel());
        this.shadowRadius = 0.3F;
    } // Constructor MandrakeGirlGreenRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MandrakeGirlGreenEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MandrakeGirlGreenRenderer