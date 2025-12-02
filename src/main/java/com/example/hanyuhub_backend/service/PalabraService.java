package com.example.hanyuhub_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hanyuhub_backend.model.Coleccion;
import com.example.hanyuhub_backend.model.Palabra;
import com.example.hanyuhub_backend.repository.ColeccionRepository;
import com.example.hanyuhub_backend.repository.PalabraRepository;

@Service
public class PalabraService {

    @Autowired
    private PalabraRepository palabraRepository;

    @Autowired
    private ColeccionRepository coleccionRepository;

    public Palabra agregarPalabra(Long idColeccion, Palabra palabra) {
        Coleccion coleccion = coleccionRepository.findById(idColeccion).orElse(null);
        palabra.setColeccion(coleccion);
        return palabraRepository.save(palabra);
    }

    public List<Palabra> listarPorColeccion(Long idColeccion) {
        return palabraRepository.findByColeccionId(idColeccion);
    }

    public void eliminar(Long idPalabra) {
        palabraRepository.deleteById(idPalabra);
    }
}
