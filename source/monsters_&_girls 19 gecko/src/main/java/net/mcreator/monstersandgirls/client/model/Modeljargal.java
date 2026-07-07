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
public class Modeljargal<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_and_girls", "modeljargal"), "main");
	public final ModelPart bone2;

	public Modeljargal(ModelPart root) {
		this.bone2 = root.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(52, 0).addBox(-6.0F, -15.0F, -6.0F, 12.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(68, 27).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(52, 43)
						.addBox(-6.0F, -1.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(59, 58).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition root = bone2.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 0.0F));
		PartDefinition shape9 = root.addOrReplaceChild("shape9", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.5F, 0.5F));
		PartDefinition shape2 = shape9.addOrReplaceChild("shape2", CubeListBuilder.create().texOffs(0, 33).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition boob2_r1 = shape2.addOrReplaceChild("boob2_r1", CubeListBuilder.create().texOffs(24, 97).addBox(-1.0F, -0.53F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.06F, -1.1F, 0.2618F, 0.0F, 0.0F));
		PartDefinition neck = shape2.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, -1.2F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition shroom1 = head.addOrReplaceChild("shroom1", CubeListBuilder.create().texOffs(0, 14).addBox(-4.5F, -2.0F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition shroom2 = shroom1.addOrReplaceChild("shroom2", CubeListBuilder.create().texOffs(0, 6).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition shroom3 = shroom2.addOrReplaceChild("shroom3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(0, 88).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition Pigtailleft = hair.addOrReplaceChild("Pigtailleft", CubeListBuilder.create().texOffs(28, 92).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 1.5F, 2.0F, 0.3927F, 0.0F, -0.4363F));
		PartDefinition Pigtailleft2 = Pigtailleft.addOrReplaceChild("Pigtailleft2", CubeListBuilder.create().texOffs(30, 97).addBox(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 1.5F, 0.5F));
		PartDefinition Pigtailright = hair.addOrReplaceChild("Pigtailright", CubeListBuilder.create().texOffs(18, 92).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 1.5F, 2.0F, 0.3927F, 0.0F, 0.4363F));
		PartDefinition Pigtailleft3 = Pigtailright.addOrReplaceChild("Pigtailleft3", CubeListBuilder.create().texOffs(20, 97).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.5F, 0.5F));
		PartDefinition boob1 = shape2.addOrReplaceChild("boob1", CubeListBuilder.create().texOffs(0, 97).addBox(-0.45F, -0.44F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.7F, 0.0F, -1.2F, 0.2731F, 0.2731F, 0.0F));
		PartDefinition boob2 = shape2.addOrReplaceChild("boob2", CubeListBuilder.create().texOffs(10, 97).addBox(-0.55F, -0.44F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.7F, 0.0F, -1.2F, 0.2731F, -0.2731F, 0.0F));
		PartDefinition rightarm = shape2.addOrReplaceChild("rightarm",
				CubeListBuilder.create().texOffs(10, 81).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 83).addBox(0.0F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -1.0F, 0.0F, -0.7175F, 0.0312F, 0.0745F));
		PartDefinition leftarm = shape2.addOrReplaceChild("leftarm",
				CubeListBuilder.create().texOffs(0, 81).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 83).addBox(-1.0F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, -1.0F, 0.0F, -0.6632F, -0.1014F, -0.0304F));
		PartDefinition shape3 = shape9.addOrReplaceChild("shape3",
				CubeListBuilder.create().texOffs(0, 44).addBox(-2.0F, -0.5F, -0.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 58).addBox(-2.5F, 0.0F, -1.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.0F, 0.0F));
		PartDefinition rightlegmain = shape3.addOrReplaceChild("rightlegmain", CubeListBuilder.create().texOffs(1, 54).addBox(-0.25F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.5F, 0.0F, -1.2566F, -0.1278F, -0.0634F));
		PartDefinition rightleg = rightlegmain.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 66).addBox(-0.7F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 0.0F));
		PartDefinition rightlegknee = rightlegmain.addOrReplaceChild("rightlegknee", CubeListBuilder.create().texOffs(0, 61).addBox(-0.25F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, 0.0F));
		PartDefinition leftlegmain = shape3.addOrReplaceChild("leftlegmain", CubeListBuilder.create().texOffs(9, 54).addBox(-0.75F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.5F, 0.0F, -1.4815F, 0.173F, 0.0579F));
		PartDefinition leftleg = leftlegmain.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(10, 66).addBox(-1.3F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 0.0F));
		PartDefinition leftlegpart = leftleg.addOrReplaceChild("leftlegpart", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.5F, 0.0F));
		PartDefinition leftlegknee = leftlegmain.addOrReplaceChild("leftlegknee", CubeListBuilder.create().texOffs(10, 61).addBox(-0.75F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 2.0F, 0.0F));
		PartDefinition shape9a = shape3.addOrReplaceChild("shape9a", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, 0.0F, -1.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 1.0F));
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
