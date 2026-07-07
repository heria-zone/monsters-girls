package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MushroomCrimsonRareModel;
import net.msymbios.monsters_girls.entity.custom.MushroomCrimsonRareEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomCrimsonRareRenderer extends GeoEntityRenderer<MushroomCrimsonRareEntity> {

    // -- Constructor --
    public MushroomCrimsonRareRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomCrimsonRareModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomCrimsonRareRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomCrimsonRareEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomCrimsonRareRenderer