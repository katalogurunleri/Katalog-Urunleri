package com.KatalogÜrünleri.Utilidades;

//import com.Brillapismar.persistencia.SQLHelpers;
import com.KatalogÜrünleri.Persistencia.SQLHelpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public Conexion() {
    }

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (ClassNotFoundException e1) {
            System.out.println("ClassNotFoundException  :"
                    + e1.getMessage());
        } catch (InstantiationException e2) {
            System.out.println("InstantiationException :"
                    + e2.getMessage());
        } catch (IllegalAccessException e3) {
            System.out.println("IllegalAccessException :"
                    + e3.getMessage());
        } catch (Exception e) {
            System.out.println("Exception general :"
                    + e.getMessage());
        }
    }// fin static
    public Connection Con;

    public Connection getCon() {
        ConexionDB();
        return Con;
    }

    public void setCon(Connection Con) {
        this.Con = Con;
    }

    public void ConexionDB() {
        String host = "Localhost";
//String host="200.75.77.34";
        String puerto = "1521";
        String SID = "xe";// espacio de trabajo único
        String user = "Katalog";
        String password = "AdminKat123";
        try {

            DriverManager.registerDriver(
                    new oracle.jdbc.OracleDriver());
            setCon(DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + puerto + ":" + SID, user, password));

        } catch (SQLException e4) {
            System.out.println("SQLException :" + e4.getMessage());

        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
        }
    }// Fin ConexionDB

    public void cerrarConexion() throws SQLException {
        this.Con.close();
    }

    public static void main(String param[]) {
        Conexion c = new Conexion();
        Connection con;
        /*
         probar sentencias SQL
         */
        try {
            ResultSet r = c.getCon().prepareStatement(SQLHelpers.getUsuarioEmail("brayan_sosa23151@elpoli.edu.co")).executeQuery();
            System.out.println("lista de los Usuarios");

            if (r.next()) {
                System.out.println("Usuario: " + r.getString(2));
                while (r.next()) {
                    System.out.println("Usuario: " + r.getString(2));
                }// fin while
            } else {
                System.out.println("No hay datos ");
            }// fin si

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage() + " Causa " + e.getCause());

        } finally {
            try {
                c.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
    }// fin del main
}// fin de la clase
