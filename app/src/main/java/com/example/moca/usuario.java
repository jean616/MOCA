package com.example.moca;

import java.util.Date;

public class usuario {

    private   String nombre;
    private   String contraseña;
    private   String email;
    private   String fecha;
    private   int telefono;
    private   int tarjeta;
    private   int cvv;

    public usuario(String nombre, String contraseña, String email, int telefono) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.fecha = fecha;
        this.telefono = this.telefono;
        this.tarjeta = tarjeta;
        this.cvv = cvv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

}