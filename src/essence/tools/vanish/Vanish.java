package essence.tools.vanish;

import essence.util.Language;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Vanish {
    private final JavaPlugin plugin;
    private final List<Player> hiddenPlayers = new ArrayList<>();

    public Vanish(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void ChangeVanishStatus(Player player, boolean silent){
        if(hiddenPlayers.contains(player)){
            hiddenPlayers.remove(player);
            //everybody can see the player again
            for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                otherPlayer.showPlayer(plugin, player);
            }
            if(!silent)
                player.sendMessage(Language.CMD_VANISH_OFF.getFormattedText());
        } else {
            hiddenPlayers.add(player);
            //hides the player from everyone
            for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                otherPlayer.hidePlayer(plugin, player);
            }
            if(!silent)
                player.sendMessage(Language.CMD_VANISH_ON.getFormattedText());
        }
    }

    public void VanishPlayersForJoinedPlayers(Player player){
        for (Player otherPlayer : hiddenPlayers) {
            player.hidePlayer(plugin, otherPlayer);
        }
    }

    public void ShowPlayerWhenQuitting(Player player){
        hiddenPlayers.remove(player);
    }
}
