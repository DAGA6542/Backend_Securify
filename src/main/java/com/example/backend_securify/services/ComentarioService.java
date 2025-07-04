package com.example.backend_securify.services;

import com.example.backend_securify.entities.Comentario;
import com.example.backend_securify.interfaces.IComentarioService;
import com.example.backend_securify.repositories.IComentarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService implements IComentarioService {

    @Autowired
    private IComentarioRepository comentarioRepository;

    @Override
    public Comentario insertarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Transactional
    @Override
    public void eliminarComentario(Long comentario_id) {
        if (comentarioRepository.existsById(comentario_id)) {
            comentarioRepository.deleteById(comentario_id);
        }
    }

    @Transactional
    @Override
    public Comentario modificarComentario(Comentario comentario) {
        if(comentarioRepository.findById(comentario.getComentario_id()).isPresent()){
            return comentarioRepository.save(comentario);
        }
        return null;
    }

    @Override
    public List<Comentario> listarComentario() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario buscarComentarioPorId(long comentario_id) {
        if(comentarioRepository.findById(comentario_id).isPresent()){
            return comentarioRepository.findById(comentario_id).get();
        }
        return null;
    }
}
