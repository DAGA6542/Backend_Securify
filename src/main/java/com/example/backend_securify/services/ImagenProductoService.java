package com.example.backend_securify.services;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.ImagenProductoDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.ImagenProducto;
import com.example.backend_securify.interfaces.IImagenProductoService;
import com.example.backend_securify.repositories.IImagenProductoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenProductoService implements IImagenProductoService {

    @Autowired
    private IImagenProductoRepository imagenProductoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ImagenProducto insertarImagenProducto(ImagenProducto imagenProducto) {
        return imagenProductoRepository.save(imagenProducto);
    }

    @Transactional
    @Override
    public void eliminarImagenProducto(Long detalleorden_id) {
        if (imagenProductoRepository.existsById(detalleorden_id)) {
            imagenProductoRepository.deleteById(detalleorden_id);
        }
    }

    @Transactional
    @Override
    public ImagenProducto modificarImagenProducto(ImagenProducto imagenProducto) {
        if(imagenProductoRepository.findById(imagenProducto.getImagenproducto_id()).isPresent()){
            return imagenProductoRepository.save(imagenProducto);
        }
        return null;
    }

    @Override
    public List<ImagenProducto> listarImagenProducto() {
        return imagenProductoRepository.findAll();
    }

    @Override
    public ImagenProducto buscarImagenProductoPorId(long imagenproducto_id) {
        if(imagenProductoRepository.findById(imagenproducto_id).isPresent()){
            return imagenProductoRepository.findById(imagenproducto_id).get();
        }
        return null;
    }

    //adap
    @Override
    public ImagenProductoDTO insertar(ImagenProductoDTO imagenProductodto) {
        //Convertir el DTO en Entidad
        ImagenProducto proveedorEntidad = modelMapper.map(imagenProductodto, ImagenProducto.class);
        ImagenProducto guardado = imagenProductoRepository.save(proveedorEntidad);
        return modelMapper.map(guardado, ImagenProductoDTO.class);
    }

    @Override
    public void eliminar(Long id) {
        if(imagenProductoRepository.existsById(id)){
            imagenProductoRepository.deleteById(id);
        }
    }
}