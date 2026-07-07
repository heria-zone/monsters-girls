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

// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelChubbyjargal<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "model_chubbyjargal"), "main");
	public final ModelPart bone2;

	public ModelChubbyjargal(ModelPart root) {
		this.bone2 = root.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(52, 0).addBox(-6.0F, -15.0F, -6.0F, 12.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(68, 27).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(52, 43)
						.addBox(-6.0F, -1.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(58, 57).addBox(-2.5F, -5.0F, 0.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(58, 64)
						.addBox(-3.0F, -3.0F, -1.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition root = bone2.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));
		PartDefinition shape9 = root.addOrReplaceChild("shape9", CubeListBuilder.create().texOffs(0, 39).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.7F, -2.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition shape2 = shape9.addOrReplaceChild("shape2", CubeListBuilder.create().texOffs(0, 33).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0349F, 0.0F, 0.0F));
		PartDefinition neck = shape2.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, -1.2F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition shroom1 = head.addOrReplaceChild("shroom1", CubeListBuilder.create().texOffs(0, 12).addBox(-4.5F, -3.0F, -4.5F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition shroom2 = shroom1.addOrReplaceChild("shroom2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));
		PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(0, 88).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition boob1 = shape2.addOrReplaceChild("boob1", CubeListBuilder.create().texOffs(0, 97).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.7F, -0.6F, -1.2F, 0.2731F, 0.2731F, 0.0F));
		PartDefinition boob2 = shape2.addOrReplaceChild("boob2", CubeListBuilder.create().texOffs(10, 97).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.7F, -0.6F, -1.2F, 0.2731F, -0.2731F, 0.0F));
		PartDefinition assa = shape2.addOrReplaceChild("assa", CubeListBuilder.create().texOffs(15, 46).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.4F));
		PartDefinition leftarm = shape2.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 81).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, -1.0F, 0.0F, -0.7065F, -0.0898F, -0.2751F));
		PartDefinition rightarm = shape2.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(10, 81).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -1.0F, 0.0F, 0.6872F, 0.3622F, -0.6457F));
		PartDefinition shape3 = shape9.addOrReplaceChild("shape3", CubeListBuilder.create().texOffs(0, 45).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -0.1F));
		PartDefinition rightlegmain = shape3.addOrReplaceChild("rightlegmain", CubeListBuilder.create().texOffs(1, 54).addBox(-0.5F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.7F, -0.1F, 0.1F, -0.2182F, 0.0F, -0.0456F));
		PartDefinition rightleg = rightlegmain.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 65).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, 0.0F));
		PartDefinition rightlegknee = rightlegmain.addOrReplaceChild("rightlegknee", CubeListBuilder.create().texOffs(0, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, -0.5F));
		PartDefinition rightlegass = rightlegmain.addOrReplaceChild("rightlegass", CubeListBuilder.create().texOffs(28, 68).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, 1.0F, 0.3F, 0.0F, 0.0F, 0.0456F));
		PartDefinition rightlegass2 = rightlegmain.addOrReplaceChild("rightlegass2", CubeListBuilder.create().texOffs(28, 61).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, 1.0F, 0.8F, 0.0F, 0.0F, 0.0456F));
		PartDefinition leftlegmain = shape3.addOrReplaceChild("leftlegmain", CubeListBuilder.create().texOffs(9, 54).addBox(-0.5F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.7F, -0.1F, 0.0F, -0.1745F, 0.0F, 0.0456F));
		PartDefinition leftleg = leftlegmain.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(10, 65).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 2.0F, 0.0F));
		PartDefinition leftlegknee = leftlegmain.addOrReplaceChild("leftlegknee", CubeListBuilder.create().texOffs(10, 60).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 2.0F, 0.0F));
		PartDefinition leftlegass = leftlegmain.addOrReplaceChild("leftlegass", CubeListBuilder.create().texOffs(43, 68).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4F, 1.0F, 0.4F, 0.0F, 0.0F, -0.0456F));
		PartDefinition leftlegass2 = leftlegmain.addOrReplaceChild("leftlegass2", CubeListBuilder.create().texOffs(41, 61).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4F, 1.0F, 0.9F, 0.0F, 0.0F, -0.0456F));
		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
