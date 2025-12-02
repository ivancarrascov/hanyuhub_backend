package com.example.hanyuhub_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hanyuhub_backend.dto.CrearColeccionDTO;
import com.example.hanyuhub_backend.model.Coleccion;
import com.example.hanyuhub_backend.model.Usuario;
import com.example.hanyuhub_backend.repository.ColeccionRepository;
import com.example.hanyuhub_backend.repository.UsuarioRepository;

@Service
public class ColeccionService {

    @Autowired
    private ColeccionRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<Coleccion> listarPorUsuario(String mail) {
        return repo.findByUsuarioCreador_Mail(mail);
    }

    public void crearColeccion(CrearColeccionDTO dto) {
        Usuario usuario = usuarioRepo.findByMail(dto.getMail())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        Coleccion coleccion = new Coleccion();
        coleccion.setNombre(dto.getNombre());
        coleccion.setUsuarioCreador(usuario);

        repo.save(coleccion);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
