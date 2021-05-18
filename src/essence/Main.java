package essence;

import essence.commands.gamemode;
import essence.commands.speed;
import essence.commands.tpworld;
import essence.commands.vanish;
import essence.tools.vanish.Vanish;
import essence.tools.vanish.VanishListener;
import essence.util.Config;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    private final Config config = new Config(this);
    private final Vanish vanish = new Vanish(this);

    @Override
    public void onEnable() {
        getLogger().info("Loading Essence Plugin.");

        getLogger().info("Reading Essence Configuration.");
        loadConfiguration();

        getLogger().info("Loading Essence Commands.");
        registerCommands();

        getLogger().info("Loading Essence Listeners.");
        registerListeners();

        getLogger().info("Essence primed and ready.");
    }

    private void loadConfiguration() {
        try {
            config.loadFiles();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("gm")).setExecutor(new gamemode());
        Objects.requireNonNull(getCommand("v")).setExecutor(new vanish(vanish));
        Objects.requireNonNull(getCommand("s")).setExecutor(new speed());
        Objects.requireNonNull(getCommand("tpworld")).setExecutor(new tpworld());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new VanishListener(vanish), this);
    }

}
