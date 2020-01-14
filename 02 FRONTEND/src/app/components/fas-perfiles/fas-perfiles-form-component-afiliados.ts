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
import { FasAfiliados, FasAfiliadosDomain, FasAfiliadosMetadata } from 'app/core/domain/fas-afiliados.domain';
import { FasRoles } from 'app/core/domain/fas-roles.domain';
import { FasUsuarios } from 'app/core/domain/fas-usuarios.domain';

@Component({
  selector: 'fas-perfiles-form-component-afiliados',
  templateUrl: './fas-perfiles-form-component-afiliados.html',
  providers: [UriProvider, GenericClientService, ]
})
export class FasPerfilesFormComponentAfiliados implements OnInit   {
  fasUsuarioGet : FasUsuarios[];
  idAfiliado:number;
  @Input() fasAfiliados : FasAfiliados;
  @ViewChild('fasAfiliadosForm') currentForm: NgForm;
  private sub: any;
  private fasAfiliadosDomain = new FasAfiliadosDomain();
  private isNewFasAfiliados : boolean = false;
  private metadata : FasAfiliadosMetadata = new FasAfiliadosDomain().getFasAfiliadosMetadata();
  private formErrors : any = this.fasAfiliadosDomain.getFormErrors();
  private validationMessages : any = this.fasAfiliadosDomain.getValidationMessages();
  @Input()padre: any;

  fasPerfilesList: FasPerfiles[];
  fasPerfilesPorUsuarioList: FasPerfiles[];

  botonDisabled = true;
  submitted = false;
  active = true;
  fasAfiliadosForm: NgForm;
  submitClicked=false;
  
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage : ConfirmationModalOptions
    = new ConfirmationModalOptions('Title',
                                    'Esperamos tu confirmación !!!',
                                    'Submit', 'Cancel', null, true, false);
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
    if (this.fasAfiliados == null) {
      this.fasAfiliados = new FasAfiliados();
      this.isNewFasAfiliados = true;
    }    
    this.getFasPerfilesList(null);
    this.getPerfilesPorUsuario(this.fasAfiliados.correo);
    this.getUsuariosPorCorreo(this.fasAfiliados.correo);
  }
   ngAfterViewChecked() {
     this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.fasAfiliadosForm) { return; }
    this.fasAfiliadosForm = this.currentForm;
    if (this.fasAfiliadosForm) {
      this.fasAfiliadosForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  addFasAfiliados() {
    this.active = false;
    setTimeout(() => this.active = true, 0);
  }
  onSubmit() {
    this.delete(this.idAfiliado);
    if(this.padre){
      this.padre.close();
    }
  }

  onValueChanged(data?: any) {
    this.modalMessage.disabled = !this.fasAfiliadosForm.form.valid;
    if (!this.fasAfiliadosForm) { return; }
    const form = this.fasAfiliadosForm.form;

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

  
  post(request: any) {
    let response : any;
    let serviceProvider : string = 'FasAfiliados';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.post(uriService, request)
          .subscribe(result => {response = result;
                                this.handleResponse(response); },
                       err  => this.cathException('error_' + err)
          );
      });
  }

  postFasRoles(request: any) {
    let response : any;
    let serviceProvider : string = 'FasRoles';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

    this.sub = this.route.params.subscribe(params => {
        this.genericClientService.post(uriService, request)
          .subscribe(result => {
            response = result; 
            this.handleResponse(response);
          },
                       err  => this.cathException('error_' + err)
          );
      });
  }

  getPerfilesPorUsuario(Correo: String){
    let uriService = this.uriProvider.getUri(new UriControl(`FasPerfiles`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.get(`${uriService}/correo?correo=${Correo}`)
        .subscribe(result => {                        
          this.fasPerfilesPorUsuarioList = result;
        }
        );
    });
  }
  
  compararPerfilesDeUnUsuario(perfil: FasPerfiles,i): boolean{
    let encontro = false;    
    if(this.fasPerfilesPorUsuarioList === null || this.fasPerfilesPorUsuarioList === undefined) return;
    for (let index = 0; index < this.fasPerfilesPorUsuarioList.length; index++) {
        encontro = this.fasPerfilesPorUsuarioList[index].idPerfil === perfil.idPerfil;     
        if(encontro){
          this.fasPerfilesList[i].elegido=true;
          break;
        }
    }
    return encontro;
  }

  delete(idUsuario: number){
    let uriService = this.uriProvider.getUri(new UriControl(`FasRoles`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.delete(`${uriService}/eliminarPorUsuario?idUsuario=${idUsuario}`)
        .subscribe(result => {    
          this.postCheckeados();                    
        }
        );
    });
    
  }

  getUsuariosPorCorreo(IdCorreo: String){
    
    let uriService = this.uriProvider.getUri(new UriControl(`UsuariosSearch`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.get(`${uriService}/${IdCorreo}`)
        .subscribe(result => {                    
          this.fasUsuarioGet = result; 
          
          for (let index = 0; index < this.fasUsuarioGet.length; index++) {
            this.idAfiliado = this.fasUsuarioGet[index].idUsuario;            
          }          
        }
        );
    });
}

  postCheckeados(){
    for (let index = 0; index < this.fasPerfilesList.length; index++) {
      if(this.fasPerfilesList[index].elegido){
        let rol = new FasRoles();
        
        rol.fasUsuariosIdUsuario=this.idAfiliado;
        rol.fasPerfilesIdPerfil=this.fasPerfilesList[index].idPerfil;
        this.postFasRoles(rol);
      }              
    }
  }
  
  put(request: any) {
    let response : any;
    let serviceProvider : string = 'FasAfiliados';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.put(uriService, request)
          .subscribe(result => {response = result;
                                this.handleResponse(response); },
                       err  => this.cathException('error_' + err)
          );
      });
  }
  
  handleResponse(response : any) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject('Successful operation', 'success', true, 10000);
    this.generateAlert();
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

  getConfirmationResponse($event : [boolean, any]) {
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
      color: this.localAlert.resolveColor() ,
      timeout: this.localAlert.lifetime,
      icon: this.localAlert.resolveIcon()
    });
  }

  getFasPerfilesList(queryParamList: [string, string][]) {
    //this._spinnerService.show();
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
   this.sub = this.route
     .params
     .subscribe(params => {
       this.genericClientService.get(uriService)
         .subscribe(result => {
           this.fasPerfilesList = result; 
           this.fasPerfilesList.map(Perfil => {
             Perfil.elegido = false;
           });
           this._spinnerService.hide(); 
          },
           err  => this.cathException('error_' + err)
         );
     });
  }

  cambiarLosPerfiles(i) {
    this.fasPerfilesList[i].elegido = !this.fasPerfilesList[i].elegido;
    this.botonDisabled= !this.fasPerfilesList.some(perfil=> perfil.elegido);
  }

  validarUsuario(){
    if(this.fasUsuarioGet === undefined){
      return true;
    }
    return this.fasUsuarioGet.length === 0;
  }
}