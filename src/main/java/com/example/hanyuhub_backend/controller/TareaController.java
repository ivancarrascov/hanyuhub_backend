package com.example.hanyuhub_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hanyuhub_backend.dto.TareaDTO;
import com.example.hanyuhub_backend.model.Tarea;
import com.example.hanyuhub_backend.service.TareaService;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    // Crear tarea
    @PostMapping("/crear")
    public ResponseEntity<Tarea> crearTarea(@RequestBody TareaDTO dto) {
        Tarea nueva = tareaService.crearTarea(dto);
        return ResponseEntity.ok(nueva);
    }

    // Editar tarea
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarTarea(
            @PathVariable String id,
            @RequestBody TareaDTO dto) {

        Optional<Tarea> editada = tareaService.editarTarea(id, dto);

        return editada
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Borrar tarea
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarTarea(@PathVariable String id) {
        boolean borrada = tareaService.borrarTarea(id);

        if (borrada) {
            return ResponseEntity.ok("Tarea eliminada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> listarTareas() {
        List<Tarea> lista = tareaService.listarTareas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTarea(@PathVariable String id) {
        return tareaService.obtenerTareaPorId(id)
                .map(t -> ResponseEntity.ok(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
