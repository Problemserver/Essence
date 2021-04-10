package essence.commands;

import essence.tools.Vanish;
import org.bukkit.Bukkit;
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
        int lengthWithoutSilent;
        boolean silent;
        if(strings.length > 0 && strings[strings.length - 1].equals(s)) {
            lengthWithoutSilent = strings.length - 1;
            silent = true;
        }
        else {
            lengthWithoutSilent = strings.length;
            silent = false;
        }

            // /vn s(ilent)=false
            if (lengthWithoutSilent == 0) {
                if (commandSender instanceof Player) {
                    Player player = (Player) commandSender;
                    vanish.ChangeVanishStatus(player, silent);
                } else {
                    return false;
                }
            }
            // /vn [PlayerName] s(ilent)=false
            else if(lengthWithoutSilent == 1){
                Player targetPlayer = null;
                for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                    if(otherPlayer.getName().equals(strings[0]))
                        targetPlayer = otherPlayer;
                }
                if(targetPlayer != null){
                    vanish.ChangeVanishStatus(targetPlayer, silent);
                } else {
                    return false;
                }
            } else {
                return false;
            }
            return true;

    }
}