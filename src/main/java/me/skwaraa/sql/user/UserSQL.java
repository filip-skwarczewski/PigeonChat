package me.skwaraa.sql.user;

import me.skwaraa.Main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSQL {
    private final Connection sqlConn;
    public UserSQL(Main main) {
        this.sqlConn = main.sqlConn.getConn();
    }

    private boolean checkIfUsernameAvailable(String username) {
        try {
            try(PreparedStatement ps = sqlConn.prepareStatement("SELECT username FROM users")) {
                try(ResultSet rs = ps.executeQuery()) {
                    while(rs.next()) {
                        if(rs.getString(1).equals(hashPassword(username))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsernameById(int userid) {
        try {
            try(PreparedStatement ps = sqlConn.prepareStatement("SELECT username FROM users WHERE userid = ?")) {
                ps.setInt(1,userid);
                try(ResultSet rs = ps.executeQuery()) {
                    if(rs.next()) {
                        return rs.getString(1);
                    }
                    throw new RuntimeException("No user found with id: " + userid);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDisplayNameById(int userid) {
        try {
            try(PreparedStatement ps = sqlConn.prepareStatement("SELECT displayname FROM users WHERE userid = ?")) {
                ps.setInt(1, userid);
                try(ResultSet rs = ps.executeQuery()) {
                    if(rs.next()) {
                        return rs.getString(1);
                    }
                    throw new RuntimeException("No user found with id: " + userid);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmail(int userid) {
        try {
            try(PreparedStatement ps = sqlConn.prepareStatement("SELECT email FROM users WHERE userid = ?")) {
                ps.setInt(1,userid);
                try(ResultSet rs = ps.executeQuery()) {
                    if(rs.next()) {
                        return rs.getString(1);
                    }
                    throw new RuntimeException("No user found with id: " + userid);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkPasswordHash(String password,int userid) {
        try {
            try(PreparedStatement ps = sqlConn.prepareStatement("SELECT passwordhash FROM users WHERE userid = ?")) {
                ps.setInt(1,userid);
                try(ResultSet rs = ps.executeQuery()) {
                    if(rs.next()) {
                        String hashedPassword = hashPassword(password);
                        String userPassword = rs.getString(1);
                        return hashedPassword.equals(userPassword);
                    }
                    throw new RuntimeException("No user found with id: " + userid);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(password.getBytes());

            BigInteger no = new BigInteger(1,messageDigest);

            StringBuilder hashText = new StringBuilder(no.toString(16));
            while(hashText.length() < 32) {
                hashText.insert(0, "0");
            }
            return hashText.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
