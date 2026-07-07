package net.mcreator.monstersandgirls.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
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

// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelMandrake<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "model_mandrake"), "main");
	public final ModelPart head;
	public final ModelPart rightlegmain;
	public final ModelPart rightarm;
	public final ModelPart leftarm;
	public final ModelPart leftlegmain;
	public final ModelPart shape9_2;

	public ModelMandrake(ModelPart root) {
		this.head = root.getChild("head");
		this.rightlegmain = root.getChild("rightlegmain");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.leftlegmain = root.getChild("leftlegmain");
		this.shape9_2 = root.getChild("shape9_2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.5F, 0.0F));
		PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(0, 5).addBox(-2.0F, 0.5F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.5F));
		PartDefinition petal1 = hair.addOrReplaceChild("petal1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -1.5F, 0.4363F, 0.0F, 0.0F));
		PartDefinition leaf1 = hair.addOrReplaceChild("leaf1", CubeListBuilder.create().texOffs(5, 0).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -2.0F, 1.0472F, 0.0F, 0.0F));
		PartDefinition leaf2 = hair.addOrReplaceChild("leaf2", CubeListBuilder.create().texOffs(5, 0).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 1.0F, -1.0472F, 0.0F, 0.0F));
		PartDefinition leaf3 = hair.addOrReplaceChild("leaf3", CubeListBuilder.create().texOffs(5, 0).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.5F, -0.5F, -1.0472F, -1.5708F, 0.0F));
		PartDefinition leaf4 = hair.addOrReplaceChild("leaf4", CubeListBuilder.create().texOffs(5, 0).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.5F, -0.5F, 1.0472F, -1.5708F, 0.0F));
		PartDefinition petal2 = hair.addOrReplaceChild("petal2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.5F, -0.4363F, 0.0F, 0.0F));
		PartDefinition petal3 = hair.addOrReplaceChild("petal3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, -0.5F, 0.0F, 0.0F, 0.4363F));
		PartDefinition petal4 = hair.addOrReplaceChild("petal4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, -0.5F, 0.0F, 0.0F, -0.4363F));
		PartDefinition rightlegmain = partdefinition.addOrReplaceChild("rightlegmain", CubeListBuilder.create().texOffs(9, 47).addBox(-0.75F, 1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 20.5F, 0.0F, 0.0F, 0.0F, 0.0436F));
		PartDefinition rightleg = rightlegmain.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(10, 41).addBox(-3.25F, -23.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 23.5F, 0.0F));
		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(25, 46).addBox(-1.0F, -0.1F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, 17.6F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(41, 46).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 17.5F, 0.0F, 0.0F, 0.0F, -0.3491F));
		PartDefinition leftlegmain = partdefinition.addOrReplaceChild("leftlegmain", CubeListBuilder.create().texOffs(0, 47).addBox(-0.25F, 1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 20.5F, 0.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition leftleg = leftlegmain.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 41).addBox(0.25F, -24.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 24.5F, 0.0F));
		PartDefinition shape9_2 = partdefinition.addOrReplaceChild("shape9_2", CubeListBuilder.create().texOffs(0, 34).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.5F, 0.0F));
		PartDefinition shape9 = shape9_2.addOrReplaceChild("shape9", CubeListBuilder.create().texOffs(0, 28).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition neck = shape9.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 20).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, 0.0F));
		return LayerDefinition.create(meshdefinition, 50, 50);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegmain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegmain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shape9_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.rightlegmain.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftlegmain.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
