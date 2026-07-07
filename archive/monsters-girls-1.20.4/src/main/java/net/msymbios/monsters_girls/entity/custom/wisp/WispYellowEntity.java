package net.msymbios.monsters_girls.entity.custom.wisp;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.internal.WispVariant;

public class WispYellowEntity extends WispEntity {

    // -- Constructor --

    public WispYellowEntity(EntityType<? extends WispYellowEntity> entityType, World world) {
        super(entityType, world);
        this.nativeEntity = WispVariant.YELLOW;
    } // Constructor WispYellowEntity ()

    // -- Inherited Methods --

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new TemptGoal(this, WispVariant.YELLOW.getMoveSpeed(), WispVariant.YELLOW.getTemptingItems(), false));
        this.goalSelector.add(4, new FollowOwnerGoal(this, WispVariant.YELLOW.getMoveSpeed(), 2.0F, 12.0F, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, WispVariant.GREEN.getMoveSpeed()));
    } // initGoals ()

} // Class WispYellowEntity