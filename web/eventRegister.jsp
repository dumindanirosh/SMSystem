<%-- 
    Document   : register
    Created on : Nov 27, 2015, 3:25:08 PM
    Author     : ESOFT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Club Register</h1>
        
                <%
         
            String errorMessage = (String)request.getAttribute("errorMessage");
            
            if(errorMessage != null){
                out.println("<font color='red'>" + errorMessage + "</font>");
            }
            
         %>
        
        
        <form action="event.action" method="post">
        <table border="1">
           
            <tbody>
                <tr>
                    <td>Event Name</td>
                    <td>
                        <input type="text" name="eventName"/>
                        
                    </td>
                </tr>
                <tr>
                    <td>
                        Schedule Dates
                    </td>
                    <td>
                            
                        <input type="date" name="scheduleDate"/>
                    
                        
                    </td>
                </tr>
                <tr>
                    <td>
                        Event Fee
                    </td>
                    <td><input type="text" name="eventFee" /></td>
                </tr>
                <tr>
                    <td>
                        Event Description
                        
                    </td>
                    
                     <td>
                         <textarea name="eventDescription" rows="4" cols="20"></textarea>
                </td>
                </tr>
               
                   
             
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="actionType" value="registerEvent"/> 
                        <input type="submit" value="Register Event" /> 
                    </td>
                </tr>
              
            </tbody>
        </table>

        </form>
        
        
    </body>
</html>
