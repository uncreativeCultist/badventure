package dev.uncreative.badventure.mixin.client.fix.window;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.render.shader.ShaderProviderInternal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import dev.uncreative.badventure.util.ShaderVersionUtil;

@Mixin(ShaderProviderInternal.class)
public class ShaderVersionDowngradeInternal {

	@ModifyReturnValue(method = "getShaderSource", at = @At("RETURN"))
	private String spike$downgradeGlsl(String source) {
		return ShaderVersionUtil.downgrade(source);
	}
}
