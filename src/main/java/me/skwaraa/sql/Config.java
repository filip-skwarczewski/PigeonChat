package me.skwaraa.sql;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private final String dbHost;
    private final String dbUser;
    private final String dbPass;
    private final String dbName;
    public Config() {
        Dotenv dotenv = Dotenv.load();

        dbHost = dotenv.get("DB_HOST");
        dbUser = dotenv.get("DB_USER");
        dbPass = dotenv.get("DB_PASS");
        dbName = dotenv.get("DB_NAME");

    }

//    Returns the hostname of the SQL server
    public String getHost() {
        return this.dbHost;
    }

//    Returns the username of the SQL server
    public String getUser() {
        return this.dbUser;
    }

//    Returns the password of the SQL server
    public String getPass() {
        return this.dbPass;
    }

//    Returns the database name of the SQL server
    public String getName() {
        return this.dbName;
    }
}
