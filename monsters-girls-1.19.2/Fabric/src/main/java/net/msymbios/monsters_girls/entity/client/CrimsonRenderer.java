package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.CrimsonEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrimsonRenderer extends GeoEntityRenderer<CrimsonEntity> {

    // -- Constructor --
    public CrimsonRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CrimsonModel());
        this.shadowRadius = 0.3F;
    } // Constructor CrimsonRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(CrimsonEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class CrimsonRenderer