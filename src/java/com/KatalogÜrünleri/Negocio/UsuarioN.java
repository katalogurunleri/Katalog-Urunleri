package com.KatalogÜrünleri.Negocio;

import com.KatalogÜrünleri.Entidades.Usuario;
import com.KatalogÜrünleri.Persistencia.DaosUsuario;
import com.KatalogÜrünleri.Utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

public class UsuarioN {

    public DaosUsuario dao;

    public UsuarioN() {
        dao = new DaosUsuario();
    }// fin constructor

    public Usuario getUsuarioEmail(String email) {
        Connection c = new Conexion().getCon();
        return dao.getUsuarioCorreo(c, email);
        //una vez programado pasamos al servlet al buscar

    }

    public List<Usuario> listadoUsuarios() {
        Connection c;
        c = new Conexion().getCon();
        return dao.listaUsuarios(c);
    }// fin ListadoUsuarios

    public List<Usuario> PorParametros(String usu) {
        Connection c;
        c = new Conexion().getCon();
        return dao.PorParametro(c, usu);
    }// fin ListadoUsuarios

    public Usuario getUsuario(String us) {
        Connection c;
        c = new Conexion().getCon();
        return dao.getUsuario(c, us);
    }// fin getUsuario()

    public Usuario getExisteCorreo(String us) {
        Connection c;
        c = new Conexion().getCon();
        return dao.getUsuario(c, us);
    }// fin getUsuario()

    public void insertarUsuario(Usuario user) throws Exception {
// Cargamos los datos en el servlet
        //con el constructor new(usuario, nombre,....estado)
        Conexion con = new Conexion();
        String mensajeError = "";
        String u = user.getUsuario();
        String nombre = user.getNombre();        
        String doc = user.getDocumento();
        String clave = user.getClave();
        String perfil = user.getPerfil();
        String estado = user.getEstado();
        String correo = user.getCorreo();
        String foto = user.getFoto();

        if ("".equals(correo) || null == correo) {
            mensajeError = "<br>Debe ingresar el  correo";
        }// fin si
        if ("".equals(estado) || null == estado) {
            mensajeError = "<br>Debe ingresar el  estado";
        }// fin si
        if ("".equals(perfil) || null == perfil) {
            mensajeError = "<br>Debe ingresar el  perfil";
        }// fin si
        if ("".equals(clave) || null == clave) {
            mensajeError = "<br>Debe ingresar la  contraseña";
        }// fin si
        if ("".equals(nombre) || null == nombre) {
            mensajeError = "<br>Debe ingresar el nombre";
        }// fin si
        if ("".equals(u) || null == u) {
            mensajeError = "<br>Debe ingresar el usuario";
        }// fin si
        if ("".equals(doc) || null == doc) {
            mensajeError = "<br>Debe ingresar el documento";
        }// fin si
// Para validar que si se hayan ingresado todos los
// campos obligatorios
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }// fin si

        if (dao.ValidarSiExiste(con.getCon(), u)) {
            mensajeError = "El usuario: " + u + " ya existe";
            throw new Exception(mensajeError);
        }

        mensajeError = dao.getInsertaUsuario(con.getCon(), u,
                nombre, doc, clave, perfil, estado, correo, foto);
        /*Para capturar errores al guardar el dato(Usuario)  */
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
            // Mostrar resultados (que grabó los datos ó en caso )
            // Contrario con los errores generados
        }// fin si

    }// Regresamos al servlet(UsuarioServlet)

    public void ActualizarUsuario(Usuario user) throws Exception {
// Cargamos los datos en el servlet
        //con el constructor new(usuario, nombre,....estado)
        Conexion con = new Conexion();
        String mensajeError = "";
        String u = user.getUsuario();
        String nombre = user.getNombre();
        String doc = user.getDocumento();
        String clave = user.getClave();
        String perfil = user.getPerfil();
        String estado = user.getEstado();
        String correo = user.getCorreo();
        String foto = user.getFoto();

        if ("".equals(u) || null == u) {
            mensajeError += "<br>Debe ingresar el usuario";
        }// fin si
        if ("".equals(nombre) || null == nombre) {
            mensajeError += "<br>Debe ingresar el nombre";
        }// fin si
        if ("".equals(doc) || null == doc) {
            mensajeError += "<br>Debe ingresar el documento";
        }// fin si
        if ("".equals(clave) || null == clave) {
            mensajeError += "<br>Debe ingresar la  clave";
        }// fin si
        if ("".equals(perfil) || null == perfil) {
            mensajeError += "<br>Debe ingresar el  perfil";
        }// fin si
        if ("".equals(estado) || null == estado) {
            mensajeError += "<br>Debe ingresar el  estado";
        }// fin si
        if ("".equals(correo) || null == correo) {
            mensajeError += "<br>Debe ingresar el  correo";
        }// fin si
// Para validar que si se hayan ingresado todos los
// campos obligatorios
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }// fin si

        // Lanzar una excepcion si el usuario ya existe
 /*
         * Validar que un dato no empice con un caracter
         * Ejemplo NIT / CEDULA 
         * 
         * Lanzamos una exepcion 
         */
        mensajeError = dao.getActualizarUsuario(con.getCon(), u, nombre, doc, clave, perfil, estado, correo, foto);
        /*Para capturar errores al guardar el dato(Usuario)  */
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
            // Mostrar resultados (que grabó los datos ó en caso )
            // Contrario con los errores generados
        }// fin si

    }// Regresamos al servlet(UsuarioServlet)

    public Usuario getValidarIngreso(String us, String pwd) {
        Connection c;
        c = new Conexion().getCon();
        return dao.getValidarIngreso(c, us, pwd);
    }// fin getUsuario()
// Como ya tenemos la capa de negocio con el 
//método para validar el ingreso al sistema
// Vamos a Crear una Servlet nombre:Autenticacion
// En el paquete servlet
//No vamos para el paquete servlet..
}// fin UsuarioN
