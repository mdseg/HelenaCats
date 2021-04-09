import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProductoService } from 'src/app/service/producto.service.ts.service';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {


  nombre:string = '';
  email:string = '';
  telefono:string = '';
  mensaje:string= '';
  


  constructor(
    private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router

    
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void
  {



  }

}
