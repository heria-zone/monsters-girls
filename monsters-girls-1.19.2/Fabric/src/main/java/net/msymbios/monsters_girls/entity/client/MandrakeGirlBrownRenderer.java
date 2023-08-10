package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MandrakeGirlBrownEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MandrakeGirlBrownRenderer extends GeoEntityRenderer<MandrakeGirlBrownEntity> {

    // -- Constructor --
    public MandrakeGirlBrownRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeGirlBrownModel());
        this.shadowRadius = 0.3F;
    } // Constructor MandrakeGirlBrownRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MandrakeGirlBrownEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MandrakeGirlBrownRenderer