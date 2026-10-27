package dev.uncreative.badventure.mixin.server.spawnchunks;

import net.minecraft.core.world.Dimension;
import net.minecraft.server.world.WorldServer;
import net.minecraft.server.world.chunk.provider.ChunkProviderServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import dev.uncreative.badventure.config.badventureconfig;

@Mixin(ChunkProviderServer.class)
public abstract class SpawnChunkKeepAlive {

	@Shadow
	@Final
	private WorldServer world;

	@ModifyConstant(
		method = "dropChunk",
		constant = @Constant(intValue = 128)
	)
	private int spike$spawnKeepRadius(int original) {
		if (!badventureconfig.spawnChunks) {
			return 0;
		}
		if (this.world.dimension != Dimension.OVERWORLD) {
			return 0;
		}
		return original;
	}
}
