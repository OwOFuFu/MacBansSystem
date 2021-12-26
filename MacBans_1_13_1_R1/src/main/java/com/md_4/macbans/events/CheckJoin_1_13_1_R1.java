package com.md_4.macbans.events;


import com.md_4.macbans.MacBans_1_13_1_R1;
import com.md_4.macbans.functions.MacAddress_1_13_1_R1;
import com.md_4.macbans.security.AdvancedLicense_1_13_1_R1;
import com.md_4.macbans.utils.Format_1_13_1_R1;
import com.md_4.macbans.utils.GetConfig_1_13_1_R1;
import com.md_4.macbans.utils.Messages_1_13_1_R1;
import com.md_4.macbans.utils.Prefix_1_13_1_R1;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.ResultSet;
import java.sql.Statement;

import static com.md_4.macbans.MacBans_1_13_1_R1.SQL;

@SuppressWarnings("all")
public class CheckJoin_1_13_1_R1 implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e){

        Bukkit.getScheduler().runTaskLater(MacBans_1_13_1_R1.getInstance(), new Runnable() {
            public void run() {
                AdvancedLicense_1_13_1_R1.ValidationType vt = new AdvancedLicense_1_13_1_R1(MacBans_1_13_1_R1.getInstance().getConfig().getString("License-Key").toString(), "https://rload.eu/labscriptadd/verify.php", MacBans_1_13_1_R1.getInstance()).isValid();
                if(
                        vt == vt.KEY_OUTDATED
                                || vt == vt.NOT_VALID_IP
                                || vt == vt.KEY_NOT_FOUND
                                || vt == vt.PAGE_ERROR
                                || vt == vt.URL_ERROR
                ) {
                    Bukkit.getServer().getPluginManager().disablePlugin(MacBans_1_13_1_R1.getInstance());
                    Bukkit.getLogger().info("[]==========[MacBans License]==========[]");
                    Bukkit.getLogger().info("[MacBans] License Not Valid");
                    Bukkit.getLogger().info("[]==========[MacBans License]==========[]");
                }
            }
        }, 1L);

        Player p = e.getPlayer();



        try {




            Statement stmt = SQL.getconnection().createStatement();

            String SQL = "SELECT * FROM bannedaccounts WHERE mac='" + MacAddress_1_13_1_R1.get(p) + "'";

            ResultSet rs = stmt.executeQuery(SQL);

            if(rs.next()){


                if(GetConfig_1_13_1_R1.main().getString("Lang").equals("It")){
                    p.kickPlayer(Format_1_13_1_R1.color(Prefix_1_13_1_R1.get() + Messages_1_13_1_R1.DisconnectBanned()));
                }

                if(GetConfig_1_13_1_R1.main().getString("Lang").equals("En")){
                    p.kickPlayer(Format_1_13_1_R1.color(Prefix_1_13_1_R1.get() + Messages_1_13_1_R1.DisconnectBannedEN()));
                }



            }

        } catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
