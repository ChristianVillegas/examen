package com.example.jdaesdeveniments.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Asistentes")
public class Assistent {

    @PrimaryKey
    @NonNull
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String edad;

    public Assistent(String nombre, String apellido, String mail, String telefono, String edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
