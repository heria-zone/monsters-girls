package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.SpookPeachModel;
import net.msymbios.monsters_girls.entity.custom.SpookPeachEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpookPeachRenderer extends GeoEntityRenderer<SpookPeachEntity> {

    // -- Constructor --
    public SpookPeachRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SpookPeachModel());
        this.shadowRadius = 0.3F;
    } // Constructor SpookPeachRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(SpookPeachEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class SpookPeachRenderer