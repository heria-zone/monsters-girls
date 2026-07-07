package net.msymbios.monsters_girls.entity.custom.spook;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.internal.SpookVariant;

public class SpookPeachEntity extends SpookEntity {

    // -- Constructor --

    public SpookPeachEntity(EntityType<? extends SpookPeachEntity> entityType, World world) {
        super(entityType, world);
        nativeEntity = SpookVariant.PEACH;
    } // Constructor SpookPeachEntity ()

    // -- Inherited Methods --

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new TemptGoal(this, SpookVariant.PEACH.getMoveSpeed(), SpookVariant.PEACH.getTemptingItems(), false));
        this.goalSelector.add(4, new FollowOwnerGoal(this, SpookVariant.PEACH.getMoveSpeed(), 2.0F, 12.0F, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, SpookVariant.PEACH.getMoveSpeed()));
    } // initGoals ()

} // Class SpookPeachEntity