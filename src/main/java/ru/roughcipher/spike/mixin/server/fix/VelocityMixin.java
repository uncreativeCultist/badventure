// https://github.com/Gabriel-Hiss/Im-Fast/blob/master/src/main/java/com/biel/mod/mixin/VelocityMixin.java
package ru.roughcipher.spike.mixin.server.fix;

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
		return Double.MAX_VALUE;
	}

	// Moved Wrongly
	@ModifyConstant(
		method = "handleMovePlayer",
		constant = @Constant(doubleValue = 0.0625D)
	)
	private double imfast_MovedWrong(double speed) {
		return Double.MAX_VALUE;
	}
}
