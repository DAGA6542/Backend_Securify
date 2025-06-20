package com.example.backend_securify.services;

import com.example.backend_securify.entities.DetalleOrden;
import com.example.backend_securify.interfaces.IDetalleOrdenService;
import com.example.backend_securify.repositories.IDetalleOrdenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleOrdenService implements IDetalleOrdenService {
    @Autowired
    private IDetalleOrdenRepository detalleordenRepository;

    @Override
    public DetalleOrden insertarDetalleOrden(DetalleOrden detalleOrden) {
        return detalleordenRepository.save(detalleOrden);
    }

    @Transactional
    @Override
    public void eliminarDetalleOrden(Long id_detalleorden) {
        if (detalleordenRepository.existsById(id_detalleorden)) {
            detalleordenRepository.deleteById(id_detalleorden);
        }
    }

    @Transactional
    @Override
    public DetalleOrden modificarDetalleOrden(DetalleOrden detalleOrden) {
        if (detalleordenRepository.findById(detalleOrden.getId_detalleorden()).isPresent()){
            return detalleordenRepository.save(detalleOrden);
        }
        return null;
    }

    @Override
    public List<DetalleOrden> listarDetalleOrden() {
        return detalleordenRepository.findAll();
    }
}
