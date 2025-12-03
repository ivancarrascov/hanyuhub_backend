package com.example.hanyuhub_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hanyuhub_backend.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, String> {

}
