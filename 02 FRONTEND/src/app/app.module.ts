import { NgModule, ApplicationRef } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpModule } from "@angular/http";

import { NgxPrintModule } from "ngx-print";
/*
 * Platform and Environment providers/directives/pipes
 */
import { routing } from "./app.routing";
// App is our top level component
import { AppComponent } from "./app.component";
import { APP_RESOLVER_PROVIDERS } from "./app.resolver";
import { AppState, InternalStateType } from "./app.service";

// Core providers
import { CoreModule } from "./core/core.module";
import { SmartadminLayoutModule } from "./shared/layout/layout.module";

// imports generador crud
import { FasAccesosModule } from './components/fas-accesos/fas-accesos.module';
import { FasAfiliadosModule } from './components/fas-afiliados/fas-afiliados.module';
import { FasAhorrosModule } from './components/fas-ahorros/fas-ahorros.module';
import { FasAportesModule } from './components/fas-aportes/fas-aportes.module';
import { FasConveniosModule } from './components/fas-convenios/fas-convenios.module';
import { FasCreditosModule } from './components/fas-creditos/fas-creditos.module';
import { FasPagosModule } from './components/fas-pagos/fas-pagos.module';
import { FasPerfilesModule } from './components/fas-perfiles/fas-perfiles.module';
import { FasPermisosModule } from './components/fas-permisos/fas-permisos.module';
import { FasRolesModule } from './components/fas-roles/fas-roles.module';
import { FasSolConveniosModule } from './components/fas-sol-convenios/fas-sol-convenios.module';
import { FasTiposDeCreditoModule } from './components/fas-tipos-de-credito/fas-tipos-de-credito.module';

import { SpinnerService } from './core/util/spinner/spinner.service';
import { ModalService } from './core/util/modal/modal.service';
import { InformacionModule } from './informacion/informacion.module';
import { UploadFormsComponent } from './uploads/upload-forms/upload-forms.component';
import { UploadService } from './uploads/share/upload.service';
import { AngularFireModule } from '@angular/fire';
import {AngularFireStorageModule, StorageBucket} from'@angular/fire/storage';


import { AdalService, AdalGuard, AdalInterceptor } from 'adal-angular4';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthGuardAdal } from './core/guards/auth-guard-adal';
import { DatosModule } from "./components/datos/datos.module";
import { FasExtractosModule } from "./components/fas-extractos/fas-extractos.module";
import { RegistroComponent } from './registro/registro.component';
import { UriProvider } from './core/service/uri.provider';
import { GenericClientService } from './core/client/generic-client.service';
import { UiValidateDirective } from './shared/forms/validation';
import { ModalModule } from 'ngx-bootstrap';
import { GraphServiceService } from './graph-service.service';

// Application wide providers
  const firebaseConfig= {
    apiKey: "AIzaSyCjRk0jcDKdMkM85acWXX1IQFkG4B-E1m8",
    authDomain: "fasesoft1.firebaseapp.com",
    databaseURL: "https://fasesoft1.firebaseio.com",
    projectId: "fasesoft1",
    storageBucket: "fasesoft1.appspot.com",
    messagingSenderId: "156119879436",
    appId: "1:156119879436:web:5614181bc513686a348329",
    measurementId: "G-3LVKB07EGN"
};
const APP_PROVIDERS = [
  ...APP_RESOLVER_PROVIDERS,
  AppState
];

type StoreType = {
  state: InternalStateType;
  restoreInputValues: () => void;
  disposeOldHosts: () => void;
};


@NgModule({
  bootstrap: [ AppComponent ],
  declarations: [
    AppComponent, 
    UploadFormsComponent, 
    RegistroComponent,
    UiValidateDirective,
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,

    CoreModule,
    SmartadminLayoutModule,
    routing,
  AngularFireModule.initializeApp(firebaseConfig), 
	FasAccesosModule,
	FasAfiliadosModule,
	FasAhorrosModule,
	FasAportesModule,
	FasConveniosModule,
	FasCreditosModule,
	FasPagosModule,
	FasPerfilesModule,
	FasPermisosModule,
	FasRolesModule,
	FasSolConveniosModule,
  FasTiposDeCreditoModule,
  InformacionModule,
  AngularFireStorageModule,
  FasAccesosModule,
  FasAfiliadosModule,
  FasAhorrosModule,
  FasAportesModule,
  FasConveniosModule,
  FasCreditosModule,
  FasPagosModule,
  FasPerfilesModule,
  FasPermisosModule,
  FasRolesModule,
  FasSolConveniosModule,
  FasTiposDeCreditoModule,
  FasExtractosModule,
  DatosModule,
  NgxPrintModule,
  ModalModule.forRoot()
  
  ],
  exports: [
    UiValidateDirective,

  ],
  providers: [
    UriProvider,
    ModalService,
    SpinnerService,
    APP_PROVIDERS,
    UploadService,
    AdalService, 
    AdalGuard, 
    GenericClientService,
    AuthGuardAdal, 
    GraphServiceService,
    {
      provide: HTTP_INTERCEPTORS, 
      useClass: AdalInterceptor, 
      multi: true 
    }
  ]
})
export class AppModule {
  constructor(public appRef: ApplicationRef, public appState: AppState) {}
}
