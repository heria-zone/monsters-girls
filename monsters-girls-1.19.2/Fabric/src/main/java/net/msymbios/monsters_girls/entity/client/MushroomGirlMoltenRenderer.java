package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomGirlMoltenEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomGirlMoltenRenderer extends GeoEntityRenderer<MushroomGirlMoltenEntity> {

    // -- Constructor --
    public MushroomGirlMoltenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomGirlMoltenModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomGirlMoltenRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomGirlMoltenEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomGirlMoltenRenderer