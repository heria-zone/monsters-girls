package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.GourdragoraJackOLanternBigModel;
import net.msymbios.monsters_girls.entity.custom.GourdragoraJackOLanternBigEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GourdragoraJackOLanternBigRenderer extends GeoEntityRenderer<GourdragoraJackOLanternBigEntity> {

    // -- Constructor --
    public GourdragoraJackOLanternBigRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GourdragoraJackOLanternBigModel());
        this.shadowRadius = 0.3F;
    } // Constructor GourdragoraJackOLanternBigRenderer ()

    // -- Method --
    @Override
    public void render(GourdragoraJackOLanternBigEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        this.scaleHeight = 2F;
        this.scaleWidth = 2F;
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    } // render ()

    @Override
    public Identifier getTextureLocation(GourdragoraJackOLanternBigEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class GourdragoraJackOLanternBigRenderer