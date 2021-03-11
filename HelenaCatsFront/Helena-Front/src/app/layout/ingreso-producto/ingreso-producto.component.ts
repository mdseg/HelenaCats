import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Producto } from 'src/app/models/producto.model';
import { ProductoService } from 'src/app/service/producto.service.ts.service';

@Component({
  selector: 'app-ingreso-producto',
  templateUrl: './ingreso-producto.component.html',
  styleUrls: ['./ingreso-producto.component.css']
})
export class IngresoProductoComponent implements OnInit {

  nombre:string = '';
  precio: number = null;
  alto: number = null;
  ancho: number = null;
  profundidad: number = null;
  detalles: string = '';
  fileToUpload: File = null;


  constructor(
    private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router

    
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void
  {
    const producto = new Producto(this.nombre,this.alto,this.ancho,this.profundidad,this.precio,this.detalles);
    console.log(producto.idProducto);
    console.log(producto.nombre);
    console.log(producto.precio);
    this.productoService.save(producto).subscribe(
      data =>{
        this.toastr.success("Producto creado correctamente", 'OK',
        {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/']);
      },
      err =>{
        this.toastr.error(err.error.mensaje, 'Fail',
        {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/']);

      }
    );
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
}

}