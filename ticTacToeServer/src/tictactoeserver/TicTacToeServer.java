/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

/**
 * @author Asus2
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TicTacToeServer {

     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        static final String DB_URL = "jdbc:mysql://localhost/";
         static final String USER = "Selaine";
   static final String PASS = "03121996";
   
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

           Connection conn = null;
    Connection conn2= null;
   Statement stmt = null;
   Statement stmt2 = null; 
   
   try{
      // Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //Delete to prevent already existing table error
      stmt = conn.createStatement();
      stmt.executeUpdate("DROP DATABASE GAME");
      
      //Creating Database
      System.out.println("Creating database...");
      stmt.executeUpdate("CREATE DATABASE GAME");
      System.out.println("Database created successfully...");
      
      //Connecting to the new database
      conn2 = DriverManager.getConnection("jdbc:mysql://localhost/GAME",USER,PASS);
      stmt2 = conn2.createStatement();
      
      //Creating Table
       System.out.println("Creating table");
        String sql2 = "CREATE TABLE PLAYERS( ID INT NOT NULL, USERNAME VARCHAR (20) NOT NULL,PASSWORD VARCHAR (20) NOT NULL, AGE  INT NOT NULL,ADDRESS  CHAR (25),EMAIL CHAR(25), SCORE INT, PRIMARY KEY (ID))";
        stmt2.executeUpdate(sql2);
        System.out.println("Table created succesfully");
        
      int portNumber = 8050;

            
            GameThread r = new GameThread(portNumber);
            new Thread(r).start();
 
       
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
      
        
        
        
        
        
        
       
    

