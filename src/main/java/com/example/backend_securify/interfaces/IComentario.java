package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ComentarioDTO;

import java.util.List;

public interface IComentario {

    List<ComentarioDTO> listar();

    ComentarioDTO actualizarComentario(Long idComentario, ComentarioDTO comentario);

    ComentarioDTO guardarComentario(ComentarioDTO comentario);

    void eliminarComentario(Long idComentario);
}
