package net.msymbios.monsters_girls.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.model.MushroomMoltenModel;
import net.msymbios.monsters_girls.entity.custom.MushroomMoltenEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomMoltenRenderer extends GeoEntityRenderer<MushroomMoltenEntity> {

    // -- Constructor --
    public MushroomMoltenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomMoltenModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomMoltenRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(MushroomMoltenEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class MushroomMoltenRenderer