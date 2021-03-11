import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Producto } from 'src/app/models/producto.model';
import { ProductoService } from 'src/app/service/producto.service.ts.service';

@Component({
  selector: 'app-modificar-producto',
  templateUrl: './modificar-producto.component.html',
  styleUrls: ['./modificar-producto.component.css']
})
export class ModificarProductoComponent implements OnInit {

  producto: Producto = null;

  constructor(
    private productoService: ProductoService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router

  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.productoService.detail(id).subscribe(
      data => {
        this.producto = data;
      },
      err => {
        this.toastr.error("Error al cargar el producto", 'OK',
          {
            timeOut: 3000, positionClass: 'toast-top-center'
          });
        this.router.navigate(['/']);

      }
    );
  }
  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.productoService.update(id, this.producto).subscribe(
      data => {
        this.toastr.success("Producto actualizado correctamente", 'OK',
          {
            timeOut: 3000, positionClass: 'toast-top-center'
          });
        this.router.navigate(['/']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail',
          {
            timeOut: 3000, positionClass: 'toast-top-center'
          });
        this.router.navigate(['/']);

      }

    );
  }

}
