// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelfruityMandrake<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "fruitymandrake"), "main");
	private final ModelPart rightarm;
	private final ModelPart leftlarm;
	private final ModelPart head2;
	private final ModelPart rightlegass;
	private final ModelPart leftlegass;
	private final ModelPart root;

	public ModelfruityMandrake(ModelPart root) {
		this.rightarm = root.getChild("rightarm");
		this.leftlarm = root.getChild("leftlarm");
		this.head2 = root.getChild("head2");
		this.rightlegass = root.getChild("rightlegass");
		this.leftlegass = root.getChild("leftlegass");
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm",
				CubeListBuilder.create().texOffs(0, 23).mirror()
						.addBox(0.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 16.0F, -1.5F, 0.0F, 0.0F, -0.5672F));

		PartDefinition leftlarm = partdefinition.addOrReplaceChild("leftlarm",
				CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 16.0F, -1.5F, 0.0F, 0.0F, 0.5672F));

		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 1)
				.addBox(-2.5F, -5.0F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 15.4993F, -1.4673F));

		PartDefinition hair1 = head2.addOrReplaceChild("hair1", CubeListBuilder.create().texOffs(28, 1).addBox(-4.5F,
				-4.5F, -2.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -0.5F, -0.5F));

		PartDefinition leaves = hair1.addOrReplaceChild("leaves", CubeListBuilder.create(),
				PartPose.offset(1.5F, -4.5F, 2.0F));

		PartDefinition hair3 = leaves.addOrReplaceChild("hair3",
				CubeListBuilder.create().texOffs(52, 7).addBox(-4.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -1.5708F, 0.0F));

		PartDefinition hair4 = leaves.addOrReplaceChild("hair4",
				CubeListBuilder.create().texOffs(52, 22).addBox(-4.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.3491F, -1.5708F, 0.0F));

		PartDefinition hair6 = leaves.addOrReplaceChild("hair6",
				CubeListBuilder.create().texOffs(52, 7).addBox(-4.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.4363F, -1.5708F, 0.0F));

		PartDefinition leaves2 = hair1.addOrReplaceChild("leaves2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-4.5F, -4.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition hair7 = leaves2.addOrReplaceChild("hair7",
				CubeListBuilder.create().texOffs(52, 7).mirror()
						.addBox(-4.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -1.5708F, 0.0F));

		PartDefinition hair8 = leaves2.addOrReplaceChild("hair8",
				CubeListBuilder.create().texOffs(52, 22).mirror()
						.addBox(-4.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.3491F, -1.5708F, 0.0F));

		PartDefinition hair9 = leaves2.addOrReplaceChild("hair9",
				CubeListBuilder.create().texOffs(52, 7).mirror()
						.addBox(-4.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.4363F, -1.5708F, 0.0F));

		PartDefinition hair2 = hair1
				.addOrReplaceChild("hair2",
						CubeListBuilder.create().texOffs(46, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-1.5F, 1.5F, 3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition hair5 = hair1.addOrReplaceChild("hair5", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-1.5F, 1.5F, -2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition leaves3 = hair1.addOrReplaceChild("leaves3", CubeListBuilder.create(),
				PartPose.offset(-1.5F, -4.5F, 3.0F));

		PartDefinition hair10 = leaves3
				.addOrReplaceChild("hair10",
						CubeListBuilder.create().texOffs(50, 2).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition hair13 = leaves3.addOrReplaceChild("hair13",
				CubeListBuilder.create().texOffs(60, 12).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 0.0F, -5.0F, -0.2182F, 0.0436F, 0.0873F));

		PartDefinition hair14 = leaves3.addOrReplaceChild("hair14",
				CubeListBuilder.create().texOffs(60, 12).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 0.0F, -5.0F, -0.2182F, 0.3054F, 0.3927F));

		PartDefinition hair11 = leaves3
				.addOrReplaceChild("hair11",
						CubeListBuilder.create().texOffs(51, 17).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition hair12 = leaves3
				.addOrReplaceChild("hair12",
						CubeListBuilder.create().texOffs(50, 2).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Flower = hair1.addOrReplaceChild("Flower",
				CubeListBuilder.create().texOffs(28, 16)
						.addBox(0.0F, -9.5F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(30, 30)
						.addBox(-1.0F, -14.5F, -1.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, 4.0F, 2.0F));

		PartDefinition hair5_r1 = Flower.addOrReplaceChild("hair5_r1",
				CubeListBuilder.create().texOffs(30, 30).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -12.0F, -1.5F, 0.0F, 2.3562F, 0.0F));

		PartDefinition hair5_r2 = Flower.addOrReplaceChild("hair5_r2",
				CubeListBuilder.create().texOffs(30, 30).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -12.0F, -1.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition hair4_r1 = Flower.addOrReplaceChild("hair4_r1",
				CubeListBuilder.create().texOffs(30, 30).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -12.0F, -1.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition petal1 = Flower.addOrReplaceChild("petal1",
				CubeListBuilder.create().texOffs(28, 20).addBox(-2.5F, -5.0F, 0.0F, 5.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -8.5F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition petal2 = Flower.addOrReplaceChild("petal2",
				CubeListBuilder.create().texOffs(28, 20).mirror()
						.addBox(-2.5F, -5.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.5F, -8.5F, -3.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition petal3 = Flower.addOrReplaceChild("petal3",
				CubeListBuilder.create().texOffs(28, 20).addBox(-2.5F, -5.0F, 0.0F, 5.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -8.5F, -1.5F, -0.9599F, -1.5708F, 0.0F));

		PartDefinition petal4 = Flower.addOrReplaceChild("petal4",
				CubeListBuilder.create().texOffs(28, 20).mirror()
						.addBox(-2.5F, -5.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -8.5F, -1.5F, 0.9599F, -1.5708F, 0.0F));

		PartDefinition rightlegass = partdefinition.addOrReplaceChild("rightlegass",
				CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, 0.5F, -1.5F, 3.0F, 3.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 18.5F, -0.5F, -0.0436F, 0.0F, 0.0873F));

		PartDefinition rightlegmain_r1 = rightlegass.addOrReplaceChild("rightlegmain_r1",
				CubeListBuilder.create().texOffs(17, 31).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.5F, 0.0F, 0.0436F, 0.0F, -0.0436F));

		PartDefinition rightlegmain = rightlegass
				.addOrReplaceChild("rightlegmain",
						CubeListBuilder.create().texOffs(13, 31).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.5F, 3.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition rightleg = rightlegmain.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(10, 35)
				.addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.25F, -0.5F, 0.0F));

		PartDefinition leftlegass = partdefinition.addOrReplaceChild("leftlegass",
				CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, 0.5F, -1.5F, 3.0F, 3.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 18.5F, -0.5F, -0.0436F, 0.0F, -0.0873F));

		PartDefinition rightlegmain_r2 = leftlegass.addOrReplaceChild("rightlegmain_r2",
				CubeListBuilder.create().texOffs(17, 31).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 0.5F, 0.0F, 0.0436F, 0.0F, 0.0436F));

		PartDefinition leftlegmain = leftlegass
				.addOrReplaceChild("leftlegmain",
						CubeListBuilder.create().texOffs(0, 30).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-0.5F, 3.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition leftleg = leftlegmain.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 35)
				.addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.25F, -0.5F, 0.0F));

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(),
				PartPose.offset(0.0F, 25.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 5.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -6.0F, -1.5F, -0.0436F, 0.0F, 0.0F));

		PartDefinition neck = body.addOrReplaceChild("neck",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 0)
						.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0007F, 0.0327F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tit4 = body.addOrReplaceChild("tit4",
				CubeListBuilder.create().texOffs(0, 50).mirror()
						.addBox(-2.0F, -0.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -2.0F, -1.5F, 0.1309F, 0.2182F, 0.0F));

		PartDefinition tit3 = body.addOrReplaceChild("tit3",
				CubeListBuilder.create().texOffs(0, 50).addBox(0.0F, -0.5F, -1.5F, 2.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, -1.5F, 0.1309F, -0.2182F, 0.0F));

		PartDefinition belly = body.addOrReplaceChild("belly",
				CubeListBuilder.create().texOffs(12, 13).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.75F, 1.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegass.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegass.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.leftlarm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.rightlegass.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.head2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head2.xRot = headPitch / (180F / (float) Math.PI);
		this.leftlegass.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}