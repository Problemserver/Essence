package essence.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Objects;

public class tpworld implements CommandExecutor {

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        if (!(commandSender instanceof Player)) return false;
        if(args.length != 1) return false;
        if(Bukkit.getWorld(args[0])== null) return false;

        ((Player)commandSender).teleport(Objects.requireNonNull(Bukkit.getWorld(args[0])).getSpawnLocation());
        return true;
    }
}
