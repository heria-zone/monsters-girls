package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.MushroomEnderPuffballModel;
import net.msymbios.monsters_girls.entity.custom.MushroomEnderPuffballEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomEnderPuffballRenderer extends GeoEntityRenderer<MushroomEnderPuffballEntity> {

    // -- Constructor --
    public MushroomEnderPuffballRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomEnderPuffballModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomEnderPuffballRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomEnderPuffballEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomEnderPuffballRenderer