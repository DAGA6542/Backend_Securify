package com.example.backend_securify.dtos;

import com.example.backend_securify.security.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TiendaDTO implements Serializable {
    Long tienda_id;
    String nombre;
    String descripcion;
    User user_id;
}