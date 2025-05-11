package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.PagoDTO;

import java.util.List;

public interface IPagoService {
    public PagoDTO grabarPago(PagoDTO pagoDto);
    public List<PagoDTO> obtenerPagoSegunMonto(double precio);
}
