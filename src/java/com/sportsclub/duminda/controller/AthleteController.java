package com.sportsclub.duminda.controller;

import com.sportsclub.duminda.dao.AthleteDAOImpl;
import com.sportsclub.duminda.dao.ClubDAOImpl;
import com.sportsclub.duminda.model.Athlete;
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
 * @author Duminda
 */
public class AthleteController extends HttpServlet {

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

            if (actionType.equals("registerAthlete")) {

                String firstName = request.getParameter("firstName");
                String emailAddress = request.getParameter("emailAddress");
                String contactNumber = request.getParameter("contactNumber");
                String sports[] = request.getParameterValues("sports");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String confirmPassword = request.getParameter("confirmPassword");

                boolean validated = true;

                RequestDispatcher requestDispatcher = null;

                if (firstName == null || firstName.length() == 0) {
                    validated = false;
                    request.setAttribute("errorMessage", "Please Enter First Name");
                    requestDispatcher = request.getRequestDispatcher("athleteRegister.jsp");
                } else if (emailAddress == null || emailAddress.length() == 0) {
                    validated = false;
                    request.setAttribute("errorMessage", "Please Enter Email Address");
                    requestDispatcher = request.getRequestDispatcher("athleteRegister.jsp");
                } else if (username == null || username.length() == 0) {
                    validated = false;
                    request.setAttribute("errorMessage", "Please Enter User Name");
                    requestDispatcher = request.getRequestDispatcher("athleteRegister.jsp");
                } else if ((password != null && confirmPassword != null) && !(password.equals(confirmPassword))) {
                    validated = false;
                    request.setAttribute("errorMessage", "Password and Confirm password is mismatch");
                    requestDispatcher = request.getRequestDispatcher("athleteRegister.jsp");
                }

                if (validated) { // validation  success

                    // set request parameter data to model object
                    User u = new User();

                    u.setUsername(username);
                    u.setPassword(password);
                    u.setUserType("Athlete");
                    u.setUserStatus(false);

                    Athlete athlete = new Athlete();
                    athlete.setFirstName(firstName);
                    athlete.setContactNumber(contactNumber);
                    athlete.setEmailAddress(emailAddress);
                    athlete.setSports(sports);

                    AthleteDAOImpl clubDAOImpl = new AthleteDAOImpl();
                    String status = clubDAOImpl.registerAthlete(u, athlete);
                    out.println(status + ">>>>>>>" + athlete.getAtheleteId());

                    if (status.equals("success")) {

                        request.setAttribute("successMessage", "Athelete Registered Successfully."
                                + "Please Wait till Admin Approval. You ID is : " + athlete.getAtheleteId());

                        requestDispatcher = request.getRequestDispatcher("success.jsp");
                        requestDispatcher.forward(request, response);
                    } else if (status.equals("userExist")) {

                        request.setAttribute("errorMessage", "Username Already Exist");
                        requestDispatcher = request.getRequestDispatcher("athleteRegister.jsp");
                        requestDispatcher.forward(request, response);
                    } else {

                        request.setAttribute("errorMessage", "System Error !!!. Please Contact System Administrator");
                        requestDispatcher.forward(request, response);
                    }

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
