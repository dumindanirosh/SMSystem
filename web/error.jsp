<%-- 
    Document   : error
    Created on : Dec 1, 2015, 11:25:17 PM
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
         
            String errorMessage = (String)request.getAttribute("errorMessage");
            
            if(errorMessage != null){
                out.println("<font color='red'>" + errorMessage + "</font>");
            }
            
         %>
        
    </body>
</html>
