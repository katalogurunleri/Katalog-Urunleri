<%@page import="java.util.List"%>
<%@page import="com.KatalogÜrünleri.Entidades.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String cod = request.getParameter("");
    String nom = request.getParameter("");
    String des = request.getParameter("");
    String exi = request.getParameter("");
    String val = request.getParameter("");
    String fot = request.getParameter("");
    String est = request.getParameter("");

    String men = (String) request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : "";

    List<Producto> LP = (List<Producto>) request.getAttribute("listado");
//vamos a recibir atributo para la consulta de un dato
    Producto datop = (Producto) request.getAttribute("datoproducto") != null ? (Producto) request.getAttribute("datoproducto") : null;
    if (datop != null) {
        cod = datop.getCodpro();
        nom = datop.getNombre();
        des = datop.getDescripcion();
        exi = datop.getExistencias();
        val = datop.getValor();
        fot = datop.getFoto();
        est = datop.getEstado();
    }// fin si

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="jq/jquery-ui.css">
        <script src="jq/jquery-1.10.2.js"></script>
        <script src="jq/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">

    </head>
    <!-- <center>
         <iframe width="95%" height="800" src="http://www.cincopa.com/media-platform/iframe.aspx?fid=AIDALc8Iadyh"  frameborder="0" allowfullscreen scrolling="si"></iframe><noscript><span>Katalog Ürünleri</span><span>Catálogo de productos</span><span>Crema natural care</span><span>Paquete promoción de cremas faciales y corporales humectantes</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 1428</span><span>width</span><span> 1600</span><span>camerasoftware</span><span> Google</span><span>Anew, crema facial</span><span>Crema para el contorno de los ojos y las lineas de expresión</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 302</span><span>height</span><span> 167</span><span>Body splash</span><span>Crema, jabón líquido, y loción splash aroma a mora</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 375</span><span>height</span><span> 375</span><span>Cremas Natural milk</span><span>paquete de cremas faciales y corporales humectantes.
             1lt</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 1600</span><span>width</span><span> 1553</span><span>camerasoftware</span><span> Google</span><span>Locion secret musk</span><span>75ml</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 225</span><span>height</span><span> 225</span><span>Locion pasion secret</span><span>50ml</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 500</span><span>height</span><span> 500</span><span>Lociones splash</span><span>Lociones body splash de fresa, pera, mora, manzana y naranja
             300ml c/u</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 500</span><span>height</span><span> 332</span><span>Loción masculina 300 km</span><span>100ml</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 613</span><span>height</span><span> 800</span><span>Paquete Exclusive</span><span>fragancia masculina Exclusive 10mil, desodorante, y crema</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 600</span><span>height</span><span> 510</span><span>Kit fragancia Musk</span><span>Loción 120ml, crema y desodorante</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 474</span><span>height</span><span> 500</span><span>Loción Juvenil 300</span><span>150ml</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 300</span><span>height</span><span> 300</span><span>Labiales Golden</span><span>variedad de colores</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 225</span><span>height</span><span> 225</span><span>Kit de Maquillaje avon</span><span>sombras, labial, rimel, y esmalte de uñas</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 300</span><span>width</span><span> 322</span><span>camerasoftware</span><span> Google</span><span>Sombras</span><span>Octetos de sombras </span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 605</span><span>width</span><span> 640</span><span>camerasoftware</span><span> Google</span><span>Polvo compacto</span><span>8g Texturas variadas</span><span>originaldate</span><span> 11/1/2010 2:40:27 PM</span><span>height</span><span> 446</span><span>width</span><span> 375</span><span>orientation</span><span> 1</span><span>camerasoftware</span><span> Adobe Photoshop CS5 </span><span>Delineadores soft </span><span>variedad de colores</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 400</span><span>height</span><span> 400</span><span>Base de maquillaje</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 361</span><span>height</span><span> 398</span><span>Cremas para manos</span><span>300ml c/u</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 640</span><span>height</span><span> 613</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 1428</span><span>width</span><span> 1600</span><span>camerasoftware</span><span> Google</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 302</span><span>height</span><span> 167</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 375</span><span>height</span><span> 375</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 1600</span><span>width</span><span> 1553</span><span>camerasoftware</span><span> Google</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 225</span><span>height</span><span> 225</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 500</span><span>height</span><span> 500</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 500</span><span>height</span><span> 332</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 613</span><span>height</span><span> 800</span><span>kqjq</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 600</span><span>height</span><span> 510</span><span>qkqjkq</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 474</span><span>height</span><span> 500</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 300</span><span>height</span><span> 300</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 225</span><span>height</span><span> 225</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 300</span><span>width</span><span> 322</span><span>camerasoftware</span><span> Google</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 605</span><span>width</span><span> 640</span><span>camerasoftware</span><span> Google</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 361</span><span>height</span><span> 398</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 640</span><span>height</span><span> 613</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 1428</span><span>width</span><span> 1600</span><span>camerasoftware</span><span> Google</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 302</span><span>height</span><span> 167</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 375</span><span>height</span><span> 375</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 1600</span><span>width</span><span> 1553</span><span>camerasoftware</span><span> Google</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 225</span><span>height</span><span> 225</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 500</span><span>height</span><span> 500</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 500</span><span>height</span><span> 332</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 613</span><span>height</span><span> 800</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 600</span><span>height</span><span> 510</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 474</span><span>height</span><span> 500</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 300</span><span>height</span><span> 300</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 225</span><span>height</span><span> 225</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 300</span><span>width</span><span> 322</span><span>camerasoftware</span><span> Google</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>height</span><span> 605</span><span>width</span><span> 640</span><span>camerasoftware</span><span> Google</span><span>originaldate</span><span> 11/1/2010 2:40:27 PM</span><span>height</span><span> 446</span><span>width</span><span> 375</span><span>orientation</span><span> 1</span><span>camerasoftware</span><span> Adobe Photoshop CS5 </span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 400</span><span>height</span><span> 400</span><span>originaldate</span><span> 1/1/0001 6:00:00 AM</span><span>width</span><span> 361</span><span>height</span><span> 398</span>
         </noscript>
     </center>
    -->
    <div id="centro">
        <form name="Xfrom" action="./ProductoServlet?action=listar" method="POST">
            <center><h1 id="titu"> Catálogo </h1>
            <h5 style="font-family: Arial; margin-bottom: -2%;">Clic en la imagen para mas información del producto</h5></center>
            <BR>
            <hr aling=left noshade size:5 width:70px color="#00a383"> 
            <%if (LP != null) {%>
            <% for (Producto pro : LP) {%>
            <script>
                $(function() {
                    $("#dialog").dialog({
                        modal: true,
                        autoOpen: false,
                        show: {
                            effect: "blind",
                            duration: 1000
                        },
                        hide: {
                            effect: "explode",
                            duration: 1000
                        }
                    });

                    $("#<%=pro.getCodpro()%>").click(function() {
                        $(".<%=pro.getCodpro()%>").dialog("open");
                    });
                });
            </script>
            <div id="dialog" class="<%=pro.getCodpro()%>"  title="<%=pro.getNombre()%>">
                <center> <img src="ImaCatalogo/<%=pro.getFoto()%>" height="250" width="250"  id="opener"/> 
                    <p width="50%">Código: <%=pro.getCodpro()%> <br> Descripción: <%=pro.getDescripcion()%></p>
                </center>
            </div>
            <div class="menu" id="menu" >
                <ul id="boton">
                    <li id="letra"> 
                    <center><img id="<%=pro.getCodpro()%>" id="img" src="ImaCatalogo/<%=pro.getFoto()%>" width="80" height="80">
                        <br>
                        <p id="txtcat"><%=pro.getNombre()%></p>  </center>
                    </li> 
            </div>
            <%}%>  
            <%}%>  
            <style type="text/css">
                ul li img{
                    opacity: 1;
                    -webkit-transition: all .6s ease;
                }
                ul li img:hover{
                    border-radius: 200px;
                    box-shadow: 0px 0px 20px #ddd;
                    transition: 2s;
                    -webkit-transform: scale(1.2);
                    background: url(Imagenes/lupa.png) no-repeat;
                }

                #img{
                    border-radius: 5%;
                }

                #menu  li  {
                    display: inline;
                    margin-bottom: 2%;
                    margin-top: -0.2%;
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
                    background-color:  #00a383;
                    color: black;
                    font-family: Arial;
                    font-size: 14px;
                    border-radius: 10px;
                }
                #txtcat{
                    font-family: Arial;
                    font-size: 110%;
                }
                #titu{
                    font-family: Arial;
                    color: #00a383;
                    font-size: 250%;
                    margin-bottom: -2%;
                }
                #centro{
                    width: 96%;
                    margin-left: 1%;
                    margin-bottom: 2%;
                    margin-top: 1%;
                    position: absolute;      
                    -webkit-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
                    -moz-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
                    box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
                }
            </style>

        </form>
    </div>
</html>