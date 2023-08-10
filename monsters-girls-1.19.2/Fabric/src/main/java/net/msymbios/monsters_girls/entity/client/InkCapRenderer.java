package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.InkCapEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class InkCapRenderer extends GeoEntityRenderer<InkCapEntity> {

    // -- Constructor --
    public InkCapRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new InkCapModel());
        this.shadowRadius = 0.3F;
    } // Constructor VanillaRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(InkCapEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class InkCapRenderer