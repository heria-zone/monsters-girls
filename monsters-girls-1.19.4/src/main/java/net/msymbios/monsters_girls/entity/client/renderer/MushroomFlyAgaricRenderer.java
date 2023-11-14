package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MushroomFlyAgaricModel;
import net.msymbios.monsters_girls.entity.custom.MushroomFlyAgaricRedEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomFlyAgaricRenderer extends GeoEntityRenderer<MushroomFlyAgaricRedEntity> {

    // -- Constructor --
    public MushroomFlyAgaricRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomFlyAgaricModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomFlyAgaricRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomFlyAgaricRedEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomFlyAgaricRenderer