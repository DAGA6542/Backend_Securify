package com.example.backend_securify.services;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.interfaces.IOrdenService;
import com.example.backend_securify.repositories.IOrdenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService implements IOrdenService {
    @Autowired
    private IOrdenRepository ordenRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrdenDTO grabarOrden(OrdenDTO ordenDto) {
        Orden orden = modelMapper.map(ordenDto, Orden.class);
        Orden guardar = ordenRepositorio.save(orden);
        return modelMapper.map(guardar, OrdenDTO.class);
    }
}
