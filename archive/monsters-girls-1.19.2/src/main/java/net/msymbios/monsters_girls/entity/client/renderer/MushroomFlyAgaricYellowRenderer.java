package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MushroomFlyAgaricYellowModel;
import net.msymbios.monsters_girls.entity.custom.MushroomFlyAgaricYellowEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomFlyAgaricYellowRenderer extends GeoEntityRenderer<MushroomFlyAgaricYellowEntity> {

    // -- Constructor --
    public MushroomFlyAgaricYellowRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomFlyAgaricYellowModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomFlyAgaricYellowRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomFlyAgaricYellowEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomFlyAgaricYellowRenderer