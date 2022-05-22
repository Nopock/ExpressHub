package me.nopox.expresshub.scoreboard;

import io.github.thatkawaiisam.assemble.AssembleAdapter;
import me.clip.placeholderapi.PlaceholderAPI;
import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.CC;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard implements AssembleAdapter {

    private FileConfiguration config;

    public Scoreboard() {
        this.config = ExpressHub.getInstance().getConfig();
    }

    /**
     * Get's the scoreboard title.
     *
     * @param player who's title is being displayed.
     * @return title.
     */
    @Override
    public String getTitle(Player player) {
        return CC.translate(config.getString("Scoreboard.title"));
    }

    /**
     * Get's the scoreboard lines.
     *
     * @param player who's lines are being displayed.
     * @return lines.
     */
    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        for (String line : config.getStringList("Scoreboard.lines")) {
            String line1 = CC.translate(line);

            line1 = PlaceholderAPI.setPlaceholders(player, line1);

            lines.add(line1);
        }

        return lines;
    }
}
