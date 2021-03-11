package com.mdseg.Helena.controller;

import com.mdseg.Helena.dto.Mensaje;
import com.mdseg.Helena.dto.ProductoDto;
import com.mdseg.Helena.entity.Producto;
import com.mdseg.Helena.service.ProductoService;
import com.mdseg.Helena.service.ValidationService;

import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    @Autowired
    ProductoService productoService;
    @Autowired
    ValidationService validationService;

    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> list() {
        List<Producto> list = productoService.list();
        for (Producto producto : list) {
            System.out.println(producto);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id) {
        if (!(productoService.existsById(id))) {
            return new ResponseEntity(new Mensaje("No existe el producto"), HttpStatus.NOT_FOUND);

        }
        Producto producto = productoService.getOne(id).get();
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre) {
        if (!(productoService.existsByNombre(nombre))) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        }
        Producto producto = productoService.getByNombre(nombre).get();
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto) {
        int resultadoValidar = validationService.validateProducto(productoDto);

        switch (resultadoValidar) {
            case 1:
                return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            case 2:
                return new ResponseEntity(new Mensaje("El precio es obligatorio o debe ser mayor que cero"), HttpStatus.BAD_REQUEST);
            case 3:
                return new ResponseEntity(new Mensaje("La altura es obligatoria o debe ser mayor que cero"), HttpStatus.BAD_REQUEST);
            case 4:
                return new ResponseEntity(new Mensaje("El ancho es obligatorio o debe ser mayor que cero"), HttpStatus.BAD_REQUEST);
            case 5:
                return new ResponseEntity(new Mensaje("La profundidad es obligatoria o debe ser mayor que cero"), HttpStatus.BAD_REQUEST);
            case 6:
                return new ResponseEntity(new Mensaje("El campo detalles es obligatorio"), HttpStatus.BAD_REQUEST);
            case 0:
                Producto producto = new Producto(productoDto.getNombre(), productoDto.getAlto(), productoDto.getAncho(), productoDto.getProfundidad(), productoDto.getPrecio(), productoDto.getDetalles());
                productoService.save(producto);
                return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);

        }

        return new ResponseEntity(new Mensaje("Error genérnico"), HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductoDto productoDto) {
        if (!productoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        int resultadoValidar = validationService.validateProducto(productoDto);

        switch (resultadoValidar) {
            case 1:
                return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            case 2:
                return new ResponseEntity(new Mensaje("El precio es obligatorio o debe ser mayor que cero"), HttpStatus.BAD_REQUEST);
            case 3:
                return new ResponseEntity(new Mensaje("La altura es obligatoria o debe ser mayor que cero"), HttpStatus.BAD_REQUEST);
            case 4:
                return new ResponseEntity(new Mensaje("El ancho es obligatorio o debe ser mayor que cero"), HttpStatus.BAD_REQUEST);
            case 5:
                return new ResponseEntity(new Mensaje("La profundidad es obligatoria o debe ser mayor que cero"), HttpStatus.BAD_REQUEST);
            case 6:
                return new ResponseEntity(new Mensaje("El campo detalles es obligatorio"), HttpStatus.BAD_REQUEST);
            case 0:
                Producto producto = productoService.getOne(id).get();
                producto.setNombre(productoDto.getNombre());
                producto.setPrecio(productoDto.getPrecio());
                producto.setAlto(productoDto.getAlto());
                producto.setAncho(productoDto.getAncho());
                producto.setProfundidad(productoDto.getProfundidad());
                producto.setDetalles(productoDto.getDetalles());
                productoService.save(producto);
                return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);

        }

        return new ResponseEntity(new Mensaje("Error genérnico"), HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!productoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        productoService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);

    }
}
