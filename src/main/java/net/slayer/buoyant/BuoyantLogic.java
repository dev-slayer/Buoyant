package net.slayer.buoyant;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.slayer.buoyant.util.ModTags;

import java.util.List;

public class BuoyantLogic {

    public static float applyBuoyancy(ItemStack stack) {
        if (stack.isIn(ModTags.BUOYANT)) return Config.BUOYANT_VALUE;
        else if (stack.isIn(ModTags.SUPER_BUOYANT)) return Config.SUPER_BUOYANT_VALUE;
        else if (stack.isIn(ModTags.DENSE)) return Config.DENSE_VALUE;
        else if (stack.isIn(ModTags.SUPER_DENSE)) return Config.SUPER_DENSE_VALUE;
        else return Config.NEUTRAL_VALUE;
    }

    public static void applyTooltips(ItemStack stack, List<Text> tooltip) {
        if (Config.TOOLTIP == Config.TOOLTIP_OPTIONS.NO || (Config.TOOLTIP == Config.TOOLTIP_OPTIONS.SHIFT && !Screen.hasShiftDown())) return;

        var string = "null";

        if(stack.isIn(ModTags.BUOYANT)) string = "buoyant.tooltips.buoyant";
        else if(stack.isIn(ModTags.SUPER_BUOYANT)) string = "buoyant.tooltips.super_buoyant";
        else if(stack.isIn(ModTags.DENSE)) string = "buoyant.tooltips.dense";
        else if(stack.isIn(ModTags.SUPER_DENSE)) string = "buoyant.tooltips.super_dense";
        else string = "buoyant.tooltips.neutral";

        tooltipHelper(tooltip, string);
    }

    public static void tooltipHelper(List<Text> tooltip, String string) {
        tooltip.add(Text.translatable(string).formatted(Formatting.valueOf(String.valueOf(Config.TOOLTIP_COLOR))));
    }
}
