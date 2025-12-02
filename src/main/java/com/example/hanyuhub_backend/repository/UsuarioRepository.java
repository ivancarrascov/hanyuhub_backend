package com.example.hanyuhub_backend.repository;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hanyuhub_backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // Busca un usuario por mail y contraseña
    //Optional<Usuario> findByMailAndPass(String mail, String pass);

    // (Opcional) si quieres validar existencia sin traer el usuario
    boolean existsByMailAndPass(String mail, String pass);

    // Buscar usuario por mail
    Optional<Usuario> findByMail(String mail);
}
