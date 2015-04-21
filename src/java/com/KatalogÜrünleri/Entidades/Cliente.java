package com.KatalogÜrünleri.Entidades;

public class Cliente {
    
    public Cliente(){}
    
    private String ideCliente, nombres, apellidos, correo, telefono, direccion, estado;

    public Cliente(String ideCliente, String nombres, String apellidos, String correo, String telefono, String direccion, String estado) {
        this.ideCliente = ideCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getIdeCliente() {
        return ideCliente;
    }

    public void setIdeCliente(String ideCliente) {
        this.ideCliente = ideCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
