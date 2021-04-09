package essence.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class gm implements CommandExecutor {

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length == 0) {
                player.setGameMode(player.getGameMode() == GameMode.CREATIVE ? GameMode.SURVIVAL : GameMode.CREATIVE);

            } else if (strings.length == 1) {

                int gmValue = Integer.parseInt(strings[0]);

                if (gmValue < 0 || gmValue > 3) return false;

                switch (gmValue) {
                    case 0:
                        player.setGameMode(GameMode.SURVIVAL);
                        break;
                    case 1:
                        player.setGameMode(GameMode.CREATIVE);
                        break;
                    case 2:
                        player.setGameMode(GameMode.ADVENTURE);
                        break;
                    case 3:
                        player.setGameMode(GameMode.SPECTATOR);
                        break;
                }

            } else {
                return false;
            }
        }
        return true;
    }
}
