package com.example.backend_securify.entities;
import com.example.backend_securify.security.entities.User;
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
    private Long id_tienda;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    // Relación con el usuario propietario de la tienda
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Relación con productos: una tienda tiene muchos productos
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;

    // Relación opcional con comentarios (si aplica que los usuarios comenten una tienda)
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;


}

