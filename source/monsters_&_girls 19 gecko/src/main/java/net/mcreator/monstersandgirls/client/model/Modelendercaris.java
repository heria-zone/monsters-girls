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

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelendercaris<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "modelendercaris"), "main");
	public final ModelPart bodymain;

	public Modelendercaris(ModelPart root) {
		this.bodymain = root.getChild("bodymain");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bodymain = partdefinition.addOrReplaceChild("bodymain", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.0F, -4.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition bodymain2 = bodymain.addOrReplaceChild("bodymain2", CubeListBuilder.create().texOffs(0, 25).addBox(-2.5F, -1.0F, -2.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));
		PartDefinition bodymain4 = bodymain2.addOrReplaceChild("bodymain4", CubeListBuilder.create().texOffs(0, 29).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition head1 = bodymain4.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 33).addBox(-2.5F, -1.0F, -3.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition limbjoint1 = head1.addOrReplaceChild("limbjoint1", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.0F, -3.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition limbleft1 = limbjoint1.addOrReplaceChild("limbleft1", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 1.0F));
		PartDefinition limbjoint2 = limbleft1.addOrReplaceChild("limbjoint2", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, -3.5F, 0.5236F, 0.0F, 0.0F));
		PartDefinition limbleft2 = limbjoint2.addOrReplaceChild("limbleft2", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.5F));
		PartDefinition limbjoint3 = limbleft2.addOrReplaceChild("limbjoint3", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.5236F, 0.0F, 0.0F));
		PartDefinition limbleft3 = limbjoint3.addOrReplaceChild("limbleft3", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-1.0F, -1.0F, -5.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 3.0F));
		PartDefinition limbjoint4 = head1.addOrReplaceChild("limbjoint4", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, 0.0F, -3.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition limbleft4 = limbjoint4.addOrReplaceChild("limbleft4", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));
		PartDefinition limbjoint5 = limbleft4.addOrReplaceChild("limbjoint5", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -3.5F, 0.5236F, 0.0F, 0.0F));
		PartDefinition limbleft5 = limbjoint5.addOrReplaceChild("limbleft5", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));
		PartDefinition limbjoint6 = limbleft5.addOrReplaceChild("limbjoint6", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.5236F, 0.0F, 0.0F));
		PartDefinition limbleft6 = limbjoint6.addOrReplaceChild("limbleft6", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, -1.0F, -5.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));
		PartDefinition eye1 = head1.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(0, 3).addBox(-4.5F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition eye2 = head1.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(2.5F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition leftfin1 = bodymain4.addOrReplaceChild("leftfin1", CubeListBuilder.create().texOffs(40, 6).addBox(0.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.1309F));
		PartDefinition rightfin1 = bodymain4.addOrReplaceChild("rightfin1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-2.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.1309F));
		PartDefinition leftfin2 = bodymain2.addOrReplaceChild("leftfin2", CubeListBuilder.create().texOffs(38, 4).addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition rightfin2 = bodymain2.addOrReplaceChild("rightfin2", CubeListBuilder.create().texOffs(38, 4).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.5F, 0.0F, -1.0F, 0.0F, 0.0F, -0.0873F));
		PartDefinition bodymain3 = bodymain.addOrReplaceChild("bodymain3", CubeListBuilder.create().texOffs(0, 10).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 4.0F));
		PartDefinition bodymain5 = bodymain3.addOrReplaceChild("bodymain5", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));
		PartDefinition leftfin9 = bodymain5.addOrReplaceChild("leftfin9", CubeListBuilder.create().texOffs(36, 8).addBox(0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.0F, 2.0F, 0.0F, -0.2618F, -0.6545F));
		PartDefinition leftfin10 = bodymain5.addOrReplaceChild("leftfin10", CubeListBuilder.create().texOffs(36, 8).addBox(0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.0F, 3.0F, 0.0F, -0.5236F, -0.6981F));
		PartDefinition leftfin11 = bodymain5.addOrReplaceChild("leftfin11", CubeListBuilder.create().texOffs(36, 8).addBox(0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.0F, 4.0F, 0.0F, -0.7854F, -0.7854F));
		PartDefinition rightfin9 = bodymain5.addOrReplaceChild("rightfin9", CubeListBuilder.create().texOffs(36, 8).mirror().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.5F, 0.0F, 2.0F, 0.0F, 0.2618F, 0.6545F));
		PartDefinition rightfin10 = bodymain5.addOrReplaceChild("rightfin10", CubeListBuilder.create().texOffs(36, 8).mirror().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.5F, 0.0F, 3.0F, 0.0F, 0.5236F, 0.6981F));
		PartDefinition rightfin11 = bodymain5.addOrReplaceChild("rightfin11", CubeListBuilder.create().texOffs(36, 8).mirror().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.5F, 0.0F, 4.0F, 0.0F, 0.7854F, 0.7854F));
		PartDefinition leftfin7 = bodymain3.addOrReplaceChild("leftfin7", CubeListBuilder.create().texOffs(38, 4).addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, 0.0F, 1.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition leftfin8 = bodymain3.addOrReplaceChild("leftfin8", CubeListBuilder.create().texOffs(39, 6).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, 3.0F));
		PartDefinition rightfin7 = bodymain3.addOrReplaceChild("rightfin7", CubeListBuilder.create().texOffs(38, 4).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.5F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0436F));
		PartDefinition rightfin8 = bodymain3.addOrReplaceChild("rightfin8", CubeListBuilder.create().texOffs(39, 6).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 0.0F, 3.0F));
		PartDefinition leftfin3 = bodymain.addOrReplaceChild("leftfin3", CubeListBuilder.create().texOffs(37, 2).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -1.0F, -3.0F, 0.0F, 0.0F, 0.0436F));
		PartDefinition rightfin3 = bodymain.addOrReplaceChild("rightfin3", CubeListBuilder.create().texOffs(37, 2).mirror().addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.5F, -1.0F, -3.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition rightfin5 = bodymain.addOrReplaceChild("rightfin5", CubeListBuilder.create().texOffs(37, 2).mirror().addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.5F, -1.0F, 1.0F, 0.0F, 0.0F, 0.0436F));
		PartDefinition rightfin6 = bodymain.addOrReplaceChild("rightfin6", CubeListBuilder.create().texOffs(38, 4).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.5F, -1.0F, 3.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition leftfin5 = bodymain.addOrReplaceChild("leftfin5", CubeListBuilder.create().texOffs(37, 2).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -1.0F, 1.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition leftfin6 = bodymain.addOrReplaceChild("leftfin6", CubeListBuilder.create().texOffs(38, 4).addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -1.0F, 3.0F, 0.0F, 0.0F, -0.0873F));
		PartDefinition leftfin4 = bodymain.addOrReplaceChild("leftfin4", CubeListBuilder.create().texOffs(36, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -1.0F, -1.0F));
		PartDefinition rightfin4 = bodymain.addOrReplaceChild("rightfin4", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, -1.0F, -1.0F));
		return LayerDefinition.create(meshdefinition, 50, 50);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bodymain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
