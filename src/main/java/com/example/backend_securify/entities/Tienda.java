package com.example.backend_securify.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tienda;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;


    @JoinColumn(name = "usuario_id")
    private Long usuarioId;


}

