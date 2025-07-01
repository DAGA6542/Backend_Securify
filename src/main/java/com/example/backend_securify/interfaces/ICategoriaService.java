package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.Producto;

import java.util.List;

public interface ICategoriaService {

    public Categoria insertarCategoria(Categoria categoria);
    public void eliminarCategoria(Long categoria_id);
    public Categoria modificarCategoria(Categoria categoria);
    public List<Categoria> listarCategorias();
    public Categoria buscarCategoriaPorId(long categoria_id);

}
