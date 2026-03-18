package me.skwaraa;

import me.skwaraa.sql.SqlConnector;

public class Main {
    public SqlConnector sqlConn;
    public Main() {
        sqlConn = new SqlConnector();
    }

    public static void main(String[] args) {
        new Main();
    }
}