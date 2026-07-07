package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.SlimeGirlModel;
import net.msymbios.monsters_girls.entity.custom.SlimeGirlEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SlimeGirlRenderer extends GeoEntityRenderer<SlimeGirlEntity> {

    // -- Constructor --
    public SlimeGirlRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SlimeGirlModel());
        this.shadowRadius = 0.3F;
    } // Constructor SlimeGirlRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(SlimeGirlEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class SlimeGirlRenderer