package net.msymbios.monsters_girls.entity.custom.wisp;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.internal.WispVariant;

public class WispBlueEntity extends WispEntity {

    // -- Constructor --

    public WispBlueEntity(EntityType<? extends WispBlueEntity> entityType, World world) {
        super(entityType, world);
        nativeEntity = WispVariant.BLUE;
    } // Constructor WispBlueEntity ()

    // -- Inherited Methods --

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new TemptGoal(this, WispVariant.BLUE.getMoveSpeed(), WispVariant.BLUE.getTemptingItems(), false));
        this.goalSelector.add(4, new FollowOwnerGoal(this, WispVariant.BLUE.getMoveSpeed(), 2.0F, 12.0F, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, WispVariant.BLUE.getMoveSpeed()));
    } // initGoals ()

} // Class WispBlueEntity