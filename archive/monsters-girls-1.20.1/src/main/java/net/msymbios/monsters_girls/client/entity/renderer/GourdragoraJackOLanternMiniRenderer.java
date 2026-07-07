package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.GourdragoraJackOLanternMiniModel;
import net.msymbios.monsters_girls.entity.custom.GourdragoraJackOLanternMiniEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GourdragoraJackOLanternMiniRenderer extends GeoEntityRenderer<GourdragoraJackOLanternMiniEntity> {

    // -- Constructor --
    public GourdragoraJackOLanternMiniRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GourdragoraJackOLanternMiniModel());
        this.shadowRadius = 0.3F;
    } // Constructor GourdragoraJackOLanternMiniRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(GourdragoraJackOLanternMiniEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class GourdragoraJackOLanternMiniRenderer