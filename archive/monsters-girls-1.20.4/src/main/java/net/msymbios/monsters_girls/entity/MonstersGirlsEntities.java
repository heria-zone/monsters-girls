package net.msymbios.monsters_girls.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.common.entity.InternalEntities;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.entity.client.renderer.*;
import net.msymbios.monsters_girls.entity.custom.spook.*;
import net.msymbios.monsters_girls.entity.custom.wisp.WispBlueEntity;
import net.msymbios.monsters_girls.entity.custom.wisp.WispGreenEntity;
import net.msymbios.monsters_girls.entity.custom.wisp.WispYellowEntity;
import net.msymbios.monsters_girls.entity.internal.SpookVariant;
import net.msymbios.monsters_girls.entity.internal.WispVariant;

public class MonstersGirlsEntities extends InternalEntities {

    // -- Variables --

    public static final EntityType<SpookPeachEntity> SPOOK_PEACH = register(MonstersGirlsID.getId(MonstersGirlsID.SPOOK_PEACH), SpawnGroup.CREATURE, 0.4F, 1.3F, SpookPeachEntity::new);
    public static final EntityType<SpookTealEntity> SPOOK_TEAL = register(MonstersGirlsID.getId(MonstersGirlsID.SPOOK_TEAL), SpawnGroup.CREATURE, 0.4F, 1.3F, SpookTealEntity::new);

    public static final EntityType<WispBlueEntity> WISP_BLUE = register(MonstersGirlsID.getId(MonstersGirlsID.WISP_BLUE), SpawnGroup.CREATURE, 0.4F, 0.8F, WispBlueEntity::new);
    public static final EntityType<WispGreenEntity> WISP_GREEN = register(MonstersGirlsID.getId(MonstersGirlsID.WISP_GREEN), SpawnGroup.CREATURE, 0.4F, 0.8F, WispGreenEntity::new);
    public static final EntityType<WispYellowEntity> WISP_YELLOW = register(MonstersGirlsID.getId(MonstersGirlsID.WISP_YELLOW), SpawnGroup.CREATURE, 0.4F, 0.8F, WispYellowEntity::new);

    // -- Methods --

    public static void register() {
        MonstersGirls.LOGGER.info("Registering Entities for: " + MonstersGirls.MODID);

        registerAttribute();
    } // register ()

    public static void registerAttribute(){
        FabricDefaultAttributeRegistry.register(SPOOK_PEACH, SpookPeachEntity.createAttributes(SpookVariant.PEACH));
        FabricDefaultAttributeRegistry.register(SPOOK_TEAL, SpookTealEntity.createAttributes(SpookVariant.TEAL));

        FabricDefaultAttributeRegistry.register(WISP_BLUE, WispBlueEntity.createAttributes(WispVariant.BLUE));
        FabricDefaultAttributeRegistry.register(WISP_GREEN, WispGreenEntity.createAttributes(WispVariant.GREEN));
        FabricDefaultAttributeRegistry.register(WISP_YELLOW, WispYellowEntity.createAttributes(WispVariant.YELLOW));
    } // registerAttribute ()

    public static void registerRender(){
        EntityRendererRegistry.register(SPOOK_PEACH, SpookRenderer::new);
        EntityRendererRegistry.register(SPOOK_TEAL, SpookRenderer::new);

        EntityRendererRegistry.register(WISP_BLUE, WispRenderer::new);
        EntityRendererRegistry.register(WISP_GREEN, WispRenderer::new);
        EntityRendererRegistry.register(WISP_YELLOW, WispRenderer::new);
    } // registerRender ()

} // Class MonstersGirlsEntities