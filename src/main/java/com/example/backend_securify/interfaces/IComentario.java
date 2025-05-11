package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ComentarioDto;

import java.util.List;

public interface IComentario {

    List<ComentarioDto> listar();

    ComentarioDto actualizarComentario(Long idComentario, ComentarioDto comentario);

    ComentarioDto guardarComentario(ComentarioDto comentario);

    void eliminarComentario(Long idComentario);
}
