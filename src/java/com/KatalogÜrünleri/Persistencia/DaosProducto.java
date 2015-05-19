package com.KatalogÜrünleri.Persistencia;

import com.KatalogÜrünleri.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaosProducto {

    public List<Producto> listaProductos(Connection con) {
        List<Producto> resultado = new ArrayList<Producto>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getProducto());
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Producto pr = new Producto();
                pr.setCodpro(registros.getString(1));
                pr.setNombre(registros.getString(2));
                pr.setDescripcion(registros.getString(3));
                pr.setExistencias(registros.getString(4));
                pr.setValor(registros.getString(5));
                pr.setFoto(registros.getString(6));
                pr.setEstado(registros.getString(7));
                pr.setCatprin(registros.getString(8));
                resultado.add(pr);
            }// fin mientras

        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
            }
        }// fin finally

        return resultado;
    }// fin ListaUsuarios  

    public List<Producto> PorParametroProd(Connection con, String parametro) {
        List<Producto> resultado = new ArrayList<Producto>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getProducto(parametro));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Producto pr = new Producto();
                pr.setCodpro(registros.getString(1));
                pr.setNombre(registros.getString(2));
                pr.setDescripcion(registros.getString(3));
                pr.setExistencias(registros.getString(4));
                pr.setValor(registros.getString(5));
                pr.setFoto(registros.getString(6));
                pr.setEstado(registros.getString(7));
                pr.setCatprin(registros.getString(8));
                resultado.add(pr);
            }// fin mientras

        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
            }
        }// fin finally
        return resultado;
    }// fin ListaUsuarios  

    public Producto getProducto(Connection con, String cod) {
        Producto pr = new Producto();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getProducto(cod));
            ResultSet r = p.executeQuery();
            while (r.next()) {
                pr.setCodpro(r.getString(1));
                pr.setNombre(r.getString(2));
                pr.setDescripcion(r.getString(3));
                pr.setExistencias(r.getString(4));
                pr.setValor(r.getString(5));
                pr.setFoto(r.getString(6));
                pr.setEstado(r.getString(7));
                pr.setCatprin(r.getString(8));
            }// fin mientras
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception cl) {
            }
        }
        return pr;
    }// fin getUsuario
// Guardar un dato (Un usuario)

    public boolean ValidarSiExistePro(Connection con, String cod) {
        boolean u = false;
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getProducto(cod));
            ResultSet r = p.executeQuery();
            while (r.next()) {
                u = true;
            }// fin mientras
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception cl) {
            }
        }
        return u;
    }// fin ValidarSiExiste

    public String getInsertaProducto(
            Connection con,
            String cod,
            String nombre,
            String desp,
            String exis,
            String valor,
            String foto, 
            String estado,
            String catprin
            ) {
        String res = "";
        try {

            PreparedStatement p = con.prepareStatement(SQLHelpers.insertarProducto());

            p.setString(1, cod);
            p.setString(2, nombre);
            p.setString(3, desp);
            p.setString(4, exis);
            p.setString(5, valor);
            p.setString(6, foto);
            p.setString(7, estado);
            p.setString(8, catprin);
            p.execute();// Para acciones de actualizacion
// e inserción de datos, eliminación y otros
// es distinto a<>ó !=  executeQuery()-- solo consulta de datos
            if (p.getUpdateCount() > 0) {
                res = "Producto agregado ";
            } else {
                res = "Error ! Producto No..agregado.!";
            }// fin si
        } catch (Exception e) {
            res += "" + e.getMessage() + " Causa :" + e.getCause();
        } finally {
            try {
                con.close();
            } catch (Exception e2) {
            }
        }// fin finally
        return res;
    }// fin insertar dato
// Nos vamos para la capa de negocio y 
// Creamos el método para guardar un dato(Usuario)

    public String getActualizarProdcuto(
            Connection con,
            String cod,
            String nombre,
            String desp,
            String exis,
            String valor,
            String foto, 
            String estado,
            String catprin) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.actualizarProducto());
           p.setString(8, cod);
            p.setString(1, nombre);
            p.setString(2, desp);
            p.setString(3, exis);
            p.setString(4, valor);
            p.setString(5, foto);
            p.setString(6, estado);
            p.setString(7, catprin);
            p.execute();// Para acciones de actualizacion
// e inserción de datos, eliminación y otros
// es distinto a<>ó !=  executeQuery()-- solo consulta de datos
            if (p.getUpdateCount() > 0) {
                res = "Producto actualizado";
            } else {
                res = "Error ! Producto No..actualizado.!";
            }// fin si
        } catch (Exception e) {
            res += "" + e.getMessage() + " Causa :" + e.getCause();
        } finally {
            try {
                con.close();
            } catch (Exception e2) {
            }
        }// fin finally
        return res;
    }// fin insertar dato

}
