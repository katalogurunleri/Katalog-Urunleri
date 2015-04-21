/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.KatalogÜrünleri.Servlets;

import com.KatalogÜrünleri.Entidades.Cliente;
import com.KatalogÜrünleri.Negocio.ClienteN;
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
public class ClienteServlet extends HttpServlet {

    Cliente entC = new Cliente();

    public void limpiar() {
        entC.setIdeCliente("");
        entC.setNombres("");
        entC.setApellidos("");
        entC.setCorreo("");
        entC.setTelefono("");
        entC.setDireccion("");
        entC.setEstado("...Seleccione...");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FCliente.jsp";// enviar respuesta
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        // Traer par�metros de la petici�n
        // Hecha desde FUsuario.jsp
        String idecli = request.getParameter("txtidecliente");
        String nom = request.getParameter("txtnombre");
        String ape = request.getParameter("txtapellido");
        String corr = request.getParameter("txtcorreo");
        String tele = request.getParameter("txttelefono");
        String dire = request.getParameter("txtdireccion");
        String estado = request.getParameter("cboestado");

        String men = "";// para los mensajes
        ClienteN cn = new ClienteN();// Creamos un Objeto
        // de tipo UsuarioN();
        // Establecemos atributos e inicializamos en null
        request.setAttribute("listado", null);
        // m�todo vacio espera dos par�metros:
        // 1. String--> nombre del atributo
        // 2. Object --> Object a establecer 
        request.setAttribute("mensaje", null);
        // Creamos un atributo para recuperar
        // Un dato de consulta(de Un Usuario x)
        request.setAttribute("datocliente", null);
        // hay un bot�n con name = action y
        // con una propiedad value = buscar
        // si(buscar es igual a un par�metro de una petici�n)
        //llamada action   

        if ("buscar".equals(request.getParameter("action"))) {
            try {
                if (idecli != "") {
                    men = "Búsqueda de usuario llamado: " + idecli;
                    request.setAttribute("datocliente", cn.getCliente(idecli));
                    request.setAttribute("listado", cn.PorParametros(idecli));
                    //enviamos los datos del  usuario a un atributo
                    //Llamado datousuario
                } else {
                    men = "Ingrese un usuario para la busqueda";
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
                request.setAttribute("datocliente", entC);
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
        }// fin Nuevo

        if ("listar".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datocliente", entC);
                request.setAttribute("listado", cn.listadoClientes());
                men = "Tabla de los clientes existentes";

            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }// fin listar

        if ("guardar".equals(request.getParameter("action"))) {
            try {
                cn.insertarCliente(new Cliente(idecli, nom, ape, corr, tele, dire, estado));
                request.setAttribute("listado", cn.listadoClientes());
            } catch (Exception er) {
                men = er.getMessage();
            }
        }// fin guardar

        if ("editar".equals(request.getParameter("action"))) {
            try {
                cn.actualizarCliente(new Cliente(idecli, nom, ape, corr, tele, dire, estado));
                request.setAttribute("listado", cn.listadoClientes());
                /*
                 * Para Limpiar Textos
                 */
                limpiar();
                request.setAttribute("datousuario", entC);
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
