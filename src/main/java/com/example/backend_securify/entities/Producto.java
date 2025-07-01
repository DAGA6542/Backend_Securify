package com.example.backend_securify.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long idProducto;

    private String nombre;
    private String descripcion;
    private float precio;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria id_categoria;

    // Relación con tienda
    @ManyToOne
    @JoinColumn(name = "id_Tienda", nullable = false)
    private Tienda id_Tienda;

    // Relación con imágenes del producto
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenProducto> imagenes;

    // Relación con comentarios sobre el producto
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

    // Relación con orden (puede haber una lista intermedia en otra entidad llamada DetalleOrden)
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orden> ordenes;
}
