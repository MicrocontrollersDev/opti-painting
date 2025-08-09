package dev.isxander.optipainting.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.decoration.PaintingVariant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PaintingVariant.class)
public class PaintingVariantMixin {
    @ModifyExpressionValue(method = "method_59948", at = @At(value = "CONSTANT", args = "intValue=16"))
    private static int modifyMaxPaintingSize(int oldMaxSize) {
        return Integer.MAX_VALUE;
    }
}

