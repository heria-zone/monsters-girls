package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MushroomMoltenModel;
import net.msymbios.monsters_girls.entity.custom.MushroomMoltenEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomMoltenRenderer extends GeoEntityRenderer<MushroomMoltenEntity> {

    // -- Constructor --
    public MushroomMoltenRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MushroomMoltenModel());
        this.shadowRadius = 0.3F;
    } // Constructor MushroomMoltenRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MushroomMoltenEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MushroomMoltenRenderer