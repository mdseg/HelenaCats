
package com.mdseg.Helena.dto;

import javax.validation.constraints.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProductoDto {
    @NotBlank
    private String nombre;

    @Min(0)
    private Integer alto;
    @Min(0)
    private Integer ancho;
    @Min(0)
    private Integer profundidad;
    @Min(0)
    private Float precio;
    @Min(0)   
    private String detalles;
    
    public ProductoDto()
    {
        
    }
    
        public ProductoDto(String nombre, Integer alto, Integer ancho, Integer profundidad, Float precio, String detalles) {
        this.nombre = nombre;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.precio = precio;
        this.detalles = detalles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }



    @Override
    public String toString() {
        return "ProductoDto{" + "nombre=" + nombre + ", alto=" + alto + ", ancho=" + ancho + ", profundidad=" + profundidad + ", precio=" + precio + ", detalles=" + detalles + '}';
    }
    

    
}
