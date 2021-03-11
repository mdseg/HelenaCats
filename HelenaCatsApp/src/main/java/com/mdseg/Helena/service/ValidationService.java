package com.mdseg.Helena.service;

import com.mdseg.Helena.dto.ProductoDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public int validateProducto(ProductoDto productoDto) {
        if (StringUtils.isBlank(productoDto.getNombre())) {
            return 1;
        } else if (productoDto.getPrecio() == null ||  !(productoDto.getPrecio() > 0)) {
            return 2;
        } else if (productoDto.getAlto() == null || !(productoDto.getAlto() > 0)) {
            return 3;
        } else if (productoDto.getAncho() == null || !(productoDto.getAncho() > 0)) {
            return 4;
        } else if (productoDto.getProfundidad() == null || !(productoDto.getProfundidad() > 0)) {
            return 5;
        } else if (StringUtils.isBlank(productoDto.getDetalles())) {
            return 6;
        }
            
        return 0;
    }
}
