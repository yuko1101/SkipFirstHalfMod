package io.github.yuko1101.skipfirsthalf.mixin;

import emu.lunarcore.data.excel.ChallengeExcel;
import emu.lunarcore.game.challenge.ChallengeEntityLoader;
import io.github.yuko1101.skipfirsthalf.SkipFirstHalfMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ChallengeEntityLoader.class, remap = false)
public class ChallengeEntityLoaderMixin {
    @Redirect(method = "onSceneLoad", at = @At(value = "INVOKE", target = "Lemu/lunarcore/data/excel/ChallengeExcel;getMazeGroupID1()I"))
    private int loadMazeGroupID2(ChallengeExcel excel) {
        return SkipFirstHalfMod.shouldSkip(excel) ? excel.getMazeGroupID2() : excel.getMazeGroupID1();
    }
}
