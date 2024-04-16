package io.github.yuko1101.skipfirsthalf.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import io.github.yuko1101.skipfirsthalf.SkipFirstHalfMod;

@Command(
        label = "skipfirsthalf",
        permission = "player.skipfirsthalf",
        desc = "/skipfirsthalf. Toggles first half skipping."
)
public class SkipFirstHalfCommand implements CommandHandler {
    @Override
    public void execute(CommandArgs commandArgs) {
        SkipFirstHalfMod.INSTANCE.isSkippingEnabled = !SkipFirstHalfMod.INSTANCE.isSkippingEnabled;

        commandArgs.sendMessage("Toggled first half skipping. Status: " + (SkipFirstHalfMod.INSTANCE.isSkippingEnabled ? "Enabled" : "Disabled"));
    }
}
