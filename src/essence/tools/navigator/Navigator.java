package essence.tools.navigator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Navigator{

    public final String COMPASS_NAME = ChatColor.BOLD + "" + ChatColor.RED + "Navigator";
    private final int INV_SIZE = 9;
    private final int COMPASS_SLOT = 4;
    public final List<String> COMPASS_WORLDS = List.of("hub", "JapaneseCity");

    public ItemStack compassItem() {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
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
        itemHub.getItemMeta().setDisplayName("Hub");
        inv.setItem(3, itemHub);

        ItemStack itemBuild = new ItemStack(Material.MAGMA_CREAM);
        itemHub.getItemMeta().setDisplayName("Build");
        inv.setItem(5, itemHub);

        player.openInventory(inv);
    }

    public void giveCompass(Player p) {
        Inventory inv = p.getInventory();
        ItemStack item = inv.getItem(COMPASS_SLOT);
        ItemStack compass = this.compassItem();
        inv.setItem(COMPASS_SLOT, compass);
        if (!this.isCompass(item)) {
            inv.addItem(item);
        }

    }

}
