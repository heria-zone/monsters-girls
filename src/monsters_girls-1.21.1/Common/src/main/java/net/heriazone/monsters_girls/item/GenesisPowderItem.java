package net.heriazone.monsters_girls.item;

import net.heriazone.monsters_girls.entity.feature.GenesisFeature;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

/**
 * <p>Consumes an item block to spawn its corresponding entity.<p>
 * <p>
 * <b>Spawn contract:</b> Target block must be registered in {@link GenesisFeature}'s
 * lookup. Item and block are only consumed on a valid trigger — no silent losses.
 * Variant selection is fully delegated to the entity's {@code finalizeSpawn()}.
 */
public class GenesisPowderItem extends EnchantedItem {

    // -- Constructor --

    public GenesisPowderItem(Properties properties) {
        super(properties);
    } // Constructor: GenesisPowderItem ()

    // -- Interaction --

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!(context.getLevel() instanceof ServerLevel serverLevel)) return InteractionResult.PASS;

        BlockState state = serverLevel.getBlockState(context.getClickedPos());
        EntityType<?> type = GenesisFeature.resolve(state.getBlock(), serverLevel, context.getClickedPos());

        if (type == null) return InteractionResult.PASS;

        Entity entity = type.create(serverLevel);
        if (!(entity instanceof Mob mob)) return InteractionResult.PASS;

        serverLevel.removeBlock(context.getClickedPos(), false);
        context.getItemInHand().shrink(1);

        mob.moveTo(
                context.getClickedPos().getX() + 0.5,
                context.getClickedPos().getY(),
                context.getClickedPos().getZ() + 0.5,
                0f, 0f
        );
        mob.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(mob.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
        serverLevel.addFreshEntity(mob);

        return InteractionResult.SUCCESS;
    } // useOn ()

} // Class: GenesisPowderItem