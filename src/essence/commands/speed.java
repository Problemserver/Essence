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
                if(player.getFlySpeed() == 0.1f && player.getWalkSpeed() == 0.2f){
                    newSpeed = 0.6f;
                    player.setWalkSpeed(newSpeed);
                    player.setFlySpeed(newSpeed);
                }
                else{
                    newSpeed = 0.2f;
                    player.setWalkSpeed(newSpeed);
                    player.setFlySpeed(0.1f); //0.1 is the standart flyingspeed
                }
                player.sendMessage(String.format(Language.getStringFromKeyword(LanguageKeyword.CMD_SPEED_SET), newSpeed));
            }else if(strings.length == 1 && strings[0].matches("[+-]?\\d*(\\.\\d+)?") && Float.parseFloat(strings[0]) >= 0f && Float.parseFloat(strings[0]) <= 1f){
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