package io.github.yuko1101.skipfirsthalf.mixin;

import emu.lunarcore.plugin.PluginManager;
import io.github.yuko1101.skipfirsthalf.SkipFirstHalfMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PluginManager.class, remap = false)
public class PluginManagerMixin {
    @Inject(method = "enablePlugins", at = @At("HEAD"))
    private void onEnable(CallbackInfo ci) {
        SkipFirstHalfMod.INSTANCE.onEnable();
    }
}
