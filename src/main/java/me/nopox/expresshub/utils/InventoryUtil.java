package me.nopox.expresshub.utils;

import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.external.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class InventoryUtil {
    private FileConfiguration config;


    public void setupInventory(Player p) {
        config = ExpressHub.getInstance().getConfig();
        ExpressHub plugin = ExpressHub.getInstance();
        Inventory inv = p.getInventory();

        inv.clear();


        // Setup the enderbutt

        if (config.getBoolean("Inventory.Enderbutt.enabled")) {
            inv.setItem(config.getInt("Inventory.Enderbutt.slot"), plugin.getItems().getEnderbutt());
        }
        if (config.getBoolean("Inventory.Server_Selector.enabled")) {
            inv.setItem(config.getInt("Inventory.Server_Selector.slot"), plugin.getItems().getServer_selector());
        }
        if (config.getBoolean("Inventory.Show_Players.enabled")) {
            inv.setItem(config.getInt("Inventory.Show_Players.slot"), plugin.getItems().getShow_players());
        }
    }


}
