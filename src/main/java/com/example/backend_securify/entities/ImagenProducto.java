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
    @Column(name = "imagenproducto_id")
    private Long imagenproducto_id;
    @Column( name = "urlImagen", nullable = false)
    private String urlImagen;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto_id;

}