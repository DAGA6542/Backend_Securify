package com.example.backend_securify.entities;

import com.example.backend_securify.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalleOrden")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalleorden_id")
    private Long detalleorden_id;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto_id;
    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden_id;
}
