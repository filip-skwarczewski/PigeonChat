package me.skwaraa.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MessageSql {
    private SqlConnector sqlConn;

    public MessageSql(SqlConnector sqlConn) {
        this.sqlConn = sqlConn;
    }

    public String getContentById(int messageId) {
        try {
            Statement st = sqlConn.conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT message FROM messages WHERE messageid = %s",messageId));
            rs.next();
            String out = rs.getString(1);
            return out;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAuthorId(int messageId) {
        try {
            Statement st = sqlConn.conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT senderid FROM messages WHERE messageid = %s",messageId));
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getReceiverId(int messageId) {
        try {
          Statement st = sqlConn.conn.createStatement();
          ResultSet rs = st.executeQuery(String.format("SELECT recieverid FROM messages WHERE messageid = %s",messageId));
          rs.next();
          return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDate(int messageId) {
        try {
            Statement st = sqlConn.conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT date FROM messages WHERE messageid = %s",messageId));
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
