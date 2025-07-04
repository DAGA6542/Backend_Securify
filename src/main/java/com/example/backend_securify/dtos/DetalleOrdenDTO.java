package com.example.backend_securify.dtos;

import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.entities.Producto;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenDTO implements Serializable{
    Long detalleorden_id;
    int cantidad;
    Producto producto_id;
    Orden orden_id;
}
