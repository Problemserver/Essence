package essence;

import essence.commands.gamemode;
import essence.commands.vanish;
import essence.commands.speed;
import essence.tools.navigator.Navigator;
import essence.tools.navigator.NavigatorListener;
import essence.tools.vanish.VanishListener;
import essence.tools.vanish.Vanish;
import essence.util.Config;
import essence.util.Language;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private final Config config = new Config(this);

    private final Vanish vanish = new Vanish(this);
    private final Navigator navigator = new Navigator(config);

    @Override
    public void onEnable() {
        getLogger().info("Loading Essence Plugin.");
        Language.putStringsInHashmap();

        getLogger().info("Loading Essence Commands.");
        registerCommands();

        getLogger().info("Loading Essence Listeners.");
        registerListeners();

        getLogger().info("Reading Essence Configuration.");
        loadConfiguration();

        getLogger().info("Essence primed and ready.");
    }

    private void loadConfiguration(){
        try {
            config.createFiles();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void registerCommands(){
            getCommand("gm").setExecutor(new gamemode());
            getCommand("v").setExecutor(new vanish(vanish));
            getCommand("s").setExecutor(new speed());
    }

    private void registerListeners(){
        getServer().getPluginManager().registerEvents(new VanishListener(vanish), this);
        getServer().getPluginManager().registerEvents(new NavigatorListener(navigator), this);
    }

}
