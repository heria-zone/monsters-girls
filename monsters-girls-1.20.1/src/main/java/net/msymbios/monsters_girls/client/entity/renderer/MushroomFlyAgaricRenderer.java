package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.MushroomFlyAgaricModel;
import net.msymbios.monsters_girls.entity.custom.MushroomFlyAgaricEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomFlyAgaricRenderer extends GeoEntityRenderer<MushroomFlyAgaricEntity> {

    // -- Constructor --
    public MushroomFlyAgaricRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomFlyAgaricModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomFlyAgaricRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomFlyAgaricEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomFlyAgaricRenderer