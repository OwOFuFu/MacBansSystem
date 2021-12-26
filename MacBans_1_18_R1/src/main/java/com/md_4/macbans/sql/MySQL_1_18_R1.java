package com.md_4.macbans.sql;



import com.md_4.macbans.utils.GetConfig_1_18_R1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SuppressWarnings("all")
public class MySQL_1_18_R1 {

    private String host = GetConfig_1_18_R1.main().getString("Host");
    private String port = GetConfig_1_18_R1.main().getString("Port");
    private String database = GetConfig_1_18_R1.main().getString("DataBase");
    private String username = GetConfig_1_18_R1.main().getString("UserName");
    private String password = GetConfig_1_18_R1.main().getString("Password");

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
