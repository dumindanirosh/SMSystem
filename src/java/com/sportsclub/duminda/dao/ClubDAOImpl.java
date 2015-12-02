/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.dao;

import com.sportsclub.duminda.model.Club;
import com.sportsclub.duminda.model.User;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author ESOFT
 */
public class ClubDAOImpl {

    public String registerClub(User u, Club c) {

        Connection conn = null;
        try {

            conn = DBConnection.getConnection();

            if (conn != null) {

                UserDAOImpl userDAOImpl = new UserDAOImpl();
                String userStatus = userDAOImpl.registerUser(u);

                if (userStatus.equals("success")) {

                    String insertQuery = "INSERT INTO club VALUES('" + c.getClubName() + "',"
                            + "'" + c.getEmailAddress() + "',"
                            + "'" + c.getTelephoneNumber() + "',"
                            + " '" + u.getUsername() + "')";

                    System.out.println("insert : " + insertQuery);

                    int status = DBCRUDOperations.insertUpdateDelete(insertQuery, conn);

                    if (status == 1) {

                        return "success";

                    } else {

                        return "fail";
                    }

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

    public Club getClub(String username) {

        Connection conn = null;
        try {

            conn = DBConnection.getConnection();

            if (conn != null) {
                String loginQuery = "select * FROM club WHERE username='" + username + "'";

                ResultSet rs = DBCRUDOperations.retriveData(loginQuery, conn);

                if (rs.next()) {
                    Club c = new Club();
                    int clubId = rs.getInt("club_id");
                    c.setClubId(clubId);

                    return c;
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
        return null;
    }

}
