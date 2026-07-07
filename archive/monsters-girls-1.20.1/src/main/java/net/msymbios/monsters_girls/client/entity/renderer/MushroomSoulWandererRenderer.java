package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.MushroomSoulWandererModel;
import net.msymbios.monsters_girls.entity.custom.MushroomSoulWandererEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomSoulWandererRenderer extends GeoEntityRenderer<MushroomSoulWandererEntity> {

    // -- Constructor --
    public MushroomSoulWandererRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomSoulWandererModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomSoulWandererRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomSoulWandererEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomSoulWandererRenderer