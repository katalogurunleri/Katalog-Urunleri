package com.KatalogÜrünleri.Negocio;

import com.KatalogÜrünleri.Entidades.Producto;
import com.KatalogÜrünleri.Persistencia.DaosProducto;
import com.KatalogÜrünleri.Utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

public class ProductoN {

    public DaosProducto dao;

    public ProductoN() {
        dao = new DaosProducto();
    }// fin constructor

    public List<Producto> listadoProductos() {
        Connection c;
        c = new Conexion().getCon();
        return dao.listaProductos(c);
    }// fin ListadoUsuarios

    public Producto getProducto(String ced) {
        Connection c;
        c = new Conexion().getCon();
        return dao.getProducto(c, ced);
    }// fin getUsuario()

    public List<Producto> PorParametros(String usu) {
        Connection c;
        c = new Conexion().getCon();
        return dao.PorParametroProd(c, usu);
    }// fin ListadoUsuarios

    public void insertarProducto(Producto datop) throws Exception {
// Cargamos los datos en el servlet
        //con el constructor new(usuario, nombre,....estado)
        Conexion con = new Conexion();
        String mensajeError = "";
        String cod = datop.getCodpro();
        String nombre = datop.getNombre();
        String desp = datop.getDescripcion();
        String exis = datop.getExistencias();
        String valor = datop.getValor();
        String foto = datop.getFoto();
        String est = datop.getEstado();

        if ("".equals(cod) || null == cod) {
            mensajeError += "<br>Debe ingresar el código del producto";
        }// fin si

        if ("".equals(nombre) || null == nombre) {
            mensajeError += "<br>Debe ingresar el nombre del producto";
        }// fin si
        if ("".equals(desp) || null == desp) {
            mensajeError += "<br>Debe ingresar la descripción del producto";
        }// fin si
        if ("".equals(exis) || null == exis) {
            mensajeError += "<br>Debe ingresar la existencia del producto";
        }// fin si
        if ("".equals(valor) || null == valor) {
            mensajeError += "<br>Debe ingresar el  valor del producto";
        }// fin si
        if ("".equals(foto) || null == foto) {
            mensajeError += "<br>Debe ingresar la foto del producto";
        }// fin si
        if ("".equals(est) || null == est) {
            mensajeError += "<br>Debe ingresar el estado del producto";
        }// fin si

// Para validar que si se hayan ingresado todos los
// campos obligatorios
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }// fin si

        if (dao.ValidarSiExistePro(con.getCon(), cod)) {
            mensajeError = "El producto: " + cod + " ya existe";
            throw new Exception(mensajeError);
        }

        mensajeError = dao.getInsertaProducto(con.getCon(), cod, nombre, desp, exis, valor, foto, est);
        /*Para capturar errores al guardar el dato(Usuario)  */
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
            // Mostrar resultados (que grabó los datos ó en caso )
            // Contrario con los errores generados
        }// fin si

    }// Regresamos al servlet(UsuarioServlet)

    public void actualizarProducto(Producto datop) throws Exception {
// Cargamos los datos en el servlet
        //con el constructor new(usuario, nombre,....estado)
        Conexion con = new Conexion();
        String mensajeError = "";
        String cod = datop.getCodpro();
        String nombre = datop.getNombre();
        String desp = datop.getDescripcion();
        String exis = datop.getExistencias();
        String valor = datop.getValor();
        String foto = datop.getFoto();
        String est = datop.getEstado();

        if ("".equals(cod) || null == cod) {
            mensajeError += "<br>Debe ingresar el código del producto";
        }// fin si

        if ("".equals(nombre) || null == nombre) {
            mensajeError += "<br>Debe ingresar el nombre del producto";
        }// fin si
        if ("".equals(desp) || null == desp) {
            mensajeError += "<br>Debe ingresar la descripción del producto";
        }// fin si
        if ("".equals(exis) || null == exis) {
            mensajeError += "<br>Debe ingresar la existencia del producto";
        }// fin si
        if ("".equals(valor) || null == valor) {
            mensajeError += "<br>Debe ingresar el  valor del producto";
        }// fin si
        if ("".equals(foto) || null == foto) {
            mensajeError += "<br>Debe ingresar la foto del producto";
        }// fin si
        if ("".equals(est) || null == est) {
            mensajeError += "<br>Debe ingresar el estado del producto";
        }// fin si

// Para validar que si se hayan ingresado todos los
// campos obligatorios
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }// fin si

        mensajeError = dao.getActualizarProdcuto(con.getCon(), cod, nombre, desp, exis, valor, foto, est);
        /*Para capturar errores al guardar el dato(Usuario)  */
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
            // Mostrar resultados (que grabó los datos ó en caso )
            // Contrario con los errores generados
        }// fin si

    }// Regresamos al servlet(UsuarioServlet)

}
