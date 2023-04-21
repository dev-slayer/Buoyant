package net.slayer.buoyant;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Buoyant implements ModInitializer {
	public static final String MOD_ID = "buoyant";
	public static final Logger LOGGER = LoggerFactory.getLogger("buoyant");

	@Override
	public void onInitialize() {
		LOGGER.info("Buoyant loaded successfully!");
		MidnightConfig.init("buoyant", Config.class);
	}
}