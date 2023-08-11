package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomBrownEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomBrownRenderer extends GeoEntityRenderer<MushroomBrownEntity> {

    // -- Constructor --
    public MushroomBrownRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomBrownModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomBrownRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomBrownEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomBrownRenderer