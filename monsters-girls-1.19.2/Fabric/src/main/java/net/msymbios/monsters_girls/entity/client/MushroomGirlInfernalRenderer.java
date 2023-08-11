package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomGirlInfernalEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomGirlInfernalRenderer extends GeoEntityRenderer<MushroomGirlInfernalEntity> {

    // -- Constructor --
    public MushroomGirlInfernalRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomGirlInfernalModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomGirlInfernalRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomGirlInfernalEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomGirlInfernalRenderer