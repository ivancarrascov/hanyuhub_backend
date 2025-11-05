package com.example.hanyuhub_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.hanyuhub_backend.dto.LoginDto;
import com.example.hanyuhub_backend.dto.UsuarioDto;
//import com.example.hanyuhub_backend.dto.LoginDto;
import com.example.hanyuhub_backend.dto.UsuarioResponse;
import com.example.hanyuhub_backend.model.Usuario;
import com.example.hanyuhub_backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<?> usuarioRegistrar(UsuarioDto dto) {
        UsuarioResponse response = new UsuarioResponse();

        // Verificar si ya existe el usuario por correo
        if (usuarioRepository.existsById(dto.getMail())) {
            response.setEstado("ERROR");
            response.setMensaje("El usuario ya existe");
            return ResponseEntity.badRequest().body(response);
        }
        // Crear nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setMail(dto.getMail());
        usuario.setPass(dto.getPass());
        usuario.setRol(dto.getRol());

        // Guardar en base de datos
        usuarioRepository.save(usuario);

        response.setEstado("OK");
        response.setMensaje("Usuario almacenado correctamente");
        response.setUsuarioDto(dto);

        return ResponseEntity.ok(response);



    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioDto validarCredenciales(LoginDto dto) {
        boolean validador = usuarioRepository.existsByMailAndPass(dto.getMail(), dto.getPass());
        UsuarioDto usuarioDto = new UsuarioDto();

        if (validador) {
            //Usuario usuario = this.usuarioRepository.findById(dto.getMail()).get();

            usuarioDto.setMail(dto.getMail());
            usuarioDto.setPass("*********");
            usuarioDto.setNombre(this.usuarioRepository.findById(dto.getMail()).get().getNombre());
            usuarioDto.setApellido(this.usuarioRepository.findById(dto.getMail()).get().getApellido());
            usuarioDto.setRol(this.usuarioRepository.findById(dto.getMail()).get().getRol());

            return usuarioDto;
        } else {
            return null;

        }   
    }

    //Valida si existe un usuario por email
    public boolean existePorEmail(String mail) {
        return usuarioRepository.existsById(mail);
    }

    //Obtiene un usuario por su email
    public Usuario obtenerUsuarioPorMail(String mail) {
    return usuarioRepository.findById(mail).orElse(null);
}
}
