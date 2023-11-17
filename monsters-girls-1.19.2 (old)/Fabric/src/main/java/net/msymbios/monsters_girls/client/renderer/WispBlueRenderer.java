package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.WispBlueModel;
import net.msymbios.monsters_girls.entity.custom.WispBlueEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WispBlueRenderer extends GeoEntityRenderer<WispBlueEntity> {

    // -- Constructor --
    public WispBlueRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WispBlueModel());
        this.shadowRadius = 0.3F;
    } // Constructor WispBlueRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(WispBlueEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class WispBlueRenderer