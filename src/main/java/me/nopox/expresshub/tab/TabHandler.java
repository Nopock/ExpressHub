package me.nopox.expresshub.tab;

import io.github.nosequel.tab.shared.entry.TabElement;
import io.github.nosequel.tab.shared.entry.TabElementHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.CC;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class TabHandler implements TabElementHandler {
    private FileConfiguration config;

    /**
     * Get the tab element of a player
     *
     * @param player the player
     * @return the element
     */

    @Override
    public TabElement getElement(Player player) {
        config = ExpressHub.getInstance().getConfig();
        TabElement e = new TabElement();
        e.setHeader(CC.translate(config.getString("Tablist.header")));
        e.setFooter(CC.translate(config.getString("Tablist.footer")));



        for (int i = 0; i < 80; i++) {
            final int x = i % 4;
            final int y = i / 4;

            String line = config.getStringList("Tablist.lines").get(i);

            line = PlaceholderAPI.setPlaceholders(player, line);

            e.add(x, y, CC.translate(line));
        }


        return e;
    }
}
