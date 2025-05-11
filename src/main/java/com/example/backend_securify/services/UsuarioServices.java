package com.example.backend_securify.services;

import com.example.backend_securify.dtos.ReporteUsuario;
import com.example.backend_securify.dtos.UsuarioDto;
import com.example.backend_securify.entities.Usuario;
import com.example.backend_securify.interfaces.IUsuarioService;
import com.example.backend_securify.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServices implements IUsuarioService {

    @Autowired //inyecta
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(usuario -> modelMapper.map(usuario, UsuarioDto.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        Usuario save  = usuarioRepository.save(usuario);
        return modelMapper.map(save, UsuarioDto.class);
    }

    @Override
    public UsuarioDto actualizarUsuario(Long id_usuario, UsuarioDto usuarioDto) {
        Usuario u = usuarioRepository.findById(id_usuario).get();
        modelMapper.map(usuarioDto, u);
        Usuario usuarioActualizado = usuarioRepository.save(u);
        return modelMapper.map(usuarioActualizado, UsuarioDto.class);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuarioRepository.deleteById(idUsuario);
        }
    }

    @Override
    public List<ReporteUsuario>  obtenerReporteUsuarios() {
        return usuarioRepository.listarUsuarioSeparadoPorFilas();
    }


}
