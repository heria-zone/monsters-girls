package net.msymbios.monsters_girls.entity.custom.spook;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FlyGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.custom.SpookEntity;
import net.msymbios.monsters_girls.entity.internal.SpookVariant;

public class SpookTealEntity extends SpookEntity {

    // -- Constructor --

    public SpookTealEntity(EntityType<? extends SpookTealEntity> entityType, World world) {
        super(entityType, world);
        nativeEntity = SpookVariant.TEAL;
    } // Constructor SpookTealEntity ()

    // -- Inherited Methods --

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new TemptGoal(this, SpookVariant.TEAL.getMoveSpeed(), SpookVariant.TEAL.getTemptingItems(), false));
        this.goalSelector.add(4, new FollowOwnerGoal(this, SpookVariant.TEAL.getMoveSpeed(), 2.0F, 12.0F, false));
        this.goalSelector.add(5, new FlyGoal(this, SpookVariant.TEAL.getMoveSpeed()));
    } // initGoals ()

} // Class SpookTealEntity