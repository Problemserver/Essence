package essence.commands;

import essence.tools.Vanish;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class s implements CommandExecutor {

    public s(){
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(strings.length == 0){
                if(player.getFlySpeed() == 1 && player.getWalkSpeed() == 1){
                    player.setWalkSpeed(2);
                    player.setFlySpeed(2);
                }
                else{
                    player.setWalkSpeed(1);
                    player.setFlySpeed(1);
                }
            }else if(strings.length == 1 && strings[0].matches("[+-]?\\d*(\\.\\d+)?")){
                player.setWalkSpeed(Integer.parseInt(strings[0]));
                player.setFlySpeed(Integer.parseInt(strings[0]));
            } else {
                return false;
            }
        }
        return true;
    }
}