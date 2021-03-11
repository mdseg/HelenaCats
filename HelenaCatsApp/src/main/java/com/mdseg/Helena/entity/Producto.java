package com.mdseg.Helena.entity;
import javax.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nombre;
    private int alto;
    private int ancho;
    private int profundidad;
    private float precio;
    private String detalles;

    public Producto() {
    }

    public Producto(String nombre, int alto, int ancho, int profundidad, float precio, String detalles) {
        this.nombre = nombre;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.precio = precio;
        this.detalles = detalles;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
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
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", alto=" + alto + ", ancho=" + ancho + ", profundidad=" + profundidad + ", precio=" + precio + ", detalles=" + detalles + '}';
    }
    
    
    
}
