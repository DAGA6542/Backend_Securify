package com.example.backend_securify.services;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.entities.Categoria;
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
    private IOrdenRepository ordenRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Orden insertarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Transactional
    @Override
    public void eliminarOrden(Long orden_id) {
        if(ordenRepository.existsById(orden_id)) {
            ordenRepository.deleteById(orden_id);
        }
    }

    @Transactional
    @Override
    public Orden modificarOrden(Orden orden) {
        if(ordenRepository.findById(orden.getOrden_id()).isPresent()){
            return ordenRepository.save(orden);
        }
        return null;
    }

    @Override
    public List<Orden> listarOrden() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden buscarOrdenPorId(long orden_id) {
        if(ordenRepository.findById(orden_id).isPresent()){
            return ordenRepository.findById(orden_id).get();
        }
        return null;
    }

    //adap
    @Override
    public OrdenDTO insertar(OrdenDTO ordendto) {
        //Convertir el DTO en Entidad
        Orden proveedorEntidad = modelMapper.map(ordendto, Orden.class);
        Orden guardado = ordenRepository.save(proveedorEntidad);
        return modelMapper.map(guardado, OrdenDTO.class);
    }

    @Override
    public void eliminar(Long id) {
        if(ordenRepository.existsById(id)){
            ordenRepository.deleteById(id);
        }
    }
}