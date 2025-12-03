package com.example.hanyuhub_backend.dto;

public class TareaDTO {
    private String id;
    private String titulo;
    private String descripcion;
    private String fechaPub;
    private String fechaLim;
    private String contenido;

    public TareaDTO(){
        this.id = "";
        this.titulo = "";
        this.descripcion = "";
        this.fechaPub = "";
        this.fechaLim = "";
        this.contenido = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(String fechaPub) {
        this.fechaPub = fechaPub;
    }

    public String getFechaLim() {
        return fechaLim;
    }

    public void setFechaLim(String fechaLim) {
        this.fechaLim = fechaLim;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
