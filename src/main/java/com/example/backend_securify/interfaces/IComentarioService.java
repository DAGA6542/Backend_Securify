package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ComentarioDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.Comentario;

import java.util.List;

public interface IComentarioService {

    public Comentario insertarComentario(Comentario comentario);
    public void eliminarComentario(Long comentario_id);
    public Comentario modificarComentario(Comentario comentario);
    public List<Comentario> listarComentario();
    public Comentario buscarComentarioPorId(long comentario_id);
}
