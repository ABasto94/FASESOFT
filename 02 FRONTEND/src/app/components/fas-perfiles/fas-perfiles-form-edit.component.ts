import { Component, AfterViewChecked, OnInit, ViewChild, Input, QueryList, ElementRef } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasPerfiles } from '../../core/domain/fas-perfiles.domain';

import { FasPermisosDomain } from '../../core/domain/fas-permisos.domain';
import { FasPermisosMetadata } from '../../core/domain/fas-permisos.domain';
import { FasPerfilesMetadata } from '../../core/domain/fas-perfiles.domain';
import { FasPerfilesDomain } from '../../core/domain/fas-perfiles.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule } from "ngx-bootstrap";
import { NotificationService } from "../../shared/utils/notification.service";
import { FasAccesos } from 'app/core/domain/fas-accesos.domain';
import { FasPermisos } from 'app/core/domain/fas-permisos.domain';
import { bootstrapElementsRoutes } from 'app/+forms/+bootstrap-elements/bootstrap-elements.routing';

@Component({
  selector: 'fas-perfiles-form-edit',
  templateUrl: './fas-perfiles-form-edit.component.html',
  providers: [UriProvider, GenericClientService, ]
})
export class FasPerfilesFormEditComponent implements AfterViewChecked {
  @Input() fasPerfiles: FasPerfiles;
  @ViewChild('fasPerfilesForm') currentForm: NgForm;
  @ViewChild('closeModal') closeModal: ElementRef;
  private sub: any;
  private fasPerfilesDomain = new FasPerfilesDomain();
  private isNewFasPerfiles: boolean = false;
  private metadata2: FasPermisosMetadata = new FasPermisosDomain().getFasPermisosMetadata();
  private metadata: FasPerfilesMetadata = new FasPerfilesDomain().getFasPerfilesMetadata();
  private formErrors: any = this.fasPerfilesDomain.getFormErrors();
  private validationMessages: any = this.fasPerfilesDomain.getValidationMessages();
  @Input() padre: any;

  fasAccesosList: FasAccesos[];
  fasAccesosPorPerfil :FasAccesos[];
  fasPerfilesList: FasPerfiles[];

  submitted = false;
  active = true;
  fasPerfilesForm: NgForm;
  private localAlert: AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage: ConfirmationModalOptions
    = new ConfirmationModalOptions('Registro de nuevos datos',
      '¿La información ingresada es la correcta?',
      'Confirmar', 'Cancelar', null, true, false);

  botonDisabled = true;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private _spinnerService: SpinnerService,
    private genericClientService: GenericClientService,
    private notificationService: NotificationService
  ) {
  }

  ngOnInit(): void {

    if (this.fasPerfiles == null) {
      this.fasPerfiles = new FasPerfiles();
      this.isNewFasPerfiles = true;
    }
    this.getAccesoPorPerfil(this.fasPerfiles.tipo)
    this.getFasAccesosList(null);
    this.volverClick=false;
    this.getFasPerfilesList(null);
  }

  ngAfterViewChecked() {
    this.formChanged();
  }

  getFasPerfilesList(queryParamList: [string, string][]) {
    this._spinnerService.show();
   let serviceProvider : string = 'FasPerfiles';
   let pathParams : Array<[number, string]> = null;
   let queryParams : Array<[string, string]> = new Array<[string, string]>();
   let commonQuery : Array<string> = ["filterBy", "orderBy", "from", "to"];
   if (queryParamList !== null) {
     for (let queryParam of queryParamList) {
       queryParams.push([queryParam[0], this.uriProvider.encodeURI(queryParam[1])]);
       commonQuery = commonQuery.filter(item => item !== queryParam[0]);
     }
   }
   
   for ( let cq of commonQuery ){
     queryParams.push([cq, this.uriProvider.encodeURI("")]);
   }
   
   let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, pathParams, queryParams));
   console.log(uriService);
   this.sub = this.route
     .params
     .subscribe(params => {
       this.genericClientService.get(uriService)
         .subscribe(result => {this.fasPerfilesList = result; this._spinnerService.hide(); },
                      err  => this.cathException('error_' + err)
         );
     });
  }

  formChanged() {
    if (this.currentForm === this.fasPerfilesForm) { return; }
    this.fasPerfilesForm = this.currentForm;
    if (this.fasPerfilesForm) {
      this.fasPerfilesForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  addFasPerfiles() {
    this.active = false;
    setTimeout(() => this.active = true, 0);
  }
  onSubmit() {
    this.submitted = true;
    this.delete(this.fasPerfiles.idPerfil);
    if (this.padre) { 
      this.padre.close();
    }
    this.currentForm.reset();
    this.fasAccesosList = JSON.parse(JSON.stringify(this.fasAccesosList));
    this.volver();
  }

  onValueChanged(data?: any) {
    this.modalMessage.disabled = !this.fasPerfilesForm.form.valid;
    if (!this.fasPerfilesForm) { return; }
    const form = this.fasPerfilesForm.form;

    for (const field in this.formErrors) {
      if (true) {
        this.formErrors[field] = '';
        const control = form.get(field);

        if (control && control.dirty && !control.valid) {
          const messages = this.validationMessages[field];
          for (const key in control.errors) {
            if (true) {
              this.formErrors[field] += messages[key] + ' ';
            }
          }
        }
      }
    }
  }
  postFasPerfiles = (request: any) => {
    for (let index = 0; index < this.fasPerfilesList.length; index++) {
            if(this.fasPerfilesList[index].tipo == request.tipo ){
              this.cathException('error_' + "Ya existe")
              return;
            }
    }

      let serviceProvider: string = 'FasPerfiles';
      let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
      this.sub = this.route.params.subscribe(params => {
        this.genericClientService.post(uriService, request).subscribe(result => {
          this._spinnerService.hide();
          for (let i = 0; i < this.fasAccesosList.length; i++) {
            
            if(this.fasAccesosList[i].elegido){
              let permiso = new FasPermisos();
              permiso.fasPerfilesIdPerfil= result.idPerfil;
              permiso.fasAccesosIdAcceso=this.fasAccesosList[i].idAcceso;
              this.postFasPermisos(permiso);
            }          
          }

        this.handleResponse(result);

      },
        err => this.cathException('error_' + err)
      );
    });
  }

  postEditFasPermisos(){
    for (let i = 0; i < this.fasAccesosList.length; i++) {
            
      if(this.fasAccesosList[i].elegido){
        let permiso = new FasPermisos();
        permiso.fasPerfilesIdPerfil= this.fasPerfiles.idPerfil;
        permiso.fasAccesosIdAcceso=this.fasAccesosList[i].idAcceso;
        this.postFasPermisos(permiso);
      }          
    }

  }

  postFasPermisos(request: any) {
    let response: any;
    let serviceProvider: string = 'FasPermisos';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.post(uriService, request)
          .subscribe(result => {
            response = result;
                    },
            err => {
              this.cathException('error_' + err)
            }
          );
      });
  }

  put(request: any) {
    let response: any;
    let serviceProvider: string = 'FasPermisos';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    console.log(uriService);
    console.log(JSON.stringify(request));
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.put(uriService, request)
          .subscribe(result => {
            response = result;
            this.handleResponse(response);
          },
            err => this.cathException('error_' + err)
          );
      });
  }

  delete(idPerfil: number){
    let uriService = this.uriProvider.getUri(new UriControl(`FasPermisos`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.delete(`${uriService}/eliminarPorPerfil?idPerfil=${idPerfil}`)
        .subscribe(result => {    
          this.postEditFasPermisos();                    
        }
        );
    });
    
  }

  handleResponse(response: any) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject('!Operación Exitosa¡', 'success', true, 10000);
    this.generateAlert();
    console.log(response);
  }

  cathException(error: string) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject('Error on service', 'danger', true, 10000);
    this.generateAlert();
    switch (error) {
      case 'error_401':
        break;
      default:

    }
  }

  getConfirmationResponse($event: [boolean, any]) {
    if ($event[0]) {
      this.onSubmit();
    } else {
      document.body.classList.add('modal-open');
    }
  }

  generateAlert() {
    this.notificationService.smallBox({
      title: "Mensaje",
      content: this.localAlert.message,
      color: this.localAlert.resolveColor(),
      timeout: this.localAlert.lifetime,
      icon: this.localAlert.resolveIcon()
    });
  }
  getFasAccesosList(queryParamList: [string, string][]) {
    this._spinnerService.show();
    let serviceProvider: string = 'FasAccesos';
    let pathParams: Array<[number, string]> = null;
    let queryParams: Array<[string, string]> = new Array<[string, string]>();
    let commonQuery: Array<string> = ["filterBy", "orderBy", "from", "to"];
    if (queryParamList !== null) {
      for (let queryParam of queryParamList) {
        queryParams.push([queryParam[0], this.uriProvider.encodeURI(queryParam[1])]);
        commonQuery = commonQuery.filter(item => item !== queryParam[0]);
      }
    }

    for (let cq of commonQuery) {
      queryParams.push([cq, this.uriProvider.encodeURI("")]);
    }

    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, pathParams, queryParams));
    console.log(uriService);
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.get(uriService)
          .subscribe(result => {            
            this.fasAccesosList = result;
            this.fasAccesosList.map(Acceso => {
              Acceso.elegido = false;
            });
            this._spinnerService.hide();
          },
            err => this.cathException('error_' + err)
          );

      });
  }

  getAccesoPorPerfil(Tipo: String){
      
    let uriService = this.uriProvider.getUri(new UriControl(`FasAccesos`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.get(`${uriService}/tipo?tipo=${Tipo}`)
        .subscribe(result => {                        
          this.fasAccesosPorPerfil = result;
        }
        );
    });
}

  compararAccesosDeUnPerfil(acceso: FasAccesos, i):boolean{
    let encontro= false;
    for (let index = 0; index < this.fasAccesosPorPerfil.length; index++) {
         encontro = this.fasAccesosPorPerfil[index].nombre === acceso.nombre;
         if(encontro){
           this.fasAccesosList[i].elegido=true;
           break;
         }    
    }
    return encontro;
  }

  validateInput() {
    let nombre = false;

    for (let fasAcceso of this.fasAccesosList) {
      if (fasAcceso.elegido) nombre = true;
    }
    this.botonDisabled = !nombre || this.fasPerfiles.tipo === undefined || this.fasPerfiles.tipo === "";
  }
  cambiarLosAccesos(i) {
    this.fasAccesosList[i].elegido = !this.fasAccesosList[i].elegido;

    let nombre = false;

    for (let fasAcceso of this.fasAccesosList) {
      if (fasAcceso.elegido) nombre = true; 
    }
    this.botonDisabled = !nombre || this.fasPerfiles.tipo === undefined || this.fasPerfiles.tipo === "";
  }
  volverClick:boolean=false;
  volver(){
    window.scroll(0,0);
  }

}