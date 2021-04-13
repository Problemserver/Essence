package essence.tools.navigator;

import essence.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public class Navigator{

    public final String COMPASS_NAME;
    private final int INV_SIZE;
    private final int COMPASS_SLOT;
    public final List<String> COMPASS_WORLDS = List.of("world");

    public Navigator(Config config) {
        COMPASS_NAME = config.getConfig().isString("navigator.name") ? ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("navigator.name"))) : ChatColor.RED + "Navigator";
        COMPASS_SLOT = config.getConfig().isInt("navigator.slot") ? config.getConfig().getInt("navigator.slot") : 4;
        INV_SIZE = config.getConfig().isInt("navigator.inv-size") ? config.getConfig().getInt("navigator.inv-size") : 27;
    }

    public ItemStack compassItem() {
        ItemStack compass = new ItemStack(Material.ENDER_PEARL);
        ItemMeta compassMeta = compass.getItemMeta();
        assert compassMeta != null;
        compassMeta.setDisplayName(COMPASS_NAME);
        compass.setItemMeta(compassMeta);
        return compass;
    }

    public boolean isCompass(ItemStack item) {
        if (item != null && item.hasItemMeta()) {
            return item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(COMPASS_NAME);
        } else {
            return false;
        }
    }
    public void openCompassMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, INV_SIZE, COMPASS_NAME);

        ItemStack itemHub = new ItemStack(Material.SLIME_BALL);
        ItemMeta itemHubMeta = itemHub.getItemMeta();
        assert itemHubMeta != null;
        itemHubMeta.setDisplayName("Spawn");
        itemHub.setItemMeta(itemHubMeta);
        inv.setItem(13, itemHub);

        player.openInventory(inv);
    }

    public void giveCompass(Player p) {
        p.getInventory().setItem(COMPASS_SLOT, this.compassItem());
    }

}
