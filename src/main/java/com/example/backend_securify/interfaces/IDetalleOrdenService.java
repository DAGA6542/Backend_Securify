package com.example.backend_securify.interfaces;

import com.example.backend_securify.entities.Comentario;
import com.example.backend_securify.entities.DetalleOrden;
import com.example.backend_securify.entities.Producto;

import java.util.List;

public interface IDetalleOrdenService {

    public DetalleOrden insertarDetalleOrden(DetalleOrden detalleorden);
    public void eliminarDetalleOrden(Long detalleorden_id);
    public DetalleOrden modificarDetalleOrden(DetalleOrden detalleorden);
    public List<DetalleOrden> listarDetalleOrden();
    public DetalleOrden buscarDetalleOrdenPorId(long detalleorden_id);

}
