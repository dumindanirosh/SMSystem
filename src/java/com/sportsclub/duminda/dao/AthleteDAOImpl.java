/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.dao;

import com.sportsclub.duminda.model.Athlete;
import com.sportsclub.duminda.model.Club;
import com.sportsclub.duminda.model.User;
import java.sql.Connection;

/**
 *
 * @author ESOFT
 */
public class AthleteDAOImpl {

    public String registerAthlete(User u, Athlete a) {

        Connection conn = null;
        try {

            conn = DBConnection.getConnection();

            if (conn != null) {
                conn.setAutoCommit(false);
                UserDAOImpl userDAOImpl = new UserDAOImpl();
                String userStatus = userDAOImpl.registerUser(u);

                if (userStatus.equals("success")) {

                    String insertQuery = "INSERT INTO athelete(first_name,contact_number,email_address,username) VALUES('" + a.getFirstName() + "',"
                            + "'" + a.getContactNumber() + "',"
                            + "'" + a.getEmailAddress() + "',"
                            + " '" + u.getUsername() + "')";

                    System.out.println("insert : " + insertQuery);

                    int atheleteId = DBCRUDOperations.insertUpdateDeleteAutoIncrement(insertQuery, conn);

                    if (atheleteId != 0) {
                        a.setAtheleteId(atheleteId);
                        conn.commit();

                        for (String s : a.getSports()) {

                            String insertQuery2 = "INSERT INTO athlete_sports VALUES("
                                    + +atheleteId + ","
                                    + " " + Integer.parseInt(s) + " )";

                            System.out.println("in 2 > " + insertQuery2);

                            int status = DBCRUDOperations.insertUpdateDelete(insertQuery2, conn);
                            System.out.println("stats : " + status);
                        }

                        conn.commit();
                        System.out.println("Auto : " + atheleteId);

                        return "success";

                    }

                }else{
                    return userStatus;
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }

        return "error";
    }
    
    
   
}
