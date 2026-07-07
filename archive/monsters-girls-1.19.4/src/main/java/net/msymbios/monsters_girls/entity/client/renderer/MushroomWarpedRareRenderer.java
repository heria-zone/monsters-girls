package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MushroomWarpedRareModel;
import net.msymbios.monsters_girls.entity.custom.MushroomWarpedRareEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomWarpedRareRenderer extends GeoEntityRenderer<MushroomWarpedRareEntity> {

    // -- Constructor --
    public MushroomWarpedRareRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomWarpedRareModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomWarpedRareRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomWarpedRareEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomWarpedRareRenderer