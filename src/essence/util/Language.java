package essence.util;

import java.util.HashMap;
import java.util.Map;

public class Language {

    private static final Map<LanguageKeyword, String> lang = new HashMap<>();

    public static String getStringFromKeyword(LanguageKeyword keyword){
        return lang.get(keyword);
    }

    public static void putStringsInHashmap(){
        lang.put(LanguageKeyword.CMD_VANISH_ON, "You are now vanished");
        lang.put(LanguageKeyword.CMD_VANISH_OFF, "You are no longer vanished");
        lang.put(LanguageKeyword.CMD_GM, "Switched your gamemode to %s");
        lang.put(LanguageKeyword.CMD_SPEED_SET, "Your walkingspeed is set to %f");
    }

}
