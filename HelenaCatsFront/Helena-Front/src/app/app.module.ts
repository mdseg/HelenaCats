import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListadoProductosComponent } from './layout/listado-productos/listado-productos.component';
import { DetallesProductoComponent } from './layout/detalles-producto/detalles-producto.component';
import { FooterComponent } from './layout/footer/footer.component';
import { HeaderComponent } from './layout/header/header.component';
import { HomeComponent } from './layout/home/home.component';
import { IngresoProductoComponent } from './layout/ingreso-producto/ingreso-producto.component';
import { ModificarProductoComponent } from './layout/modificar-producto/modificar-producto.component';
import { ContactoComponent } from './layout/contacto/contacto.component';


import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ProductoService } from './service/producto.service.ts.service';
import { NgxFileDropModule} from 'ngx-file-drop';
import { FileUploadComponent } from './file-upload/file-upload.component';


@NgModule({
  declarations: [
    AppComponent,
    ListadoProductosComponent,
    DetallesProductoComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    IngresoProductoComponent,
    ModificarProductoComponent,
    FileUploadComponent,
    ContactoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    NgxFileDropModule


    
  ],
  providers: [ProductoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
