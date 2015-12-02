/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESOFT
 */
public class DBCRUDOperations {

    /*
     * retriveData method use to get database table data for given sql query
     * if data is avialable it will come with ResultSet object
     */
    public static ResultSet retriveData(String selectQuery, Connection conn) {

        try {

            if (conn != null) {  // connection success

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(selectQuery);

                return rs;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        return null;
    }

    public static int insertUpdateDelete(String sqlQuery, Connection conn) {

        try {

            if (conn != null) {  // connection success

                Statement stmt = conn.createStatement();
                int status = stmt.executeUpdate(sqlQuery);

                return status;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
              ex1.printStackTrace();
            }
        }
        return 0;
    }

      public static int insertUpdateDeleteAutoIncrement(String sqlQuery, Connection conn) {

        try {

            if (conn != null) {  // connection success

                Statement stmt = conn.createStatement();
                int status = stmt.executeUpdate(sqlQuery,Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                int autoIncrment = rs.getInt(1);
               
                return autoIncrment;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
              ex1.printStackTrace();
            }
        }
        return 0;
    }

}
