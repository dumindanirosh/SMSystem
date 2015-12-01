/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.controller;

import com.sportsclub.duminda.dao.UserDAOImpl;
import com.sportsclub.duminda.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ESOFT
 */
public class UserController extends HttpServlet {

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

            // Retrieve client request parameters
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // set request parameter data to model object
            User u = new User();

            u.setUsername(username);
            u.setPassword(password);

            // Autenticate user credential data
            UserDAOImpl userDAOImpl = new UserDAOImpl();
            String status = userDAOImpl.login(u);

            RequestDispatcher requestDispatcher = null;
            if (status != null && status.equals("Admin")) {

                // Establish Session Object
                createSession(request, u);
                createCookie(response, u);
                requestDispatcher = request.getRequestDispatcher("adminDashboard.jsp");
            } else if (status != null && status.equals("Club")) {
                createSession(request, u);
                createCookie(response, u);
                requestDispatcher = request.getRequestDispatcher("clubDashboard.jsp");
            } else if (status != null && status.equals("Athletes")) {
                createSession(request, u);
                createCookie(response, u);
                requestDispatcher = request.getRequestDispatcher("athletesDashboard.jsp");
            } else if (status != null && status.equals("notActive")) {
                request.setAttribute("errorMessage", "User Login Not Active. Please Contact System Administrator");
                requestDispatcher = request.getRequestDispatcher("index.jsp");
            } else if (status != null && status.equals("invalid")) {
                request.setAttribute("errorMessage", "Invalid Login Details");
                requestDispatcher = request.getRequestDispatcher("index.jsp");
            } else if (status != null && status.equals("error")) {
                request.setAttribute("errorMessage", "System Error !!!. Please Contact System Administrator");
                requestDispatcher = request.getRequestDispatcher("index.jsp");
            }

            requestDispatcher.forward(request, response);

        }
    }

    private void createSession(HttpServletRequest request, User u) {

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(15 * 60);
        session.setAttribute("user", u);

    }

    private void createCookie(HttpServletResponse response, User u) {

        Cookie c = new Cookie("user", u.getUsername());
        c.setMaxAge(30 * 60);
        response.addCookie(c);
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
