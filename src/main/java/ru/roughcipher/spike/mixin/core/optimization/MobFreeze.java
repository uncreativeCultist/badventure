package ru.roughcipher.spike.mixin.core.optimization;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public abstract class MobFreeze {
    private static final double SLEEPDIST = 4096.0; //64x64 blocks (which seems to be default entity view distance @ 10 chunks)

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void freezeDistantMobs(CallbackInfo ci) {
        Mob mob = (Mob) (Object) this;

        World world = mob.world;
        if (world == null || world.isClientSide) {
            return;
        }

        for (Object object : world.players) {
            if (!(object instanceof Player)) {
                continue;
            }

            Player player = (Player) object;

            double dx = mob.x - player.x;
            double dy = mob.y - player.y;
            double dz = mob.z - player.z;

            if (dx * dx + dy * dy + dz * dz
                    <= SLEEPDIST) {
                return;
            }
        }

        //zzzzzz
        ci.cancel();
    }
}
