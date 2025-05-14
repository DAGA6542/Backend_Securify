package com.example.backend_securify.services;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IOrdenService;
import com.example.backend_securify.repositories.IOrdenRepository;
import com.example.backend_securify.repositories.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenService implements IOrdenService {
    @Autowired //inyecta
    private IOrdenRepository ordenRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrdenDTO> listarOrdenes() {
        return ordenRepository.findAll()
                .stream()
                .map(orden -> modelMapper.map(orden, OrdenDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrdenDTO guardarOrdenes(OrdenDTO ordenDto) {
        Orden o = modelMapper.map(ordenDto, Orden.class);
        Orden save = ordenRepository.save(o);
        return modelMapper.map(save, OrdenDTO.class);
    }

    @Override
    public OrdenDTO actualizarOrdenes(Long id_orden, OrdenDTO ordenDto) {
        Orden o = ordenRepository.findById(id_orden).get();
        modelMapper.map(ordenDto, o);

        Orden ordenActualizado = ordenRepository.save(o);

        return modelMapper.map(ordenActualizado, OrdenDTO.class);
    }

    @Override
    public void eliminarOrdenes (Long id_orden) {
        if (ordenRepository.existsById(id_orden)) {
            ordenRepository.deleteById(id_orden);
        }
    }
}
