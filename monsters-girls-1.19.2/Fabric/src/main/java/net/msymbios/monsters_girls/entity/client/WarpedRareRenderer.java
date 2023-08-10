package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.WarpedRareEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WarpedRareRenderer extends GeoEntityRenderer<WarpedRareEntity> {

    // -- Constructor --
    public WarpedRareRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WarpedRareModel());
        this.shadowRadius = 0.3F;
    } // Constructor VanillaRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(WarpedRareEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class WarpedRareRenderer