package com.md_4.macbans.utils;

import com.md_4.macbans.MacBans_1_17_R1;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@SuppressWarnings("all")
public class Prefix {
    public static File lang_it = new File(MacBans_1_17_R1.getInstance().getDataFolder() + "/lang/it_IT.yml");
    public static FileConfiguration lang_it_config;
    public static String lang;

    public static String get(){
        return lang.equals("It") ? Format.color(lang_it_config.getString("Msg.Prefix")) : "";
    }

    static {
        lang_it_config = YamlConfiguration.loadConfiguration(lang_it);
        lang = MacBans_1_17_R1.getInstance().getConfig().getString("Lang");
    }
}
