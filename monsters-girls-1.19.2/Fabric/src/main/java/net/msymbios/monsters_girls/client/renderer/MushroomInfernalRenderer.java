package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.MushroomInfernalModel;
import net.msymbios.monsters_girls.entity.custom.MushroomInfernalEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomInfernalRenderer extends GeoEntityRenderer<MushroomInfernalEntity> {

    // -- Constructor --
    public MushroomInfernalRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomInfernalModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomInfernalRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomInfernalEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomInfernalRenderer