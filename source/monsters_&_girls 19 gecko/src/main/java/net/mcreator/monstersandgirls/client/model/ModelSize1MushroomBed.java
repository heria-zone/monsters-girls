package net.mcreator.monstersandgirls.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelSize1MushroomBed<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "model_size_1_mushroom_bed"), "main");
	public final ModelPart body2;
	public final ModelPart bone;

	public ModelSize1MushroomBed(ModelPart root) {
		this.body2 = root.getChild("body2");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body2 = partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 12).addBox(-1.4F, -3.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1F, 21.0F, -1.5F, -0.2182F, 0.0F, 0.0F));
		PartDefinition tit5 = body2.addOrReplaceChild("tit5", CubeListBuilder.create().texOffs(0, 46).mirror().addBox(-2.0F, -0.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.1F, -2.0F, -1.5F, 0.2182F, 0.2182F, 0.0F));
		PartDefinition tit6 = body2.addOrReplaceChild("tit6", CubeListBuilder.create().texOffs(0, 46).addBox(0.0F, -0.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -2.0F, -1.5F, 0.2182F, -0.2182F, 0.0F));
		PartDefinition leftlegass2 = body2.addOrReplaceChild("leftlegass2", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4F, 0.0F, 1.0F, -1.1432F, 0.2967F, 0.1047F));
		PartDefinition leftlegmain2 = leftlegass2.addOrReplaceChild("leftlegmain2", CubeListBuilder.create().texOffs(0, 30).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 4.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition leftleg2 = leftlegmain2.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(0, 35).addBox(-1.25F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 0.0F));
		PartDefinition rightlegass2 = body2.addOrReplaceChild("rightlegass2", CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.6F, 0.0F, 1.0F, -1.1432F, -0.2967F, -0.1047F));
		PartDefinition rightlegmain2 = rightlegass2.addOrReplaceChild("rightlegmain2", CubeListBuilder.create().texOffs(13, 31).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 4.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition rightleg2 = rightlegmain2.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(10, 35).addBox(-0.75F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 0.0F));
		PartDefinition leftlarm2 = body2.addOrReplaceChild("leftlarm2", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4F, -3.0F, 0.0F, 0.5672F, 0.0F, 0.8727F));
		PartDefinition rightarm2 = body2.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.6F, -3.0F, 0.0F, 0.5672F, 0.0F, -0.8727F));
		PartDefinition head = body2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition head3 = head.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition hair6 = head3.addOrReplaceChild("hair6",
				CubeListBuilder.create().texOffs(28, 1).addBox(-4.0F, -3.5F, -2.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(28, 12).addBox(-3.5F, -3.5F, -2.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, -0.5F, -0.5F));
		PartDefinition hair7 = hair6.addOrReplaceChild("hair7", CubeListBuilder.create().texOffs(46, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5F, 3.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition shroom2 = hair6.addOrReplaceChild("shroom2",
				CubeListBuilder.create().texOffs(0, 51).addBox(-5.3333F, 0.0167F, -5.5F, 11.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 64).addBox(-3.3333F, -0.9833F, -3.5F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 87)
						.addBox(-3.3333F, -3.9833F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(14, 90).addBox(-1.3333F, -4.9833F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 72)
						.addBox(-1.3333F, -1.9833F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.1667F, -5.0167F, 0.5F));
		PartDefinition hair8 = hair6.addOrReplaceChild("hair8",
				CubeListBuilder.create().texOffs(52, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(51, 7).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.25F, 3.0F, 0.7854F, 0.3491F, -1.0036F));
		PartDefinition hair9 = hair6.addOrReplaceChild("hair9", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(51, 7).mirror()
				.addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 0.25F, 3.0F, 0.7854F, -0.3491F, 1.0036F));
		PartDefinition belly = body2.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(12, 13).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 0.5F, 0.2182F, 0.0F, 0.0F));
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(36, 41).addBox(-8.0F, -3.0F, -13.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(36, 60).addBox(-6.0F, -3.0F, -11.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 5.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(72, 63).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.2531F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
