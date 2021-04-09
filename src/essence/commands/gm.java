package essence.commands;

import essence.util.Language;
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

                GameMode gameMode;

                switch (gmValue) {
                    case 0:
                        gameMode = GameMode.SURVIVAL;
                        break;
                    case 2:
                        gameMode = GameMode.ADVENTURE;
                        break;
                    case 3:
                        gameMode = GameMode.SPECTATOR;
                        break;
                    default:
                        gameMode = GameMode.CREATIVE;
                        break;
                }

                player.setGameMode(gameMode);
                player.sendMessage(String.format(Language.getStringFromKeyword("cmd_gm"), gameMode.name()));

            } else {
                return false;
            }
        }
        return true;
    }
}
