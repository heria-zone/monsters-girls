package net.heriazone.monsters_girls.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

/**
 * <p>Item that renders a configurable list of translation-key tooltips.<p>
 * <p>
 * <b>Design:</b> Tooltip lines are injected at construction time, keeping
 * display concerns out of subclasses and avoiding per-type overrides for
 * items that differ only in their hover text.
 */
public class TooltipItem extends Item {

    // -- Fields --

    private final List<String> tooltips;

    // -- Constructor --

    public TooltipItem(Properties properties, List<String> tooltips) {
        super(properties);
        this.tooltips = tooltips;
    } // Constructor: TooltipItem ()

    // -- Methods --

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
        for (String key : tooltips) tooltip.add(Component.translatable(key));
    } // appendHoverText ()

} // Class: TooltipItem