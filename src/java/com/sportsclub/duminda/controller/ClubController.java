/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.controller;

import com.sportsclub.duminda.dao.ClubDAOImpl;
import com.sportsclub.duminda.model.Club;
import com.sportsclub.duminda.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ESOFT
 */
public class ClubController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String actionType = request.getParameter("actionType");
            
            if (actionType.equals("registerClub")) {
                String clubName = request.getParameter("clubName");
                String emailAddress = request.getParameter("emailAddress");
                String telephone = request.getParameter("telephoneNum");
                String username = request.getParameter("clubUsername");
                String password = request.getParameter("password");
                String confirmPassword = request.getParameter("confirmPassword");
                
                boolean validated = true;
                
                RequestDispatcher requestDispatcher = null;
                
                if (clubName == null || clubName.length() == 0) {
                    validated = false;
                    request.setAttribute("errorMessage", "Please Club Name");
                    requestDispatcher = request.getRequestDispatcher("clubRegister.jsp");
                } else if (emailAddress == null || emailAddress.length() == 0) {
                    validated = false;
                    request.setAttribute("errorMessage", "Please Email Address");
                    requestDispatcher = request.getRequestDispatcher("clubRegister.jsp");
                } else if (username == null || username.length() == 0) {
                    validated = false;
                    request.setAttribute("errorMessage", "Please User Name");
                    requestDispatcher = request.getRequestDispatcher("clubRegister.jsp");
                } else if ((password != null && confirmPassword != null) && !(password.equals(confirmPassword))) {
                    validated = false;
                    request.setAttribute("errorMessage", "Password and Confirm password is mismatch");
                    requestDispatcher = request.getRequestDispatcher("clubRegister.jsp");
                }
                
                if (validated) { // validation  success

                    // set request parameter data to model object
                    User u = new User();
                    
                    u.setUsername(username);
                    u.setPassword(password);
                    u.setUserType("Club");
                    u.setUserStatus(false);
                    
                    Club c = new Club();
                    c.setClubName(clubName);
                    c.setEmailAddress(emailAddress);
                    c.setTelephoneNumber(telephone);
                    
                    ClubDAOImpl clubDAOImpl = new ClubDAOImpl();
                  String status =   clubDAOImpl.registerClub(u, c);
                  out.println(status);
                  
                } else {
                    requestDispatcher.forward(request, response);
                }
                
            }
            
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
