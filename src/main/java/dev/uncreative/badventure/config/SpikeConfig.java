package dev.uncreative.badventure.config;

import dev.uncreative.badventure.badventure;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

public final class SpikeConfig {

	public static boolean spawnChunks = false;
	public static boolean increaseFoodStacks = true;
	public static boolean enableEntitySimulationDistance = true;
	public static int entitySimulationBlocks = 64;

	private SpikeConfig() {
	}

	public static void load() {
		Toml defaults = new Toml("badventure configuration file.");
		defaults.addEntry(
			"spawn-chunks",
			"""
			Prepare and keep overworld spawn area loaded.""",
			false
		);
		defaults.addEntry(
			"increase-food-stacks",
			"""
			Multiply most food stack size by 2.
			Doesn't apply if new stack size would be > 16""",
			true
		);
		defaults.addEntry(
			"enable-entity-simulation-distance",
			"""
			Simulates modern minecraft's simulation distance for
			entites by disabling AI after certain amount of blocks""",
			true
		);
		defaults.addEntry(
			"entity-simulation-blocks",
			"""
			Distance in blocks before entity AI is disabled""",
			64
		);

		TomlConfigHandler config = new TomlConfigHandler(badventure.MOD_ID, defaults);
		spawnChunks = config.getBoolean("spawn-chunks");
		increaseFoodStacks = config.getBoolean("increase-food-stacks");
		enableEntitySimulationDistance = config.getBoolean("enable-entity-simulation-distance");
		entitySimulationBlocks = config.getInt("entity-simulation-blocks");
	}
}
