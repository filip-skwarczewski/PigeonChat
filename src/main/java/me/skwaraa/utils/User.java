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

}
