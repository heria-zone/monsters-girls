package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.GourdragoraPumpkinModel;
import net.msymbios.monsters_girls.entity.custom.GourdragoraPumpkinEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GourdragoraPumpkinRenderer extends GeoEntityRenderer<GourdragoraPumpkinEntity> {

    // -- Constructor --
    public GourdragoraPumpkinRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GourdragoraPumpkinModel());
        this.shadowRadius = 0.3F;
    } // Constructor GourdragoraPumpkinRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(GourdragoraPumpkinEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class GourdragoraPumpkinRenderer