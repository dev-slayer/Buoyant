package net.slayer.buoyant.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.buoyant.util.RegisterTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.slayer.buoyant.Config;

@Mixin(ItemEntity.class)
public abstract class ItemEntityWater extends Entity {
    @Shadow public abstract ItemStack getStack();

    public ItemEntityWater(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "applyWaterBuoyancy()V")
    public void buoyant$Floatabilities(CallbackInfo ci) {
        float DEFINED_VALUE = 0;
        if(getStack().isIn(RegisterTags.Items.BUOYANT)) {
            DEFINED_VALUE = Config.BUOYANT_VALUE;
        } else if (getStack().isIn(RegisterTags.Items.SUPER_BUOYANT)) {
            DEFINED_VALUE = Config.SUPER_BUOYANT_VALUE;
        } else if (getStack().isIn(RegisterTags.Items.HEAVY)) {
            DEFINED_VALUE = Config.HEAVY_VALUE;
        } else if (getStack().isIn(RegisterTags.Items.SUPER_HEAVY)) {
            DEFINED_VALUE = Config.SUPER_HEAVY_VALUE;
        } else {
            DEFINED_VALUE = Config.NEUTRAL_VALUE;
        }
        this.setVelocity(this.getVelocity().add(0.0, DEFINED_VALUE, 0.0));
    }
}