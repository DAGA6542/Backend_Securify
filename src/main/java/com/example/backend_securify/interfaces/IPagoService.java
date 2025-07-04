package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.entities.Pago;

import java.util.List;

public interface IPagoService {

    public Pago insertarPago(Pago pago);
    public void eliminarPago(Long pago_id);
    public Pago modificarPago(Pago pago);
    public List<Pago> listarPago();
    public Pago buscarPagoPorId(long pago_id);
}
