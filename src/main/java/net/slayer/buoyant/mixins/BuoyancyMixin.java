package net.slayer.buoyant.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.buoyant.BuoyantLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class BuoyancyMixin extends Entity {
    @Shadow public abstract ItemStack getStack();

    public BuoyancyMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "applyWaterBuoyancy()V")
    public void applyBuoyancy(CallbackInfo ci) {
        this.setVelocity(this.getVelocity().add(0.0, BuoyantLogic.applyBuoyancy(getStack()), 0.0));
    }
}