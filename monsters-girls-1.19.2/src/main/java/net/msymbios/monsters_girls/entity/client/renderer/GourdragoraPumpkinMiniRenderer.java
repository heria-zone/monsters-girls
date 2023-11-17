package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.GourdragoraPumpkinMiniModel;
import net.msymbios.monsters_girls.entity.custom.GourdragoraPumpkinMiniEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GourdragoraPumpkinMiniRenderer extends GeoEntityRenderer<GourdragoraPumpkinMiniEntity> {

    // -- Constructor --
    public GourdragoraPumpkinMiniRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GourdragoraPumpkinMiniModel());
        this.shadowRadius = 0.3F;
    } // Constructor GourdragoraPumpkinMiniRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(GourdragoraPumpkinMiniEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class GourdragoraPumpkinMiniRenderer