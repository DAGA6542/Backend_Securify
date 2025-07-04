package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.entities.DetalleOrden;
import com.example.backend_securify.entities.ImagenProducto;
import com.example.backend_securify.entities.Orden;

import java.util.List;

public interface IOrdenService {

    public Orden insertarOrden(Orden orden);
    public void eliminarOrden(Long orden_id);
    public Orden modificarOrden(Orden orden);
    public List<Orden> listarOrden();
    public Orden buscarOrdenPorId(long orden_id);
}
