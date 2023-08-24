package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.MushroomInkCapModel;
import net.msymbios.monsters_girls.entity.custom.MushroomInkCapEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomInkCapRenderer extends GeoEntityRenderer<MushroomInkCapEntity> {

    // -- Constructor --
    public MushroomInkCapRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomInkCapModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomInkCapRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomInkCapEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomInkCapRenderer