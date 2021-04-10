package essence.commands;

import essence.tools.Vanish;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class v implements CommandExecutor {
    private final Vanish vanish;

    public v(Vanish vanish){
        this.vanish = vanish;
    }
    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            // /vn
            if (strings.length == 0) {
                vanish.ChangeVanishStatus(player, false);
            } else {
                return false;
            }
        }
        return true;
    }
}