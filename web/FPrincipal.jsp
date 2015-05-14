<%@page import="com.KatalogÜrünleri.Entidades.Usuario"%>
<%
    String targetModulo = request.getAttribute("targetModulo") == null ? "datos.jsp" : (String) request.getAttribute("targetModulo");
    Usuario entUsuario = (Usuario) session.getAttribute("usuario");
    String user = entUsuario.getUsuario();
    String nombre = entUsuario.getNombre();
    String perfil = entUsuario.getPerfil();
    String estado = entUsuario.getEstado();
    String foto = entUsuario.getFoto();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/Fprincipal.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        <% if ("Activo".equals(estado)) {%>  
        <% if ("Administrador".equals(perfil)) {%>      
        <table style="width: 100%; border: 0px;" >
            <tr>
            </tr>
            <tr>
                <td><jsp:include page="MenuAdm.jsp" flush="true"/></td>
            </tr>
            <tr>
                <td><jsp:include page="<%=targetModulo%>" flush="true"/></td>
            </tr>
            <tr>
                <td><jsp:include page="Pie.jsp" flush="true"/></td>
            </tr>

        </table>        
        <%} else {%> 
            <h1> USTED NO ES ADMINISTRADOR </h1>
        <%}%>
        <%} else {%>
            <h1>USTED NO ESTA ACTIVO</h1>
        <%}%>
    </body>
</html>