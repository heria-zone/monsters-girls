package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomGirlBrownEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomGirlBrownRenderer extends GeoEntityRenderer<MushroomGirlBrownEntity> {

    // -- Constructor --
    public MushroomGirlBrownRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomGirlBrownModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomGirlBrownRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomGirlBrownEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomGirlBrownRenderer