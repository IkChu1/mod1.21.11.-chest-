package com.example.chestfps.mixin;

import com.example.chestfps.ChestFPSMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.BlockRenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBlock.class)
public class MixinChestBlock {

    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    private void chestfps$changeRenderType(BlockState state, CallbackInfoReturnable<BlockRenderType> cir) {
        if (ChestFPSMod.fastChestsEnabled) {
            // Заставляем игру рендерить сундук как обычный блок (встраивать в меш чанка)
            cir.setReturnValue(BlockRenderType.MODEL);
        }
    }
}
