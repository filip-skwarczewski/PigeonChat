package me.skwaraa.sql;

import me.skwaraa.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MessageSql {
    private SqlConnector sqlConn;
    private Main main;
    public MessageSql(Main main) {
        this.sqlConn = main.sqlConn;
    }

//    public void createMessage()

    public String getContentById(int messageId) {
        try {
            PreparedStatement ps = sqlConn.conn.prepareStatement("SELECT message FROM messages WHERE messageid = ?");
            ps.setInt(1,messageId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String out = rs.getString(1);
            return out;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAuthorId(int messageId) {
        try {
            PreparedStatement ps = sqlConn.conn.prepareStatement("SELECT senderid FROM messages WHERE messageid = ?");
            ps.setInt(1,messageId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getReceiverId(int messageId) {
        try {
          PreparedStatement ps = sqlConn.conn.prepareStatement("SELECT receiverid FROM messages WHERE messageid = ?");
          ps.setInt(1,messageId);
          ResultSet rs = ps.executeQuery();
          rs.next();
          return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDate(int messageId) {
        try {
            PreparedStatement ps = sqlConn.conn.prepareStatement("SELECT date FROM messages WHERE messageid = ?");
            ps.setInt(1,messageId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
