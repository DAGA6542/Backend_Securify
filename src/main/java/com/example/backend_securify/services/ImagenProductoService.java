package com.example.backend_securify.services;

import com.example.backend_securify.dtos.ImagenProductoDto;
import com.example.backend_securify.entities.ImagenProducto;
import com.example.backend_securify.interfaces.IImagenProductoService;
import com.example.backend_securify.repositories.IImagenProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImagenProductoService implements IImagenProductoService {

    @Autowired
    private IImagenProductoRepository IImagenProductoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ImagenProductoDto> listarImagenProducto() {
        return IImagenProductoRepository.findAll()
                .stream()
                .map(c->modelMapper.map(c, ImagenProductoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ImagenProductoDto insertProducto(ImagenProductoDto imagenProductoDto) {
        ImagenProducto imagenProducto = modelMapper.map(imagenProductoDto, ImagenProducto.class);
        return modelMapper.map(IImagenProductoRepository.save(imagenProducto), ImagenProductoDto.class);
    }

    @Override
    public ImagenProductoDto updateProducto(Long id_Imagen, ImagenProductoDto imagenProductoDto) {
        ImagenProducto c = IImagenProductoRepository.findById((id_Imagen)).get();
        modelMapper.map(imagenProductoDto, c);
        ImagenProducto imagenProducto = IImagenProductoRepository.save(c);
        return modelMapper.map(imagenProductoDto, ImagenProductoDto.class);
    }

    @Override
    public void deleteProducto(Long id_Imagen) {
        if (IImagenProductoRepository.existsById((id_Imagen))) {
            IImagenProductoRepository.deleteById(id_Imagen);
        }
    }
}
