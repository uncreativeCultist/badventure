package dev.uncreative.badventure;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dev.uncreative.badventure.config.badventureconfig;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.util.dependency.Key;

public class badventure implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("badventure", false);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		badventureconfig.load();
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		LOGGER.info("badventure initialized.");
	}

	private void beforeGameStart() {
	}

	private void afterGameStart() {
	}
}
