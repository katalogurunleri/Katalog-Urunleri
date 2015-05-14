/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KatalogÜrünleri.Persistencia;

import com.KatalogÜrünleri.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaosUsuario {

    public List<Usuario> listaUsuarios(Connection con) {
        List<Usuario> resultado = new ArrayList<Usuario>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getUsuario());
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Usuario u = new Usuario();
                u.setUsuario(registros.getString(1));
                u.setNombre(registros.getString(2));
                u.setClave(registros.getString(3));
                u.setEstado(registros.getString(4));
                u.setPerfil(registros.getString(5));
                u.setCorreo(registros.getString(6));
                u.setFoto(registros.getString(7));
                resultado.add(u);
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

    public List<Usuario> PorParametro(Connection con, String parametro) {
        List<Usuario> resultado = new ArrayList<Usuario>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getUsuario(parametro));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Usuario u = new Usuario();
                u.setUsuario(registros.getString(1));
                u.setNombre(registros.getString(2));
                u.setClave(registros.getString(3));
                u.setEstado(registros.getString(4));
                u.setPerfil(registros.getString(5));
                u.setCorreo(registros.getString(6));
                u.setFoto(registros.getString(7));
                resultado.add(u);
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

    public Usuario getUsuario(Connection con, String user) {
        Usuario u = new Usuario();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getUsuario(user));
            ResultSet r = p.executeQuery();
            while (r.next()) {
                u.setUsuario(r.getString(1));
                u.setNombre(r.getString(2));
                u.setClave(r.getString(3));
                u.setPerfil(r.getString(4));
                u.setEstado(r.getString(5));
                u.setCorreo(r.getString(6));
                u.setFoto(r.getString(7));

            }// fin mientras
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception cl) {
            }
        }
        return u;
    }// fin getUsuario
    
    public Usuario getUsuarioCorreo(Connection con, String correo) {
        Usuario u = new Usuario();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getUsuarioEmail(correo));
            ResultSet r = p.executeQuery();
            while (r.next()) {
                u.setUsuario(r.getString(1));
                u.setNombre(r.getString(2));
                u.setClave(r.getString(3));
                u.setPerfil(r.getString(4));
                u.setEstado(r.getString(5));
                u.setCorreo(r.getString(6));
                u.setFoto(r.getString(7));

            }// fin mientras
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception cl) {
            }
        }
        return u;
    }// fin getUsuario
    
    public boolean ValidarSiExiste(Connection con, String user) {
        boolean u = false;
        try {

            /*usuario, nombre,clave,perfil, estado */
            PreparedStatement p = con.prepareStatement(SQLHelpers.getUsuario(user));
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

    
    public boolean ValidarSiExisteCorreo(Connection con, String user) {
        boolean u = false;
        try {

            /*usuario, nombre,clave,perfil, estado */
            PreparedStatement p = con.prepareStatement(SQLHelpers.getUsuarioEmail(user));
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
    
    public String getInsertaUsuario(
            Connection con,
            String user,
            String nombre,
            String clave,
            String perfil,
            String estado,
            String correo,
            String foto) {
        String res = "";
        try {
            /*PreparedStatement una clase  
             * del subpaquete java.sql.*
             * permite crear  un espacio para ejecutar acciones sobre
             * Los elementso de una base de datos, basicamente
             * Necesita de  dos elementos: La conexion, el script sql
             * Ejemplo:
             */
            PreparedStatement p = con.prepareStatement(SQLHelpers.insertarUsuario());
            /*
             (1 usuario,2 nombre,3 clave,4 perfil, 5 estado)"
             values(1?,2?,3?,4?,5?)";
             */
            p.setString(1, user);
            p.setString(2, nombre);
            p.setString(3, clave);
            p.setString(4, perfil);
            p.setString(5, estado);
            p.setString(6, correo);
            p.setString(7, foto);
            p.execute();// Para acciones de actualizacion
// e inserción de datos, eliminación y otros
// es distinto a<>ó !=  executeQuery()-- solo consulta de datos
            if (p.getUpdateCount() > 0) {
                res = "Usuario agregado ";
            } else {
                res = "Error ! Usuario No..agregado.!";
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

    public String getActualizarUsuario(
            Connection con,
            String user,
            String nombre,
            String clave,
            String perfil,
            String estado,
            String correo,
            String foto) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.ActualizarUsuario());
            p.setString(7, user);
            p.setString(1, nombre);
            p.setString(2, clave);
            p.setString(3, perfil);
            p.setString(4, estado);
            p.setString(5, correo);
            p.setString(6, foto);
            p.execute();// Para acciones de actualizacion
// e inserción de datos, eliminación y otros
// es distinto a<>ó !=  executeQuery()-- solo consulta de datos
            if (p.getUpdateCount() > 0) {
                res = "Usuario Editado ";
            } else {
                res = "Error ! Usuario No..editado.!";
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

    public Usuario getValidarIngreso(Connection con, String user, String pwd) {
        Usuario u = new Usuario();
        u.setUsuario("0");
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getValidarIngreso(user, pwd));
            ResultSet r = p.executeQuery();
            while (r.next()) {
                u.setUsuario(r.getString(1));
                u.setNombre(r.getString(2));
                u.setClave(r.getString(3));
                u.setPerfil(r.getString(4));
                u.setEstado(r.getString(5));
                u.setCorreo(r.getString(6));
                u.setFoto(r.getString(7));
            }// fin mientras
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception cl) {
            }
        }
        return u;
    }// fin getValidarIngreso

}
