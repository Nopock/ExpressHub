package me.nopox.expresshub.utils;

import me.nopox.expresshub.ExpressHub;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MessageUtil {
    private FileConfiguration config;
    public MessageUtil(ExpressHub plugin) {
        this.config = plugin.getConfig();
    }

    public void sendMOTD(Player player) {

        for (String line : config.getStringList("MOTD")) {
            player.sendMessage(CC.translate(line));
        }
    }
}
