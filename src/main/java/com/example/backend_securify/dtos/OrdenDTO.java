package com.example.backend_securify.dtos;

import com.example.backend_securify.entities.Cliente;
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

public class OrdenDTO implements Serializable {
    Long orden_id;
    LocalDate fecha;
    String estado;
    Cliente user_id;
}
