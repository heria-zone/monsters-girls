package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomGirlSoulWandererEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomGirlSoulWandererRenderer extends GeoEntityRenderer<MushroomGirlSoulWandererEntity> {

    // -- Constructor --
    public MushroomGirlSoulWandererRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomGirlSoulWandererModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomGirlSoulWandererRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomGirlSoulWandererEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomGirlSoulWandererRenderer