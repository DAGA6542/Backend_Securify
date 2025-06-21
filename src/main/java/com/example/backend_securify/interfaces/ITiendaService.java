package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.TiendaDTO;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.entities.Tienda;


import java.util.List;

public interface ITiendaService {

    public Tienda insertarTienda(Tienda tienda);
    public void eliminarTienda(Long tienda_id);
    public Tienda modificarTienda(Tienda tienda);
    public List<Tienda> listarTienda();
    public Tienda buscarTiendaPorId(long tienda_id);
}
