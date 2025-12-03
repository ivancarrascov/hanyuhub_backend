package com.example.hanyuhub_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hanyuhub_backend.dto.TareaDTO;
import com.example.hanyuhub_backend.model.Tarea;
import com.example.hanyuhub_backend.repository.TareaRepository;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // Crear tarea
    public Tarea crearTarea(TareaDTO dto) {
        Tarea tarea = new Tarea();
        tarea.setId(dto.getId());
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setFechaPub(dto.getFechaPub());
        tarea.setFechaLim(dto.getFechaLim());
        tarea.setContenido(dto.getContenido());

        return tareaRepository.save(tarea);
    }

    // Editar tarea
    public Optional<Tarea> editarTarea(String id, TareaDTO dto) {
        Optional<Tarea> tareaOpt = tareaRepository.findById(id);
        if (tareaOpt.isPresent()) {
            Tarea tarea = tareaOpt.get();
            tarea.setTitulo(dto.getTitulo());
            tarea.setDescripcion(dto.getDescripcion());
            tarea.setFechaPub(dto.getFechaPub());
            tarea.setFechaLim(dto.getFechaLim());
            tarea.setContenido(dto.getContenido());

            tareaRepository.save(tarea);
            return Optional.of(tarea);
        }
        return Optional.empty();
    }

    // Borrar tarea
    public boolean borrarTarea(String id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Listar todas las tareas
    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    // Obtener tarea por id
    public Optional<Tarea> obtenerTareaPorId(String id) {
        return tareaRepository.findById(id);
    }
}

