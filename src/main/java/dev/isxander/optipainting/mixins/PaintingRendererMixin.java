package dev.isxander.optipainting.mixins;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PaintingRenderer.class)
public class PaintingRendererMixin {
    @Unique
    private static final String optipainting$vertexTarget = "Lnet/minecraft/client/renderer/entity/PaintingRenderer;vertex(Lcom/mojang/blaze3d/vertex/PoseStack$Pose;Lcom/mojang/blaze3d/vertex/VertexConsumer;FFFFFIIII)V";

    /**
     * The u and v we are targeting are from the nested for loops.
     */
    @WrapWithCondition(method = "renderPainting", at = {
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 8),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 9),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 10),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 11)
    })
    private boolean checkTop(PaintingRenderer instance, PoseStack.Pose pose, VertexConsumer consumer, float x, float y, float u1, float v1, float z, int normalX, int normalY, int normalZ, int packedLight,@Local(argsOnly = true, ordinal = 1) int height, @Local(ordinal = 3) int v) {
        return v == height - 1;
    }

    @WrapWithCondition(method = "renderPainting", at = {
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 12),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 13),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 14),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 15)
    })
    private boolean checkBottom(PaintingRenderer instance, PoseStack.Pose pose, VertexConsumer consumer, float x, float y, float u1, float v1, float z, int normalX, int normalY, int normalZ, int packedLight, @Local(ordinal = 3) int v) {
        return v == 0;
    }
    
    @WrapWithCondition(method = "renderPainting", at = {
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 16),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 17),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 18),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 19)
    })
    private boolean checkRight(PaintingRenderer instance, PoseStack.Pose pose, VertexConsumer consumer, float x, float y, float u1, float v1, float z, int normalX, int normalY, int normalZ, int packedLight, @Local(argsOnly = true, ordinal = 0) int width, @Local(ordinal = 2) int u) {
        return u == width - 1;
    }

    @WrapWithCondition(method = "renderPainting", at = {
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 20),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 21),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 22),
            @At(value = "INVOKE", target = optipainting$vertexTarget, ordinal = 23)
    })
    private boolean checkLeft(PaintingRenderer instance, PoseStack.Pose pose, VertexConsumer consumer, float x, float y, float u1, float v1, float z, int normalX, int normalY, int normalZ, int packedLight, @Local(ordinal = 2) int u) {
        return u == 0;
    }
}
