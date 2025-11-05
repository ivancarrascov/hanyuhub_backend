package com.example.hanyuhub_backend.dto;


public class UsuarioResponse {
    private String estado;
    private String mensaje;
    private UsuarioDto usuarioDto;

    public UsuarioResponse() {
        this.estado = "";
        this.mensaje = "";
        this.usuarioDto = new UsuarioDto();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
    
}
