package me.skwaraa;

import me.skwaraa.sql.MessageSql;
import me.skwaraa.sql.SqlConnector;

import java.sql.SQLException;

public class Main {
    public SqlConnector sqlConn;
    public Main() {
        sqlConn = new SqlConnector();
    }

    public static void main(String[] args) {
        new Main();
    }
}