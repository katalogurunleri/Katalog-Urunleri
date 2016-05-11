package com.KatalogÜrünleri.Persistencia;

public class SQLHelpers {

    //Lista de los usuarios
    public static String getUsuario() {
        return "SELECT usuario, nombre, documento, clave, estado, perfil, correo, foto FROM katalog.tblusuario ";
    }//fin método     
//Consultar Usuario

    public static String getUsuario(String user) {
        return "SELECT usuario, nombre, documento,clave,perfil, estado, correo, foto FROM katalog.tblusuario where usuario ='" + user + "' ";
    }//fin método     
//Insertar Usuario

    public static String getUsuarioEmail(String correo) {
        return "SELECT usuario, nombre, documento,clave,perfil, estado, correo, foto FROM tkatalog.tblusuario where correo ='"+correo+"'";
    }

    public static String insertarUsuario() {
        return "INSERT INTO katalog.tblusuario(usuario,nombre, documento, clave,perfil, estado, correo, foto)values(?,?,?,?,?,?,?,?)";
    }
//Editar usuario

    public static String ActualizarUsuario() {
        return "UPDATE katalog.tblusuario set nombre=?, documento=?,clave=? ,perfil=?,estado=?, correo=?, foto=? WHERE usuario=?";
    }

//Validar Ingreso Al Sistema
    public static String getValidarIngreso(String user, String pwd) {
        return "SELECT usuario, nombre, clave, perfil, estado, correo, foto  FROM katalog.tblusuario where usuario ='" + user + "' AND clave='" + pwd + "' ";
    }//fin método

    public static String getProducto() {
        return "Select codpro, nombre,descripcion, existencias, valor, foto, estado, catprin FROM katalog.tblproductos";
    }

    public static String getProducto(String cos) {
        return "Select codpro, nombre,descripcion, existencias, valor, foto, estado, catprin  FROM katalog.tblproductos where codpro='" + cos + "'";
    }

    public static String insertarProducto() {
        return "INSERT INTO katalog.tblproductos (codpro, nombre,descripcion, existencias, valor, foto, estado, catprin )VALUES (?,?,?,?,?,?,?,?)";
    }

    public static String actualizarProducto() {
        return "UPDATE katalog.tblproductos set nombre=?,descripcion=?, existencias=?, valor=?, foto=?, estado=?, catprin=? where codpro=? ";
    }
}
