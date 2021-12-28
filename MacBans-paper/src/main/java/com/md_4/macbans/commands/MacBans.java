package com.md_4.macbans.commands;

import com.md_4.macbans.MacBans_1_17_R1;
import com.md_4.macbans.functions.MacAddress;
import com.md_4.macbans.utils.Format;
import com.md_4.macbans.utils.GetConfig;
import com.md_4.macbans.utils.Messages;
import com.md_4.macbans.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Statement;
import java.util.Set;

import static com.md_4.macbans.MacBans_1_17_R1.SQL;
import static com.md_4.macbans.events.CheckJoin.getJoinedPlayers;

@SuppressWarnings("all")
public class MacBans implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if(command.getName().equals("macbans")){

                CommandSender p = sender;

                if(args.length == 0){
                    if(p.hasPermission("MacBans.use")){
                        if(GetConfig.main().getString("Lang").equals("It")){
                            p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                            p.sendMessage(Format.color("&cMacBans &4" + MacBans_1_17_R1.getInstance().getDescription().getVersion()));
                            p.sendMessage(Format.color("&cComandi"));
                            p.sendMessage(Format.color("&4/&cmacbans mac &4/ &cmac &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format.color("&4#&cOttieni l'indirizzo mac tuo o di altri"));
                            p.sendMessage(Format.color("&4/&cmacbans ban &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format.color("&4#&cBanna per indirizzo mac"));
                            p.sendMessage(Format.color("&4/&cmacbans unban &4<&cNomePlayer&4>&c"));
                            p.sendMessage(Format.color("&4#&cUnbanna per indirizzo mac"));
                            p.sendMessage(Format.color("&4/&cmacbans list"));
                            p.sendMessage(Format.color("&4#&cMostra lista giocatori online + mac"));
                            p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        }
                        if(GetConfig.main().getString("Lang").equals("En")){
                            p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                            p.sendMessage(Format.color("&cMacBans &4" + MacBans_1_17_R1.getInstance().getDescription().getVersion()));
                            p.sendMessage(Format.color("&cCommands"));
                            p.sendMessage(Format.color("&4/&cmacbans mac &4/ &cmac &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format.color("&4#&cGet your or someone else's mac address"));
                            p.sendMessage(Format.color("&4/&cmacbans ban &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format.color("&4#&cBan for mac address"));
                            p.sendMessage(Format.color("&4/&cmacbans unban &4<&cPlayerName&4>&c"));
                            p.sendMessage(Format.color("&4#&cUnban for mac address"));
                            p.sendMessage(Format.color("&4/&cmacbans list"));
                            p.sendMessage(Format.color("&4#&cShow online players list + mac"));
                            p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        }
                    } else {
                        p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                    }
                }
                if(args.length >= 1){
                    if(args[0].equals("mac")){

                        if(p.hasPermission("MacBans.mac")){


                            if(sender instanceof Player){
                                if(GetConfig.main().getString("Lang").equals("It")){


                                    String maclocalmsg = Messages.MacAddressLocal();
                                    maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress.get((Player) sender));

                                    p.sendMessage(Format.color(Messages.getPrefix() + maclocalmsg));
                                }

                                if(GetConfig.main().getString("Lang").equals("En")){
                                    String maclocalmsg = Messages.MacAddressLocalEN();
                                    maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress.get((Player) sender));

                                    p.sendMessage(Format.color(Messages.getPrefix() + maclocalmsg));
                                }
                            } else {
                                if(GetConfig.main().getString("Lang").equals("It")){
                                    sender.sendMessage(Prefix.get() + Messages.ConsoleIsNotAPlayer());
                                }

                                if(GetConfig.main().getString("Lang").equals("En")){
                                    sender.sendMessage(Prefix.get() + Messages.ConsoleIsNotAPlayerEN());
                                }
                            }


                        } else {

                            if(GetConfig.main().getString("Lang").equals("It")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                            }

                            if(GetConfig.main().getString("Lang").equals("En")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.AccessDeniedEN()));
                            }

                        }
                    }

                    if(args[0].equals("ban")){

                        if(p.hasPermission("MacBans.ban")){
                            if(args[0].length() == 0){

                                if(GetConfig.main().getString("Lang").equals("It")){
                                    p.sendMessage(Format.color(Prefix.get() + Messages.CommandBanUsage()));
                                }

                                if(GetConfig.main().getString("Lang").equals("En")){
                                    p.sendMessage(Format.color(Prefix.get() + Messages.CommandBanUsageEN()));
                                }


                            }

                            if(args[0].length() >= 1){
                                try {


                                    Statement stmt = SQL.getconnection().createStatement();

                                    Player target = Bukkit.getPlayer(args[1]);

                                    stmt.executeUpdate("INSERT INTO bannedaccounts(mac) VALUES('"+MacAddress.get(target)+"')");

                                    if(GetConfig.main().getString("Lang").equals("It")){
                                        String banlocalmsg = Messages.BanMac();
                                        banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                        p.sendMessage(Format.color(Prefix.get() + banlocalmsg));

                                        target.kickPlayer(Format.color(Prefix.get() + Messages.DisconnectBanned()));
                                    }

                                    if(GetConfig.main().getString("Lang").equals("En")){
                                        String banlocalmsg = Messages.BanMacEN();
                                        banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                        p.sendMessage(Format.color(Prefix.get() + banlocalmsg));

                                        target.kickPlayer(Format.color(Prefix.get() + Messages.DisconnectBannedEN()));
                                    }




                                } catch (Exception ex){
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }

                        } else {
                            if(GetConfig.main().getString("Lang").equals("It")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                            }

                            if(GetConfig.main().getString("Lang").equals("En")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.AccessDeniedEN()));
                            }
                        }

                    }
                    if(args[0].equals("unban")){

                        if(p.hasPermission("MacBans.unban")){
                            if(args[0].length() == 0){
                                if(GetConfig.main().getString("Lang").equals("It")){
                                    p.sendMessage(Format.color(Prefix.get() + Messages.CommandUnbanUsage()));
                                }

                                if(GetConfig.main().getString("Lang").equals("En")){
                                    p.sendMessage(Format.color(Prefix.get() + Messages.CommandUnbanUsageEN()));
                                }
                            }

                            if(args[0].length() >= 1){
                                try {


                                    Statement stmt = SQL.getconnection().createStatement();

                                    stmt.executeUpdate("DELETE FROM bannedaccounts WHERE mac=('"+args[1]+"')");

                                    if(GetConfig.main().getString("Lang").equals("It")){
                                        String unbanlocalmsg = Messages.UnbanMac();
                                        unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", args[1]);
                                        p.sendMessage(Format.color(Prefix.get() + unbanlocalmsg));
                                    }

                                    if(GetConfig.main().getString("Lang").equals("En")){
                                        String unbanlocalmsg = Messages.UnbanMacEN();
                                        unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", args[1]);
                                        p.sendMessage(Format.color(Prefix.get() + unbanlocalmsg));
                                    }



                                } catch (Exception ex){
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }
                        } else {
                            if(GetConfig.main().getString("Lang").equals("It")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                            }

                            if(GetConfig.main().getString("Lang").equals("En")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.AccessDeniedEN()));
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
                    if(GetConfig.main().getString("Lang").equals("It")){
                        p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        p.sendMessage(Format.color("&cMacBans &4" + MacBans_1_17_R1.getInstance().getDescription().getVersion()));
                        p.sendMessage(Format.color("&cComandi"));
                        p.sendMessage(Format.color("&4/&cmacbans mac &4/ &cmac &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format.color("&4#&cOttieni l'indirizzo mac tuo o di altri"));
                        p.sendMessage(Format.color("&4/&cmacbans ban &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format.color("&4#&cBanna per indirizzo mac"));
                        p.sendMessage(Format.color("&4/&cmacbans unban &4<&cNomePlayer&4>&c"));
                        p.sendMessage(Format.color("&4#&cUnbanna per indirizzo mac"));
                        p.sendMessage(Format.color("&4/&cmacbans list"));
                        p.sendMessage(Format.color("&4#&cMostra lista giocatori online + mac"));
                        p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                    }
                    if(GetConfig.main().getString("Lang").equals("En")){
                        p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                        p.sendMessage(Format.color("&cMacBans &4" + MacBans_1_17_R1.getInstance().getDescription().getVersion()));
                        p.sendMessage(Format.color("&cCommands"));
                        p.sendMessage(Format.color("&4/&cmacbans mac &4/ &cmac &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format.color("&4#&cGet your or someone else's mac address"));
                        p.sendMessage(Format.color("&4/&cmacbans ban &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format.color("&4#&cBan for mac address"));
                        p.sendMessage(Format.color("&4/&cmacbans unban &4<&cPlayerName&4>&c"));
                        p.sendMessage(Format.color("&4#&cUnban for mac address"));
                        p.sendMessage(Format.color("&4/&cmacbans list"));
                        p.sendMessage(Format.color("&4#&cShow online players list + mac"));
                        p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                    }
                } else {
                    p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                }
            }
            if(args.length >= 1){
                if(args[0].equals("mac")){

                    if(p.hasPermission("MacBans.mac")){


                        if(GetConfig.main().getString("Lang").equals("It")){
                            String maclocalmsg = Messages.MacAddressLocal();
                            maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress.get(p));

                            p.sendMessage(Format.color(Messages.getPrefix() + maclocalmsg));
                        }

                        if(GetConfig.main().getString("Lang").equals("En")){
                            String maclocalmsg = Messages.MacAddressLocalEN();
                            maclocalmsg = maclocalmsg.replaceAll("%mac_address_local%", MacAddress.get(p));

                            p.sendMessage(Format.color(Messages.getPrefix() + maclocalmsg));
                        }


                    } else {

                        if(GetConfig.main().getString("Lang").equals("It")){
                            p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                        }

                        if(GetConfig.main().getString("Lang").equals("En")){
                            p.sendMessage(Format.color(Prefix.get() + Messages.AccessDeniedEN()));
                        }

                    }
                }

                if(args[0].equals("ban")){

                    if(p.hasPermission("MacBans.ban")){
                        if(args[0].length() == 0){

                            if(GetConfig.main().getString("Lang").equals("It")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.CommandBanUsage()));
                            }

                            if(GetConfig.main().getString("Lang").equals("En")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.CommandBanUsageEN()));
                            }


                        }

                        if(args[0].length() >= 1){
                            try {


                                Statement stmt = SQL.getconnection().createStatement();

                                Player target = Bukkit.getPlayer(args[1]);

                                stmt.executeUpdate("INSERT INTO bannedaccounts(mac) VALUES('"+MacAddress.get(target)+"')");

                                if(GetConfig.main().getString("Lang").equals("It")){
                                    String banlocalmsg = Messages.BanMac();
                                    banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format.color(Prefix.get() + banlocalmsg));

                                    target.kickPlayer(Format.color(Prefix.get() + Messages.DisconnectBanned()));
                                }

                                if(GetConfig.main().getString("Lang").equals("En")){
                                    String banlocalmsg = Messages.BanMacEN();
                                    banlocalmsg = banlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format.color(Prefix.get() + banlocalmsg));

                                    target.kickPlayer(Format.color(Prefix.get() + Messages.DisconnectBannedEN()));
                                }




                            } catch (Exception ex){
                                System.out.println("Error: " + ex.getMessage());
                            }
                    }

                    } else {
                        if(GetConfig.main().getString("Lang").equals("It")){
                            p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                        }

                        if(GetConfig.main().getString("Lang").equals("En")){
                            p.sendMessage(Format.color(Prefix.get() + Messages.AccessDeniedEN()));
                        }
                    }

                }
                if(args[0].equals("unban")){

                    if(p.hasPermission("MacBans.unban")){
                        if(args[0].length() == 0){
                            if(GetConfig.main().getString("Lang").equals("It")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.CommandUnbanUsage()));
                            }

                            if(GetConfig.main().getString("Lang").equals("En")){
                                p.sendMessage(Format.color(Prefix.get() + Messages.CommandUnbanUsageEN()));
                            }
                        }

                        if(args[0].length() >= 1){
                            try {


                                Statement stmt = SQL.getconnection().createStatement();

                                Player target = Bukkit.getPlayer(args[1]);

                                stmt.executeUpdate("DELETE FROM bannedaccounts WHERE mac=('"+MacAddress.get(target)+"')");

                                if(GetConfig.main().getString("Lang").equals("It")){
                                    String unbanlocalmsg = Messages.UnbanMac();
                                    unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format.color(Prefix.get() + unbanlocalmsg));
                                }

                                if(GetConfig.main().getString("Lang").equals("En")){
                                    String unbanlocalmsg = Messages.UnbanMacEN();
                                    unbanlocalmsg = unbanlocalmsg.replaceAll("%player_name%", target.getName());
                                    p.sendMessage(Format.color(Prefix.get() + unbanlocalmsg));
                                }



                            } catch (Exception ex){
                                System.out.println("Error: " + ex.getMessage());
                            }
                        }
                    } else {
                        if(GetConfig.main().getString("Lang").equals("It")){
                            p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                        }

                        if(GetConfig.main().getString("Lang").equals("En")){
                            p.sendMessage(Format.color(Prefix.get() + Messages.AccessDeniedEN()));
                        }
                    }
                }

                if(args[0].equals("list")){
                    if(p.hasPermission("MacBans.list")){


                        Set keys = getJoinedPlayers.keySet();

                        for(Object key : keys){ // TODO : ADDED MACBANS LIST

                            if(GetConfig.main().getString("Lang").equals("It")){

                                p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                                p.sendMessage(Format.color("&c&lLista Giocatori Online"));
                                p.sendMessage("");
                                p.sendMessage(Format.color("&4" + key.toString() + " &c&l➟ &4" + getJoinedPlayers.get(key).toString() + "\n"));
                                p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));


                            }

                            if(GetConfig.main().getString("Lang").equals("En")){
                                p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                                p.sendMessage(Format.color("&c&lOnline Players List"));
                                p.sendMessage("");
                                p.sendMessage(Format.color("&4" + key.toString() + " &c&l➟ &4" + getJoinedPlayers.get(key).toString() + "\n"));
                                p.sendMessage(Format.color("&c▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                            }
                        }
                    } else {
                        if(GetConfig.main().getString("Lang").equals("It")){
                            p.sendMessage(Format.color(Prefix.get() + Messages.AccessDenied()));
                        }

                        if(GetConfig.main().getString("Lang").equals("En")){
                            p.sendMessage(Format.color(Prefix.get() + Messages.AccessDeniedEN()));
                        }
                    }
                }

            }
        }

        return false;
    }
}
