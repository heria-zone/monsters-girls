package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.MushroomSnowballModel;
import net.msymbios.monsters_girls.entity.custom.MushroomSnowballEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomSnowballRenderer extends GeoEntityRenderer<MushroomSnowballEntity> {

    // -- Constructor --
    public MushroomSnowballRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomSnowballModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomSnowballRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomSnowballEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomSnowballRenderer