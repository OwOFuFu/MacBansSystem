package com.md_4.macbans.sql;


import com.md_4.macbans.utils.GetConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SuppressWarnings("all")
public class MySQL {

    private String host = GetConfig.main().getString("Host");
    private String port = GetConfig.main().getString("Port");
    private String database = GetConfig.main().getString("DataBase");
    private String username = GetConfig.main().getString("UserName");
    private String password = GetConfig.main().getString("Password");

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if(!isConnected()){
            Class.forName("com.mysql.cj.jdbc.Driver");



            connection = DriverManager.getConnection("jdbc:mysql://" +
                            host + ":" + port + "/" + database,
                    username, password);
        }
    }

    public void disconnect() {
        if(isConnected()){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Connection getconnection() {
        return connection;
    }

}
