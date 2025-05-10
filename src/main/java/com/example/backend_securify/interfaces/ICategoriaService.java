package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaDTO> listarCategorias();
    CategoriaDTO guardarCategoria(CategoriaDTO categoria);
    CategoriaDTO actualizarCategoria(Long idCategoria, CategoriaDTO categoriaDto);
    void eliminarCategoria(Long idCategoria);

}
