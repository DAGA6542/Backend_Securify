package com.example.backend_securify.services;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.ComentarioDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.Comentario;
import com.example.backend_securify.interfaces.IComentarioService;
import com.example.backend_securify.repositories.IComentarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService implements IComentarioService {

    @Autowired
    private IComentarioRepository comentarioRepository;
    @Autowired
    private ModelMapper modelMapper;

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

    //adap
    @Override
    public ComentarioDTO insertar(ComentarioDTO comentario) {
        //Convertir el DTO en Entidad
        Comentario proveedorEntidad = modelMapper.map(comentario, Comentario.class);
        Comentario guardado = comentarioRepository.save(proveedorEntidad);
        return modelMapper.map(guardado, ComentarioDTO.class);
    }

    @Override
    public void eliminar(Long id) {
        if(comentarioRepository.existsById(id)){
            comentarioRepository.deleteById(id);
        }
    }

    @Override
    public List<Comentario> obtenerComentariosPorUsuario(Long user_id) {
        return comentarioRepository.obtenerComentariosPorUsuario(user_id);
    }

    @Override
    public List<Comentario> obtenerComentariosPorProducto(Long producto_id) {
        return comentarioRepository.obtenerComentariosPorProducto(producto_id);
    }
}
