package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.MushroomInfernalModel;
import net.msymbios.monsters_girls.entity.custom.MushroomInfernalEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomInfernalRenderer extends GeoEntityRenderer<MushroomInfernalEntity> {

    // -- Constructor --
    public MushroomInfernalRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomInfernalModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomInfernalRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomInfernalEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomInfernalRenderer