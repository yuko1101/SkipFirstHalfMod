package io.github.yuko1101.skipfirsthalf.mixin;

import emu.lunarcore.data.excel.ChallengeExcel;
import emu.lunarcore.game.challenge.ChallengeInstance;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.ExtraLineupTypeOuterClass;
import io.github.yuko1101.skipfirsthalf.SkipFirstHalfMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ChallengeInstance.class, remap = false)
public abstract class ChallengeInstanceMixin {
    @Shadow private int currentStage;

    @Shadow public abstract ChallengeExcel getExcel();

    @Shadow protected abstract void setCurrentExtraLineup(ExtraLineupTypeOuterClass.ExtraLineupType type);

    @Inject(method = "<init>(Lemu/lunarcore/game/player/Player;Lemu/lunarcore/data/excel/ChallengeExcel;)V", at = @At("TAIL"))
    private void skipFirstHalf(Player player, ChallengeExcel excel, CallbackInfo ci) {
        if (!SkipFirstHalfMod.shouldSkip(getExcel())) return;

        currentStage = 2;
        setCurrentExtraLineup(ExtraLineupTypeOuterClass.ExtraLineupType.LINEUP_CHALLENGE_2);

    }
}
