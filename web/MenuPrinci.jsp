<%-- 
    Document   : Menu
    Created on : 08-mar-2015, 20:41:01
    Author     : Familia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script lang="javascript">
        function abrirVentana() {
            open("init.jsp", "miventana", "toolbar=no, directories=yes, menubar=no, status=no, resizable=yes,scrollbars=no");
        }
    </script>
    <body>

        <div id="fondoMe">       
            <img id="img" src="Imagenes/Logo.png" width="150" height="150"/>

        </div>
        <div class="menu" id="menu" >
            <ul id="boton">
                <a href="Inicio.jsp" id="letra" target="Pprincipal">  <li> <center> Inicio </center>  </li> </a>
                <a href="CatalogoPrin.jsp" id="letra" target="Pprincipal"> <li>  <center> Catálogo </center>  </li> </a>
                <a href="#" id="letra" target="Pprincipal">  <li>  <center> Contáctanos</center> </li> </a>  
            </ul>
        </div>

        <a id="in"> 
            <center>  <p id="c" onclick="abrirVentana()"> INGRESAR </p>  </center> 
        </a>
    </body>
    <style type="text/css">

        #img{
            position: absolute;
            margin-left: 7%;
        }

        #fondoMe{
            margin-top: -1%;
                position:absolute;
            background: #00A383 ;
            height: 98%;
            width: 98%;
            border-radius: 10px;
        }

        #menu{
            margin-left:  30%; 

        }
        #menu a li  {
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

        #c{
            position: absolute;
            margin-top: 5px;
            margin-left: 15%;
            font-family: Arial;
            text-decoration: none;
            font-size: 15px;
        }


        #in:hover{
            background: white;
            color: #00A383;

        }


    </style>
</html>
