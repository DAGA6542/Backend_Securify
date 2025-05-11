package com.example.backend_securify.services;

import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.entities.Pago;
import com.example.backend_securify.interfaces.IPagoService;
import com.example.backend_securify.repositories.IPagoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoService implements IPagoService {
    @Autowired
    private IPagoRepository pagoRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PagoDTO grabarPago(PagoDTO pagoDto) {
        Pago pago = modelMapper.map(pagoDto, Pago.class);
        Pago guardar = pagoRepositorio.save(pago);
        return modelMapper.map(guardar, PagoDTO.class);
    }

    @Override
    public List<PagoDTO> obtenerPagoSegunMonto(double precio) {
        return pagoRepositorio.findPagoByMontoEquals(precio)
                .stream().map(pago -> modelMapper.map(pago, PagoDTO.class)).collect(Collectors.toList());
    }
}
