package me.nopox.expresshub.utils;

import lombok.Getter;
import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.external.ItemBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

@Getter
public class Items {
    private ExpressHub plugin;

    public Items(ExpressHub plugin) {
        this.plugin = plugin;
    }

    FileConfiguration config = plugin.getConfig();


    private ItemStack enderbutt = getItem("Enderbutt");
    private ItemStack server_selector = getItem("Server_Selector");
    private ItemStack show_players = getItem("Show_Players");
    private ItemStack hide_players = getItem("Hide_Players");
    private ItemStack item_1 = getItem("Item_1");
    private ItemStack item_2 = getItem("Item_2");
    private ItemStack item_3 = getItem("Item_3");


    private ItemStack getItem(String id) {
        return new ItemBuilder(config.getItemStack("Inventory" + id + ".material").getType()).setDisplayName(config.getString("Inventory" + id + ".name")).addLore(config.getStringList("Inventory." + id + ".lore")).setAmount(config.getInt("Inventory." + id + ".amount")).create();
    }
}
