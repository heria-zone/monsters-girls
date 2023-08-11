package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomWarpedEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomWarpedRenderer extends GeoEntityRenderer<MushroomWarpedEntity> {

    // -- Constructor --
    public MushroomWarpedRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomWarpedModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomWarpedRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomWarpedEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomWarpedRenderer