package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomGirlEnderPuffballEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomGirlEnderPuffballRenderer extends GeoEntityRenderer<MushroomGirlEnderPuffballEntity> {

    // -- Constructor --
    public MushroomGirlEnderPuffballRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomGirlEnderPuffballModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomGirlEnderPuffballRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomGirlEnderPuffballEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomGirlEnderPuffballRenderer