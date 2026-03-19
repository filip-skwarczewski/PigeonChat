package me.skwaraa.utils;

import me.skwaraa.Main;
import me.skwaraa.sql.user.UserSQL;

public class User {
    private int userId;
    private final UserSQL uSql;

    public User(int userId, Main main) {
        this.userId = userId;
        uSql = new UserSQL(main);
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUsername() {
        return uSql.getUsernameById(userId);
    }

    public String getDisplayName() {
        return uSql.getDisplayNameById(userId);
    }

    public String getEmail() {
        return uSql.getEmail(userId);
    }
    
}
