package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.MushroomWarpedModel;
import net.msymbios.monsters_girls.entity.custom.MushroomWarpedEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomWarpedRenderer extends GeoEntityRenderer<MushroomWarpedEntity> {

    // -- Constructor --
    public MushroomWarpedRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomWarpedModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomWarpedRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomWarpedEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomWarpedRenderer