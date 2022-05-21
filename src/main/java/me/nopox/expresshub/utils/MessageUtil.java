package me.nopox.expresshub.utils;

import me.nopox.expresshub.ExpressHub;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MessageUtil {
    private ExpressHub plugin;

    public MessageUtil(ExpressHub plugin) {
        this.plugin = plugin;
    }

    public void sendMOTD(Player player) {
        FileConfiguration config = plugin.getConfig();

        for (String line : config.getStringList("MOTD")) {
            player.sendMessage(CC.translate(line));
        }
    }
}
