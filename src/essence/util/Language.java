package essence.util;

import java.util.HashMap;
import java.util.Map;

public class Language {

    private static final Map<String, String> lang = new HashMap<>();

    public static String getStringFromKeyword(String keyword){
        return lang.get(keyword);
    }

    public static void putStringsInHashmap(){
        lang.put("cmd_vanish_on", "You are now vanished");
        lang.put("cmd_vanish_off", "You are no longer vanished");
        lang.put("cmd_gm", "Switched your gamemode to %s");
    }

}
