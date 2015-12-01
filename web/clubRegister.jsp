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
        
        
        <form action="club.action" method="post">
        <table border="1">
           
            <tbody>
                <tr>
                    <td>Club Name</td>
                    <td>
                        <input type="text" name="clubName"/>
                        
                    </td>
                </tr>
                <tr>
                    <td>
                        Email Address
                    </td>
                    <td>
                            
                        <input type="text" name="emailAddress"/>
                    
                        
                    </td>
                </tr>
                <tr>
                    <td>
                        Telephone Number
                    </td>
                    <td><input type="text" name="telephoneNum" /></td>
                </tr>
                <tr>
                    <td>
                        Club User Name
                        
                    </td>
                    <td>
                        <input type="text" name="clubUsername" />
                    </td>
                </tr>
                <tr>
                    <td>Password </td>
                    <td>
                        <input type="password" name="password" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td>
                        <input type="password" name="confirmPassword" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="actionType" value="registerClub"/> 
                        <input type="submit" value="Register Club" /> 
                    </td>
                </tr>
              
            </tbody>
        </table>

        </form>
        
        
    </body>
</html>
