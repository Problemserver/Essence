package essence.commands;

import essence.util.Language;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.stream.Collectors;

public class tpworld implements CommandExecutor {

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        if(args.length == 0){
            commandSender.sendMessage(Language.WORLD_NAMES.getFormattedText());
            commandSender.sendMessage(Bukkit.getWorlds().stream().map(World::getName).collect(Collectors.joining(ChatColor.GRAY + ", " + ChatColor.WHITE)));
            return true;
        }

        if (!(commandSender instanceof Player)) return false;
        if(args.length != 1) return false;
        if(Bukkit.getWorld(args[0]) == null) return false;

        commandSender.sendMessage(String.format(Language.WORLD_TELEPORT.getFormattedText(), args[0]));
        ((Player)commandSender).teleport(Objects.requireNonNull(Bukkit.getWorld(args[0])).getSpawnLocation());

        return true;
    }
}
