package net.heriazone.monsters_girls.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

/**
 * Snowball projectile thrown by the Mushroom Snowball girl.
 * <p>
 * <b>Architecture:</b> Extends vanilla {@link Snowball} so it inherits all the
 * standard throw physics, rendering, and collision handling. The only extension
 * is {@link #onHitEntity} — when the snowball strikes a living entity it applies
 * the same freeze + slow effects declared in {@code MushroomFamily.SNOWBALL}'s
 * {@code EmanationFeature}, keeping the two systems in sync without coupling
 * the projectile to the feature system.
 * <p>
 * <b>Effect values mirror EmanationFeature:</b>
 * <ul>
 *   <li>{@code MOVEMENT_SLOWDOWN} level 1 for 100 ticks (5 s)</li>
 *   <li>Freeze ticks: 70 (3.5 s)</li>
 * </ul>
 * <p>
 * <b>Why not re-use EmanationFeature here:</b> EmanationFeature fires from
 * {@code MonsterEntity.doHurtTarget()} — the attacker's hit pipeline. A thrown
 * snowball impact does not call {@code doHurtTarget()} on the thrower, so the
 * feature cannot fire automatically. Duplicating the constants here is a deliberate
 * trade-off: the projectile is self-contained and the values are documented above
 * for easy sync when EmanationFeature values change.
 * <p>
 * <b>Loader isolation:</b> The thrower constructor accepts an {@code EntityType}
 * parameter rather than referencing {@code MonstersEntities.MUSHROOM_SNOWBALL_PROJECTILE}
 * directly. This keeps the Common class free of any loader-specific dependency —
 * the caller (loader-side {@code MushroomEntity}) passes in the registered type.
 */
public class MushroomSnowball extends Snowball {

    // -- Effect constants (mirror MushroomFamily.SNOWBALL EmanationFeature) --

    /** Ticks of {@code MOVEMENT_SLOWDOWN} applied on hit (level 1). */
    private static final int SLOW_DURATION_TICKS = 100;

    /** Amplifier for {@code MOVEMENT_SLOWDOWN} (0 = level I). */
    private static final int SLOW_AMPLIFIER = 1;

    /** Freeze ticks applied to the hit entity. */
    private static final int FREEZE_TICKS = 70;

    // -- Constructors --

    /**
     * Deserialization / registry constructor — used by Minecraft when reading the
     * entity from a packet or NBT. The type is provided by the registry system.
     *
     * @param type  registered entity type
     * @param level world instance
     */
    public MushroomSnowball(EntityType<? extends MushroomSnowball> type, Level level) {
        super(type, level);
    } // Constructor ()

    /**
     * Thrower constructor — called by {@code MushroomEntity.performRangedAttack()}.
     * <p>
     * The caller passes the registered {@code EntityType} so this Common class never
     * needs to reference the loader-specific {@code MonstersEntities} registry class.
     *
     * @param type    the registered {@code EntityType} for this projectile,
     *                supplied by the loader-side caller
     * @param level   world instance
     * @param thrower the entity throwing this snowball
     */
    public MushroomSnowball(EntityType<? extends MushroomSnowball> type,
                            Level level, LivingEntity thrower) {
        super(type, level);
        setOwner(thrower);
        setPos(thrower.getX(), thrower.getEyeY() - 0.1, thrower.getZ());
    } // Constructor (type, thrower) ()

    // -- Projectile default item --

    @Override
    protected Item getDefaultItem() {
        return Items.SNOWBALL;
    } // getDefaultItem ()

    // -- Impact --

    /**
     * Applies freeze and slow on entity hit, then delegates to vanilla for knockback.
     * <p>
     * <b>Melee fallback:</b> The thrower's {@code EmanationFeature} still fires for
     * melee hits via {@code doHurtTarget()} — this path only handles projectile hits.
     */
    @Override
    protected void onHitEntity(EntityHitResult result) {
        // Friendly fire prevention — projectile side.
        // If thrower and target share the same owner UUID, suppress the hit entirely.
        if (getOwner() instanceof TamableAnimal thrower
                && result.getEntity() instanceof TamableAnimal peer
                && thrower.getOwnerUUID() != null
                && thrower.getOwnerUUID().equals(peer.getOwnerUUID())) {
            return; // same-owner peer — no knockback, no effects
        }

        super.onHitEntity(result); // vanilla: deals 0 damage, applies knockback

        if (!(result.getEntity() instanceof LivingEntity target)) return;

        // Apply slow
        target.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN,
                SLOW_DURATION_TICKS,
                SLOW_AMPLIFIER));

        // Apply freeze — additive with existing freeze ticks, capped at entity max
        int newFreeze = Math.min(
                target.getTicksFrozen() + FREEZE_TICKS,
                target.getTicksRequiredToFreeze());
        target.setTicksFrozen(newFreeze);
    } // onHitEntity ()

} // Class: MushroomSnowball