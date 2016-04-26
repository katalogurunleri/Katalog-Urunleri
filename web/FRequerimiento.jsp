<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset=utf-8 />
    </head>
    <body>
        <div id="centro">
            <center><h1 id="titu"> Requerimientos en proceso </h1></center><br>
            <hr aling=left noshade size:5 width:70px color="#00a383"> 
            <center>
            <table class="tabla">
                <tr>
                    <td >Nro.</td>    
                    <td >Título</td>    
                    <td >Detalle</td>    
                    <td >Autor</td>  
                    <td >Encargado</td>  
                    <td >Nvl.</td>  
                </tr>  
                <tr>
                    <td >1</td>    
                    <td ></td>    
                    <td </td>    
                    <td ></td>
                    <td ></td>  
                    <td ></td>
                </tr>  
                <tr>
                    <td >2</td>    
                    <td ></td>    
                    <td </td>    
                    <td ></td>
                    <td ></td>  
                    <td ></td>
                </tr>  
                <tr>
                    <td >3</td>    
                    <td ></td>    
                    <td </td>    
                    <td ></td>
                    <td ></td>  
                    <td ></td>
                </tr>  
            </table>
            </center>
        </div>
    </body>
    <style type="text/css">
        body{
            background: white;
        }
        #borde{
            border-color: #00a383
        }
        #tibo{
            font-family: Arial;
            color: #00a383;
            font-size: 23px;

        }
        #datou{
            margin-left: 2%;
            margin-top: 2%;
            width: 35%;
        }
        #centro{
            width: 98%;
            height: 4%;
            margin-left: 1%;
            margin-bottom: 2%;
            margin-top: 5%;
            position:relative;      
            -webkit-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            -moz-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
        }
        #tex{
            font-family: Arial;
            font-size: 105%;
            color:#00A383;
        }
        #cam{
            color: #00a383;
            font-size: 80%;
            font-family: Arial;
        }
        #titu{
            font-family: Arial;
            color: #00342A;
            font-size: 250%;
            margin-bottom: -7%;
        }
        #imaperfil{
            margin-top: -40%;
            margin-left: 50%;
        }
        h3{
            font-family: Arial;
            color: #00342A;
            margin-bottom: -1%;
        }
        h5{
            margin-top: -1%;
            color: #00a383;
        }
        .tabla {
            margin:0px;padding:0px;
            width: 85% !important;
            box-shadow: 10px 10px 5px #888888;
            border:1px solid #000000;

            -moz-border-radius-bottomleft:9px;
            -webkit-border-bottom-left-radius:9px;
            border-bottom-left-radius:9px;

            -moz-border-radius-bottomright:9px;
            -webkit-border-bottom-right-radius:9px;
            border-bottom-right-radius:9px;

            -moz-border-radius-topright:9px;
            -webkit-border-top-right-radius:9px;
            border-top-right-radius:9px;

            -moz-border-radius-topleft:9px;
            -webkit-border-top-left-radius:9px;
            border-top-left-radius:9px;
        }.tabla table{
            border-collapse: collapse;
            border-spacing: 0;
            width:100%;
            height:100%;
            margin:0px;padding:0px;
        }.tabla tr:last-child td:last-child {
            -moz-border-radius-bottomright:9px;
            -webkit-border-bottom-right-radius:9px;
            border-bottom-right-radius:9px;
        }
        .tabla table tr:first-child td:first-child {
            -moz-border-radius-topleft:9px;
            -webkit-border-top-left-radius:9px;
            border-top-left-radius:9px;
        }
        .tabla table tr:first-child td:last-child {
            -moz-border-radius-topright:9px;
            -webkit-border-top-right-radius:9px;
            border-top-right-radius:9px;
        }.tabla tr:last-child td:first-child{
            -moz-border-radius-bottomleft:9px;
            -webkit-border-bottom-left-radius:9px;
            border-bottom-left-radius:9px;
        }.tabla tr:hover td{
            background: #00a383;
        }
        .tabla tr:nth-child(odd){ background-color:#5fd3b3; }
        .tabla tr:nth-child(even)    { background-color:#ffffff; }.tabla td{
            vertical-align:middle;


            border:1px solid #000000;
            border-width:0px 1px 1px 0px;
            text-align:center;
            padding:9px;
            font-size:12px;
            font-family:Arial;
            font-weight:normal;
            color:#000000;
        }.tabla tr:last-child td{
            border-width:0px 1px 0px 0px;
        }.tabla tr td:last-child{
            border-width:0px 0px 1px 0px;
        }.tabla tr:last-child td:last-child{
            border-width:0px 0px 0px 0px;
        }
        .tabla tr:first-child td{
            background:-o-linear-gradient(bottom, #00a383 5%, #00a383 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #00a383), color-stop(1, #00a383) );
            background:-moz-linear-gradient( center top, #00a383 5%, #00a383 100% );
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#00a383", endColorstr="#00a383");	background: -o-linear-gradient(top,#00a383,00a383);

            background-color:#00a383;
            border:0px solid #000000;
            text-align:center;
            border-width:0px 0px 1px 1px;
            font-size:18px;
            font-family:Arial;
            font-weight:bold;
            color:#ffffff;
        }
        .tabla tr:first-child:hover td{
            background:-o-linear-gradient(bottom, #00a383 5%, #00a383 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #00a383), color-stop(1, #00a383) );
            background:-moz-linear-gradient( center top, #00a383 5%, #00a383 100% );
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#00a383", endColorstr="#00a383");	background: -o-linear-gradient(top,#00a383,00a383);

            background-color:#00a383;
        }
        .tabla tr:first-child td:first-child{
            border-width:0px 0px 1px 0px;
        }
        .tabla tr:first-child td:last-child{
            border-width:0px 0px 1px 1px;
        }
    </style> 
</html>
