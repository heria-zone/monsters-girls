package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.WispModel;
import net.msymbios.monsters_girls.entity.custom.wisp.WispEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WispRenderer extends GeoEntityRenderer<WispEntity> {

    // -- Constructor --

    public WispRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WispModel());
        this.shadowRadius = 0.3F;
    } // Constructor WispRenderer ()

    // -- Method --

    @Override
    public Identifier getTextureLocation(WispEntity entity) { return entity.getCurrentTexture(); } // getTextureResource ()

} // Class WispRenderer