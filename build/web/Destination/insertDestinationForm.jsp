<%-- 
    Document   : insertDestinationForm
    Created on : 9 de dez de 2021, 20:01:10
    Author     : imaju
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inserir Destination</h1>
        <form action ="insertDestination.jsp" method="POST">
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
                    <td><input type="submit" value = "Adicionar"/></input>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
