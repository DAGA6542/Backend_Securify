package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.dtos.ProductoDTO;

import java.util.List;

public interface IPagoService {
    List<PagoDTO> listarPagos();
    PagoDTO guardarPagos(PagoDTO pagoDto);
    PagoDTO actualizarPagos(Long id_pagos, PagoDTO pagoDto);
    void eliminarPagos(Long id_pagos);
}
