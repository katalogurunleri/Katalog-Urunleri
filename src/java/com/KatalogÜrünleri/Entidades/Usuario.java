package com.KatalogÜrünleri.Entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

    String usuario;
    String nombre;
    String documento;
    String clave;
    String conclave;
    String perfil;
    String estado;
    String correo;
    String foto;
    
    public Usuario() {
    }

    public Usuario(String usuario, String nombre, String documento, String clave, String perfil, String estado, String correo, String foto) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.documento = documento;
        this.clave = clave;
        this.perfil = perfil;
        this.estado = estado;
        this.correo = correo;
        this.foto = foto;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    } 

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getConclave() {
        return conclave;
    }

    public void setConclave(String conclave) {
        this.conclave = conclave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", nombre=" + nombre + ", documento=" + documento + ", clave=" + clave + ", conclave=" + conclave + ", perfil=" + perfil + ", estado=" + estado + ", correo=" + correo + ", foto=" + foto + '}';
    }
    
    
    
}//Fin Clase Usuario
