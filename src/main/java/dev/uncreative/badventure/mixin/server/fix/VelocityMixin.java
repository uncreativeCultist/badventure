// https://github.com/Gabriel-Hiss/Im-Fast/blob/master/src/main/java/com/biel/mod/mixin/VelocityMixin.java
package dev.uncreative.badventure.mixin.server.fix;

import dev.uncreative.badventure.config.badventureconfig;
import net.minecraft.server.net.handler.PacketHandlerServer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PacketHandlerServer.class, priority = 2000)
public abstract class VelocityMixin {

	// Moved Quickly
	@ModifyConstant(
		method = "handleMovePlayer",
		constant = @Constant(doubleValue = 100.0D)
	)
	private double imfast_PlayerMaxSpeed(double speed) {
		if (badventureconfig.disableMovementChecks) {
			return Double.MAX_VALUE;
		}
		else {
			return speed;
		}
	}

	// Moved Wrongly
	@ModifyConstant(
		method = "handleMovePlayer",
		constant = @Constant(doubleValue = 0.0625D)
	)
	private double imfast_MovedWrong(double speed) {
		if (badventureconfig.disableMovementChecks) {
			return Double.MAX_VALUE;
		}
		else {
			return speed;
		}
	}
}
