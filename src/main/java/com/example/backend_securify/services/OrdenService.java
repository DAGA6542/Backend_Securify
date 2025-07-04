package com.example.backend_securify.services;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.entities.ImagenProducto;
import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.interfaces.IOrdenService;
import com.example.backend_securify.repositories.IOrdenRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService implements IOrdenService {
    @Autowired
    private IOrdenRepository ordenRepositorio;

    @Override
    public Orden insertarOrden(Orden orden) {
        return ordenRepositorio.save(orden);
    }

    @Transactional
    @Override
    public void eliminarOrden(Long orden_id) {
        if(ordenRepositorio.existsById(orden_id)) {
            ordenRepositorio.deleteById(orden_id);
        }
    }

    @Transactional
    @Override
    public Orden modificarOrden(Orden orden) {
        if(ordenRepositorio.findById(orden.getOrden_id()).isPresent()){
            return ordenRepositorio.save(orden);
        }
        return null;
    }

    @Override
    public List<Orden> listarOrden() {
        return ordenRepositorio.findAll();
    }

    @Override
    public Orden buscarOrdenPorId(long orden_id) {
        if(ordenRepositorio.findById(orden_id).isPresent()){
            return ordenRepositorio.findById(orden_id).get();
        }
        return null;
    }
}