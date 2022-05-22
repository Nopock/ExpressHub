package me.nopox.expresshub.serverselector;

import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.menu.ServerSelector;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ServerSelectorListener implements Listener {
    public ServerSelectorListener() {
        Bukkit.getPluginManager().registerEvents(this, ExpressHub.getInstance());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ExpressHub plugin = ExpressHub.getInstance();
        System.out.println("Interact");
        if (!(event.getAction() == Action.RIGHT_CLICK_AIR) && !(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        System.out.println("Interact2");
        if (event.getItem() == null ||!event.getItem().equals(plugin.getItems().getServer_selector())) return;
        System.out.println("Interact3");

        new ServerSelector(event.getPlayer()).updateMenu();
    }
}
