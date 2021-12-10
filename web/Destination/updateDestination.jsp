<%@page import="br.com.clienteweb.service.DestinationService"%>
<%@page import="br.com.clienteweb.commonvo.DestinationVO"%>
<jsp:useBean id = "u" class="br.com.clienteweb.commonvo.DestinationVO"></jsp:useBean>
<jsp:setProperty property = "*" name ="u"/>
<%
    //Editar
    DestinationService objDestinationService = new DestinationService();
    
    int i = objDestinationService.updateDestination(u, request.getParameter("currentId"));
    
    if (i > 0) {
%><h1>204 No Content</h1><%
        } else {
%><h1>404 Error</h1><%
             }
%>
<form action ="viewDestinations.jsp" method="POST">
    <br>
    <input type="submit" value = "VOLTAR"/></input>
</form>