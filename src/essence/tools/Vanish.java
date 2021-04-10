package essence.tools;

import essence.util.Language;
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

    public void ChangeVanishStatus(Player player, boolean silent){
        if(hiddenPlayers.contains(player)){
            hiddenPlayers.remove(player);
            //everybody can see the player again
            for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                otherPlayer.showPlayer(main, player);
            }
            if(!silent)
                player.sendMessage(Language.getStringFromKeyword("cmd_vanish_off"));
        } else {
            hiddenPlayers.add(player);
            //hides the player from everyone
            for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                otherPlayer.hidePlayer(main, player);
            }
            if(!silent)
                player.sendMessage(Language.getStringFromKeyword("cmd_vanish_on"));
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
