package com.example.jdaesdeveniments.Model;

import java.util.Date;

public class Esdeveniment {

    private String nombre;
    private Date fecha;
    private String lugar;
    private String mail;
    private String sala;
    private String descripcion;
    private int precio;
    private int aforo;

    public Esdeveniment() {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.mail = mail;
        this.sala = sala;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aforo = aforo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }
}
