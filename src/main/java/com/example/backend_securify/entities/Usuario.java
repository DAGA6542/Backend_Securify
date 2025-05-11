package com.example.backend_securify.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

}
