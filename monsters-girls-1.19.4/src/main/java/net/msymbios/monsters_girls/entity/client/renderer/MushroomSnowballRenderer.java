package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MushroomSnowballModel;
import net.msymbios.monsters_girls.entity.custom.MushroomSnowballEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomSnowballRenderer extends GeoEntityRenderer<MushroomSnowballEntity> {

    // -- Constructor --
    public MushroomSnowballRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomSnowballModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomSnowballRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomSnowballEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomSnowballRenderer