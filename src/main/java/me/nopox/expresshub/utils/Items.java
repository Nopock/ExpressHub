package me.nopox.expresshub.utils;

import lombok.Getter;
import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.external.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

@Getter
public class Items {
    private  FileConfiguration config;


    private final ItemStack enderbutt = getItem("Enderbutt", "Inventory", Material.ENDER_PEARL);
    private final ItemStack server_selector = getItem("Server_Selector", "Inventory", Material.COMPASS);
    private final ItemStack show_players = getItem("Show_Players", "Inventory", Material.GREEN_DYE);
    private final ItemStack hide_players = getItem("Hide_Players", "Inventory", Material.GRAY_DYE);
    private final ItemStack item_1 = getItem("Item_1", "Server_Selector", Material.COAL_BLOCK);
    private final ItemStack item_2 = getItem("Item_2", "Server_Selector", Material.REDSTONE_BLOCK);
    private final ItemStack item_3 = getItem("Item_3", "Server_Selector", Material.EMERALD_BLOCK);


    private ItemStack getItem(String id, String firstName, Material m) {
        config = ExpressHub.getInstance().getConfig();
        return new ItemBuilder(m)
                .setDisplayName(config.getString(firstName + "." + id + ".name"))
                .addLore(config.getStringList(firstName + "." + id + ".lore"))
                .setAmount(config.getInt(firstName + "." + id + ".amount"))
                .create();
    }
}
