package essence.commands;

import essence.util.Language;
import essence.util.LanguageKeyword;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class speed implements CommandExecutor {

    public speed(){
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Float newSpeed;

            if(strings.length == 0){
                /*if(player.getFlySpeed() == 1 && player.getWalkSpeed() == 1){
                    newSpeed = 2f;
                    player.setWalkSpeed(newSpeed);
                    player.setFlySpeed(newSpeed);
                }
                else{
                    newSpeed = 1f;
                    player.setWalkSpeed(newSpeed);
                    player.setFlySpeed(newSpeed);
                }
                player.sendMessage(String.format(Language.getStringFromKeyword(LanguageKeyword.CMD_SPEED_SET), newSpeed));*/
                player.sendMessage(player.getWalkSpeed() + "");
            }else if(strings.length == 1 && strings[0].matches("[+-]?\\d*(\\.\\d+)?")){
                newSpeed = Float.parseFloat(strings[0]);
                player.setWalkSpeed(newSpeed);
                player.setFlySpeed(newSpeed);
                player.sendMessage(String.format(Language.getStringFromKeyword(LanguageKeyword.CMD_SPEED_SET), newSpeed));
            } else {
                return false;
            }
        }
        return true;
    }
}