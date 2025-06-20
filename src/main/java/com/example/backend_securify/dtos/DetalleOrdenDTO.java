package com.example.backend_securify.dtos;

import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.entities.Producto;
import lombok.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenDTO implements Serializable{
    Long id_detalleorden;
    int cantidad;
    Producto id_producto;
    Orden id_orden;
}
