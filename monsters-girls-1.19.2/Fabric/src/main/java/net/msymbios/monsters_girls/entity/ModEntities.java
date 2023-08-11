package net.msymbios.monsters_girls.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.entity.client.*;
import net.msymbios.monsters_girls.entity.custom.*;

public class ModEntities {

    // -- Variables --
    public static final EntityType<MandrakeGirlBrownEntity> MANDRAKE_GIRL_BROWN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mandrake_girl_brown"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MandrakeGirlBrownEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build());

    public static final EntityType<MandrakeGirlGreenEntity> MANDRAKE_GIRL_GREEN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mandrake_girl_green"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MandrakeGirlGreenEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build());

    public static final EntityType<CrimsonEntity> MUSHROOM_GIRL_CRIMSON = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_crimson"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrimsonEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<CrimsonRareEntity> MUSHROOM_GIRL_CRIMSON_RARE = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_crimson_rare"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrimsonRareEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<InkCapEntity> MUSHROOM_GIRL_INK_CAP = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_ink_cap"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, InkCapEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1.4F)).build());

    public static final EntityType<WarpedEntity> MUSHROOM_GIRL_WARPED = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_warped"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WarpedEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<WarpedRareEntity> MUSHROOM_GIRL_WARPED_RARE = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_warped_rare"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WarpedRareEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<FlyAgaricEntity> MUSHROOM_GIRL_FLY_AGARIC = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_red"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FlyAgaricEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<AmanitaYellowEntity> MUSHROOM_GIRL_AMANITA_YELLOW = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_yellow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AmanitaYellowEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomGirlBrownEntity> MUSHROOM_GIRL_BROWN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_brown"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomGirlBrownEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomGirlEnderPuffballEntity> MUSHROOM_GIRL_ENDER_PUFFBALL = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_ender_puffball"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomGirlEnderPuffballEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomGirlInfernalEntity> MUSHROOM_GIRL_INFERNAL = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_infernal"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomGirlInfernalEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomGirlMoltenEntity> MUSHROOM_GIRL_MOLTEN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_molten_fungus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomGirlMoltenEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomGirlSoulWandererEntity> MUSHROOM_GIRL_SOUL_WANDERER = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_soul_wanderer"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomGirlSoulWandererEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    // -- Methods --
    public static void registerEntityAttribute () {
        FabricDefaultAttributeRegistry.register(MANDRAKE_GIRL_BROWN, MandrakeGirlBrownEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MANDRAKE_GIRL_GREEN, MandrakeGirlGreenEntity.setAttributes());

        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_AMANITA_YELLOW, AmanitaYellowEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_BROWN, MushroomGirlBrownEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_CRIMSON, CrimsonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_CRIMSON_RARE, CrimsonRareEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_ENDER_PUFFBALL, MushroomGirlEnderPuffballEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_FLY_AGARIC, FlyAgaricEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_INFERNAL, MushroomGirlInfernalEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_INK_CAP, InkCapEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_MOLTEN, MushroomGirlMoltenEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_WARPED, WarpedEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_WARPED_RARE, WarpedRareEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_SOUL_WANDERER, MushroomGirlSoulWandererEntity.setAttributes());
    } // registerEntityAttribute ()

    public static void registerEntityRenderer () {
        EntityRendererRegistry.register(MANDRAKE_GIRL_BROWN, MandrakeGirlBrownRenderer::new);
        EntityRendererRegistry.register(MANDRAKE_GIRL_GREEN, MandrakeGirlGreenRenderer::new);

        EntityRendererRegistry.register(MUSHROOM_GIRL_AMANITA_YELLOW, AmanitaYellowRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_BROWN, MushroomGirlBrownRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_CRIMSON, CrimsonRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_CRIMSON_RARE, CrimsonRareRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_ENDER_PUFFBALL, MushroomGirlEnderPuffballRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_INFERNAL, MushroomGirlInfernalRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_INK_CAP, InkCapRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_MOLTEN, MushroomGirlMoltenRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_FLY_AGARIC, FlyAgaricRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_WARPED, WarpedRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_WARPED_RARE, WarpedRareRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_SOUL_WANDERER,MushroomGirlSoulWandererRenderer::new);

    } // registerEntityRenderer ()

} // Class ModEntities