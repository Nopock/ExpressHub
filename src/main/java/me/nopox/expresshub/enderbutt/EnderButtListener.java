package me.nopox.expresshub.enderbutt;

import me.nopox.expresshub.ExpressHub;
import me.nopox.expresshub.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnderButtListener implements Listener {

    private final ExpressHub plugin;

    public EnderButtListener(ExpressHub plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (!(event.getEntity() instanceof EnderPearl)) {
            return;
        }

        if (!(event.getEntity().getShooter() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity().getShooter();
        EnderPearl enderPearl = (EnderPearl) event.getEntity();

        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

        if (player.getVehicle() != null) {
            player.getVehicle().eject();
        }


        Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, () -> player.getInventory().setItem(plugin.getConfig().getInt("Inventory.Enderbutt.slot"), plugin.getItems().getEnderbutt()), 5L);

        player.spigot().setCollidesWithEntities(false);
        enderPearl.setPassenger(player);
        player.updateInventory();
        enderPearl.setVelocity(enderPearl.getVelocity().multiply(1.5f));
    }

}
