/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
        }
        return 0;
    }

}
