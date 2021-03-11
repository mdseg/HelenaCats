import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Producto } from 'src/app/models/producto.model';
import { ProductoService } from 'src/app/service/producto.service.ts.service';

@Component({
  selector: 'app-listado-productos',
  templateUrl: './listado-productos.component.html',
  styleUrls: ['./listado-productos.component.css']
})
export class ListadoProductosComponent implements OnInit {

  productos: Producto[] = [];

  constructor(
    private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router

  ) { }

  ngOnInit(): void {
    this.cargarProductos();
  }

  cargarProductos():void
  {
    this.productoService.lista().subscribe(
      data => 
      {
        this.productos = data;
        this.productos.forEach(element => {
          console.log(`id: ${element.idProducto}, nombre: ${element.nombre}`);  
        });
      },
      err =>
      {
        console.log(err);
      }
    );
  }

  borrar(id: number)
  {
    //alert('Borrar el ' + id);
    this.productoService.delete(id).subscribe(
      data =>{
        this.toastr.success("Producto eliminado correctamente", 'OK',
        {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.cargarProductos();

      },
      err =>
      {
        this.toastr.error("Error al eliminar el producto", 'OK',
        {
          timeOut: 3000, positionClass: 'toast-top-center'
        });

      }
    );
  }

  irCreate(): void
  {
    this.router.navigate(['/create']);  
  }
}
