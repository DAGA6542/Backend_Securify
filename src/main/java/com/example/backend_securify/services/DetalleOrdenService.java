package com.example.backend_securify.services;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.DetalleOrdenDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.DetalleOrden;
import com.example.backend_securify.interfaces.IDetalleOrdenService;
import com.example.backend_securify.repositories.IDetalleOrdenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class DetalleOrdenService implements IDetalleOrdenService {
    @Autowired
    private IDetalleOrdenRepository detalleordenRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DetalleOrden insertarDetalleOrden(DetalleOrden detalleorden) {
        return detalleordenRepository.save(detalleorden);
    }

    @Transactional
    @Override
    public void eliminarDetalleOrden(Long detalleorden_id) {
        if (detalleordenRepository.existsById(detalleorden_id)) {
            detalleordenRepository.deleteById(detalleorden_id);
        }
    }

    @Transactional
    @Override
    public DetalleOrden modificarDetalleOrden(DetalleOrden detalleorden) {
        if(detalleordenRepository.findById(detalleorden.getDetalleorden_id()).isPresent()){
            return detalleordenRepository.save(detalleorden);
        }
        return null;
    }

    @Override
    public List<DetalleOrden> listarDetalleOrden() {
        return detalleordenRepository.findAll();
    }

    @Override
    public DetalleOrden buscarDetalleOrdenPorId(long detalleorden_id) {
        if(detalleordenRepository.findById(detalleorden_id).isPresent()){
            return detalleordenRepository.findById(detalleorden_id).get();
        }
        return null;
    }

    //adap
    @Override
    public DetalleOrdenDTO insertar(DetalleOrdenDTO detalleOrdendto) {
        //Convertir el DTO en Entidad
        DetalleOrden proveedorEntidad = modelMapper.map(detalleOrdendto, DetalleOrden.class);
        DetalleOrden guardado = detalleordenRepository.save(proveedorEntidad);
        return modelMapper.map(guardado, DetalleOrdenDTO.class);
    }

    @Override
    public void eliminar(Long id) {
        if(detalleordenRepository.existsById(id)){
            detalleordenRepository.deleteById(id);
        }
    }
}
