import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactoComponent } from './layout/contacto/contacto.component';
import { DetallesProductoComponent } from './layout/detalles-producto/detalles-producto.component';
import { HomeComponent } from './layout/home/home.component';
import { IngresoProductoComponent } from './layout/ingreso-producto/ingreso-producto.component';
import { ListadoProductosComponent } from './layout/listado-productos/listado-productos.component';
import { ModificarProductoComponent } from './layout/modificar-producto/modificar-producto.component';


const routes: Routes = [
  {path: '', component: ListadoProductosComponent},
  {path: 'create', component: IngresoProductoComponent},
  {path: 'update/:id', component: ModificarProductoComponent},
  {path: 'detalle/:id', component: DetallesProductoComponent},
  {path: 'home', component: HomeComponent},
  {path: 'contacto', component: ContactoComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
