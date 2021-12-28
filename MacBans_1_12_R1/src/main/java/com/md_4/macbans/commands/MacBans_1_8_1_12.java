package com.md_4.macbans.commands;


import com.md_4.macbans.MacBans_1_8_1_12_R1;
import com.md_4.macbans.functions.MacAddress_1_8_1_12;
import com.md_4.macbans.utils.Format_1_8_1_12;
import com.md_4.macbans.utils.GetConfig_1_8_1_12;
import com.md_4.macbans.utils.Messages_1_8_1_12;
import com.md_4.macbans.utils.Prefix_1_8_1_12;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Statement;

import static com.md_4.macbans.MacBans_1_8_1_12_R1.SQL;

@SuppressWarnings("all")
public class MacBans_1_8_1_12 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if(command.getName().equals("macbans")){

                CommandSender p = sender;

                if(args.length == 0){
                    if(p.hasPermission("MacBans.use")){
                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_8_1_12.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                            p.sendMessage(Format_1_8_1_12.color("&cMacBans &4" + MacBans_1_8_1_12_R1.getInstance().getDescription().getVersion()));
                            p.sendMessage(Format_1_8_1_12.color("&cComandi"));
                            p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans mac &4/ &cmac &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format_1_8_1_12.color("&4#&cOttieni l'indirizzo mac tuo o di altri"));
                            p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans ban &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format_1_8_1_12.color("&4#&cBanna per indirizzo mac"));
                            p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans unban &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format_1_8_1_12.color("&4#&cUnbanna per indirizzo mac"));
                            p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans list"));
                            p.sendMessage(Format_1_8_1_12.color("&4#&cMostra lista giocatori online + mac"));
                            p.sendMessage(Format_1_8_1_12.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        }
                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_8_1_12.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                            p.sendMessage(Format_1_8_1_12.color("&cMacBans &4" + MacBans_1_8_1_12_R1.getInstance().getDescription().getVersion()));
                            p.sendMessage(Format_1_8_1_12.color("&cCommands"));
                            p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans mac &4/ &cmac &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format_1_8_1_12.color("&4#&cGet your or someone else's mac address"));
                            p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans ban &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format_1_8_1_12.color("&4#&cBan for mac address"));
                            p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans unban &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format_1_8_1_12.color("&4#&cUnban for mac address"));
                            p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans list"));
                            p.sendMessage(Format_1_8_1_12.color("&4#&cShow online players list + mac"));
                            p.sendMessage(Format_1_8_1_12.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        }
                    } else {
                        p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDenied()));
                    }
                }
                if(args.length >= 1){
                    if(args[0].equals("mac")){

                        if(p.hasPermission("MacBans.mac")){


                            if(sender instanceof Player){
                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){


                                    String maclocalmsg = Messages_1_8_1_12.MacAddressLocal();
                                    maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress_1_8_1_12.get((Player) sender));

                                    p.sendMessage(Format_1_8_1_12.color(Messages_1_8_1_12.getPrefix() + maclocalmsg));
                                }

                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                    String maclocalmsg = Messages_1_8_1_12.MacAddressLocalEN();
                                    maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress_1_8_1_12.get((Player) sender));

                                    p.sendMessage(Format_1_8_1_12.color(Messages_1_8_1_12.getPrefix() + maclocalmsg));
                                }
                            } else {
                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                    sender.sendMessage(Prefix_1_8_1_12.get() + Messages_1_8_1_12.ConsoleIsNotAPlayer());
                                }

                                if(GetConfig_1_17_R1.main().getString("Lang").equals("En")){
                                    sender.sendMessage(Prefix_1_8_1_12.get() + Messages_1_8_1_12.ConsoleIsNotAPlayerEN());
                                }
                            }


                        } else {

                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDenied()));
                            }

                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDeniedEN()));
                            }

                        }
                    }

                    if(args[0].equals("ban")){

                        if(p.hasPermission("MacBans.ban")){
                            if(args[0].length() == 0){

                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.CommandBanUsage()));
                                }

                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.CommandBanUsageEN()));
                                }


                            }

                            if(args[0].length() >= 1){
                                try {


                                    Statement stmt = SQL.getconnection().createStatement();

                                    Player target = Bukkit.getPlayer(args[1]);

                                    stmt.executeUpdate("INSERT INTO bannedaccounts(mac) VALUES('"+ MacAddress_1_8_1_12.get(target)+"')");

                                    if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                        String banlocalmsg = Messages_1_8_1_12.BanMac();
                                        banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                        p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + banlocalmsg));

                                        target.kickPlayer(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.DisconnectBanned()));
                                    }

                                    if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                        String banlocalmsg = Messages_1_8_1_12.BanMacEN();
                                        banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                        p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + banlocalmsg));

                                        target.kickPlayer(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.DisconnectBannedEN()));
                                    }




                                } catch (Exception ex){
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }

                        } else {
                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDenied()));
                            }

                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDeniedEN()));
                            }
                        }

                    }
                    if(args[0].equals("unban")){

                        if(p.hasPermission("MacBans.unban")){
                            if(args[0].length() == 0){
                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.CommandUnbanUsage()));
                                }

                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.CommandUnbanUsageEN()));
                                }
                            }

                            if(args[0].length() >= 1){
                                try {


                                    Statement stmt = SQL.getconnection().createStatement();

                                    stmt.executeUpdate("DELETE FROM bannedaccounts WHERE mac=('"+args[1]+"')");

                                    if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                        String unbanlocalmsg = Messages_1_8_1_12.UnbanMac();
                                        unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", args[1]);
                                        p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + unbanlocalmsg));
                                    }

                                    if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                        String unbanlocalmsg = Messages_1_8_1_12.UnbanMacEN();
                                        unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", args[1]);
                                        p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + unbanlocalmsg));
                                    }



                                } catch (Exception ex){
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }
                        } else {
                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDenied()));
                            }

                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDeniedEN()));
                            }
                        }
                    }

                }
            }
            return true;
        }
        Player p = (Player) sender;

        if(command.getName().equals("macbans")){
            if(args.length == 0){
                if(p.hasPermission("MacBans.use")){
                    if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                        p.sendMessage(Format_1_8_1_12.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        p.sendMessage(Format_1_8_1_12.color("&cMacBans &4" + MacBans_1_8_1_12_R1.getInstance().getDescription().getVersion()));
                        p.sendMessage(Format_1_8_1_12.color("&cComandi"));
                        p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans mac &4/ &cmac &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format_1_8_1_12.color("&4#&cOttieni l'indirizzo mac tuo o di altri"));
                        p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans ban &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format_1_8_1_12.color("&4#&cBanna per indirizzo mac"));
                        p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans unban &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format_1_8_1_12.color("&4#&cUnbanna per indirizzo mac"));
                        p.sendMessage(Format_1_8_1_12.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                    }
                    if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                        p.sendMessage(Format_1_8_1_12.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        p.sendMessage(Format_1_8_1_12.color("&cMacBans &4" + MacBans_1_8_1_12_R1.getInstance().getDescription().getVersion()));
                        p.sendMessage(Format_1_8_1_12.color("&cCommands"));
                        p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans mac &4/ &cmac &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format_1_8_1_12.color("&4#&cGet your or someone else's mac address"));
                        p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans ban &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format_1_8_1_12.color("&4#&cBan for mac address"));
                        p.sendMessage(Format_1_8_1_12.color("&4/&cmacbans unban &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format_1_8_1_12.color("&4#&cUnban for mac address"));
                        p.sendMessage(Format_1_8_1_12.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                    }
                } else {
                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDenied()));
                }
            }
            if(args.length >= 1){
                if(args[0].equals("mac")){

                    if(p.hasPermission("MacBans.mac")){


                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                            String maclocalmsg = Messages_1_8_1_12.MacAddressLocal();
                            maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress_1_8_1_12.get(p));

                            p.sendMessage(Format_1_8_1_12.color(Messages_1_8_1_12.getPrefix() + maclocalmsg));
                        }

                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                            String maclocalmsg = Messages_1_8_1_12.MacAddressLocalEN();
                            maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress_1_8_1_12.get(p));

                            p.sendMessage(Format_1_8_1_12.color(Messages_1_8_1_12.getPrefix() + maclocalmsg));
                        }


                    } else {

                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDenied()));
                        }

                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDeniedEN()));
                        }

                    }
                }

                if(args[0].equals("ban")){

                    if(p.hasPermission("MacBans.ban")){
                        if(args[0].length() == 0){

                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.CommandBanUsage()));
                            }

                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.CommandBanUsageEN()));
                            }


                        }

                        if(args[0].length() >= 1){
                            try {


                                Statement stmt = SQL.getconnection().createStatement();

                                Player target = Bukkit.getPlayer(args[1]);

                                stmt.executeUpdate("INSERT INTO bannedaccounts(mac) VALUES('"+ MacAddress_1_8_1_12.get(target)+"')");

                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                    String banlocalmsg = Messages_1_8_1_12.BanMac();
                                    banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + banlocalmsg));

                                    target.kickPlayer(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.DisconnectBanned()));
                                }

                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                    String banlocalmsg = Messages_1_8_1_12.BanMacEN();
                                    banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + banlocalmsg));

                                    target.kickPlayer(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.DisconnectBannedEN()));
                                }




                            } catch (Exception ex){
                                System.out.println("Error: " + ex.getMessage());
                            }
                    }

                    } else {
                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDenied()));
                        }

                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDeniedEN()));
                        }
                    }

                }
                if(args[0].equals("unban")){

                    if(p.hasPermission("MacBans.unban")){
                        if(args[0].length() == 0){
                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.CommandUnbanUsage()));
                            }

                            if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.CommandUnbanUsageEN()));
                            }
                        }

                        if(args[0].length() >= 1){
                            try {


                                Statement stmt = SQL.getconnection().createStatement();

                                Player target = Bukkit.getPlayer(args[1]);

                                stmt.executeUpdate("DELETE FROM bannedaccounts WHERE mac=('"+ MacAddress_1_8_1_12.get(target)+"')");

                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                                    String unbanlocalmsg = Messages_1_8_1_12.UnbanMac();
                                    unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + unbanlocalmsg));
                                }

                                if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                                    String unbanlocalmsg = Messages_1_8_1_12.UnbanMacEN();
                                    unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + unbanlocalmsg));
                                }



                            } catch (Exception ex){
                                System.out.println("Error: " + ex.getMessage());
                            }
                        }
                    } else {
                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDenied()));
                        }

                        if(GetConfig_1_8_1_12.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_8_1_12.color(Prefix_1_8_1_12.get() + Messages_1_8_1_12.AccessDeniedEN()));
                        }
                    }
                }

            }
        }

        return false;
    }
}
