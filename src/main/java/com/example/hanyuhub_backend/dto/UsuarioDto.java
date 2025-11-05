package com.example.hanyuhub_backend.dto;

public class UsuarioDto {
    private String mail;
    private String pass;
    private String nombre;
    private String apellido;
    private String rol;

    public UsuarioDto(){
        this.mail = "";
        this.pass = "";
        this.nombre = "";
        this.apellido = "";
        this.rol = "";
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
