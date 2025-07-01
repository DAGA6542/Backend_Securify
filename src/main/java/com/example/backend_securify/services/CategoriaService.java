package com.example.backend_securify.services;

import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.interfaces.ICategoriaService;
import com.example.backend_securify.repositories.ICategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired //inyecta
    private ICategoriaRepository categoriaRepository;

    @Override
    public Categoria insertarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    @Override
    public void eliminarCategoria(Long categoria_id) {
        if (categoriaRepository.existsById(categoria_id)) {
            categoriaRepository.deleteById(categoria_id);
        }
    }

    @Transactional
    @Override
    public Categoria modificarCategoria(Categoria categoria) {
        if(categoriaRepository.findById(categoria.getCategoria_id()).isPresent()){
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarCategoriaPorId(long categoria_id) {
        if(categoriaRepository.findById(categoria_id).isPresent()){
            return categoriaRepository.findById(categoria_id).get();
        }
        return null;
    }
}

