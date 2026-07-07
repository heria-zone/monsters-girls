package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.MushroomBrownModel;
import net.msymbios.monsters_girls.entity.custom.MushroomBrownEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomBrownRenderer extends GeoEntityRenderer<MushroomBrownEntity> {

    // -- Constructor --
    public MushroomBrownRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomBrownModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomBrownRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomBrownEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomBrownRenderer