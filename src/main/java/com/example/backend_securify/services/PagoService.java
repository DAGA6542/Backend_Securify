package com.example.backend_securify.services;

import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Pago;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IPagoService;
import com.example.backend_securify.repositories.IPagoRepository;
import com.example.backend_securify.repositories.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoService implements IPagoService{
    @Autowired //inyecta
    private IPagoRepository pagoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PagoDTO> listarPagos() {
        return pagoRepository.findAll()
                .stream()
                .map(pago -> modelMapper.map(pago, PagoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PagoDTO guardarPagos(PagoDTO pagoDto) {
        Pago p = modelMapper.map(pagoDto, Pago.class);
        Pago save = pagoRepository.save(p);
        return modelMapper.map(save, PagoDTO.class);
    }

    @Override
    public PagoDTO actualizarPagos(Long id_pago, PagoDTO pagoDto) {
        Pago p = pagoRepository.findById(id_pago).get();
        modelMapper.map(pagoDto, p);

        Pago pagoActualizado = pagoRepository.save(p);

        return modelMapper.map(pagoActualizado, PagoDTO.class);
    }

    @Override
    public void eliminarPagos (Long id_pago) {
        if (pagoRepository.existsById(id_pago)) {
            pagoRepository.deleteById(id_pago);
        }
    }
}
