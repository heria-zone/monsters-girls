package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.MandrakeChorusModel;
import net.msymbios.monsters_girls.entity.custom.MandrakeChorusEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MandrakeChorusRenderer extends GeoEntityRenderer<MandrakeChorusEntity> {

    // -- Constructor --
    public MandrakeChorusRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MandrakeChorusModel());
        this.shadowRadius = 0.3F;
    } // Constructor MandrakeChorusRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(MandrakeChorusEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class MandrakeChorusRenderer