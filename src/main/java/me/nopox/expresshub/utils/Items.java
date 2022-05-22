package me.nopox.expresshub.utils;

import lombok.Getter;
import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.external.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

@Getter
public class Items {
    private final ExpressHub plugin;
    private final FileConfiguration config;

    public Items(ExpressHub plugin) {
        this.plugin = plugin;
        this.config = this.plugin.getConfig();
    }



    private final ItemStack enderbutt = getItem("Enderbutt");
    private final ItemStack server_selector = getItem("Server_Selector");
    private final ItemStack show_players = getItem("Show_Players");
    private final ItemStack hide_players = getItem("Hide_Players");
    private final ItemStack item_1 = getItem("Item_1");
    private final ItemStack item_2 = getItem("Item_2");
    private final ItemStack item_3 = getItem("Item_3");


    private ItemStack getItem(String id) {
        return new ItemBuilder(Material.valueOf(config.getString("Inventory." + id + ".material")))
                .setDisplayName(config.getString("Inventory." + id + ".name"))
                .addLore(config.getStringList("Inventory." + id + ".lore"))
                .setAmount(config.getInt("Inventory." + id + ".amount"))
                .create();
    }
}
