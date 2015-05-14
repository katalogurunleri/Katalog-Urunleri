<%-- 
    Document   : FBotones
    Created on : 21/05/2014, 08:06:56 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/botones.css">
<table><tr>
        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="nuevo">Nuevo</button> </td>    

        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="buscar">Buscar</button> </td>    

        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="guardar">Guardar</button> </td>     

        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="editar">Actualizar</button> </td>   

        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="listar">Listar</button> </td>     

    </tr></table>
<style type="text/css">
    #fboton{
        background: white;
        font-family: Arial;
        color:  black;
        font-size: 120%;
        border: none;
        border-radius: 10px 10px;
        // margin-left: 2%;
    }
    #fboton:hover{
        color: white;
        background: #00A383;
        font-size: 130%;
        transition: 0.4s;
        box-shadow: inset 0 0 0 1px black;
    }
</style>
