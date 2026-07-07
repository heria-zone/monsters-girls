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

import net.mcreator.monstersandgirls.EndMath;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBeegirl<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "model_beegirl"), "main");
	public final ModelPart abdomen;
	public final ModelPart leftlegass;
	public final ModelPart rightlegass;
	public final ModelPart head;
	public final ModelPart leftwing;
	public final ModelPart rightwing;
	public final ModelPart belly2;
	public final ModelPart body;

	public ModelBeegirl(ModelPart root) {
		this.abdomen = root.getChild("abdomen");
		this.leftlegass = root.getChild("leftlegass");
		this.rightlegass = root.getChild("rightlegass");
		this.head = root.getChild("head");
		this.leftwing = root.getChild("leftwing");
		this.rightwing = root.getChild("rightwing");
		this.belly2 = root.getChild("belly2");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition abdomen = partdefinition.addOrReplaceChild("abdomen",
				CubeListBuilder.create().texOffs(0, 46).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 47).addBox(0.0F, 6.0F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 17.55F, -0.05F, 0.7854F, 0.0F, 0.0F));
		PartDefinition leftlegass = partdefinition.addOrReplaceChild("leftlegass", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, 17.75F, -0.5F, 0.1309F, 0.0F, 0.0F));
		PartDefinition leftlegmain = leftlegass.addOrReplaceChild("leftlegmain", CubeListBuilder.create().texOffs(0, 30).addBox(-0.5F, 0.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.25F, 0.0F));
		PartDefinition leftleg = leftlegmain.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 35).addBox(-1.25F, -1.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 0.0F));
		PartDefinition rightlegass = partdefinition.addOrReplaceChild("rightlegass", CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 17.75F, -0.5F, 0.1309F, 0.0F, 0.0F));
		PartDefinition rightlegmain = rightlegass.addOrReplaceChild("rightlegmain", CubeListBuilder.create().texOffs(13, 31).addBox(-0.5F, 0.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 3.25F, 0.0F));
		PartDefinition rightleg = rightlegmain.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(10, 35).addBox(-0.75F, -1.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 15.342F, -2.4397F, 0.3491F, 0.0F, 0.0F));
		PartDefinition head2 = head.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 1).addBox(-2.5F, -4.0F, -3.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 1.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition hair1 = head2.addOrReplaceChild("hair1",
				CubeListBuilder.create().texOffs(26, 1).addBox(-5.5F, -3.75F, -3.5F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(33, 14).addBox(-5.5F, -3.0F, -3.25F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(52, 5)
						.addBox(-4.5F, -4.75F, -3.5F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(23, 17).addBox(-6.5F, -4.75F, -5.0F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(50, 18)
						.addBox(-4.5F, -7.75F, -3.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 57).addBox(1.5F, -2.75F, -2.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 57).mirror()
						.addBox(-6.5F, -2.75F, -2.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, -0.25F, -0.5F));
		PartDefinition hair8_r1 = hair1.addOrReplaceChild("hair8_r1",
				CubeListBuilder.create().texOffs(10, 57).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(10, 57).mirror().addBox(-6.0F, -3.0F, -1.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -4.75F, -1.5F, 0.48F, 0.0F, 0.0F));
		PartDefinition leftwing = partdefinition.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(0, 20).addBox(-8.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.25F, 16.5F, -0.4F, 0.3491F, 0.6981F, 0.2618F));
		PartDefinition rightwing = partdefinition.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, -2.5F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.25F, 16.5F, -0.4F, 0.3491F, -0.6981F, -0.2618F));
		PartDefinition belly2 = partdefinition.addOrReplaceChild("belly2", CubeListBuilder.create().texOffs(12, 13).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 17.1F, -1.25F, 0.48F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-1.4F, -3.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1F, 18.0F, -1.5F, 0.3054F, 0.0F, 0.0F));
		PartDefinition tit4 = body.addOrReplaceChild("tit4", CubeListBuilder.create().texOffs(0, 64).addBox(-2.0F, -0.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -2.0F, -1.5F, 0.1309F, 0.2182F, 0.0F));
		PartDefinition tit2 = body.addOrReplaceChild("tit2", CubeListBuilder.create().texOffs(0, 64).mirror().addBox(0.0F, -0.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.1F, -2.0F, -1.5F, 0.1309F, -0.2182F, 0.0F));
		PartDefinition leftlarm = body.addOrReplaceChild("leftlarm", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, -1.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4F, -3.0F, 0.0F, 0.0F, -0.1309F, -0.829F));
		PartDefinition leftlarm2 = body.addOrReplaceChild("leftlarm2", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, -1.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4F, -1.5F, 1.0F, 0.0F, 0.0F, -0.6109F));
		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(13, 25).addBox(0.0F, -1.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.6F, -3.0F, 0.0F, 0.0F, 0.1309F, 0.829F));
		PartDefinition rightarm2 = body.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(13, 25).addBox(0.0F, -1.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.6F, -1.5F, 1.0F, 0.0F, 0.0F, 0.6109F));
		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		abdomen.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegass.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegass.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		belly2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leftwing.yRot = (EndMath.sin(ageInTicks * 0.6F + 3) * 0.6F);
		this.rightwing.yRot = (EndMath.sin(ageInTicks * 0.6F) * 0.6F);
	}
}
