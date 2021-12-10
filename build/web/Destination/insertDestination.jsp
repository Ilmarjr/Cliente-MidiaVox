<%@page import="br.com.clienteweb.dao.DestinationDAO"%>
<%@page import="br.com.clienteweb.commonvo.DestinationVO"%>
<%@page import="br.com.clienteweb.service.DestinationService"%>


<%
    DestinationVO objDestinationVO = new DestinationVO();
    DestinationService objDestinationService = new DestinationService();
    
    //Captura dados e insere o registro no banco de dados
    objDestinationVO.setId(request.getParameter("id"));
    objDestinationVO.setDestination(request.getParameter("destination"));
    
    int i = objDestinationService.createOrUpdate(objDestinationVO);
    
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