package me.skwaraa.sql;

import me.skwaraa.Main;

import java.sql.*;
import java.time.LocalDateTime;

public class MessageSql {
    private final Connection sqlConn;
    public MessageSql(Main main) {
        this.sqlConn = main.sqlConn.getConn();

    }

    public void deleteMessage(int messageid) {
        try {
            PreparedStatement ps = sqlConn.prepareStatement("DELETE FROM messages WHERE messageid = ?");
            ps.setInt(1,messageid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createMessage(int receiverid, int senderid, String message, String date) {
        try {
            PreparedStatement ps = sqlConn.prepareStatement("INSERT INTO messages(recieverid,senderid,message,date,edited) VALUES(?,?,?,?,FALSE)");
            ps.setInt(1, receiverid);
            ps.setInt(2, senderid);
            ps.setString(3, message);
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String getContentById(int messageId) {
        try {
            try (PreparedStatement ps = sqlConn.prepareStatement("SELECT message FROM messages WHERE messageid = ?")) {
                ps.setInt(1, messageId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString(1);
                    }
                    throw new RuntimeException("No message found with id: " + messageId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAuthorId(int messageId) {
        try {
            try (PreparedStatement ps = sqlConn.prepareStatement("SELECT senderid FROM messages WHERE messageid = ?")) {
                ps.setInt(1, messageId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                    throw new RuntimeException("No message found with id: " + messageId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getReceiverId(int messageId) {
        try {
            try (PreparedStatement ps = sqlConn.prepareStatement("SELECT recieverid FROM messages WHERE messageid = ?")) {
                ps.setInt(1, messageId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                    throw new RuntimeException("No message found with id: " + messageId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDate(int messageId) {
        try {
            try (PreparedStatement ps = sqlConn.prepareStatement("SELECT date FROM messages WHERE messageid = ?")) {
                ps.setInt(1, messageId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString(1);
                    }
                    throw new RuntimeException("No message found with id: " + messageId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
