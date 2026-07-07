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
public class ModelSlimeGal<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "model_slime_gal"), "main");
	public final ModelPart rightarm;
	public final ModelPart leftarm;
	public final ModelPart LeftLegMain;
	public final ModelPart rightlegmain;
	public final ModelPart root;

	public ModelSlimeGal(ModelPart root) {
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.LeftLegMain = root.getChild("LeftLegMain");
		this.rightlegmain = root.getChild("rightlegmain");
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(15, 52).addBox(0.0F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 52).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition LeftLegMain = partdefinition.addOrReplaceChild("LeftLegMain", CubeListBuilder.create().texOffs(49, 80).addBox(-1.5F, 1.0F, -1.0F, 3.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, 6.0F, 0.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition rightleg2 = LeftLegMain.addOrReplaceChild("rightleg2", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, 0.0F));
		PartDefinition rightleg_r1 = rightleg2.addOrReplaceChild("rightleg_r1", CubeListBuilder.create().texOffs(55, 36).addBox(-5.0F, -13.0F, -1.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(52, 43)
				.addBox(-6.0F, -11.0F, -2.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(51, 63).addBox(-5.0F, -3.0F, -1.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition rightlegmain = partdefinition.addOrReplaceChild("rightlegmain", CubeListBuilder.create().texOffs(76, 79).addBox(-1.5F, 1.0F, -1.0F, 3.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0436F));
		PartDefinition rightleg = rightlegmain.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));
		PartDefinition rightleg_r2 = rightleg.addOrReplaceChild("rightleg_r2", CubeListBuilder.create().texOffs(80, 36).addBox(2.0F, -13.0F, -1.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(75, 43)
				.addBox(1.0F, -11.0F, -2.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(76, 63).addBox(1.0F, -3.0F, -1.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));
		PartDefinition shape2 = root.addOrReplaceChild("shape2", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, -3.0F, -1.25F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));
		PartDefinition shape9 = shape2.addOrReplaceChild("shape9", CubeListBuilder.create().texOffs(0, 31).addBox(-4.0F, -4.1F, -2.5F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.9F, 0.5F));
		PartDefinition neck = shape9.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(29, 19).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -7.1F, -4.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition hair = head.addOrReplaceChild("hair",
				CubeListBuilder.create().texOffs(0, 1).addBox(-4.5F, -7.6F, -4.5F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 91).addBox(-3.5F, -8.6F, -4.0F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hair2 = hair.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(49, 5).addBox(0.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -6.1F, 3.5F, 0.0F, -0.3491F, -0.1309F));
		PartDefinition hair3 = hair2.addOrReplaceChild("hair3", CubeListBuilder.create().texOffs(53, 19).addBox(-2.0F, 0.5F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, -1.0F, 0.0F, 0.0F, -0.0873F));
		PartDefinition hair4 = hair3.addOrReplaceChild("hair4", CubeListBuilder.create().texOffs(56, 28).addBox(0.0F, 2.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 2.0F, 1.0F));
		PartDefinition hair5 = hair.addOrReplaceChild("hair5", CubeListBuilder.create().texOffs(74, 5).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -6.1F, 3.5F, 0.0F, 0.3491F, 0.1309F));
		PartDefinition hair6 = hair5.addOrReplaceChild("hair6", CubeListBuilder.create().texOffs(78, 19).addBox(-2.0F, 0.5F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 5.0F, -1.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition hair7 = hair6.addOrReplaceChild("hair7", CubeListBuilder.create().texOffs(81, 28).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 1.0F));
		PartDefinition boob1 = shape9.addOrReplaceChild("boob1", CubeListBuilder.create().texOffs(0, 73).addBox(-2.25F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.1F, -2.2F, 0.1757F, 0.1739F, 0.0077F));
		PartDefinition boob2 = shape9.addOrReplaceChild("boob2", CubeListBuilder.create().texOffs(16, 73).addBox(-0.75F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -1.1F, -2.2F, 0.1757F, -0.1739F, -0.0077F));
		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLegMain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegmain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.rightlegmain.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.LeftLegMain.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
