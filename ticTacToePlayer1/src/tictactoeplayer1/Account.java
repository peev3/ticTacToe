/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeplayer1;
//import static database.Database.DB_URL;

import java.sql.*;

/**
 *
 * @author Maya
 */
public class Account {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/GAME";
    static final String USER = "User";
    static final String PASS = "123456";

    static void register(String username, String password, String email) throws ClassNotFoundException, SQLException {
        int score = 0;
        Connection conn = null;
        Statement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `PLAYERS`(username,password,email,score) VALUE('"
                + username + "','"
                + password + "','"
                + email + "','"
                + score + "')");
    }

    static boolean login(String username, String password) throws SQLException {
        ResultSet Results = null;
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();

        Results = stmt.executeQuery("SELECT USERNAME,PASSWORD from PLAYERS WHERE username like '"
                + username
                + "' and password like '"
                + password + "' ");

        while (Results.next()) {
            System.out.println(Results.getString("USERNAME"));
            if (Results.getString("USERNAME") == username) {
                return true;
            }
        }

        return false;

    }

    static void updateScore(String username) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE PLAYERS set score = score+1 where username like '" + username + "' ");

    }

}
