package me.nopox.expresshub.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.nopox.expresshub.ExpressHub;
import org.bukkit.entity.Player;

@CommandAlias("expresshub")
@CommandPermission("expresshub.admin")
public class OwnerCommands extends BaseCommand {

    private ExpressHub plugin;

    public OwnerCommands(ExpressHub plugin) {
        this.plugin = plugin;
    }

    @CommandAlias("reload")
    public void onReload(Player sender) {
        new ExpressHub().reloadConfig();
        sender.sendMessage("§aConfig reloaded!");
    }


}
