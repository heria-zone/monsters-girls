package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MandrakeBrownModel;
import net.msymbios.monsters_girls.entity.custom.MandrakeBrownEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MandrakeBrownRenderer extends GeoEntityRenderer<MandrakeBrownEntity> {

    // -- Constructor --
    public MandrakeBrownRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeBrownModel());
        this.shadowRadius = 0.3F;
    } // Constructor MandrakeBrownRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MandrakeBrownEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MandrakeBrownRenderer