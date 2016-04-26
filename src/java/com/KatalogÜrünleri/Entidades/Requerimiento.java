
package com.KatalogÜrünleri.Entidades;

public class Requerimiento {
    
    private String nro, titulo, detalle, autor, encargado, nvl;

    public Requerimiento(String nro, String titulo, String detalle, String autor, String encargado, String nvl) {
        this.nro = nro;
        this.titulo = titulo;
        this.detalle = detalle;
        this.autor = autor;
        this.encargado = encargado;
        this.nvl = nvl;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getNvl() {
        return nvl;
    }

    public void setNvl(String nvl) {
        this.nvl = nvl;
    }
    
    
}
