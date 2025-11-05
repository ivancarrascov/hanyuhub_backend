package com.example.hanyuhub_backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hanyuhub_backend.dto.LoginDto;
import com.example.hanyuhub_backend.dto.UsuarioDto;
//import com.example.hanyuhub_backend.dto.LoginDto;
import com.example.hanyuhub_backend.model.Usuario;
import com.example.hanyuhub_backend.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<?> usuarioRegistrar(@RequestBody UsuarioDto dto) {
        return usuarioService.usuarioRegistrar(dto);
    }

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping("/login")
    public ResponseEntity<?> validarCredenciales(@RequestBody LoginDto dto) {
        UsuarioDto usuario = usuarioService.validarCredenciales(dto);

        if (usuario != null) {
            return ResponseEntity.ok(usuario); // 200 OK
        } else {
            // Retorna 401 Unauthorized con un mensaje JSON
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Correo o contraseña incorrectos"));
        }
    }

    @GetMapping("/validar-email")
    public ResponseEntity<Map<String, Boolean>> validarEmail(@RequestParam String mail) {
        boolean existe = usuarioService.existePorEmail(mail);
        return ResponseEntity.ok(Map.of("existe", existe));
    }

    //Nuevo endpoint para obtener usuario por email
    @GetMapping("/{mail}")
    public ResponseEntity<?> obtenerUsuarioPorMail(@PathVariable String mail) {
        Usuario usuario = usuarioService.obtenerUsuarioPorMail(mail);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Usuario no encontrado"));
        }
    }

}
