package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.dtos.ProductoDTO;

import java.util.List;

public interface IOrdenService {
    List<OrdenDTO> listarOrdenes();
    OrdenDTO guardarOrdenes(OrdenDTO ordenDto);
    OrdenDTO actualizarOrdenes(Long id_orden, OrdenDTO ordenDto);
    void eliminarOrdenes(Long id_orden);
}
