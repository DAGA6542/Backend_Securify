package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.TiendaDto;


import java.util.List;

public interface ITienda {
    List<TiendaDto> listar();
    TiendaDto actualizarTienda(Long id_tienda, TiendaDto tienda);
    TiendaDto guardarTienda(TiendaDto tienda);
    void eliminar(Long id_tienda);
}
