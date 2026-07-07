package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.MushroomAmanitaYellowModel;
import net.msymbios.monsters_girls.entity.custom.MushroomAmanitaYellowEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomAmanitaYellowRenderer extends GeoEntityRenderer<MushroomAmanitaYellowEntity> {

    // -- Constructor --
    public MushroomAmanitaYellowRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomAmanitaYellowModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomAmanitaYellowRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomAmanitaYellowEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomAmanitaYellowRenderer