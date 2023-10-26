package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.WispGreenModel;
import net.msymbios.monsters_girls.entity.custom.WispGreenEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WispGreenRenderer extends GeoEntityRenderer<WispGreenEntity> {

    // -- Constructor --
    public WispGreenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WispGreenModel());
        this.shadowRadius = 0.3F;
    } // Constructor WispGreenRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(WispGreenEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class WispGreenRenderer