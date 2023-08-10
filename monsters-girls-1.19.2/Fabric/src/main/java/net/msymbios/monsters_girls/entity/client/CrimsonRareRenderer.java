package net.msymbios.monsters_girls.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.CrimsonRareEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrimsonRareRenderer extends GeoEntityRenderer<CrimsonRareEntity> {

    // -- Constructor --
    public CrimsonRareRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CrimsonRareModel());
        this.shadowRadius = 0.3F;
    } // Constructor CrimsonRareRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureResource(CrimsonRareEntity instance) { return instance.getTexture(); } // getTextureResource ()

} // Class CrimsonRareRenderer