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
}
