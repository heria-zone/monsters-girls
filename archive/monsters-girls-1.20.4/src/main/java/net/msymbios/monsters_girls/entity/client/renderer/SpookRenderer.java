package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.SpookModel;
import net.msymbios.monsters_girls.entity.custom.spook.SpookEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpookRenderer extends GeoEntityRenderer<SpookEntity> {

    // -- Constructor --

    public SpookRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SpookModel());
        this.shadowRadius = 0.3F;
    } // Constructor SpookRenderer ()

    // -- Method --

    @Override
    public Identifier getTextureLocation(SpookEntity entity) { return entity.getCurrentTexture(); } // getTextureResource ()

} // Class SpookRenderer