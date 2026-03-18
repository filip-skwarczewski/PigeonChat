package me.skwaraa.sql;


import java.sql.*;
import java.util.Properties;

public class SqlConnector {
    private final Connection conn;
    public SqlConnector() {
        Config config = new Config();

        String url = String.format("jdbc:postgresql://%s/%s",config.getHost(),config.getName());
        Properties props = new Properties();
        props.setProperty("user", config.getUser());
        props.setProperty("password", config.getPass());
        try {
            conn = DriverManager.getConnection(url,props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConn() {
        return this.conn;
    }

    public void close() throws SQLException {
        if(conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
