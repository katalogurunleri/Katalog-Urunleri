package com.KatalogÜrünleri.Persistencia;

import com.KatalogÜrünleri.Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaosCliente {

    public List<Cliente> listaClientes(Connection con) {
        List<Cliente> resultado = new ArrayList<Cliente>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCliente());
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Cliente c = new Cliente();
                c.setIdeCliente(registros.getString(1));
                c.setNombres(registros.getString(2));
                c.setApellidos(registros.getString(3));
                c.setCorreo(registros.getString(4));
                c.setTelefono(registros.getString(5));
                c.setDireccion(registros.getString(6));
                c.setEstado(registros.getString(7));
                resultado.add(c);
            }// fin mientras
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception clo) {
            }
        }// fin finally
        return resultado;
    }// fin Lista Entrada_lote

    public Cliente getCliente(Connection con, String ide) {
        Cliente c = new Cliente();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCliente(ide));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                c.setIdeCliente(registros.getString(1));
                c.setNombres(registros.getString(2));
                c.setApellidos(registros.getString(3));
                c.setCorreo(registros.getString(4));
                c.setTelefono(registros.getString(5));
                c.setDireccion(registros.getString(6));
                c.setEstado(registros.getString(7));
            }// fin mientras
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception cl) {
            }
        }
        return c;
    }// fin getUsuario

    public boolean ValidarSiExisteCli(Connection con, String cli) {
        boolean u = false;
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCliente(cli));
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

    public List<Cliente> PorParametroCli(Connection con, String parametro) {
        List<Cliente> resultado = new ArrayList<Cliente>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCliente(parametro));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Cliente c = new Cliente();
                c.setIdeCliente(registros.getString(1));
                c.setNombres(registros.getString(2));
                c.setApellidos(registros.getString(3));
                c.setCorreo(registros.getString(4));
                c.setTelefono(registros.getString(5));
                c.setDireccion(registros.getString(6));
                c.setEstado(registros.getString(7));
                resultado.add(c);
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

    public String getInsertaCliente(
            Connection con,
            String ideCliente,
            String nombres,
            String apellidos,
            String correo,
            String telefono,
            String direccion,
            String estado) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.insertarCliente());
            p.setString(1, ideCliente);
            p.setString(2, nombres);
            p.setString(3, apellidos);
            p.setString(4, correo);
            p.setString(5, telefono);
            p.setString(6, direccion);
            p.setString(7, estado);

            p.execute();// Para acciones de actualizacion
            if (p.getUpdateCount() > 0) {
                res = "Cliente agregado ";
            } else {
                res = "Error ! Cliente No..agregado.!";
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
    }// fin insertar laboratorio

    public String getActualizarCliente(
            Connection con,
            String ideCliente,
            String nombres,
            String apellidos,
            String correo,
            String telefono,
            String direccion,
            String estado) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.actualizarCliente());
            p.setString(7, ideCliente);
            p.setString(1, nombres);
            p.setString(2, apellidos);
            p.setString(3, correo);
            p.setString(4, telefono);
            p.setString(5, direccion);
            p.setString(6, estado);

            p.execute();// Para acciones de actualizacion
            if (p.getUpdateCount() > 0) {
                res = "Cliente editado ";
            } else {
                res = "Error ! Cliente No..editado.!";
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
    }// fin insertar laboratorio
}
