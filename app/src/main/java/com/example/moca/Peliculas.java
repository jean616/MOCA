package com.example.moca;

public class Peliculas {

    private String titulo;
    private String año;
    private String descripcion;
    private String director;

    public Peliculas(String titulo, String año, String descripcion, String director, String precio) {
        this.titulo = titulo;
        this.año = año;
        this.descripcion = descripcion;
        this.director = director;
        this.precio = precio;
    }

    private String precio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }







}