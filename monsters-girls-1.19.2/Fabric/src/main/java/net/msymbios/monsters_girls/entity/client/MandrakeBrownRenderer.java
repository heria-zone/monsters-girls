package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MandrakeBrownEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MandrakeBrownRenderer extends GeoEntityRenderer<MandrakeBrownEntity> {

    // -- Constructor --
    public MandrakeBrownRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeBrownModel());
        this.shadowRadius = 0.3F;
    } // Constructor VanillaRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MandrakeBrownEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MandrakeBrownRenderer