import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InformacionRoutingModule } from './informacion-routing.module';
import { BarraHomeComponent } from './barra-home/barra-home.component';
import { QuienesSomosComponent } from './quienes-somos/quienes-somos.component';
import { CreditosComponent } from './creditos/creditos.component';
import { AhorrosComponent } from './ahorros/ahorros.component';
import { ConveniosComponent } from './convenios/convenios.component';
import { BrowserModule }    from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UtilModule } from 'app/core/util/util.module';
import {SmartadminWidgetsModule} from "../shared/widgets/smartadmin-widgets.module";
import { ComiteComponent } from './comite/comite.component';
import { GalleryDemoRoutingModule } from 'app/+app-views/+gallery/gallery-demo-routing.module';
import { SmartadminGalleryModule } from 'app/shared/ui/gallery/gallery.module';
import { SmartadminModule } from 'app/shared/smartadmin.module';
import { CarouselModule } from 'ngx-bootstrap';
import { AdalService, AdalGuard} from 'adal-angular4';


@NgModule({
  imports: [
    CommonModule,
    InformacionRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    UtilModule,
    SmartadminWidgetsModule,
    SmartadminGalleryModule,
    SmartadminModule,
    UtilModule,
    CarouselModule
  ],
  declarations: [
    BarraHomeComponent, 
    QuienesSomosComponent, 
    CreditosComponent, 
    AhorrosComponent, 
    ConveniosComponent, 
    ComiteComponent,
    
  ],
  providers: [
    AdalService, AdalGuard,
  ]
})
export class InformacionModule { }
