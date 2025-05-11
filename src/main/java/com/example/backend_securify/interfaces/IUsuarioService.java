package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ReporteUsuario;
import com.example.backend_securify.dtos.UsuarioDto;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDto> listarUsuarios();
    UsuarioDto guardarUsuario(UsuarioDto usuarioDto);
    UsuarioDto actualizarUsuario(Long idUsuario, UsuarioDto usuarioDto);
    void eliminarUsuario(Long idUsuario);
    List<ReporteUsuario>  obtenerReporteUsuarios();


}
