package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.BeeGirlModel;
import net.msymbios.monsters_girls.entity.custom.BeeGirlEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BeeGirlRenderer extends GeoEntityRenderer<BeeGirlEntity> {

    // -- Constructor --
    public BeeGirlRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new BeeGirlModel());
        this.shadowRadius = 0.3F;
    } // Constructor BeeGirlRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(BeeGirlEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class BeeGirlRenderer