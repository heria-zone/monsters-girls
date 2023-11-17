package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MushroomFlyAgaricRedModel;
import net.msymbios.monsters_girls.entity.custom.MushroomFlyAgaricRedEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomFlyAgaricRedRenderer extends GeoEntityRenderer<MushroomFlyAgaricRedEntity> {

    // -- Constructor --
    public MushroomFlyAgaricRedRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomFlyAgaricRedModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomFlyAgaricRedRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomFlyAgaricRedEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomFlyAgaricRedRenderer