package essence.listeners;

import essence.tools.Vanish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class VanishListener implements Listener{
    private final Vanish vanish;

    public VanishListener(Vanish vanish){
        this.vanish = vanish;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        vanish.VanishPlayersForJoinedPlayers(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        vanish.ShowPlayerWhenQuitting(event.getPlayer());
    }
}
