package com.example.backend_securify.dtos;

import com.example.backend_securify.security.entities.User;
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
    Long id;
    LocalDate fecha;
    String estado;
    User user;
}
