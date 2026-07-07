package net.heriazone.monsters_girls.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * <p>Bowl-based stew that applies a custom {@link MobEffect} on consumption and returns an empty bowl.<p>
 * <p>
 * <b>Architecture:</b> Mirrors vanilla {@code MushroomStewItem} — consumes one item from the stack,
 * applies a fixed effect to the consumer, and returns an empty {@code Items.BOWL} to the inventory.
 * Effect identity and duration are supplied at construction, keeping the class stateless and
 * reusable across all mushroom gal stew variants.
 * <p>
 * <b>Bowl return:</b> On consumption the bowl is returned via
 * {@link LivingEntity#eat(Level, ItemStack)} shrinking the stew stack by 1, then the bowl
 * is directly added to the player's inventory (or dropped if full). This matches the
 * vanilla {@code SoupItem} contract precisely.
 * <p>
 * <b>Usage (from MonstersItems):</b>
 * <pre>
 *   new MonstersStewItem(MonstersEffects.BLAZING, 600, new Item.Properties()
 *       .food(MonstersFood.STEW_MOLTEN).craftRemainder(Items.BOWL))
 * </pre>
 */
public class MonstersStewItem extends TooltipItem {

    // -- Fields --

    /** The mob effect applied when this stew is fully consumed. */
    private final Holder<MobEffect> effect;

    /** Duration of the applied effect in ticks. */
    private final int durationTicks;

    // -- Constructor --

    /**
     * Creates a stew item that applies the given effect on consumption.
     *
     * @param effect        the mob effect holder to apply
     * @param durationTicks how long the effect lasts (ticks)
     * @param properties    item properties (should include {@code .food(...)} and {@code .craftRemainder(Items.BOWL)})
     */
    public MonstersStewItem(Holder<MobEffect> effect, int durationTicks, Properties properties, List<String> tooltips) {
        super(properties, tooltips);
        this.effect = effect;
        this.durationTicks = durationTicks;
    } // Constructor: MonstersStewItem ()

    // -- Item Consumption --

    /**
     * Applies the configured mob effect to the consumer and returns an empty bowl.
     * <p>
     * <b>Effect application:</b> Always amplifier 0 — the design intent is a flat
     * duration buff, not a stackable power level. Amplifier scaling is reserved
     * for future potion integration.
     * <p>
     * <b>Bowl return:</b> Delegated to {@code craftRemainder} on the {@link Item.Properties}
     * via the standard Minecraft contract; this method applies the effect only.
     *
     * @param stack  the stew item stack being consumed
     * @param level  the current level
     * @param entity the consuming entity
     * @return the remainder stack (handled by super — typically the bowl from craftRemainder)
     */
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack remainder = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide()) {
            entity.addEffect(new MobEffectInstance(effect, durationTicks, 0));
        }

        return remainder;
    } // finishUsingItem ()

} // Class: MonstersStewItem
