package net.msymbios.monsters_girls.entity.custom.wisp;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.internal.WispVariant;

public class WispGreenEntity extends WispEntity {

    // -- Constructor --

    public WispGreenEntity(EntityType<? extends WispGreenEntity> entityType, World world) {
        super(entityType, world);
        this.nativeEntity = WispVariant.GREEN;
    } // Constructor WispGreenEntity ()

    // -- Inherited Methods --

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new TemptGoal(this, WispVariant.GREEN.getMoveSpeed(), WispVariant.GREEN.getTemptingItems(), false));
        this.goalSelector.add(4, new FollowOwnerGoal(this, WispVariant.GREEN.getMoveSpeed(), 2.0F, 12.0F, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, WispVariant.GREEN.getMoveSpeed()));
    } // initGoals ()

} // Class WispGreenEntity