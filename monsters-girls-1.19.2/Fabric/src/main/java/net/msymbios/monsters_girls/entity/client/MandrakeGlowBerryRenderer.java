package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MandrakeGlowBerryEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MandrakeGlowBerryRenderer extends GeoEntityRenderer<MandrakeGlowBerryEntity> {

    // -- Constructor --
    public MandrakeGlowBerryRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeGlowBerryModel());
        this.shadowRadius = 0.3F;
    } // Constructor MandrakeGlowBerryRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MandrakeGlowBerryEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MandrakeGlowBerryRenderer