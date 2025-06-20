package com.example.backend_securify.entities;

import com.example.backend_securify.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long id_comentatio;

    @Column(nullable = false)
    private String contenido;

    private int calificacion;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
