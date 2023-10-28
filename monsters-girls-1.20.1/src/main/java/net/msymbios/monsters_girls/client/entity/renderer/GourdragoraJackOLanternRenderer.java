package net.msymbios.monsters_girls.client.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.client.entity.model.GourdragoraJackOLanternModel;
import net.msymbios.monsters_girls.entity.custom.GourdragoraJackOLanternEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GourdragoraJackOLanternRenderer extends GeoEntityRenderer<GourdragoraJackOLanternEntity> {

    // -- Constructor --
    public GourdragoraJackOLanternRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GourdragoraJackOLanternModel());
        this.shadowRadius = 0.3F;
    } // Constructor GourdragoraJackOLanternRenderer ()

    // -- Method --
    @Override
    public Identifier getTextureLocation(GourdragoraJackOLanternEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class GourdragoraJackOLanternRenderer