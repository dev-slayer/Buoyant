package net.slayer.buoyant;

import eu.midnightdust.lib.config.MidnightConfig;

public class Config extends MidnightConfig {

    @Entry(name = "buoyant.midnightconfig.tooltip") public static TOOLTIP_OPTIONS TOOLTIP = TOOLTIP_OPTIONS.YES;
    @Entry(name = "buoyant.midnightconfig.tooltip_color") public static TOOLTIP_COLORS TOOLTIP_COLOR = TOOLTIP_COLORS.DARK_GRAY;
    public enum TOOLTIP_OPTIONS {
        YES, NO, SHIFT
    }
    public enum TOOLTIP_COLORS {
        RED, DARK_RED, GOLD, YELLOW, GREEN, DARK_GREEN, AQUA, DARK_AQUA, BLUE, DARK_BLUE, DARK_PURPLE, PURPLE, GRAY, DARK_GRAY, WHITE, BLACK
    }
    @Entry(name = "buoyant.midnightconfig.super_buoyant") public static float SUPER_BUOYANT_VALUE = 0.01f;
    @Entry(name = "buoyant.midnightconfig.buoyant") public static float BUOYANT_VALUE = 0f;
    @Entry(name = "buoyant.midnightconfig.neutral") public static float NEUTRAL_VALUE = -0.005f;
    @Entry(name = "buoyant.midnightconfig.high") public static float HEAVY_VALUE = -0.025f;
    @Entry(name = "buoyant.midnightconfig.super_high") public static float SUPER_HEAVY_VALUE = -0.05f;
}