<%-- 
    Document   : index
    Created on : Nov 27, 2015, 10:31:16 AM
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
        <h1>Hello World!</h1>
        <h1> hiiiiiiiiiiiiiiiiiii git test </h1>
        Changes 2
        
        <%
         
            String errorMessage = (String)request.getAttribute("errorMessage");
            
            if(errorMessage != null){
                out.println("<font color='red'>" + errorMessage + "</font>");
            }
            
         %>
        
        
        <form action="user.action" method="post">
        
        <table border="1">
           
            <tbody>
                <tr>
                    <td> User Name</td>
                    <td>
                        
                        <input type="text" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Password
                    </td>
                    <td>
                        
                        <input type="password" name="password" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Login" />  
                        <input type="reset" value="Reset" />
                    </td>
                </tr>
            </tbody>
        </table>
        </form>
         
         </br>
         
         <a href="clubRegister.jsp">Club Register</a>
    </body>
</html>
