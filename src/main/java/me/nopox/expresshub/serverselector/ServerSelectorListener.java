package me.nopox.expresshub.serverselector;

import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.menu.ServerSelector;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ServerSelectorListener implements Listener {
    private final ExpressHub plugin;

    public ServerSelectorListener(ExpressHub plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (!(event.getAction() == Action.RIGHT_CLICK_AIR) || event.getAction() == Action.RIGHT_CLICK_BLOCK) return;

        if (event.getItem() == null || event.getItem() != plugin.getItems().getServer_selector()) return;

        new ServerSelector(event.getPlayer(), plugin);
    }
}
