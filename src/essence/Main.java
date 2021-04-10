package essence;

import essence.commands.gm;
import essence.commands.v;
import essence.listeners.VanishListener;
import essence.tools.Vanish;
import essence.util.Language;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private final Vanish vanish = new Vanish(this);

    @Override
    public void onEnable() {
        getLogger().info("Loading Essence Plugin.");
        getLogger().info("Downloading Essence Language.");
        Language.putStringsInHashmap();
        getLogger().info("Loading Essence Commands.");
        registerCommands();
        getLogger().info("Loading Essence Listeners.");
        registerListeners();
        getLogger().info("Essence primed and ready.");
    }

    private void registerCommands(){
            getCommand("gm").setExecutor(new gm());
            getCommand("v").setExecutor(new v(vanish));
    }

    private void registerListeners(){
        getServer().getPluginManager().registerEvents(new VanishListener(vanish), this);
    }

}
