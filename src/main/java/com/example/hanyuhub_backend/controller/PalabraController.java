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

import com.example.hanyuhub_backend.model.Palabra;
import com.example.hanyuhub_backend.service.PalabraService;

@RestController
@RequestMapping("/api/palabras")
public class PalabraController {

    @Autowired
    private PalabraService palabraService;

    @PostMapping("/{idColeccion}")
    public ResponseEntity<Palabra> agregar(
            @PathVariable Long idColeccion,
            @RequestBody Palabra palabra) {

        return ResponseEntity.ok(palabraService.agregarPalabra(idColeccion, palabra));
    }

    @GetMapping("/coleccion/{idColeccion}")
    public ResponseEntity<List<Palabra>> listar(
            @PathVariable Long idColeccion) {

        return ResponseEntity.ok(palabraService.listarPorColeccion(idColeccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        palabraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
