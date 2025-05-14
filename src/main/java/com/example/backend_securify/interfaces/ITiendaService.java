package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.TiendaDTO;


import java.util.List;

public interface ITiendaService {
    List<TiendaDTO> listar();
    TiendaDTO actualizarTienda(Long id_tienda, TiendaDTO tienda);
    TiendaDTO guardarTienda(TiendaDTO tienda);
    void eliminar(Long id_tienda);
}
