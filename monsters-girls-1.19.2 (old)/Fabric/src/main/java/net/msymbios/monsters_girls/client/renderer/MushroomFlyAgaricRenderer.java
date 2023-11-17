package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.MushroomFlyAgaricModel;
import net.msymbios.monsters_girls.entity.custom.MushroomFlyAgaricEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomFlyAgaricRenderer extends GeoEntityRenderer<MushroomFlyAgaricEntity> {

    // -- Constructor --
    public MushroomFlyAgaricRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomFlyAgaricModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomFlyAgaricRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomFlyAgaricEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomFlyAgaricRenderer