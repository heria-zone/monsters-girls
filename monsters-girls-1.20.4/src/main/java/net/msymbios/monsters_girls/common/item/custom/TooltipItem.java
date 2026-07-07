package net.msymbios.monsters_girls.common.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipItem extends Item {

    // -- Variables --

    private final List<String> m_tooltips;

    // -- Constructor --

    public TooltipItem(List<String> tooltips, Settings settings) {
        super(settings);
        this.m_tooltips = tooltips;
    } // Constructor TooltipItem ()

    // -- Inherited Methods --

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        for (String item : m_tooltips) tooltip.add(Text.translatable(item));
    } // appendTooltip ()

} // Class TooltipItem