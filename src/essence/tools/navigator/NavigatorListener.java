package essence.tools.navigator;

import com.onarandombox.MultiverseCore.event.MVTeleportEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class NavigatorListener implements Listener {

    private final Navigator navigator;

    public NavigatorListener(Navigator navigator) {
        this.navigator = navigator;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (navigator.isCompass(event.getItem())) {
            navigator.openCompassMenu(event.getPlayer());
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        if (event.getView().getTitle().equals(navigator.COMPASS_NAME)) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().hasItemMeta()) {
                int slot = event.getSlot();
                String world = slot == 3 ? "hub" : "JapaneseCity";
                p.getInventory().remove(navigator.compassItem());
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = "mvtp " + p.getName() + " " + world;
                Bukkit.dispatchCommand(console, command);
                if (navigator.COMPASS_WORLDS.contains(p.getWorld().getName())) {
                    navigator.giveCompass(p);
                }
            }
        }
    }

    @EventHandler
    public void onTP(MVTeleportEvent event) {
        Player p = event.getTeleportee();
        if (p.getInventory().contains(navigator.compassItem())) {
            p.getInventory().remove(navigator.compassItem());
        }

        if (navigator.COMPASS_WORLDS.contains(p.getWorld().getName())) {
            navigator.giveCompass(p);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (navigator.isCompass(event.getItemDrop().getItemStack())) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (navigator.COMPASS_WORLDS.contains(p.getWorld().getName())) {
            navigator.giveCompass(p);
        }

    }
}
