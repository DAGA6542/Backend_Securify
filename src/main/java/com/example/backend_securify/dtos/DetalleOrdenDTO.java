package com.example.backend_securify.dtos;

import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenDTO implements Serializable {
    private Long id;
    private Orden orden;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
}
