package essence.util;

import org.bukkit.ChatColor;

public enum Language {
    CMD_GM("Switched your gamemode to " + ChatColor.WHITE +  "%s"),
    CMD_VANISH_OFF("You are no longer vanished"),
    CMD_VANISH_ON("You are now vanished"),
    CMD_SPEED_SET("Your speed is set to " + ChatColor.WHITE + "%f"),
    WORLD_NAMES("The following worlds are currently loaded:"),
    WORLD_TELEPORT("Teleporting to world "+ ChatColor.WHITE + "%s");

    private static final String SYSTEM_PREFIX = ChatColor.GOLD + "System " + ChatColor.DARK_GRAY + "» ";

    private final String text;

    Language(String text) {
        this.text = text;
    }

    public String getFormattedText() {
        return SYSTEM_PREFIX + ChatColor.GRAY + text;
    }

}
