package me.skwaraa;

import io.github.cdimascio.dotenv.Dotenv;
import me.skwaraa.sql.MessageSql;
import me.skwaraa.sql.SqlConnector;

public class Main {
    public String dbHost;
    public String dbUser;
    public String dbPass;
    public String dbName;
    public SqlConnector sqlConn;
    public Main() {
        Dotenv dotenv = Dotenv.load();

        dbHost = dotenv.get("DB_HOST");
        dbUser = dotenv.get("DB_USER");
        dbPass = dotenv.get("DB_PASS");
        dbName = dotenv.get("DB_NAME");

        sqlConn = new SqlConnector(this);
    }

    public static void main(String[] args) {
        new Main();
    }
}