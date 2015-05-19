/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KatalogÜrünleri.Servlets;

import com.KatalogÜrünleri.Entidades.Usuario;
import com.KatalogÜrünleri.Negocio.UsuarioN;
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
public class UsuarioServlet extends HttpServlet {

    Usuario entU = new Usuario();

    public void limpiar() {
        entU.setUsuario("");
        entU.setNombre("");
        entU.setEstado("");
        entU.setPerfil("");
        entU.setClave("");
        entU.setCorreo("");
        entU.setConclave("");

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FUsuario.jsp";// enviar respuesta
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        // Traer par�metros de la petici�n
        // Hecha desde FUsuario.jsp
        String user = request.getParameter("txtusuario");
        String nombre = request.getParameter("txtnombre");
        String clave = request.getParameter("txtclave");
        String conclave = request.getParameter("txtconclave");
        String perfil = request.getParameter("cboperfil");

        String estado = request.getParameter("cboestado");
        String correo = request.getParameter("txtcorreo");
        String foto = request.getParameter("filefoto");

        String men = "";// para los mensajes
        UsuarioN un = new UsuarioN();// Creamos un Objeto
        // de tipo UsuarioN();
        // Establecemos atributos e inicializamos en null
        request.setAttribute("listado", null);
        // m�todo vacio espera dos par�metros:
        // 1. String--> nombre del atributo
        // 2. Object --> Object a establecer 
        request.setAttribute("mensaje", null);
        // Creamos un atributo para recuperar
        // Un dato de consulta(de Un Usuario x)
        request.setAttribute("datousuario", null);
        // hay un bot�n con name = action y
        // con una propiedad value = buscar
        // si(buscar es igual a un par�metro de una petici�n)
        //llamada action   

        if ("buscar".equals(request.getParameter("action"))) {
            try {
                if (user != "") {
                    men = "Búsqueda de usuario llamado: " + user;
                    request.setAttribute("datousuario", un.getUsuario(user));

                    try {
                        request.setAttribute("listado", un.PorParametros(user));
                    } catch (Exception e) {
                        men = "" + e.getMessage();
                        men += " causa : " + e.getCause();
                    }

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
                request.setAttribute("datousuario", entU);
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
        }// fin Nuevo

        if ("listar".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datousuario", entU);
                request.setAttribute("listado", un.listadoUsuarios());
                men = "Tabla de los usuarios existentes";

            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }// fin listar

        if ("guardar".equals(request.getParameter("action"))) {
            try {
                if (clave.equals(conclave)) {

                    String resp = "NO SIRVE";
                    char Caracter;
                    int ASCII, mayusc, longi, num, minusc;
                    mayusc = 0;
                    minusc = 0;
                    longi = 0;
                    num = 0;
                    for (int i = 0; i < clave.length(); i++) {
                        Caracter = clave.charAt(i);
                        ASCII = Caracter;
                        if (ASCII >= 65 && ASCII <= 90) {
                            mayusc = mayusc + 1;
                        }
                        if (ASCII >= 48 && ASCII <= 59) {
                            num = num + 1;
                        }
                        if (ASCII >= 97 && ASCII <= 112) {
                            minusc = minusc + 1;
                        }
                    }
                    if (clave.length() >= 8 && clave.length() <= 16) {
                        longi = 1;
                    }
                    if (mayusc != 0 && longi != 0 && num >= 3 && minusc >= 3) {
                        resp = "SIRVE";
                        un.insertarUsuario(new Usuario(user, nombre, clave, perfil, estado, correo, foto));
                        request.setAttribute("listado", un.listadoUsuarios());
                    }
                    if (resp.equals("NO SIRVE")) {
                        men += "<br>Su contraseña no cumple lo siguiente: ";
                        if (mayusc == 0) {
                            men += "<br>• Agrege 1 o mas de 1 letra mayuscula para su contraseña";
                        }
                        if (minusc < 3) {
                            men += "<br>•Agrege 3 o mas de 3 letras minusculas para su contraseña";
                        }
                        if (minusc < 3) {
                            men += "<br>•Agrege 3 o mas de 3 numeros para su contraseña";
                        }
                        if (longi == 0) {
                            men += "<br>•Use mas de 8 caracteres y menos de 16 para su contraseña ";
                        }
                        men += "<br><br>Por seguridad mejore lo anterior dicho ";
                    }

                } else {
                    men = "Las contraseñas no coinsiden";
                }

            } catch (Exception er) {
                men = er.getMessage();
            }
        }// fin guardar

        if ("editar".equals(request.getParameter("action"))) {
            try {
                un.ActualizarUsuario(new Usuario(user, nombre, clave, perfil, estado, correo, foto));
                request.setAttribute("listado", un.listadoUsuarios());
                /*
                 * Para Limpiar Textos
                 */
                limpiar();
                request.setAttribute("datousuario", entU);
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
        if ("inicio".equals(request.getParameter("action"))) {
            request.getRequestDispatcher(pagina).forward(request, response);

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
