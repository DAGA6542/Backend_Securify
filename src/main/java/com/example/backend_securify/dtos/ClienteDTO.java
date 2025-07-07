package com.example.backend_securify.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long cliente_id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
}
