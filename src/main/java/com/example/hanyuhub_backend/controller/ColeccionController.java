package com.example.hanyuhub_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hanyuhub_backend.dto.CrearColeccionDTO;
import com.example.hanyuhub_backend.model.Coleccion;
import com.example.hanyuhub_backend.service.ColeccionService;

@RestController
@RequestMapping("/api/colecciones")
public class ColeccionController {

    @Autowired
    private ColeccionService service;

    @GetMapping("/{mail}")
    public List<Coleccion> listar(@PathVariable String mail) {
        return service.listarPorUsuario(mail);
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody CrearColeccionDTO dto) {
        service.crearColeccion(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
