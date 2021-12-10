<%@page import="java.util.List"%>
<%@page import="br.com.clienteweb.service.DestinationService"%>
<%@page import="br.com.clienteweb.commonvo.DestinationVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <form action="viewDestinations.jsp" method="POST">
            <h1>Filtro</h1>
            <table> 
                <tr>
                    <td>ID: </td>
                    <td><input type="text" name = "id" /></td>
                </tr>
                <tr>
                    <td>DESTINATION</td>
                    <td><input type="text" name = "destination" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value = "APLICAR"></input></td>
                </tr>
            </table>
        </form>
        <h1>Lista de Destinations</h1>
        <%
            DestinationVO objDestinationVO = new DestinationVO();
            
            //Ao iniciar, listar todos os registros
            if (request.getParameter("id") == null) {
                objDestinationVO.setId("");
                objDestinationVO.setDestination("");
            } else {
                objDestinationVO.setId(request.getParameter("id"));
                objDestinationVO.setDestination(request.getParameter("destination"));
            }
            
            DestinationService objDestinationService = new DestinationService();
            
            List<DestinationVO> list = objDestinationService.getDestination(objDestinationVO);
            request.setAttribute("list", list);
        %>
        <table border = "1"> 
            <tr> 
                <th>ID</th> 
                <th>DESTINATION</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>

            <c:forEach items = "${list}" var = "DestinationVO"> 
                <tr>
                    <td>${DestinationVO.getId()}</td>
                    <td>${DestinationVO.getDestination()}</td>
                    <td><a href="updateDestinationform.jsp?id=${DestinationVO.getId()}">Update</a></td>
                    <td><a href="deleteDestination.jsp?id=${DestinationVO.getId()}
                           ">Delete</a></td>

                </tr>

            </c:forEach>
        </table>
        <br>
        <a href="insertDestinationForm.jsp">Inserir Usuario</a>
    </body>
</html>