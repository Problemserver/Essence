package essence.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {

            if (strings.length == 0) {
                player.setGameMode(player.getGameMode() == GameMode.CREATIVE ? GameMode.SURVIVAL : GameMode.CREATIVE);

            } else if (strings.length == 1) {

                int gmValue = Integer.parseInt(strings[0]);

                if (gmValue < 0 || gmValue > 3) return false;

                switch (gmValue) {
                    case 0 -> player.setGameMode(GameMode.SURVIVAL);
                    case 1 -> player.setGameMode(GameMode.CREATIVE);
                    case 2 -> player.setGameMode(GameMode.ADVENTURE);
                    case 3 -> player.setGameMode(GameMode.SPECTATOR);
                }

            } else {
                return false;
            }
        }
        return true;
    }
}
