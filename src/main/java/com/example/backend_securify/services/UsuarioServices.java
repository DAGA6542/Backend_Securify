package com.example.backend_securify.services;

import com.example.backend_securify.dtos.ReporteUsuarioDTO;
import com.example.backend_securify.dtos.UsuarioDTO;
import com.example.backend_securify.entities.Usuario;
import com.example.backend_securify.interfaces.IUsuarioService;
import com.example.backend_securify.repositories.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServices implements IUsuarioService {

    @Autowired //inyecta
    private IUsuarioRepository IUsuarioRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return IUsuarioRepository.findAll().stream().map(usuario -> modelMapper.map(usuario, UsuarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDto) {
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        Usuario save  = IUsuarioRepository.save(usuario);
        return modelMapper.map(save, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id_usuario, UsuarioDTO usuarioDto) {
        Usuario u = IUsuarioRepository.findById(id_usuario).get();
        modelMapper.map(usuarioDto, u);
        Usuario usuarioActualizado = IUsuarioRepository.save(u);
        return modelMapper.map(usuarioActualizado, UsuarioDTO.class);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        if (IUsuarioRepository.existsById(idUsuario)) {
            IUsuarioRepository.deleteById(idUsuario);
        }
    }

    @Override
    public List<ReporteUsuarioDTO>  obtenerReporteUsuarios() {
        return IUsuarioRepository.listarUsuarioSeparadoPorFilas();
    }


}
