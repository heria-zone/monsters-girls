package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.MushroomInkCapModel;
import net.msymbios.monsters_girls.entity.custom.MushroomInkCapEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomInkCapRenderer extends GeoEntityRenderer<MushroomInkCapEntity> {

    // -- Constructor --
    public MushroomInkCapRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomInkCapModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomInkCapRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomInkCapEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomInkCapRenderer