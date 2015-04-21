/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KatalogÜrünleri.Servlets;

import com.KatalogÜrünleri.Entidades.Producto;
import com.KatalogÜrünleri.Negocio.ProductoN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Familia
 */
public class ProductoServlet extends HttpServlet {

    Producto entP = new Producto();

    public void limpiar() {
        entP.setCodpro("");
        entP.setNombre("");
        entP.setDescripcion("");
        entP.setExistencias("");
        entP.setValor("");
        entP.setExistencias("");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FProducto.jsp";// enviar respuesta
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        // Traer par�metros de la petici�n
        // Hecha desde FUsuario.jsp
        String cod = request.getParameter("txtcodpro");
        String nom = request.getParameter("txtnombre");
        String des = request.getParameter("txtdescrip");
        String exi = request.getParameter("txtexis");
        String val = request.getParameter("txtvalor");
        String fot = request.getParameter("filefoto");
        String est = request.getParameter("cboestado");

        String men = "";// para los mensajes
        ProductoN pn = new ProductoN();// Creamos un Objeto
        // de tipo UsuarioN();
        // Establecemos atributos e inicializamos en null
        request.setAttribute("listado", null);
        // m�todo vacio espera dos par�metros:
        // 1. String--> nombre del atributo
        // 2. Object --> Object a establecer 
        request.setAttribute("mensaje", null);
        // Creamos un atributo para recuperar
        // Un dato de consulta(de Un Usuario x)
        request.setAttribute("datoproducto", null);
        // hay un bot�n con name = action y
        // con una propiedad value = buscar
        // si(buscar es igual a un par�metro de una petici�n)
        //llamada action   

        if ("buscar".equals(request.getParameter("action"))) {
            try {
                if (cod != "") {
                    men = "Búsqueda de producto con código: " + cod;
                    request.setAttribute("datoproducto", pn.getProducto(cod));
                    request.setAttribute("listado", pn.PorParametros(cod));
                    //enviamos los datos del  usuario a un atributo
                    //Llamado datousuario
                } else {
                    men = "Ingrese un código para la busqueda";
                }
            } catch (Exception e) {
                men = "" + e.getMessage();
                men += " causa : " + e.getCause();
                // vamos para FUsuario.jsp osea que abrir
                // en el editor el archivo      
            }

        }// fin si boton value es igual a buscar

        if ("nuevo".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datoproducto", entP);
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
        }// fin Nuevo

        if ("listar".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datoproducto", entP);
                request.setAttribute("listado", pn.listadoProductos());
                men = "Tabla de los productos existentes";

            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }// fin listar

        if ("guardar".equals(request.getParameter("action"))) {
            try {
                pn.insertarProducto(new Producto(cod, nom, des, exi, val, fot, est));
                request.setAttribute("listado", pn.listadoProductos());
            } catch (Exception er) {
                men = er.getMessage();
            }
        }// fin guardar

        if ("editar".equals(request.getParameter("action"))) {
            try {
                pn.actualizarProducto(new Producto(cod, nom, des, exi, val, fot, est));
                request.setAttribute("listado", pn.listadoProductos());
                /*
                 * Para Limpiar Textos
                 */
                limpiar();
                request.setAttribute("datoproducto", entP);
                /*
                 * FIN LIMPIAR TEXTOS
                 */

            } catch (Exception er) {
                men = "" + er.getMessage();
            }
        }// fin Editar

        if ("salir".equals(request.getParameter("action"))) {
            request.getSession().invalidate();
            request.getRequestDispatcher("./index.jsp").forward(request, response);
        }

        request.setAttribute("mensaje", men);
        request.getRequestDispatcher(pagina).forward(request, response);
    } // fin processrequest 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
