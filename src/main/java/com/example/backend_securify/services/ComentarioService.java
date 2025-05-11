package com.example.backend_securify.services;

import com.example.backend_securify.dtos.ComentarioDto;
import com.example.backend_securify.entities.Comentario;
import com.example.backend_securify.interfaces.IComentario;
import com.example.backend_securify.repositories.ComentarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService implements IComentario {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ComentarioDto> listar() {
        return comentarioRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, ComentarioDto.class))
                .collect(Collectors.toList());
    }
    
    @Override
    public ComentarioDto actualizarComentario(Long idComentario, ComentarioDto comentario) {
        Comentario c = comentarioRepository.findById((idComentario)).get();
        modelMapper.map(comentario, c);
        Comentario comentarioActualizado = comentarioRepository.save(c);
        return modelMapper.map(comentarioActualizado, ComentarioDto.class);
    }




    @Override
    public ComentarioDto guardarComentario(ComentarioDto comentario) {
        Comentario entidad = modelMapper.map(comentario, Comentario.class);
        return modelMapper.map(comentarioRepository.save(entidad), ComentarioDto.class);
    }


    @Override
    public void eliminarComentario(Long idComentario) {
        if (comentarioRepository.existsById((idComentario))){
            comentarioRepository.deleteById((idComentario));
        }
    }


}
