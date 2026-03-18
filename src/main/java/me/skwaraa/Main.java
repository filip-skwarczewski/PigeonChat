package me.skwaraa;

import me.skwaraa.sql.SqlConnector;
import me.skwaraa.utils.Message;

public class Main {
    public SqlConnector sqlConn;
    private Message message;
    public Main() {

        message = new Message(1,this);
        System.out.println(message.getContent());
    }

    public static void main(String[] args) {
        new Main();
    }
}