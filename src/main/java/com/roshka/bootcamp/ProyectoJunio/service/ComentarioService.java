package com.roshka.bootcamp.ProyectoJunio.service;

import com.roshka.bootcamp.ProyectoJunio.controller.dto.ComentarioDTO;
import com.roshka.bootcamp.ProyectoJunio.model.Comentario;
import com.roshka.bootcamp.ProyectoJunio.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> list() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> findById(Long id) {
        return comentarioRepository.findById(id);
    }

    public void guardarComentario(ComentarioDTO comentarioDTO) {

        Comentario comentario = new Comentario(comentarioDTO.getDescripcion(),
                Long.parseLong(comentarioDTO.getIdFoto()),Long.parseLong(comentarioDTO.getIdUsuario()));
        comentarioRepository.save(comentario);
    }

}
