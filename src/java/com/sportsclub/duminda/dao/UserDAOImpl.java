/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.dao;

import com.sportsclub.duminda.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ESOFT
 */
public class UserDAOImpl {

    public String login(User user) {

        Connection conn = null;
        try {

            conn = DBConnection.getConnection();

            if (conn != null) {
                String loginQuery = "select * FROM user WHERE username='" + user.getUsername()
                        + "' AND password='" + user.getPassword() + "'";

                ResultSet rs = DBCRUDOperations.retriveData(loginQuery, conn);

                if (rs.next()) {
                  
                  // Check for Registration approve or not  
                  boolean status =  rs.getBoolean("user_status");
                    
                  if(status){ // active user
                      
                      String userType = rs.getString("user_type");
                      
                      return userType;
                      
                  }else{
                      return "notActive";
                  }
                  
                } else {
                    System.out.println("Invalid Login Details");
                    return "invalid";
                }
                
            } else {
                return "error";
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
    
    public String registerUser(User u){
        
           Connection conn = null;
        try {

            conn = DBConnection.getConnection();

            if (conn != null) {
                String insertQuery = "INSERT INTO user VALUES('"+u.getUsername()+ "',"+
                                                            "'"+ u.getPassword() + "',"+
                                                           "'"+ u.getUserType() + "',"+
                                                           " "+u.isUserStatus() +")";

                System.out.println("insert : " + insertQuery);
                
                int status = DBCRUDOperations.insertUpdateDelete(insertQuery, conn);

                if (status  == 1) {
                  
                    return "success";
                  
                } else {
                    System.out.println("Invalid Login Details");
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
    
    
    public ArrayList<User> viewPendingRequests(){
        
        
         Connection conn = null;
        try {

            conn = DBConnection.getConnection();

            if (conn != null) {
                String loginQuery = "select * FROM user WHERE user_status=0";

                ResultSet rs = DBCRUDOperations.retriveData(loginQuery, conn);

                ArrayList<User> users = new ArrayList<User>();
                
                while (rs.next()) {
                  
                  // Check for Registration approve or not  
                    String username = rs.getString("username");
                    String userType = rs.getString("user_type");
                    
                    User u = new User();
                    u.setUsername(username);
                    u.setUserType(userType);
                    
                    users.add(u);
          
                  
                } 
                
                return users;
                
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
