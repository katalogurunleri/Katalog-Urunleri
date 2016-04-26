package com.KatalogÜrünleri.Entidades;

public class UsuarioArbol {
    
    int dato;
    UsuarioArbol LI;    
    UsuarioArbol LD;
    int direccion;
    int FB;

    public UsuarioArbol(int dato, UsuarioArbol LI, UsuarioArbol LD, int direccion, int FB) {
        this.dato = dato;
        this.LI = LI;
        this.LD = LD;
        this.direccion = direccion;
        this.FB = FB;
    }

    public UsuarioArbol() {
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public UsuarioArbol getLI() {
        return LI;
    }

    public void setLI(UsuarioArbol LI) {
        this.LI = LI;
    }

    public UsuarioArbol getLD() {
        return LD;
    }

    public void setLD(UsuarioArbol LD) {
        this.LD = LD;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getFB() {
        return FB;
    }

    public void setFB(int FB) {
        this.FB = FB;
    }
}
