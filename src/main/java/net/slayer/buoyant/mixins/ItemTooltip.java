package net.slayer.buoyant.mixins;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.slayer.buoyant.util.RegisterTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import net.slayer.buoyant.Config;

@Mixin(Item.class)
public abstract class ItemTooltip {
    @Inject(at = @At("TAIL"), method = "appendTooltip")
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if (Config.TOOLTIP == Config.TOOLTIP_OPTIONS.YES || (Config.TOOLTIP == Config.TOOLTIP_OPTIONS.SHIFT && Screen.hasShiftDown())) {
            if(stack.isIn(RegisterTags.Items.BUOYANT)) {
                tooltip.add(Text.translatable("buoyant.tooltips.buoyant").formatted(Formatting.valueOf(String.valueOf(Config.TOOLTIP_COLOR))));
            } else if (stack.isIn(RegisterTags.Items.SUPER_BUOYANT)) {
                tooltip.add(Text.translatable("buoyant.tooltips.super_buoyant").formatted(Formatting.valueOf(String.valueOf(Config.TOOLTIP_COLOR))));
            } else if (stack.isIn(RegisterTags.Items.HEAVY)) {
                tooltip.add(Text.translatable("buoyant.tooltips.high").formatted(Formatting.valueOf(String.valueOf(Config.TOOLTIP_COLOR))));
            } else if (stack.isIn(RegisterTags.Items.SUPER_HEAVY)) {
                tooltip.add(Text.translatable("buoyant.tooltips.super_high").formatted(Formatting.valueOf(String.valueOf(Config.TOOLTIP_COLOR))));
            } else {
                tooltip.add(Text.translatable("buoyant.tooltips.neutral").formatted(Formatting.valueOf(String.valueOf(Config.TOOLTIP_COLOR))));
            }
        }
    }
}
