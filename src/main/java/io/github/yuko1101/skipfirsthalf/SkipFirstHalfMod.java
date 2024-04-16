package io.github.yuko1101.skipfirsthalf;

import emu.lunarcore.LunarCore;
import emu.lunarcore.data.excel.ChallengeExcel;
import io.github.yuko1101.skipfirsthalf.commands.SkipFirstHalfCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;

public class SkipFirstHalfMod implements ModInitializer {

    public static final String MOD_NAME = "SkipFirstHalfMod";

    public static final LogCategory LOG_CATEGORY = LogCategory.create(MOD_NAME);

    public static SkipFirstHalfMod INSTANCE;


    public boolean isSkippingEnabled = false;

    @Override
    public void onInitialize() {
        INSTANCE = this;
        Log.info(LOG_CATEGORY, "Initializing " + MOD_NAME);
    }

    public void onEnable() {
        LunarCore.getCommandManager().registerCommand(new SkipFirstHalfCommand());
    }

    public static boolean shouldSkip(ChallengeExcel excel) {
        return SkipFirstHalfMod.INSTANCE.isSkippingEnabled && excel.getStageNum() >= 2;
    }
}
