import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Producto } from 'src/app/models/producto.model';
import { ProductoService } from 'src/app/service/producto.service.ts.service';

@Component({
  selector: 'app-detalles-producto',
  templateUrl: './detalles-producto.component.html',
  styleUrls: ['./detalles-producto.component.css']
})
export class DetallesProductoComponent implements OnInit {

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
    err =>{
      this.toastr.error(err.error.mensaje, 'Fail',
      {
        timeOut: 3000, positionClass: 'toast-top-center'
      });
      this.router.navigate(['/']);
    }


    );
  }

  volver(): void
  {
    this.router.navigate(['/']);  
  }

}
