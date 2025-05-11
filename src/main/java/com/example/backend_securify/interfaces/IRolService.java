package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.RolDTO;

import java.util.List;

public interface IRolService {
    List<RolDTO> listarRol();
    RolDTO guardarRol(RolDTO rol);
    RolDTO ActualizarRol(Long idRol, RolDTO rolDto);
    void EliminarRol(Long idRol);
}
