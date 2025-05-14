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
@Table(name = "imagenesProducto")
public class ImagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Imagen;

    @Column(nullable = false)
    private String urlImagen;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

}