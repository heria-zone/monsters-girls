package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MushroomAmanitaYellowModel;
import net.msymbios.monsters_girls.entity.custom.MushroomFlyAgaricYellowEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomAmanitaYellowRenderer extends GeoEntityRenderer<MushroomFlyAgaricYellowEntity> {

    // -- Constructor --
    public MushroomAmanitaYellowRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomAmanitaYellowModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomAmanitaYellowRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomFlyAgaricYellowEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomAmanitaYellowRenderer