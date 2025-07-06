package com.example.backend_securify.services;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.Pago;
import com.example.backend_securify.interfaces.IPagoService;
import com.example.backend_securify.repositories.IPagoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService implements IPagoService {
    @Autowired
    private IPagoRepository pagoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Pago insertarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Transactional
    @Override
    public void eliminarPago(Long pago_id) {
        if (pagoRepository.existsById(pago_id)) {
            pagoRepository.deleteById(pago_id);
        }
    }

    @Transactional
    @Override
    public Pago modificarPago(Pago pago) {
        if(pagoRepository.findById(pago.getPago_id()).isPresent()){
            return pagoRepository.save(pago);
        }
        return null;
    }

    @Override
    public List<Pago> listarPago() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago buscarPagoPorId(long pago_id) {
        if(pagoRepository.findById(pago_id).isPresent()){
            return pagoRepository.findById(pago_id).get();
        }
        return null;
    }

    //adap
    @Override
    public PagoDTO insertar(PagoDTO pagodto) {
        //Convertir el DTO en Entidad
        Pago proveedorEntidad = modelMapper.map(pagodto, Pago.class);
        Pago guardado = pagoRepository.save(proveedorEntidad);
        return modelMapper.map(guardado, PagoDTO.class);
    }

    @Override
    public void eliminar(Long id) {
        if(pagoRepository.existsById(id)){
            pagoRepository.deleteById(id);
        }
    }
}
