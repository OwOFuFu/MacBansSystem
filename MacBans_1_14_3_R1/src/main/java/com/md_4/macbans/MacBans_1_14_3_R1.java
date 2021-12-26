package com.md_4.macbans;

import com.md_4.macbans.events.CheckJoin_1_14_3_R1;
import com.md_4.macbans.functions.MacAddress_1_14_3_R1;
import com.md_4.macbans.security.AdvancedLicense_1_14_3_R1;
import com.md_4.macbans.sql.MySQL_1_14_3_R1;
import com.md_4.macbans.utils.Tab_1_14_3_R1;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("all")
public final class MacBans_1_14_3_R1 extends JavaPlugin {

    public static MySQL_1_14_3_R1 SQL;

    private static MacBans_1_14_3_R1 instance;

    public static MacBans_1_14_3_R1 getInstance(){
        return instance;
    }

    public void Commands(){
        getCommand("macbans").setExecutor(new com.md_4.macbans.commands.MacBans_1_14_3_R1());
    }

    public void TabCompletion(){
        getCommand("macbans").setTabCompleter(new Tab_1_14_3_R1());
    }

    public void Events(){
        getServer().getPluginManager().registerEvents(new CheckJoin_1_14_3_R1(), this);
    }


    @Override
    public void onEnable() {





        Commands();
        Events();
        TabCompletion();

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        getConfig().options().copyHeader(true);

        instance = this;

        SQL = new MySQL_1_14_3_R1();

        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[MySql] Error While Pulling Requests From MacBans, Check If Credentials In config.yml");
            getServer().getPluginManager().disablePlugin(this);
            e.printStackTrace();
        }

        if(SQL.isConnected()){
            System.out.println("[MySql] Pulling MySQL Requests From MacBans...");
            try {
                MacAddress_1_14_3_R1.createTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        File lang = new File(this.getDataFolder(), "lang");
        File lang_it = new File(this.getDataFolder() + "/lang/it_IT.yml");
        File lang_en = new File(this.getDataFolder() + "/lang/en_EN.yml");
        if (!lang.exists()) {
            lang.mkdir();
        }

        FileConfiguration lang_it_config = YamlConfiguration.loadConfiguration(lang_it);
        FileConfiguration lang_en_config = YamlConfiguration.loadConfiguration(lang_en);
        if (!lang_it.exists()) {
            try {
                lang_it.createNewFile();
                lang_it_config.createSection("Msg");
                lang_it_config.set("Msg.Prefix", "&7[&cMacBans&7] ");
                lang_it_config.set("Msg.MacAddressLocal", "&cil tuo indirizzo Mac è &4%mac_address_local%");
                lang_it_config.set("Msg.BanMac", "&cHai bannato &4%player_name% &cper indirizzo mac");
                lang_it_config.set("Msg.UnbanMac", "&cHai unbannato &4%player_name%");
                lang_it_config.set("Msg.DisconnectBanned", "&cSei Permanentemente Bannato Dal Server");
                lang_it_config.set("Msg.CommandBanUsage", "&cUsa &4/&cmacbans ban &4<&cNomePlayer&4>&c");
                lang_it_config.set("Msg.CommandUnbanUsage", "&cUsa &4/&cmacbans unban &4<&cNomePlayer&4>&c");
                lang_it_config.set("Msg.AccessDenied", "&cAccesso Negato");
                lang_it_config.save(lang_it);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (!lang_en.exists()) {
            try {
                lang_en.createNewFile();
                lang_en_config.createSection("Msg");
                lang_en_config.set("Msg.Prefix", "&7[&cMacBans&7] ");
                lang_en_config.set("Msg.MacAddressLocal", "&cyour Mac address is &4%mac_address_local%");
                lang_en_config.set("Msg.BanMac", "&cYou banned &4%player_name% &cfor Mac address");
                lang_en_config.set("Msg.UnbanMac", "&cYou got unbanned &4%player_name%");
                lang_en_config.set("Msg.DisconnectBanned", "&cYou are permanently banned from the server");
                lang_en_config.set("Msg.CommandBanUsage", "&cUse &4/&cmacbans ban &4<&cPlayerName&4>&c");
                lang_en_config.set("Msg.CommandUnbanUsage", "&cUse &4/&cmacbans unban &4<&cPlayerName&4>&c");
                lang_en_config.set("Msg.AccessDenied", "&cAccess denied");
                lang_en_config.save(lang_en);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        AdvancedLicense_1_14_3_R1.ValidationType vt = new AdvancedLicense_1_14_3_R1(getConfig().getString("License-Key").toString(), "https://rload.eu/labscriptadd/verify.php", MacBans_1_14_3_R1.getInstance()).isValid();
        if(
                vt == vt.KEY_OUTDATED
                        || vt == vt.NOT_VALID_IP
                        || vt == vt.KEY_NOT_FOUND
                        || vt == vt.PAGE_ERROR
                        || vt == vt.URL_ERROR
        ) {
            getServer().getPluginManager().disablePlugin(MacBans_1_14_3_R1.getInstance());
            getLogger().info("[]==========[MacBans License]==========[]");
            getLogger().info("[MacBans] License Not Valid");
            getLogger().info("[]==========[MacBans License]==========[]");
        }
    }

}
