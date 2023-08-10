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
    public static final EntityType<MandrakeBrownEntity> MANDRAKE_GIRL_BROWN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mandrake_girl_brown"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MandrakeBrownEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build());

    public static final EntityType<MandrakeGreenEntity> MANDRAKE_GIRL_GREEN = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mandrake_girl_green"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MandrakeGreenEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build());

    public static final EntityType<InkCapEntity> MUSHROOM_GIRL_INK_CAP = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_ink_cap"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, InkCapEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1.4F)).build());

    public static final EntityType<WarpedEntity> MUSHROOM_GIRL_WARPED = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_warped"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WarpedEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    public static final EntityType<WarpedRareEntity> MUSHROOM_GIRL_WARPED_RARE = Registry.register(Registry.ENTITY_TYPE, new Identifier(MonstersGirlsMod.MODID, "mushroom_girl_warped_rare"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WarpedRareEntity::new).dimensions(EntityDimensions.fixed(0.4F, 1F)).build());

    // -- Methods --
    public static void registerEntityAttribute () {
        FabricDefaultAttributeRegistry.register(MANDRAKE_GIRL_BROWN, MandrakeBrownEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MANDRAKE_GIRL_GREEN, MandrakeGreenEntity.setAttributes());

        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_INK_CAP, InkCapEntity.setAttributes());

        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_WARPED, WarpedEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MUSHROOM_GIRL_WARPED_RARE, WarpedRareEntity.setAttributes());
    } // registerEntityAttribute ()

    public static void registerEntityRenderer () {
        EntityRendererRegistry.register(MANDRAKE_GIRL_BROWN, MandrakeBrownRenderer::new);
        EntityRendererRegistry.register(MANDRAKE_GIRL_GREEN, MandrakeGreenRenderer::new);

        EntityRendererRegistry.register(MUSHROOM_GIRL_INK_CAP, InkCapRenderer::new);

        EntityRendererRegistry.register(MUSHROOM_GIRL_WARPED, WarpedRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_GIRL_WARPED_RARE, WarpedRareRenderer::new);
    } // registerEntityRenderer ()

} // Class ModEntities