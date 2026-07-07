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
public class Modelfat_mushroombed<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "modelfat_mushroombed"), "main");
	public final ModelPart bone;
	public final ModelPart root;

	public Modelfat_mushroombed(ModelPart root) {
		this.bone = root.getChild("bone");
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(36, 41).addBox(-8.0F, -3.0F, -13.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(36, 60).addBox(-6.0F, -3.0F, -11.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 5.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(72, 63).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.2531F, 0.0F, 0.0F));
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 0.0F));
		PartDefinition body2 = root.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 12).addBox(-1.4F, -3.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -5.0F, -1.5F, -0.7854F, 0.0F, 0.0F));
		PartDefinition belly3 = body2.addOrReplaceChild("belly3", CubeListBuilder.create().texOffs(12, 13).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -0.75F, 0.5F, 0.2618F, 0.0F, 0.0F));
		PartDefinition tit2 = body2.addOrReplaceChild("tit2", CubeListBuilder.create().texOffs(0, 50).mirror().addBox(-2.0F, -0.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.1F, -2.0F, -1.5F, 0.3054F, 0.2182F, 0.0F));
		PartDefinition tit5 = body2.addOrReplaceChild("tit5", CubeListBuilder.create().texOffs(0, 50).addBox(0.0F, -0.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -2.0F, -1.5F, 0.3054F, -0.2182F, 0.0F));
		PartDefinition leftlegass2 = body2.addOrReplaceChild("leftlegass2", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4F, 0.0F, 1.0F, -0.6318F, 0.1841F, 0.1578F));
		PartDefinition leftlegmain2 = leftlegass2.addOrReplaceChild("leftlegmain2", CubeListBuilder.create().texOffs(0, 30).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 3.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition leftleg2 = leftlegmain2.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(0, 35).addBox(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 0.0F));
		PartDefinition rightlegass2 = body2.addOrReplaceChild("rightlegass2", CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.6F, 0.0F, 1.0F, -0.6378F, -0.1582F, -0.1222F));
		PartDefinition rightlegmain2 = rightlegass2.addOrReplaceChild("rightlegmain2", CubeListBuilder.create().texOffs(13, 31).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 3.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition rightleg2 = rightlegmain2.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(10, 35).addBox(-0.75F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 0.0F));
		PartDefinition leftlarm2 = body2.addOrReplaceChild("leftlarm2", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4F, -3.0F, 0.0F, -0.5207F, -0.1065F, 0.1808F));
		PartDefinition rightarm2 = body2.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.6F, -3.0F, 0.0F, 0.0873F, 0.0F, -0.829F));
		PartDefinition head = body2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(15, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition head3 = head.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition hair6 = head3.addOrReplaceChild("hair6", CubeListBuilder.create().texOffs(28, 1).addBox(-4.0F, -3.5F, -2.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -0.5F, -0.5F));
		PartDefinition hair7 = hair6.addOrReplaceChild("hair7", CubeListBuilder.create().texOffs(46, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5F, 3.0F, -0.6109F, 0.0F, 0.0F));
		PartDefinition shroom2 = hair6.addOrReplaceChild("shroom2", CubeListBuilder.create().texOffs(1, 72).addBox(-5.5F, -4.0F, -5.5F, 11.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 87)
				.addBox(-3.5F, -6.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(48, 74).addBox(-6.5F, -13.0F, -6.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.5F, 0.5F));
		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
