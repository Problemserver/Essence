package essence;

import essence.commands.gm;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Loading Essence Plugin.");
        getLogger().info("Loading Essence Commands.");
        registerCommands();
        getLogger().info("Essence primed and ready.");
    }

    private void registerCommands(){
        getCommand("gm").setExecutor(new gm());
    }

}
