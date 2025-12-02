package com.example.hanyuhub_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hanyuhub_backend.model.Palabra;

public interface PalabraRepository extends JpaRepository<Palabra, Long> {
    List<Palabra> findByColeccionId(Long idColeccion);
}

