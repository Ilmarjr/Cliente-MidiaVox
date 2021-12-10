<%-- 
    Document   : excluirLivro
    Created on : 8 de dez de 2021, 11:56:31
    Author     : imaju
--%>

<%@page import="br.com.clienteweb.dao.DestinationDAO"%>
<%@page import="br.com.clienteweb.service.DestinationService"%>
<%@page import="br.com.clienteweb.commonvo.DestinationVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            //Deletar
            try {
                DestinationService objDestinationService = new DestinationService();
                
                String id= request.getParameter("id");
                DestinationVO objDestinationVO = objDestinationService.getOneDestination(id);

               
               objDestinationService.deleteDestination(objDestinationVO);
            } catch (Exception e) {
                %><h1>404 Not Found</h1><%
            }
            response.sendRedirect("viewDestinations.jsp");
        %>
    </body>
</html>
