package net.heriazone.monsters_girls.entity.projectile;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

/**
 * Poison spit projectile thrown by Mandrake Chorus girl.
 * <p>
 * <b>Visual:</b> Registered with {@code LlamaSpitRenderer} — renders as the vanilla
 * white spit orb, matching the "spit" feel without a custom texture. Falls back to
 * {@code ThrownItemRenderer} with a slimeball sprite if {@code LlamaSpitRenderer}
 * changes signature in future Minecraft versions.
 * <p>
 * <b>Effects on hit:</b>
 * <ul>
 *   <li>{@code POISON} level 1 / 140 ticks (7 s) — sustained damage, ~10 HP total</li>
 *   <li>{@code CONFUSION} (Nausea) level 0 / 100 ticks (5 s) — disorienting, fits Chorus's End character</li>
 * </ul>
 * <p>
 * <b>Friendly fire prevention:</b> If the thrower and the target share the same owner
 * UUID, the hit is suppressed entirely before any effect is applied. This is the
 * projectile-side layer of the two-layer friendly fire prevention system — the
 * targeting-side layer lives in {@code NativeEntity.wantsToAttack()}.
 * <p>
 * <b>Loader isolation:</b> The thrower constructor accepts an {@code EntityType} parameter
 * rather than referencing {@code MonstersEntities.MANDRAKE_CHORUS_SPIT} directly, keeping
 * this Common class free of any loader-specific dependency.
 */
public class MandrakeSpitProjectile extends ThrowableItemProjectile {

    // -- Effect constants --

    /** {@code POISON} duration in ticks (7 s). Level 1 = ~1.5 HP/s ≈ 10 HP total. */
    private static final int POISON_DURATION_TICKS = 140;

    /** {@code POISON} amplifier — level 1 (0-indexed). */
    private static final int POISON_AMPLIFIER = 1;

    /** {@code CONFUSION} (Nausea) duration in ticks (5 s). */
    private static final int NAUSEA_DURATION_TICKS = 100;

    /** {@code CONFUSION} amplifier — level 0. */
    private static final int NAUSEA_AMPLIFIER = 0;

    // -- Constructors --

    /**
     * Deserialization / registry constructor — used by Minecraft when reading the
     * entity from a packet or NBT.
     */
    public MandrakeSpitProjectile(EntityType<? extends MandrakeSpitProjectile> type, Level level) {
        super(type, level);
    } // Constructor ()

    /**
     * Thrower constructor — called by {@code WildTamableEntity.performRangedAttack()}.
     * The caller passes the registered {@code EntityType} so this Common class never
     * references the loader-specific {@code MonstersEntities} class.
     *
     * @param type    registered {@code EntityType} for this projectile
     * @param level   world instance
     * @param thrower entity throwing this projectile
     */
    public MandrakeSpitProjectile(EntityType<? extends MandrakeSpitProjectile> type,
                                  Level level, LivingEntity thrower) {
        super(type, thrower, level);
    } // Constructor (type, thrower) ()

    // -- Projectile default item --

    @Override
    protected Item getDefaultItem() {
        // Slimeball as the item sprite fallback — only visible if LlamaSpitRenderer is
        // unavailable and the renderer falls back to ThrownItemRenderer.
        return Items.SLIME_BALL;
    } // getDefaultItem ()

    // -- Impact --

    /**
     * Applies Poison + Nausea on entity hit.
     * <p>
     * <b>Friendly fire gate:</b> Hit is suppressed when the thrower and target share
     * the same owner UUID — same-owner peers are never damaged or debuffed by this
     * projectile regardless of how the AI got the target.
     */
    @Override
    protected void onHitEntity(EntityHitResult result) {
        // Friendly fire prevention — projectile side
        if (getOwner() instanceof TamableAnimal thrower
                && result.getEntity() instanceof TamableAnimal peer
                && thrower.getOwnerUUID() != null
                && thrower.getOwnerUUID().equals(peer.getOwnerUUID())) {
            // Same owner — discard silently, no vanilla knockback either
            return;
        }

        super.onHitEntity(result); // vanilla: zero damage

        if (!(result.getEntity() instanceof LivingEntity target)) return;

        target.addEffect(new MobEffectInstance(MobEffects.POISON,    POISON_DURATION_TICKS, POISON_AMPLIFIER));
        target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, NAUSEA_DURATION_TICKS,  NAUSEA_AMPLIFIER));
    } // onHitEntity ()

} // Class: MandrakeSpitProjectile
