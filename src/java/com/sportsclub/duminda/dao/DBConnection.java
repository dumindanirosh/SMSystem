/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ESOFT
 */
public class DBConnection {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url =  "jdbc:mysql://localhost:3307/sports_mgt_db";
    private static String username = "root";
    private static String password = "1234";
    
    
    // Establish DB Connection
   public static Connection getConnection(){
       
       try{
        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url,username,password);
        return conn;
       }catch(Exception ex){
           ex.printStackTrace();
           
       }
      return null;
   }
           
    
}
