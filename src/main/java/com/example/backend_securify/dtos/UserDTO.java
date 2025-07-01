package com.example.backend_securify.dtos;

import com.example.backend_securify.security.entities.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long idUser;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
}
