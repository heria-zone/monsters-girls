package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.WispBlueModel;
import net.msymbios.monsters_girls.entity.custom.WispBlueEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WispBlueRenderer extends GeoEntityRenderer<WispBlueEntity> {

    // -- Constructor --
    public WispBlueRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WispBlueModel());
        this.shadowRadius = 0.3F;
    } // Constructor WispBlueRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(WispBlueEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class WispBlueRenderer