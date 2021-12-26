package com.md_4.macbans.functions;


import org.bukkit.entity.Player;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.sql.Statement;

import static com.md_4.macbans.MacBans_1_14_3_R1.SQL;

@SuppressWarnings("all")
public class MacAddress_1_14_3_R1 {
    public static String get(Player p){
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getByName(p.getAddress().getHostName()).getLocalHost(); //InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        NetworkInterface ni = null;
        try {
            ni = NetworkInterface.getByInetAddress(localHost);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] hardwareAddress = new byte[0];
        try {
            hardwareAddress = ni.getHardwareAddress();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        String[] hexadecimal = new String[hardwareAddress.length];
        for (int i = 0; i < hardwareAddress.length; i++) {
            hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
        }
        String macAddress = String.join("-", hexadecimal);

        return macAddress;
    }

    public static void createTable() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "bannedaccounts"
                + "(mac VARCHAR(20))";

        Statement stmt = SQL.getconnection().createStatement();
        stmt.execute(sqlCreate);
    }
}
