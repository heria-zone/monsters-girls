package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MandrakeChorusEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MandrakeChorusRenderer extends GeoEntityRenderer<MandrakeChorusEntity> {

    // -- Constructor --
    public MandrakeChorusRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeChorusModel());
        this.shadowRadius = 0.3F;
    } // Constructor MandrakeChorusRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MandrakeChorusEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MandrakeChorusRenderer