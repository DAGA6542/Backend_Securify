package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ReporteUsuarioDTO;
import com.example.backend_securify.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO guardarUsuario(UsuarioDTO usuarioDto);
    UsuarioDTO actualizarUsuario(Long idUsuario, UsuarioDTO usuarioDto);
    void eliminarUsuario(Long idUsuario);
    List<ReporteUsuarioDTO>  obtenerReporteUsuarios();


}
