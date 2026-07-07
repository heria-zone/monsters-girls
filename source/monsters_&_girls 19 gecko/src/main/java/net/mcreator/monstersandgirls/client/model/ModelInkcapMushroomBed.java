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
public class ModelInkcapMushroomBed<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "model_inkcap_mushroom_bed"), "main");
	public final ModelPart root;
	public final ModelPart bone;

	public ModelInkcapMushroomBed(ModelPart root) {
		this.root = root.getChild("root");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 1.0F));
		PartDefinition body2 = root.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 14).addBox(-1.4F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -6.0F, -0.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition leftlegass2 = body2.addOrReplaceChild("leftlegass2", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, 0.25F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4F, 0.75F, 1.0F, -1.309F, 0.48F, 0.0F));
		PartDefinition leftlegmain2 = leftlegass2.addOrReplaceChild("leftlegmain2", CubeListBuilder.create().texOffs(0, 30).addBox(-0.5F, 3.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.25F, 0.0F));
		PartDefinition leftleg2 = leftlegmain2.addOrReplaceChild("leftleg2",
				CubeListBuilder.create().texOffs(0, 35).addBox(-1.25F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 33).addBox(-1.25F, -4.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, 1.0F, 0.0F));
		PartDefinition rightlegass2 = body2.addOrReplaceChild("rightlegass2", CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, 0.25F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.6F, 0.75F, 1.0F, -1.309F, -0.48F, 0.0F));
		PartDefinition rightlegmain2 = rightlegass2.addOrReplaceChild("rightlegmain2", CubeListBuilder.create().texOffs(13, 31).addBox(-0.5F, 3.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 3.25F, 0.0F));
		PartDefinition rightleg2 = rightlegmain2.addOrReplaceChild("rightleg2",
				CubeListBuilder.create().texOffs(10, 35).addBox(-0.75F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 33).mirror().addBox(-0.75F, -4.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-0.5F, 1.0F, 0.0F));
		PartDefinition belly = body2.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(29, 38).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -1.75F, 0.75F, 0.2182F, 0.0F, 0.0F));
		PartDefinition chest = body2.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(5, 23).addBox(-1.9F, -4.0F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition leftlarm2 = chest.addOrReplaceChild("leftlarm2", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.9F, -4.0F, 0.0F, -0.48F, 0.0F, 0.1745F));
		PartDefinition rightarm2 = chest.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.0F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.1F, -4.0F, 0.0F, -0.48F, 0.0F, -0.1745F));
		PartDefinition head = chest.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -4.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition head3 = head.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));
		PartDefinition hair6 = head3.addOrReplaceChild("hair6", CubeListBuilder.create().texOffs(28, 1).addBox(-4.0F, -3.5F, -2.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -0.5F, -0.5F));
		PartDefinition hair7 = hair6.addOrReplaceChild("hair7", CubeListBuilder.create().texOffs(46, 11).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5F, 3.0F, 0.0262F, 0.0F, 0.0F));
		PartDefinition shroom2 = hair6.addOrReplaceChild(
				"shroom2", CubeListBuilder.create().texOffs(0, 51).addBox(-5.3333F, 0.0167F, -5.5F, 11.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(19, 16).addBox(-5.3333F, 2.0167F, -5.5F, 11.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
						.texOffs(0, 64).addBox(-3.3333F, -2.9833F, -3.5F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 74).addBox(-1.8333F, -4.9833F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.1667F, -5.0167F, 0.5F));
		PartDefinition tit6 = chest.addOrReplaceChild("tit6", CubeListBuilder.create().texOffs(0, 46).addBox(0.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1F, -3.25F, -1.5F, 0.1745F, -0.2182F, -0.0436F));
		PartDefinition tit5 = chest.addOrReplaceChild("tit5", CubeListBuilder.create().texOffs(0, 46).mirror().addBox(-2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.1F, -3.25F, -1.5F, 0.1745F, 0.2182F, 0.0436F));
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(36, 41).addBox(-8.0F, -3.0F, -13.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(36, 60).addBox(-6.0F, -3.0F, -11.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 5.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(73, 65).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.2531F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
