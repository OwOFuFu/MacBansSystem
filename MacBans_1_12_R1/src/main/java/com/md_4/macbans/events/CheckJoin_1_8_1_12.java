package com.md_4.macbans.events;


import com.md_4.macbans.MacBans_1_8_1_12_R1;
import com.md_4.macbans.functions.MacAddress_1_8_1_12;
import com.md_4.macbans.security.AdvancedLicense_1_8_1_12;
import com.md_4.macbans.utils.Format_1_8_1_12;
import com.md_4.macbans.utils.GetConfig_1_8_1_12;
import com.md_4.macbans.utils.Messages_1_8_1_12;
import com.md_4.macbans.utils.Prefix_1_8_1_12;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.ResultSet;
import java.sql.Statement;

import static com.md_4.macbans.MacBans_1_8_1_12_R1.SQL;

@SuppressWarnings("all")
public class CheckJoin_1_8_1_12 implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e){

        Bukkit.getScheduler().runTaskLater(MacBans_1_8_1_12_R1.getInstance(), new Runnable() {
            public void run() {
                AdvancedLicense_1_8_1_12.ValidationType vt = new AdvancedLicense_1_8_1_12(MacBans_1_8_1_12_R1.getInstance().getConfig().getString("License-Key").toString(), "https://rload.eu/labscriptadd/verify.php", MacBans_1_8_1_12_R1.getInstance()).isValid();
                if(
                        vt == vt.KEY_OUTDATED
                                || vt == vt.NOT_VALID_IP
                                || vt == vt.KEY_NOT_FOUND
                                || vt == vt.PAGE_ERROR
                                || vt == vt.URL_ERROR
                ) {
                    Bukkit.getServer().getPluginManager().disablePlugin(MacBans_1_8_1_12_R1.getInstance());
                    Bukkit.getLogger().info("[]==========[MacBans License]==========[]");
                    Bukkit.getLogger().info("[MacBans] License Not Valid");
                    Bukkit.getLogger().info("[]==========[MacBans License]==========[]");
                }
            }
        }, 1L);

        Player p = e.getPlayer();



        try {




            Statement stmt = SQL.getconnection().createStatement();

            String SQL = "SELECT * FROM bannedaccounts WHERE mac='" + MacAddress_1_8_1_12.get(p) + "'";

            ResultSet rs = stmt.executeQuery(SQL);

            if(rs.next()){


                if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                    p.kickPlayer(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.DisconnectBanned()));
                }

                if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                    p.kickPlayer(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.DisconnectBannedEN()));
                }



            }

        } catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
