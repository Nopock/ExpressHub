package me.nopox.expresshub.utils;

import me.nopox.expresshub.ExpressHub;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MessageUtil {
    private FileConfiguration config;


    public void sendMOTD(Player player) {

        config = ExpressHub.getInstance().getConfig();

        for (String line : config.getStringList("MOTD")) {
            player.sendMessage(CC.translate(line));
        }
    }
}
