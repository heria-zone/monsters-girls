package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.MushroomCrimsonModel;
import net.msymbios.monsters_girls.entity.custom.MushroomCrimsonEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomCrimsonRenderer extends GeoEntityRenderer<MushroomCrimsonEntity> {

    // -- Constructor --
    public MushroomCrimsonRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomCrimsonModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomCrimsonRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomCrimsonEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomCrimsonRenderer