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
public class ModelKurwaPlease<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "model_kurwa_please"), "main");
	public final ModelPart root;

	public ModelKurwaPlease(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition shroom1 = root.addOrReplaceChild("shroom1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.75F, 6.9F, -9.5F, 18.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, -14.9F, 0.5F));
		PartDefinition shroom1b = shroom1.addOrReplaceChild("shroom1b", CubeListBuilder.create().texOffs(0, 24).addBox(-6.75F, 11.9F, -7.5F, 14.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));
		PartDefinition shroom3 = shroom1b.addOrReplaceChild("shroom3", CubeListBuilder.create().texOffs(0, 44).addBox(-3.75F, 10.3F, -4.5F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.4F, 0.0F));
		PartDefinition shroom4 = shroom3.addOrReplaceChild("shroom4", CubeListBuilder.create().texOffs(35, 50).addBox(-1.75F, 9.8F, -2.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));
		PartDefinition shroomtent = shroom1.addOrReplaceChild("shroomtent", CubeListBuilder.create().texOffs(0, 56).addBox(-8.75F, 7.9F, -9.5F, 18.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
