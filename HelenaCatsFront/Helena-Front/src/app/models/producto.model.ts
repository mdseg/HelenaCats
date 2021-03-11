export class Producto {
    idProducto?: number;
    nombre: String;
    alto: number;
    ancho: number;
    profundidad: number;
    precio: number;
    detalles: string;

    constructor
    (
        nombre: String,
        alto: number,
        ancho: number,
        profundidad: number,
        precio: number,
        detalles: string

    )
    {
        this.nombre = nombre;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.precio = precio;
        this.detalles = detalles;
    }
}
