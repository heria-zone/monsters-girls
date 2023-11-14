package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.WispYellowModel;
import net.msymbios.monsters_girls.entity.custom.WispYellowEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WispYellowRenderer extends GeoEntityRenderer<WispYellowEntity> {

    // -- Constructor --
    public WispYellowRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WispYellowModel());
        this.shadowRadius = 0.3F;
    } // Constructor WispYellowRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(WispYellowEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class WispYellowRenderer