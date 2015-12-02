<%-- 
    Document   : success
    Created on : Dec 1, 2015, 11:01:59 PM
    Author     : Duminda
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
        
        
        
                <%
         
            String successMessage = (String)request.getAttribute("successMessage");
            
            if(successMessage != null){
                out.println("<font color='blue'>" + successMessage + "</font>");
            }
            
         %>
        
    </body>
</html>
