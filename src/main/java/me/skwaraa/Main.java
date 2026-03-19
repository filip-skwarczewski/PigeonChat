package me.skwaraa;

import me.skwaraa.sql.SqlConnector;
import me.skwaraa.sql.user.UserSQL;
import me.skwaraa.webapi.ApiServer;

public class Main {
    public SqlConnector sqlConn;
    public static UserSQL uSql;
    public Main() {
        sqlConn = new SqlConnector();
        uSql = new UserSQL(this);
    }

    public static void main(String[] args) {
        new Main();
        ApiServer apiServer = new ApiServer();
        Thread apiThread = new Thread(apiServer);
        apiThread.start();
        System.out.println("API Server initalized!");
    }
}