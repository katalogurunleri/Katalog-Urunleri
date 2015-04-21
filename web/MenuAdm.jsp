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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="fondoMe">       
            <img id="imgMe" src="Imagenes/Logo.png" width="120" height="120"/>

        </div>
        <div class="menuMe" id="menuMe" >
            <ul id="boton">
                <a href="./UsuarioServlet" id="letra">  <li> <center> Usuarios </center>  </li> </a>
                <a href="./ClienteServlet" id="letra">  <li> <center> Clientes </center>  </li> </a>
                <a href="./ProductoServlet" id="letra">  <li> <center> Productos </center>  </li> </a>
                <a href="./" id="letra">  <li> <center> Pedidos </center>  </li> </a>
                <a href="./" id="letra">  <li> <center> Ventas </center>  </li> </a>

            </ul>
        </div>
        <div id="infoPer">

            <div id="fotoMe">
                <%
                    if (foto == null) {
                        foto = "";
                    }
                    if (foto.equals("")) {
                %>
               <center> <img src="ImagePerfil/perfil.jpg" width="80" height="80" /> </center>
                <% } else {%>
                <center> <img  src="<%="ImagePerfil/" + foto%>" width="80" height="80"  /> </center>
                <%}%>
            </div>
            <div id="usuaMe">
                <p>
                    <%=nombre%><BR>
                    <%=perfil%>
                </p>
            </div>
        </div>
    </body>
    <style type="text/css">

        #imgMe{
            position: absolute;
            margin-left: 7%;
            margin-top: 1.5%;
        }
        #fondoMe{
            margin-top: -1%;
            position:absolute;
            background: #00A383 ;
            height: 10%;
            width: 99%;
            border-radius: 10px;
        }
        #menuMe{
            margin-left: 20%; 

        }
        #menuMe a li  {
            display: inline;
        }
        #letra{
            position: relative;
            width: 10%;
            height: 15%;
            margin-top: 40px;
            font-size: 125%;
            text-decoration: none;
            float: left;
            padding: 10px;
            margin-left: 2%;
            background-color:  white;
            color: black;
            font-family: Arial;
            font-size: 14px;
            border-radius: 10px;
        }
        #letra:hover{
            background: rgba(0,0,0,0);
            color: white;
            transition: 0.4s;
            box-shadow: inset 0 0 0 1px white;
            font-size: 16px;

        }
        #in{
            text-decoration: none;
            position: absolute;
            height: 20%;
            width: 8%;
            background: #5fd3b3;
            margin-left: 19%;
            border-radius: 10px;
            color: white;
        }
       
        #in:hover{
            background: white;
            color: #00A383;

        }
        #usuaMe{
            margin-top: -20%;
            color: white;
            font-family: Arial;
            font-size: 120%;   
        }
        #infoPer{
            margin-top: -1.5%;
            margin-left: 87%;
            position: absolute;
        }
    </style>
</html>
