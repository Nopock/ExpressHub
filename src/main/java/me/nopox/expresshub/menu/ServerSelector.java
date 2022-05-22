package me.nopox.expresshub.menu;

import io.github.nosequel.menu.Menu;
import io.github.nosequel.menu.buttons.Button;
import io.github.nosequel.menu.filling.FillingType;
import me.nopox.expresshub.ExpressHub;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ServerSelector extends Menu {
    private ExpressHub plugin;
    FileConfiguration config = plugin.getConfig();

    /**
     * Constructor to make a new menu object
     *
     * @param player the player to create the menu for
     */
    public ServerSelector(Player player, ExpressHub plugin) {
        super(player, "&e&lServer Selector << Main", 27);
        this.plugin = plugin;
    }


    /**
     * The method to get the buttons for the current inventory tick
     * <p>
     * Use {@code this.buttons[index] = Button} to assign
     * a button to a slot.
     */
    @Override
    public void tick() {
        addFiller(FillingType.BORDER);

        buttons[config.getInt("Server_Selector.Item_1.slot")] = new Button(plugin.getItems().getItem_1()).setClickAction(player -> {
            Bukkit.dispatchCommand(getPlayer(), config.getString("Server_Selector.Item_1.command"));
        });

        buttons[config.getInt("Server_Selector.Item_2.slot")] = new Button(plugin.getItems().getItem_2()).setClickAction(player -> {
            Bukkit.dispatchCommand(getPlayer(), config.getString("Server_Selector.Item_2.command"));
        });

        buttons[config.getInt("Server_Selector.Item_3.slot")] = new Button(plugin.getItems().getItem_3()).setClickAction(player -> {
            Bukkit.dispatchCommand(getPlayer(), config.getString("Server_Selector.Item_3.command"));
        });

    }

}
