package net.msymbios.monsters_girls.entity.client.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.client.model.GourdragoraPumpkinBigModel;
import net.msymbios.monsters_girls.entity.custom.GourdragoraPumpkinBigEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GourdragoraPumpkinBigRenderer extends GeoEntityRenderer<GourdragoraPumpkinBigEntity> {

    // -- Constructor --
    public GourdragoraPumpkinBigRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GourdragoraPumpkinBigModel());
        this.shadowRadius = 0.3F;
    } // Constructor GourdragoraPumpkinBigRenderer ()

    // -- Method --
    @Override
    public void render(GourdragoraPumpkinBigEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        this.heightScale = 2F;
        this.widthScale = 2F;
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    } // render ()

    @Override
    public Identifier getTextureLocation(GourdragoraPumpkinBigEntity instance) { return instance.getCurrentTexture(); } // getTextureResource ()

} // Class GourdragoraPumpkinBigRenderer