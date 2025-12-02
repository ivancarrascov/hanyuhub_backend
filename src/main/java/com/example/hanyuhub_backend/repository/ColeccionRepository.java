package com.example.hanyuhub_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hanyuhub_backend.model.Coleccion;

public interface ColeccionRepository extends JpaRepository<Coleccion, Long> {
    List<Coleccion> findByUsuarioCreador_Mail(String mail);
}
