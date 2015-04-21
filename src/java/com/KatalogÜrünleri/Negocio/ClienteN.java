package com.KatalogÜrünleri.Negocio;

import com.KatalogÜrünleri.Entidades.Cliente;
import com.KatalogÜrünleri.Persistencia.DaosCliente;
import com.KatalogÜrünleri.Utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

public class ClienteN {

    public DaosCliente dao;

    public ClienteN() {
        dao = new DaosCliente();
    }// fin constructor

    public List<Cliente> listadoClientes() {
        Connection c;
        c = new Conexion().getCon();
        return dao.listaClientes(c);
    }// fin ListadoUsuarios

    public Cliente getCliente(String ced) {
        Connection c;
        c = new Conexion().getCon();
        return dao.getCliente(c, ced);
    }// fin getUsuario()

    public List<Cliente> PorParametros(String usu) {
        Connection c;
        c = new Conexion().getCon();
        return dao.PorParametroCli(c, usu);
    }// fin ListadoUsuarios

    public void insertarCliente(Cliente datoc) throws Exception {
// Cargamos los datos en el servlet
        //con el constructor new(usuario, nombre,....estado)
        Conexion con = new Conexion();
        String mensajeError = "";
        String idecli = datoc.getIdeCliente();
        String nom = datoc.getNombres();
        String ape = datoc.getApellidos();
        String corr = datoc.getCorreo();
        String tele = datoc.getTelefono();
        String dire = datoc.getDireccion();
        String estado = datoc.getEstado();
        if ("".equals(idecli) || null == idecli) {
            mensajeError += "<br>Debe ingresar el Id. del cliente";
        }// fin si

        if ("".equals(nom) || null == nom) {
            mensajeError += "<br>Debe ingresar el nombre";
        }// fin si
        if ("".equals(ape) || null == ape) {
            mensajeError += "<br>Debe ingresar el (los) apellido (s)";
        }// fin si
        if ("".equals(corr) || null == corr) {
            mensajeError += "<br>Debe ingresar el  correo";
        }// fin si
        if ("".equals(estado) || null == estado) {
            mensajeError += "<br>Debe ingresar el  estado";
        }// fin si
        if ("".equals(tele) || null == tele) {
            mensajeError += "<br>Debe ingresar el  teléfono";
        }// fin si
        if ("".equals(dire) || null == dire) {
            mensajeError += "<br>Debe ingresar la dirección";
        }// fin si
        if ("".equals(estado) || null == estado) {
            mensajeError += "<br>Debe ingresar el estado";
        }// fin si
// Para validar que si se hayan ingresado todos los
// campos obligatorios
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }// fin si

        if (dao.ValidarSiExisteCli(con.getCon(), idecli)) {
            mensajeError = "El Cliente: " + idecli + " ya existe";
            throw new Exception(mensajeError);
        }

        mensajeError = dao.getInsertaCliente(con.getCon(), idecli, nom, ape, corr, tele, dire, estado);
        /*Para capturar errores al guardar el dato(Usuario)  */
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
            // Mostrar resultados (que grabó los datos ó en caso )
            // Contrario con los errores generados
        }// fin si

    }// Regresamos al servlet(UsuarioServlet)

    public void actualizarCliente(Cliente datoc) throws Exception {
// Cargamos los datos en el servlet
        //con el constructor new(usuario, nombre,....estado)
        Conexion con = new Conexion();
        String mensajeError = "";
        String idecli = datoc.getIdeCliente();
        String nom = datoc.getNombres();
        String ape = datoc.getApellidos();
        String corr = datoc.getCorreo();
        String tele = datoc.getTelefono();
        String dire = datoc.getDireccion();
        String estado = datoc.getEstado();
        if ("".equals(idecli) || null == idecli) {
            mensajeError += "<br>Debe ingresar el Id. del cliente";
        }// fin si

        if ("".equals(nom) || null == nom) {
            mensajeError += "<br>Debe ingresar el nombre";
        }// fin si
        if ("".equals(ape) || null == ape) {
            mensajeError += "<br>Debe ingresar el (los) apellido (s)";
        }// fin si
        if ("".equals(corr) || null == corr) {
            mensajeError += "<br>Debe ingresar el  correo";
        }// fin si
        if ("".equals(estado) || null == estado) {
            mensajeError += "<br>Debe ingresar el  estado";
        }// fin si
        if ("".equals(tele) || null == tele) {
            mensajeError += "<br>Debe ingresar el  teléfono";
        }// fin si
        if ("".equals(dire) || null == dire) {
            mensajeError += "<br>Debe ingresar la dirección";
        }// fin si
        if ("".equals(estado) || null == estado) {
            mensajeError += "<br>Debe ingresar el estado";
        }// fin si
// Para validar que si se hayan ingresado todos los
// campos obligatorios
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }// fin si

        mensajeError = dao.getActualizarCliente(con.getCon(), idecli, nom, ape, corr, tele, dire, estado);
        /*Para capturar errores al guardar el dato(Usuario)  */
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
            // Mostrar resultados (que grabó los datos ó en caso )
            // Contrario con los errores generados
        }// fin si

    }// Regresamos al servlet(UsuarioServlet)

    public void RegistrarCliente(Cliente datoc) throws Exception {
// Cargamos los datos en el servlet
        //con el constructor new(usuario, nombre,....estado)
        Conexion con = new Conexion();
        String mensajeError = "";
        String idecli = datoc.getIdeCliente();
        String nom = datoc.getNombres();
        String ape = datoc.getApellidos();
        String corr = datoc.getCorreo();
        String tele = datoc.getTelefono();
        String dire = datoc.getDireccion();
        String estado = datoc.getEstado();
        if ("".equals(idecli) || null == idecli) {
            mensajeError += "<br>Debe ingresar el Id. del cliente";
        }// fin si

        if ("".equals(nom) || null == nom) {
            mensajeError += "<br>Debe ingresar el nombre";
        }// fin si
        if ("".equals(ape) || null == ape) {
            mensajeError += "<br>Debe ingresar el (los) apellido (s)";
        }// fin si
        if ("".equals(corr) || null == corr) {
            mensajeError += "<br>Debe ingresar el  correo";
        }// fin si
        if ("".equals(estado) || null == estado) {
            mensajeError += "<br>Debe ingresar el  estado";
        }// fin si
        if ("".equals(tele) || null == tele) {
            mensajeError += "<br>Debe ingresar el  teléfono";
        }// fin si
        if ("".equals(dire) || null == dire) {
            mensajeError += "<br>Debe ingresar la dirección";
        }// fin si
        if ("".equals(estado) || null == estado) {
            estado = "Inactivo";
        }// fin si
// Para validar que si se hayan ingresado todos los
// campos obligatorios
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }// fin si

        if (dao.ValidarSiExisteCli(con.getCon(), idecli)) {
            mensajeError = "El Cliente: " + idecli + " ya existe";
            throw new Exception(mensajeError);
        }

        mensajeError = dao.getInsertaCliente(con.getCon(), idecli, nom, ape, corr, tele, dire, estado);
        /*Para capturar errores al guardar el dato(Usuario)  */
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
            // Mostrar resultados (que grabó los datos ó en caso )
            // Contrario con los errores generados
        }// fin si

    }// Regresamos al servlet(UsuarioServlet)
    
}
