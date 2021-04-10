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

    public final String COMPASS_NAME = ChatColor.RED + "Navigator";
    private final int INV_SIZE = 27;
    private final int COMPASS_SLOT = 4;
    public final List<String> COMPASS_WORLDS = List.of("hub", "JapaneseCity");

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
        inv.setItem(12, itemHub);

        ItemStack itemBuild = new ItemStack(Material.MAGMA_CREAM);
        ItemMeta itemBuildMeta = itemHub.getItemMeta();
        assert itemBuildMeta != null;
        itemBuildMeta.setDisplayName("Build");
        itemBuild.setItemMeta(itemBuildMeta);
        inv.setItem(14, itemBuild);

        player.openInventory(inv);
    }

    public void giveCompass(Player p) {
        p.getInventory().setItem(COMPASS_SLOT, this.compassItem());
    }

}
