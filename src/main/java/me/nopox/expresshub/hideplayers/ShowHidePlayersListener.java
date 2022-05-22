package me.nopox.expresshub.hideplayers;

import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class ShowHidePlayersListener implements Listener {


    public ShowHidePlayersListener() {
        Bukkit.getPluginManager().registerEvents(this, ExpressHub.getInstance());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Bukkit.getOnlinePlayers().stream().filter(p -> p.hasMetadata("hidden")).forEach(s -> s.hidePlayer(ExpressHub.getInstance(), player));
    }


    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent event) {
        ExpressHub plugin = ExpressHub.getInstance();

        Player player = event.getPlayer();
        ItemStack held = player.getInventory().getItemInMainHand();
        if (!(event.getAction() == Action.RIGHT_CLICK_AIR) || !(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (!(held == plugin.getItems().getHide_players()) || !(held == plugin.getItems().getShow_players())) return;

        if (player.hasMetadata("hidden")) {
            player.removeMetadata("hidden", plugin);
            for (Player players : Bukkit.getOnlinePlayers()) {
                player.showPlayer(plugin, players);
            }
            player.sendMessage(CC.translate("&bPlayer visibility toggled: &aON"));
            return;
        }
        player.setMetadata("hidden", new FixedMetadataValue(plugin, true));
        for (Player players : Bukkit.getOnlinePlayers()) {
            player.hidePlayer(plugin, players);
        }
        player.sendMessage(CC.translate("&bPlayer visibility toggled: &cOFF"));
    }
}
