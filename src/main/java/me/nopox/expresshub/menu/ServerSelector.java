package me.nopox.expresshub.menu;

import io.github.nosequel.menu.Menu;
import io.github.nosequel.menu.buttons.Button;
import io.github.nosequel.menu.filling.FillingType;
import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.CC;
import me.nopox.expresshub.utils.external.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class ServerSelector extends Menu {
    FileConfiguration config;

    /**
     * Constructor to make a new menu object
     *
     * @param player the player to create the menu for
     */
    public ServerSelector(Player player) {
        super(player, CC.translate("&e&lServer Selector << Main"), 27);
    }


    /**
     * The method to get the buttons for the current inventory tick
     * <p>
     * Use {@code this.buttons[index] = Button} to assign
     * a button to a slot.
     */
    @Override
    public void tick() {
        config = ExpressHub.getInstance().getConfig();
        ExpressHub plugin = ExpressHub.getInstance();
        setFillerType(new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayName("&c").setEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addItemFlags(ItemFlag.HIDE_ENCHANTS).create());
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
