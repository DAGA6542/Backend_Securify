package com.example.backend_securify.interfaces;

import com.example.backend_securify.entities.DetalleOrden;
import com.example.backend_securify.entities.Producto;

import java.util.List;

public interface IDetalleOrdenService {
    public DetalleOrden insertarDetalleOrden(DetalleOrden detalleOrden);
    public void eliminarDetalleOrden(Long id_detalleorden);
    public DetalleOrden modificarDetalleOrden(DetalleOrden detalleOrden);
    public List<DetalleOrden> listarDetalleOrden();
}
