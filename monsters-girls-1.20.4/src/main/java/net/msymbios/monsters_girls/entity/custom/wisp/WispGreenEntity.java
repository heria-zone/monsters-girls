package net.msymbios.monsters_girls.entity.custom.wisp;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.internal.WispVariant;

public class WispGreenEntity extends WispEntity {

    // -- Constructor --

    public WispGreenEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.nativeEntity = WispVariant.GREEN;
    } // Constructor WispGreenEntity ()

} // Class WispGreenEntity