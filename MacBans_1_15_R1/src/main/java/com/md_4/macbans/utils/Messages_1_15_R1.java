package com.md_4.macbans.utils;



import com.md_4.macbans.MacBans_1_15_R1;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@SuppressWarnings("all")
public class Messages_1_15_R1 {
    public static File lang_it = new File(MacBans_1_15_R1.getInstance().getDataFolder() + "/lang/it_IT.yml");
    public static File lang_en = new File(MacBans_1_15_R1.getInstance().getDataFolder() + "/lang/en_EN.yml");
    public static FileConfiguration lang_it_config;
    public static FileConfiguration lang_en_config;
    public static String lang;

    public static String getPrefix(){
        return lang.equals("It") ? Format_1_15_R1.color(lang_it_config.getString("Msg.Prefix")) : "";
    }

    public static String MacAddressLocal(){
        return lang.equals("It") ? Format_1_15_R1.color(lang_it_config.getString("Msg.MacAddressLocal")) : "";
    }

    public static String CommandBanUsage(){
        return lang.equals("It") ? Format_1_15_R1.color(lang_it_config.getString("Msg.CommandBanUsage")) : "";
    }

    public static String CommandUnbanUsage(){
        return lang.equals("It") ? Format_1_15_R1.color(lang_it_config.getString("Msg.CommandUnbanUsage")) : "";
    }

    public static String AccessDenied(){
        return lang.equals("It") ? Format_1_15_R1.color(lang_it_config.getString("Msg.AccessDenied")) : "";
    }

    public static String BanMac(){
        return lang.equals("It") ? Format_1_15_R1.color(lang_it_config.getString("Msg.BanMac")) : "";
    }

    public static String UnbanMac(){
        return lang.equals("It") ? Format_1_15_R1.color(lang_it_config.getString("Msg.UnbanMac")) : "";
    }

    public static String DisconnectBanned(){
        return lang.equals("It") ? Format_1_15_R1.color(lang_it_config.getString("Msg.DisconnectBanned")) : "";
    }

    /////////////////////////////////////////////////////////////

    public static String getPrefixEN(){
        return lang.equals("En") ? Format_1_15_R1.color(lang_en_config.getString("Msg.Prefix")) : "";
    }

    public static String MacAddressLocalEN(){
        return lang.equals("En") ? Format_1_15_R1.color(lang_en_config.getString("Msg.MacAddressLocal")) : "";
    }

    public static String CommandBanUsageEN(){
        return lang.equals("En") ? Format_1_15_R1.color(lang_en_config.getString("Msg.CommandBanUsage")) : "";
    }

    public static String CommandUnbanUsageEN(){
        return lang.equals("En") ? Format_1_15_R1.color(lang_en_config.getString("Msg.CommandUnbanUsage")) : "";
    }

    public static String AccessDeniedEN(){
        return lang.equals("En") ? Format_1_15_R1.color(lang_en_config.getString("Msg.AccessDenied")) : "";
    }

    public static String BanMacEN(){
        return lang.equals("En") ? Format_1_15_R1.color(lang_en_config.getString("Msg.BanMac")) : "";
    }

    public static String UnbanMacEN(){
        return lang.equals("En") ? Format_1_15_R1.color(lang_en_config.getString("Msg.UnbanMac")) : "";
    }

    public static String DisconnectBannedEN(){
        return lang.equals("En") ? Format_1_15_R1.color(lang_en_config.getString("Msg.DisconnectBanned")) : "";
    }



    static {
        lang_it_config = YamlConfiguration.loadConfiguration(lang_it);
        lang_en_config = YamlConfiguration.loadConfiguration(lang_en);
        lang = MacBans_1_15_R1.getInstance().getConfig().getString("Lang");
    }
}
