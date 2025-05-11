package com.example.backend_securify.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDto implements Serializable {
    Long idUsuario;
    String nombre;
    String apellido;
    String email;
    String contrasenia;
    RolDto rol;
}