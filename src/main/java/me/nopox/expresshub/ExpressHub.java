package me.nopox.expresshub;

import co.aikar.commands.PaperCommandManager;
import io.github.nosequel.menu.MenuHandler;
import io.github.nosequel.tab.shared.TabHandler;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import lombok.Getter;
import me.lucko.helper.Events;
import me.nopox.expresshub.commands.OwnerCommands;
import me.nopox.expresshub.enderbutt.EnderButtListener;
import me.nopox.expresshub.hideplayers.ShowHidePlayersListener;
import me.nopox.expresshub.scoreboard.Scoreboard;
import me.nopox.expresshub.serverselector.ServerSelectorListener;
import me.nopox.expresshub.utils.InventoryUtil;
import me.nopox.expresshub.utils.Items;
import me.nopox.expresshub.utils.MessageUtil;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public final class ExpressHub extends JavaPlugin {

    @Getter private static ExpressHub instance;

    private InventoryUtil inventoryUtil;
    private MessageUtil messageUtil;
    private Items items;


    @Override
    public void onEnable() {
        saveDefaultConfig();

        instance = this;
        setupListeners();

        inventoryUtil = new InventoryUtil();
        messageUtil = new MessageUtil();
        items = new Items();

        Assemble assemble = new Assemble(this, new Scoreboard());

        // Set Interval (Tip: 20 ticks = 1 second).
        assemble.setTicks(2);

        // Set Style (Tip: Viper Style starts at -1 and goes down).
        assemble.setAssembleStyle(AssembleStyle.VIPER);

        new TabHandler(new me.nopox.expresshub.tab.TabHandler(), this, 20L);

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new OwnerCommands());

        new MenuHandler(this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void setupListeners() {



        // We are going to use helper to disable certain events.

        Events.subscribe(EntitySpawnEvent.class).filter(e -> !(e.getEntity() instanceof Player)).handler(e -> e.setCancelled(true));
        Events.subscribe(PlayerQuitEvent.class).handler(e -> e.setQuitMessage(null));

        Arrays.asList(BlockBreakEvent.class,
                BlockPlaceEvent.class,
                FoodLevelChangeEvent.class,
                EntityDamageEvent.class,
                PlayerDropItemEvent.class,
                InventoryClickEvent.class)
                .forEach(event -> Events.subscribe(event).handler(e -> e.setCancelled(true)));

        // Now we are going to setup players inventory, gamemode, and health.

        Events.subscribe(PlayerJoinEvent.class).handler(e ->
                setupJoinStuff(e.getPlayer(), e));

        getServer().getPluginManager().registerEvents(new ServerSelectorListener(), this);

        getServer().getPluginManager().registerEvents(new ShowHidePlayersListener(), this);

        getServer().getPluginManager().registerEvents(new EnderButtListener(), this);

    }

    private void setupJoinStuff(Player player, PlayerJoinEvent e) {
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setFoodLevel(20);
        getInventoryUtil().setupInventory(player);
        getMessageUtil().sendMOTD(player);
        e.setJoinMessage(null);

    }

}
