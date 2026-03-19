package me.skwaraa.sql;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Objects;

public class Config {
    private final String dbHost;
    private final String dbUser;
    private final String dbPass;
    private final String dbName;
    private final int port;
    public Config() {
        Dotenv dotenv = Dotenv.load();

        dbHost = Objects.requireNonNull(dotenv.get("DB_HOST"), "DB_HOST missing from .env");
        dbUser = Objects.requireNonNull(dotenv.get("DB_USER"), "DB_USER missing from .env");
        dbPass = Objects.requireNonNull(dotenv.get("DB_PASS"), "DB_PASS missing from .env");
        dbName = Objects.requireNonNull(dotenv.get("DB_NAME"), "DB_NAME missing from .env");
        try {
            String x = dotenv.get("SRV_PORT");
            port = Integer.parseInt(x);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPort() { return this.port; }

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
