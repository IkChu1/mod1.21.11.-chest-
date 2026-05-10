package com.example.chestfps.mixin;

import com.example.chestfps.ChestFPSMod;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChestBlockEntityRenderer.class)
public class MixinChestBlockEntityRenderer {

    @Inject(method = "render*", at = @At("HEAD"), cancellable = true)
    private void chestfps$cancelDynamicRender(BlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {
        if (ChestFPSMod.fastChestsEnabled) {
            // Полностью отменяем отрисовку через EntityRenderer.
            // Примечание: Для более сложной логики (анимация при открытии) 
            // здесь можно проверять, открыт ли сундук (через lidAnimator),
            // и разрешать рендер только тогда. В режиме "Fast" мы глушим всё.
            ci.cancel();
        }
    }
}
