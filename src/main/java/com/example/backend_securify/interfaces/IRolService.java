package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.RolDto;

import java.util.List;

public interface IRolService {
    List<RolDto> listarRol();
    RolDto guardarRol(RolDto rol);
    RolDto ActualizarRol(Long idRol, RolDto rolDto);
    void EliminarRol(Long idRol);
}
