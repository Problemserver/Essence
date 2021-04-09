package essence.tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Vanish {
    private final essence.Main main;
    private final List<Player> hiddenPlayers = new ArrayList<>();

    public Vanish(essence.Main main) {
        this.main = main;
    }

    public void ChangeVanishStatus(Player player){
        if(hiddenPlayers.contains(player)){
            hiddenPlayers.remove(player);
            //everybody can see the player again
            for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                otherPlayer.showPlayer(main, player);
            }
        } else {
            hiddenPlayers.add(player);
            //hides the player from everyone
            for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                otherPlayer.hidePlayer(main, player);
            }
        }
    }

    public void VanishPlayersForJoinedPlayers(Player player){
        for (Player otherPlayer : hiddenPlayers) {
            player.hidePlayer(main, otherPlayer);
        }
    }

    public void ShowPlayerWhenQuitting(Player player){
        hiddenPlayers.remove(player);
    }
}
