package com.md_4.macbans.commands;


import com.md_4.macbans.functions.MacAddress_1_14_R1;
import com.md_4.macbans.utils.Format_1_14_R1;
import com.md_4.macbans.utils.GetConfig_1_14_R1;
import com.md_4.macbans.utils.Messages_1_14_R1;
import com.md_4.macbans.utils.Prefix_1_14_R1;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Statement;
import java.util.Set;

import static com.md_4.macbans.MacBans_1_14_R1.SQL;
import static com.md_4.macbans.events.CheckJoin_1_14_R1.getJoinedPlayers;

@SuppressWarnings("all")
public class MacBans_1_14_R1 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if(command.getName().equals("macbans")){

                CommandSender p = sender;

                if(args.length == 0){
                    if(p.hasPermission("MacBans.use")){
                        if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                            p.sendMessage(Format_1_14_R1.color("&cMacBans &4" + com.md_4.macbans.MacBans_1_14_R1.getInstance().getDescription().getVersion()));
                            p.sendMessage(Format_1_14_R1.color("&cComandi"));
                            p.sendMessage(Format_1_14_R1.color("&4/&cmacbans mac &4/ &cmac &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format_1_14_R1.color("&4#&cOttieni l'indirizzo mac tuo o di altri"));
                            p.sendMessage(Format_1_14_R1.color("&4/&cmacbans ban &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format_1_14_R1.color("&4#&cBanna per indirizzo mac"));
                            p.sendMessage(Format_1_14_R1.color("&4/&cmacbans unban &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format_1_14_R1.color("&4#&cUnbanna per indirizzo mac"));
                            p.sendMessage(Format_1_14_R1.color("&4/&cmacbans list"));
                            p.sendMessage(Format_1_14_R1.color("&4#&cMostra lista giocatori online + mac"));
                            p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        }
                        if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                            p.sendMessage(Format_1_14_R1.color("&cMacBans &4" + com.md_4.macbans.MacBans_1_14_R1.getInstance().getDescription().getVersion()));
                            p.sendMessage(Format_1_14_R1.color("&cCommands"));
                            p.sendMessage(Format_1_14_R1.color("&4/&cmacbans mac &4/ &cmac &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format_1_14_R1.color("&4#&cGet your or someone else's mac address"));
                            p.sendMessage(Format_1_14_R1.color("&4/&cmacbans ban &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format_1_14_R1.color("&4#&cBan for mac address"));
                            p.sendMessage(Format_1_14_R1.color("&4/&cmacbans unban &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format_1_14_R1.color("&4#&cUnban for mac address"));
                            p.sendMessage(Format_1_14_R1.color("&4/&cmacbans list"));
                            p.sendMessage(Format_1_14_R1.color("&4#&cShow online players list + mac"));
                            p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        }
                    } else {

                        if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                            sender.sendMessage(Prefix_1_14_R1.get() + Messages_1_14_R1.ConsoleIsNotAPlayer());
                        }

                        if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                            sender.sendMessage(Prefix_1_14_R1.get() + Messages_1_14_R1.ConsoleIsNotAPlayerEN());
                        }
                    }
                }
                if(args.length >= 1){
                    if(args[0].equals("mac")){

                        if(p.hasPermission("MacBans.mac")){


                            if(sender instanceof Player){
                                if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){


                                    String maclocalmsg = Messages_1_14_R1.MacAddressLocal();
                                    maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress_1_14_R1.get((Player) sender));

                                    p.sendMessage(Format_1_14_R1.color(Messages_1_14_R1.getPrefix() + maclocalmsg));
                                }

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                    String maclocalmsg = Messages_1_14_R1.MacAddressLocalEN();
                                    maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress_1_14_R1.get((Player) sender));

                                    p.sendMessage(Format_1_14_R1.color(Messages_1_14_R1.getPrefix() + maclocalmsg));
                                }
                            } else {
                                if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                    sender.sendMessage(Prefix_1_14_R1.get() + Messages_1_14_R1.ConsoleIsNotAPlayer());
                                }

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                    sender.sendMessage(Prefix_1_14_R1.get() + Messages_1_14_R1.ConsoleIsNotAPlayerEN());
                                }
                            }


                        } else {

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDenied()));
                            }

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDeniedEN()));
                            }

                        }
                    }

                    if(args[0].equals("ban")){

                        if(p.hasPermission("MacBans.ban")){
                            if(args[0].length() == 0){

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.CommandBanUsage()));
                                }

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.CommandBanUsageEN()));
                                }


                            }

                            if(args[0].length() >= 1){
                                try {


                                    Statement stmt = SQL.getconnection().createStatement();

                                    Player target = Bukkit.getPlayer(args[1]);

                                    stmt.executeUpdate("INSERT INTO bannedaccounts(mac) VALUES('"+ MacAddress_1_14_R1.get(target)+"')");

                                    if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                        String banlocalmsg = Messages_1_14_R1.BanMac();
                                        banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                        p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + banlocalmsg));

                                        target.kickPlayer(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.DisconnectBanned()));
                                    }

                                    if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                        String banlocalmsg = Messages_1_14_R1.BanMacEN();
                                        banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                        p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + banlocalmsg));

                                        target.kickPlayer(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.DisconnectBannedEN()));
                                    }




                                } catch (Exception ex){
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }

                        } else {
                            if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDenied()));
                            }

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDeniedEN()));
                            }
                        }

                    }
                    if(args[0].equals("unban")){

                        if(p.hasPermission("MacBans.unban")){
                            if(args[0].length() == 0){
                                if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.CommandUnbanUsage()));
                                }

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.CommandUnbanUsageEN()));
                                }
                            }

                            if(args[0].length() >= 1){
                                try {


                                    Statement stmt = SQL.getconnection().createStatement();

                                    stmt.executeUpdate("DELETE FROM bannedaccounts WHERE mac=('"+args[1]+"')");

                                    if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                        String unbanlocalmsg = Messages_1_14_R1.UnbanMac();
                                        unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", args[1]);
                                        p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + unbanlocalmsg));
                                    }

                                    if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                        String unbanlocalmsg = Messages_1_14_R1.UnbanMacEN();
                                        unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", args[1]);
                                        p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + unbanlocalmsg));
                                    }



                                } catch (Exception ex){
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }
                        } else {
                            if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDenied()));
                            }

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDeniedEN()));
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
                    if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                        p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        p.sendMessage(Format_1_14_R1.color("&cMacBans &4" + com.md_4.macbans.MacBans_1_14_R1.getInstance().getDescription().getVersion()));
                        p.sendMessage(Format_1_14_R1.color("&cComandi"));
                        p.sendMessage(Format_1_14_R1.color("&4/&cmacbans mac &4/ &cmac &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format_1_14_R1.color("&4#&cOttieni l'indirizzo mac tuo o di altri"));
                        p.sendMessage(Format_1_14_R1.color("&4/&cmacbans ban &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format_1_14_R1.color("&4#&cBanna per indirizzo mac"));
                        p.sendMessage(Format_1_14_R1.color("&4/&cmacbans unban &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format_1_14_R1.color("&4#&cUnbanna per indirizzo mac"));
                        p.sendMessage(Format_1_14_R1.color("&4/&cmacbans list"));
                        p.sendMessage(Format_1_14_R1.color("&4#&cMostra lista giocatori online + mac"));
                        p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                    }
                    if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                        p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        p.sendMessage(Format_1_14_R1.color("&cMacBans &4" + com.md_4.macbans.MacBans_1_14_R1.getInstance().getDescription().getVersion()));
                        p.sendMessage(Format_1_14_R1.color("&cCommands"));
                        p.sendMessage(Format_1_14_R1.color("&4/&cmacbans mac &4/ &cmac &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format_1_14_R1.color("&4#&cGet your or someone else's mac address"));
                        p.sendMessage(Format_1_14_R1.color("&4/&cmacbans ban &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format_1_14_R1.color("&4#&cBan for mac address"));
                        p.sendMessage(Format_1_14_R1.color("&4/&cmacbans unban &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format_1_14_R1.color("&4#&cUnban for mac address"));
                        p.sendMessage(Format_1_14_R1.color("&4/&cmacbans list"));
                        p.sendMessage(Format_1_14_R1.color("&4#&cShow online players list + mac"));
                        p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                    }
                } else {
                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDenied()));
                }
            }
            if(args.length >= 1){
                if(args[0].equals("mac")){

                    if(p.hasPermission("MacBans.mac")){


                        if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                            String maclocalmsg = Messages_1_14_R1.MacAddressLocal();
                            maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress_1_14_R1.get(p));

                            p.sendMessage(Format_1_14_R1.color(Messages_1_14_R1.getPrefix() + maclocalmsg));
                        }

                        if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                            String maclocalmsg = Messages_1_14_R1.MacAddressLocalEN();
                            maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress_1_14_R1.get(p));

                            p.sendMessage(Format_1_14_R1.color(Messages_1_14_R1.getPrefix() + maclocalmsg));
                        }


                    } else {

                        if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDenied()));
                        }

                        if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDeniedEN()));
                        }

                    }
                }

                if(args[0].equals("ban")){

                    if(p.hasPermission("MacBans.ban")){
                        if(args[0].length() == 0){

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.CommandBanUsage()));
                            }

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.CommandBanUsageEN()));
                            }


                        }

                        if(args[0].length() >= 1){
                            try {


                                Statement stmt = SQL.getconnection().createStatement();

                                Player target = Bukkit.getPlayer(args[1]);

                                stmt.executeUpdate("INSERT INTO bannedaccounts(mac) VALUES('"+ MacAddress_1_14_R1.get(target)+"')");

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                    String banlocalmsg = Messages_1_14_R1.BanMac();
                                    banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + banlocalmsg));

                                    target.kickPlayer(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.DisconnectBanned()));
                                }

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                    String banlocalmsg = Messages_1_14_R1.BanMacEN();
                                    banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + banlocalmsg));

                                    target.kickPlayer(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.DisconnectBannedEN()));
                                }




                            } catch (Exception ex){
                                System.out.println("Error: " + ex.getMessage());
                            }
                    }

                    } else {
                        if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDenied()));
                        }

                        if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDeniedEN()));
                        }
                    }

                }
                if(args[0].equals("unban")){

                    if(p.hasPermission("MacBans.unban")){
                        if(args[0].length() == 0){
                            if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.CommandUnbanUsage()));
                            }

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.CommandUnbanUsageEN()));
                            }
                        }

                        if(args[0].length() >= 1){
                            try {


                                Statement stmt = SQL.getconnection().createStatement();

                                Player target = Bukkit.getPlayer(args[1]);

                                stmt.executeUpdate("DELETE FROM bannedaccounts WHERE mac=('"+ MacAddress_1_14_R1.get(target)+"')");

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                                    String unbanlocalmsg = Messages_1_14_R1.UnbanMac();
                                    unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + unbanlocalmsg));
                                }

                                if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                    String unbanlocalmsg = Messages_1_14_R1.UnbanMacEN();
                                    unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + unbanlocalmsg));
                                }



                            } catch (Exception ex){
                                System.out.println("Error: " + ex.getMessage());
                            }
                        }
                    } else {
                        if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDenied()));
                        }

                        if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDeniedEN()));
                        }
                    }
                }

                if(args[0].equals("list")){
                    if(p.hasPermission("MacBans.list")){


                        Set keys = getJoinedPlayers.keySet();

                        for(Object key : keys){ // TODO : ADDED MACBANS LIST

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){

                                p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                                p.sendMessage(Format_1_14_R1.color("&c&lLista Giocatori Online"));
                                p.sendMessage("");
                                p.sendMessage(Format_1_14_R1.color("&4" + key.toString() + " &c&l➟ &4" + getJoinedPlayers.get(key).toString() + "\n"));
                                p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));


                            }

                            if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                                p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                                p.sendMessage(Format_1_14_R1.color("&c&lOnline Players List"));
                                p.sendMessage("");
                                p.sendMessage(Format_1_14_R1.color("&4" + key.toString() + " &c&l➟ &4" + getJoinedPlayers.get(key).toString() + "\n"));
                                p.sendMessage(Format_1_14_R1.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                            }
                        }
                    } else {
                        if(GetConfig_1_14_R1.main().getString("Lang").equals("It")){
                            p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDenied()));
                        }

                        if(GetConfig_1_14_R1.main().getString("Lang").equals("En")){
                            p.sendMessage(Format_1_14_R1.color(Prefix_1_14_R1.get() + Messages_1_14_R1.AccessDeniedEN()));
                        }
                    }
                }

            }
        }

        return false;
    }
}
