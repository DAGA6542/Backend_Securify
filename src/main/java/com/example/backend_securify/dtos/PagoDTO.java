package com.example.backend_securify.dtos;

import com.example.backend_securify.entities.Orden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PagoDTO implements Serializable {
    Long id;
    String metodo;
    double monto;
    LocalDate fecha;
    Orden orden;
}
