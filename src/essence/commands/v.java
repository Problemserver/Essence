package essence.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class v implements CommandExecutor {
    private essence.Main main;

    public v(essence.Main main){
        this.main = main;
    }
    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length == 0) {

                for(Player otherPlayer : Bukkit.getOnlinePlayers()){
                    otherPlayer.hidePlayer(main, player);
                }

            } else {
                return false;
            }
        }
        return true;
    }
}