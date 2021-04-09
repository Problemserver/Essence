package essence;

import essence.commands.gm;
import essence.commands.v;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Loading Essence Plugin.");
        getLogger().info("Loading Essence Commands.");
        registerCommands();
        getLogger().info("Essence primed and ready.");
    }

    public void registerCommands(){
        getCommand("gm").setExecutor(new gm());
        getCommand("v").setExecutor(new v(this));
    }

}
