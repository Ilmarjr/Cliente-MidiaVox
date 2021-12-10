<%-- 
    Document   : updateDestination
    Created on : 8 de dez de 2021, 20:43:04
    Author     : imaju
--%>

<%@page import="br.com.clienteweb.service.DestinationService"%>
<%@page import="br.com.clienteweb.dao.DestinationDAO"%>
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
            //Carregar dados do registro a ser editado
            DestinationService objDestinationService = new DestinationService();
            //teste
            String id = request.getParameter("id");
            DestinationVO objDestinationVO = objDestinationService.getOneDestination(id);
%>

        <h1>Update Destination</h1>
        <form action ="updateDestination.jsp" method="POST">
            <input type="hidden" name="currentId" value ="<%=id%>"/>
            <table> 
                <tr>
                    <td>ID: </td>
                    <td><input type="text" name = "id" value = "<%=objDestinationVO.getId()%>"/></td>
                </tr>
                <tr>
                    <td>DESTINATION</td>
                    <td><input type="text" name = "destination" value = "<%=objDestinationVO.getDestination()%>"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value = "UPDATE"></input></td>
                </tr>
            </table>
        </form>
    </body>
</html>
