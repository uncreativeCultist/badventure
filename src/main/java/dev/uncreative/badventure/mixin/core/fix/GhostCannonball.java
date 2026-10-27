package dev.uncreative.badventure.mixin.core.fix;

import net.minecraft.core.entity.projectile.ProjectileCannonball;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProjectileCannonball.class)
public abstract class GhostCannonball {

	@Unique
	private int spite$age = 0;

	@Unique
	private static final int spite$ALIVE_TICKS = 200;

	@Unique
	private static final double spite$MAX_SPEED = 3.0;

	@Inject(method = "afterTick", at = @At("HEAD"), cancellable = true)
	private void spite$removeOldOrFastCannonballs(CallbackInfo ci) {
		ProjectileCannonball cannonball =
			(ProjectileCannonball) (Object) this;

		spite$age++;

		if (spite$age >= spite$ALIVE_TICKS) {
			cannonball.remove();
			ci.cancel();
			return;
		}

		//oh my fucking god
		double speedSquared =
			cannonball.xd * cannonball.xd
				+ cannonball.yd * cannonball.yd
				+ cannonball.zd * cannonball.zd;

		if (speedSquared > spite$MAX_SPEED * spite$MAX_SPEED) {
			cannonball.remove();
			ci.cancel();
		}
	}
}
