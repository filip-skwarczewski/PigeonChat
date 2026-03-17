package me.skwaraa.sql;

import me.skwaraa.Main;

import java.sql.*;
import java.util.Properties;

public class SqlConnector {
    public Connection conn;
    public SqlConnector(Main main) {
        String url = String.format("jdbc:postgresql://%s/%s",main.dbHost,main.dbName);
        Properties props = new Properties();
        props.setProperty("user", main.dbUser);
        props.setProperty("password",main.dbPass);
        try {
            conn = DriverManager.getConnection(url,props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
