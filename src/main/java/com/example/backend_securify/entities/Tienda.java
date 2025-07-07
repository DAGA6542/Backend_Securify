package com.example.backend_securify.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tienda_id")
    private Long tienda_id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    // Relación con el usuario propietario de la tienda
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Cliente user_id;

    // Relación con productos: una tienda tiene muchos productos
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
    private List<Producto> productos;

    // Relación opcional con comentarios (si aplica que los usuarios comenten una tienda)
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;


}

