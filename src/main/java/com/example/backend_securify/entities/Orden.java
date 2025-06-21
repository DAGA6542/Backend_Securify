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

public class Orden
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Long orden_id;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
}
