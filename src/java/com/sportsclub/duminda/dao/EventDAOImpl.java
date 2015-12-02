/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sportsclub.duminda.dao;

import com.sportsclub.duminda.model.Club;
import com.sportsclub.duminda.model.Event;
import com.sportsclub.duminda.model.User;
import java.sql.Connection;

/**
 *
 * @author Duminda
 */
public class EventDAOImpl {
    
    
        public String registerClub(User u, Event e) {

        Connection conn = null;
        try {

            conn = DBConnection.getConnection();

            if (conn != null) {

                ClubDAOImpl clubDAOImpl = new ClubDAOImpl();
                Club club = clubDAOImpl.getClub(u.getUsername());

              
                    String insertQuery = "INSERT INTO event(club_id,event_name,event_fee,schedule_date,approve_status)"
                            + " VALUES(" + club.getClubId() + ","
                            + "'" + e.getEventName() + "',"
                            + "" + e.getEventFee() + ","
                            + " " + e.getEventDate() + ","
                            + " "+ e.isApprovalStatus()+ ")";

                    System.out.println("insert : " + insertQuery);

                    int status = DBCRUDOperations.insertUpdateDeleteAutoIncrement(insertQuery, conn);

                    if (status == 1) {

                        return "success";

                    } else {

                        return "fail";
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
