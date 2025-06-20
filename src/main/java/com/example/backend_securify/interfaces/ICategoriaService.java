package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.entities.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaDTO> listarCategorias();
    CategoriaDTO guardarCategoria(CategoriaDTO categoria);
    CategoriaDTO actualizarCategoria(Long idCategoria, CategoriaDTO categoriaDto);
    void eliminarCategoria(Long idCategoria);

    //Adaptaciones
    public CategoriaDTO editar(CategoriaDTO categoria);
    CategoriaDTO insertar(CategoriaDTO categoria);
    Categoria buscarPorId(Long id);
    public void eliminar(Long id);

}
