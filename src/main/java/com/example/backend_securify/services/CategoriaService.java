package com.example.backend_securify.services;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.interfaces.ICategoriaService;
import com.example.backend_securify.repositories.ICategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired //inyecta
    private ICategoriaRepository categoriaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO guardarCategoria(CategoriaDTO categoria) {
        Categoria c = modelMapper.map(categoria, Categoria.class);
        Categoria save = categoriaRepository.save(c);
        return modelMapper.map(save, CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long idCategoria, CategoriaDTO categoriaDto) {

        Categoria c = categoriaRepository.findById(idCategoria).get();
        modelMapper.map(categoriaDto, c);

        Categoria categoriaActualizada = categoriaRepository.save(c);

        return modelMapper.map(categoriaActualizada, CategoriaDTO.class);
    }


    @Override
    public void eliminarCategoria (Long idCategoria) {
        if (categoriaRepository.existsById(idCategoria)) {
            categoriaRepository.deleteById(idCategoria);
        }
    }

    //Adaptaciones
    @Override
    public CategoriaDTO editar(CategoriaDTO proveedor) {
        if(categoriaRepository.findById(proveedor.getIdCategoria()).isPresent()){
            Categoria proveedorEntidad = modelMapper.map(proveedor, Categoria.class);
            Categoria guardado = categoriaRepository.save(proveedorEntidad);
            return modelMapper.map(guardado, CategoriaDTO.class);
        }
        return null;
    }


    @Override
    public CategoriaDTO insertar(CategoriaDTO categoria) {
        //Convertir el DTO en Entidad
        Categoria proveedorEntidad = modelMapper.map(categoria, Categoria.class);
        Categoria guardado = categoriaRepository.save(proveedorEntidad);
        return modelMapper.map(guardado, CategoriaDTO.class);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        if(categoriaRepository.findById(id).isPresent()){
            return categoriaRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        }
    }
}
