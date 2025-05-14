package com.example.backend_securify.services;

import com.example.backend_securify.dtos.ComentarioDTO;
import com.example.backend_securify.entities.Comentario;
import com.example.backend_securify.interfaces.IComentarioService;
import com.example.backend_securify.repositories.IComentarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService implements IComentarioService {

    @Autowired
    private IComentarioRepository IComentarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ComentarioDTO> listar() {
        return IComentarioRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, ComentarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ComentarioDTO guardarComentario(ComentarioDTO comentario) {
        Comentario entidad = modelMapper.map(comentario, Comentario.class);
        return modelMapper.map(IComentarioRepository.save(entidad), ComentarioDTO.class);
    }

    @Override
    public ComentarioDTO actualizarComentario(Long idComentario, ComentarioDTO comentario) {
        Comentario c = IComentarioRepository.findById((idComentario)).get();
        modelMapper.map(comentario, c);
        Comentario comentarioActualizado = IComentarioRepository.save(c);
        return modelMapper.map(comentarioActualizado, ComentarioDTO.class);
    }


    @Override
    public void eliminarComentario(Long idComentario) {
        if (IComentarioRepository.existsById((idComentario))){
            IComentarioRepository.deleteById((idComentario));
        }
    }


}
