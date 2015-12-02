<%-- 
    Document   : userRequests
    Created on : Nov 28, 2015, 1:48:37 PM
    Author     : ESOFT
--%>

<%@page import="com.sportsclub.duminda.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sportsclub.duminda.dao.UserDAOImpl"%>
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
            
            UserDAOImpl userDAOImpl = new UserDAOImpl();
            
            ArrayList<User> users = userDAOImpl.viewPendingRequests();
            
            
            for(User u : users){
                
                out.println(u.getUsername() + " |" + u.getUserType() +"<a href='user.action?actionType=acceptUser&username="+u.getUsername()+"'> Accept </a> </br>" );
            }
            
            %>
        
    </body>
</html>
