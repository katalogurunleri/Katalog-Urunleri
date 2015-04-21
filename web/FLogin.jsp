<%@page import="java.util.List"%>
<%@page import="com.KatalogÜrünleri.Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensajeError = (String) request.getAttribute("mensajeError");
    String usuario = request.getParameter("usuario") == null ? "" : request.getParameter("usuario");


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="fondo">

        </div>
        <div id="centro">
            <center>
                <img src="Imagenes/Logo.png" width="120" height="120"/>
                <form name ="xForm" method="POST" action="./Autenticacion" Onsubmit= "return valida_envia();">

                    <table>
                        <tr>
                            <td id="text"><center> Usuario: </center> </td>
                        <td id="text1"> <center> <input type="text" name="txtusuario" id="usuario" size="20" value="<%=usuario%>" maxlength="10" /> </center> </td>
                        </tr>
                        <tr>
                            <td id="text"><center> Contraseña: </center> </td>
                        <td id="text1"> <center> <input type="password" name="txtclave" id="contraseña" size="20" maxlength="15" /> </center> </td>                    
                        </tr>
                        <tr> 
                            <td colspan="2"> <center> <button id="Ingresar" type="submit" name="action"  value="ingresar" class="btn1" > Ingresar </button> </center> </td>
                        </tr>
                        <%if (mensajeError != null) {%>
                        <tr>
                            <td colspan="2"> <center> <p id="Mensa"> <%=mensajeError%> </p> </center> </td>
                        </tr>   
                        <%}%>
                    </table>
                </form>
            </center>
        </div>

        <style type="text/css">
            body{
                background-image: url(Imagenes/fondo.png);  
            }
            html,body {
                margin:0;
                padding:0;
                width:100%;
                height:100%;
                overflow:hidden;
            }
            #fondo{
                background: white;
                opacity: 0.5;
                position: absolute;
                width: 35%;
                height: 22%;
                margin-left: 30%;
                margin-top: 13%;
                position: absolute;      
                -webkit-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
                -moz-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
                box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            }
            #centro{
                position:  absolute;
                width: 35%;
                height: 4%;
                margin-left: 30%;
                margin-top: 15%;
            }
            #text{
                font-family: Arial;
                font-size: 105%;
            }
            #Ingresar{
                background: white;
                font-family: Arial;
                width: 50%; 
                height: 40px;
                color:  black;
                font-size: 80%;
                border: none;
                border-radius: 10px 10px;
                margin-left: 2%;
            }
            #Ingresar:hover{
                color: white;
                background: #00A383;
                font-size: 120%;
                transition: 0.4s;
                box-shadow: inset 0 0 0 1px black;
            }
            #Mensa{
                font-family: Arial;
                font-size: 110%;
                color: black;
            }
        </style>
    </body>
</html>
