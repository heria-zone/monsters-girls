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
import net.msymbios.monsters_girls.client.renderer.*;
import net.msymbios.monsters_girls.entity.custom.*;

public class ModEntities {

    // -- Variables --
    public static final EntityType<MandrakeBrownEntity> MANDRAKE_GIRL_BROWN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mandrake_girl_brown"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MandrakeBrownEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build());

    public static final EntityType<MandrakeChorusEntity> MANDRAKE_GIRL_CHORUS = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mandrake_girl_chorus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MandrakeChorusEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build());

    public static final EntityType<MandrakeGlowBerryEntity> MANDRAKE_GIRL_GLOW_BERRY = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mandrake_girl_glow_berry"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MandrakeGlowBerryEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.85F)).build());

    public static final EntityType<MandrakeGreenEntity> MANDRAKE_GIRL_GREEN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mandrake_girl_green"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MandrakeGreenEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.85F)).build());

    public static final EntityType<MushroomCrimsonEntity> MUSHROOM_GIRL_CRIMSON = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_crimson"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomCrimsonEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1.15F)).build());

    public static final EntityType<MushroomCrimsonRareEntity> MUSHROOM_GIRL_CRIMSON_RARE = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_crimson_rare"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomCrimsonRareEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1.15F)).build());

    public static final EntityType<MushroomInkCapEntity> MUSHROOM_GIRL_INK_CAP = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_ink_cap"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomInkCapEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1.4F)).build());

    public static final EntityType<MushroomWarpedEntity> MUSHROOM_GIRL_WARPED = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_warped"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomWarpedEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomWarpedRareEntity> MUSHROOM_GIRL_WARPED_RARE = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_warped_rare"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomWarpedRareEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomFlyAgaricEntity> MUSHROOM_GIRL_FLY_AGARIC = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_red"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomFlyAgaricEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomAmanitaYellowEntity> MUSHROOM_GIRL_AMANITA_YELLOW = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_yellow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomAmanitaYellowEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomBrownEntity> MUSHROOM_GIRL_BROWN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_brown"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomBrownEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomEnderPuffballEntity> MUSHROOM_GIRL_ENDER_PUFFBALL = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_ender_puffball"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomEnderPuffballEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomInfernalEntity> MUSHROOM_GIRL_INFERNAL = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_infernal"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomInfernalEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomMoltenEntity> MUSHROOM_GIRL_MOLTEN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_molten_fungus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomMoltenEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<MushroomSoulWandererEntity> MUSHROOM_GIRL_SOUL_WANDERER = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_soul_wanderer"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MushroomSoulWandererEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<SpookPeachEntity> SPOOK_GIRL_PEACH = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "spook_girl_peach"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SpookPeachEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1.3F)).build());

    public static final EntityType<SpookTealEntity> SPOOK_GIRL_TEAL = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "spook_girl_teal"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SpookTealEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1.3F)).build());

    public static final EntityType<WispBlueEntity> WISP_GIRL_WISP_BLUE = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "wisp_girl_blue"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WispBlueEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.8F)).build());

    public static final EntityType<WispGreenEntity> WISP_GIRL_WISP_GREEN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "wisp_girl_green"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WispGreenEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.8F)).build());

    public static final EntityType<WispYellowEntity> WISP_GIRL_YELLOW = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "wisp_girl_yellow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WispYellowEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.8F)).build());

    // -- Methods --
    public static void registerEntityAttribute () {
        FabricDefaultAttributeRegistry.register(MANDRAKE_GIRL_BROWN, MandrakeBrownEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MANDRAKE_GIRL_CHORUS, MandrakeBrownEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MANDRAKE_GIRL_GLOW_BERRY, MandrakeBrownEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MANDRAKE_GIRL_GREEN, MandrakeGreenEntity.setAttributes());

        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_AMANITA_YELLOW, MushroomAmanitaYellowEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_BROWN, MushroomBrownEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_CRIMSON, MushroomCrimsonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_CRIMSON_RARE, MushroomCrimsonRareEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_ENDER_PUFFBALL, MushroomEnderPuffballEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_FLY_AGARIC, MushroomFlyAgaricEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_INFERNAL, MushroomInfernalEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_INK_CAP, MushroomInkCapEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_MOLTEN, MushroomMoltenEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_WARPED, MushroomWarpedEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_WARPED_RARE, MushroomWarpedRareEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_SOUL_WANDERER, MushroomSoulWandererEntity.setAttributes());

        FabricDefaultAttributeRegistry.register(SPOOK_GIRL_PEACH, SpookPeachEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(SPOOK_GIRL_TEAL, SpookTealEntity.setAttributes());

        FabricDefaultAttributeRegistry.register(WISP_GIRL_WISP_BLUE, WispBlueEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(WISP_GIRL_WISP_GREEN, WispGreenEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(WISP_GIRL_YELLOW, WispYellowEntity.setAttributes());
    } // registerEntityAttribute ()

    public static void registerEntityRenderer () {
        EntityRendererRegistry.register(MANDRAKE_GIRL_BROWN, MandrakeBrownRenderer::new);
        EntityRendererRegistry.register(MANDRAKE_GIRL_CHORUS, MandrakeChorusRenderer::new);
        EntityRendererRegistry.register(MANDRAKE_GIRL_GLOW_BERRY, MandrakeGlowBerryRenderer::new);
        EntityRendererRegistry.register(MANDRAKE_GIRL_GREEN, MandrakeGreenRenderer::new);

        EntityRendererRegistry.register(MUSHROOM_GIRL_AMANITA_YELLOW, MushroomAmanitaYellowRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_BROWN, MushroomBrownRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_CRIMSON, MushroomCrimsonRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_CRIMSON_RARE, MushroomCrimsonRareRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_ENDER_PUFFBALL, MushroomEnderPuffballRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_INFERNAL, MushroomInfernalRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_INK_CAP, MushroomInkCapRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_MOLTEN, MushroomMoltenRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_FLY_AGARIC, MushroomFlyAgaricRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_WARPED, MushroomWarpedRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_WARPED_RARE, MushroomWarpedRareRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_SOUL_WANDERER, MushroomSoulWandererRenderer::new);

        EntityRendererRegistry.register(SPOOK_GIRL_PEACH, SpookPeachRenderer::new);
        EntityRendererRegistry.register(SPOOK_GIRL_TEAL, SpookTealRenderer::new);

        EntityRendererRegistry.register(WISP_GIRL_WISP_BLUE, WispBlueRenderer::new);
        EntityRendererRegistry.register(WISP_GIRL_WISP_GREEN, WispGreenRenderer::new);
        EntityRendererRegistry.register(WISP_GIRL_YELLOW, WispYellowRenderer::new);

    } // registerEntityRenderer ()

} // Class ModEntities