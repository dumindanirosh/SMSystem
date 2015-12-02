/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.controller;

import com.sportsclub.duminda.dao.AthleteDAOImpl;
import com.sportsclub.duminda.dao.EventDAOImpl;
import com.sportsclub.duminda.model.Athlete;
import com.sportsclub.duminda.model.Event;
import com.sportsclub.duminda.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duminda
 */
public class EventController extends HttpServlet {

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

            String actionType = request.getParameter("actionType");

            if (actionType.equals("registerEvent")) {

                String eventName = request.getParameter("eventName");
                String scheduleDate = request.getParameter("scheduleDate");
                String eventFee = request.getParameter("eventFee");
                String eventDescription = request.getParameter("eventDescription");

                boolean validated = true;

                RequestDispatcher requestDispatcher = null;

                if (eventName == null || eventName.length() == 0) {
                    validated = false;
                    request.setAttribute("errorMessage", "Please Enter Event Name");
                    requestDispatcher = request.getRequestDispatcher("athleteRegister.jsp");
                }

                if (validated) { // validation  success

                    // set request parameter data to model object
                    User u = (User) request.getSession().getAttribute("user");

                    Event event = new Event();
                    event.setEventName(eventName);
                    event.setEventDescription(eventDescription);
                    event.setEventFee(Double.parseDouble(eventFee));

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date eventDate = sdf.parse(scheduleDate);
                    event.setEventDate(eventDate);

                    EventDAOImpl eventDAOImpl = new EventDAOImpl();

                    String status = eventDAOImpl.registerClub(u, event);
                    if (status.equals("success")) {

                        request.setAttribute("successMessage", "Event Registered Successfully."
                                + "Please Wait till Admin Approval. You ID is : " + event.getEventId());

                        requestDispatcher = request.getRequestDispatcher("success.jsp");
                        requestDispatcher.forward(request, response);
                    } else {

                        request.setAttribute("errorMessage", "System Error !!!. Please Contact System Administrator");
                        requestDispatcher.forward(request, response);
                    }

                } else {
                    requestDispatcher.forward(request, response);
                }

            }
        } catch (ParseException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
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
