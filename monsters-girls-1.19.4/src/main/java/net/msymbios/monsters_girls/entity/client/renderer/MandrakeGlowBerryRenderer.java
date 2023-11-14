package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.MandrakeGlowBerryModel;
import net.msymbios.monsters_girls.entity.custom.MandrakeGlowBerryEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MandrakeGlowBerryRenderer extends GeoEntityRenderer<MandrakeGlowBerryEntity> {

    // -- Constructor --
    public MandrakeGlowBerryRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeGlowBerryModel());
        this.shadowRadius = 0.3F;
    } // Constructor MandrakeGlowBerryRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MandrakeGlowBerryEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MandrakeGlowBerryRenderer