package com.example.backend_securify.services;

import com.example.backend_securify.entities.Pago;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IPagoService;
import com.example.backend_securify.repositories.IPagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService implements IPagoService {
    @Autowired
    private IPagoRepository pagoRepositorio;

    @Override
    public Pago insertarPago(Pago pago) {
        return pagoRepositorio.save(pago);
    }

    @Transactional
    @Override
    public void eliminarPago(Long pago_id) {
        if (pagoRepositorio.existsById(pago_id)) {
            pagoRepositorio.deleteById(pago_id);
        }
    }

    @Transactional
    @Override
    public Pago modificarPago(Pago pago) {
        if(pagoRepositorio.findById(pago.getPago_id()).isPresent()){
            return pagoRepositorio.save(pago);
        }
        return null;
    }

    @Override
    public List<Pago> listarPago() {
        return pagoRepositorio.findAll();
    }

    @Override
    public Pago buscarPagoPorId(long pago_id) {
        if(pagoRepositorio.findById(pago_id).isPresent()){
            return pagoRepositorio.findById(pago_id).get();
        }
        return null;
    }
}
