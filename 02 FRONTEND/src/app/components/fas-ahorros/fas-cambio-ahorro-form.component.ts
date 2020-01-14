import { Component, AfterViewChecked, OnInit, ViewChild, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasAhorros } from '../../core/domain/fas-ahorros.domain';

import { FasAhorrosMetadata } from '../../core/domain/fas-ahorros.domain';
import { FasAhorrosDomain } from '../../core/domain/fas-ahorros.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule } from "ngx-bootstrap";
import { NotificationService } from "../../shared/utils/notification.service";

@Component({
  selector: 'fas-cambiar-ahorros-form',
  templateUrl: './fas-cambio-ahorro-form.component.html',
  providers: [UriProvider, GenericClientService]
})
export class FasCambiarAhorrosFormComponent implements AfterViewChecked {
  @Input() fasAhorros: FasAhorros;
  fasAhorros2: FasAhorros;
  fasAhorros3: FasAhorros;
  @ViewChild('fasAhorrosForm') currentForm: NgForm;
  private sub: any;
  private aporte: any;
  private fasAhorrosDomain = new FasAhorrosDomain();
  private isNewFasAhorros: boolean = false;
  private metadata: FasAhorrosMetadata = new FasAhorrosDomain().getFasAhorrosMetadata();
  private formErrors: any = this.fasAhorrosDomain.getFormErrors();
  private validationMessages: any = this.fasAhorrosDomain.getValidationMessages();
  @Input() padre: any;

  submitted = false;
  active = true;
  fasAhorrosForm: NgForm;
  private localAlert: AlertObject = new AlertObject(null, null, null, 0);
  private deshabilitar: any;
  private modalMessage: ConfirmationModalOptions
    = new ConfirmationModalOptions('Confirmación',
      '¿Desea enviar el cambio de aporte?',
      'Actualizar', 'Cancelar', null, true, false);
  private modalMessage2: ConfirmationModalOptions
      = new ConfirmationModalOptions('',
        '',
        'Actualizar', '', null, true, false);
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
    if (this.fasAhorros == null) {
      this.fasAhorros = new FasAhorros();



      this.isNewFasAhorros = true;
    }
    this.obtenerAporte();
    //this.aporte = this.fasAhorros.aporte;
     //this.aporte=this.fasAhorros2.aporte;
    this.fasAhorros.fasAfiliadosCorreo = localStorage.getItem("correo");
    this.fasAhorros.fasAfiliadosCorreo = this.fasAhorros.fasAfiliadosCorreo.replace("\"", "");
    this.fasAhorros.fasAfiliadosCorreo = this.fasAhorros.fasAfiliadosCorreo.replace("\"", "");
  }
  ngAfterViewChecked() {
    this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.fasAhorrosForm) { return; }
    this.fasAhorrosForm = this.currentForm;
    if (this.fasAhorrosForm) {
      this.fasAhorrosForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  addFasAhorros() {
    this.active = false;
    setTimeout(() => this.active = true, 0);
  }
  onSubmit() {
    //this.submitted = true;
    this._spinnerService.show();
    this.obtenerAporte();
    this.copiarValores(this.fasAhorros2);
    this.put(this.fasAhorros2);
    this.post(this.fasAhorros);
    if (this.isNewFasAhorros) {

      this.currentForm.reset();
    }

    if (this.padre) {

      this.padre.close();
    }

  }
  onValueChanged(data?: any) {
    this.modalMessage.disabled = !this.fasAhorrosForm.form.valid;
    if (!this.fasAhorrosForm) { return; }
    const form = this.fasAhorrosForm.form;

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

    let response: any;
    let serviceProvider: string = 'FasAhorrosCrearNuevoAporte';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.post(uriService, request)
          .subscribe(result => {
            response = result;
            this.handleResponse(response);

          },
            err => this.cathException('error_' + err)
          );
         this.obtenerAporte();
      });
  }

  put(request: any) {
    let response: any;
    let serviceProvider: string = 'FasAhorrosAportes';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.put(uriService, request)
          .subscribe(result => {
            response = result;
            this.handleResponse(response);
            // this.fasAhorros.idAhorro=null;

            // this.post(this.fasAhorros);

          },
            err => this.cathException('error_' + err)
          );

      });
  }


  handleResponse(response: any) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject('Operación exitosa', 'success', true, 10000);
    this.generateAlert();
    

  }

  cathException(error: string) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject('Error en el servicio', 'danger', true, 10000);
    this.generateAlert();
    switch (error) {
      case 'error_401':
        //this.router.navigate(['']);
        break;
      default:
      //this.router.navigate(['']);
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
  obtenerAporte() {
    let correo = localStorage.getItem("correo");
    correo = correo.replace("\"", "");
    correo = correo.replace("\"", "");
    correo.substring
    let serviceProvider: string = 'FasAhorros';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.genericClientService.get(`${uriService}/aportespermanentes?correo=${correo}`)
      // this.genericClientService.get(`${uriService}/?filterBy=fasAfiliadosCorreo%3D${correo}%26estado%3DACTIVO&orderBy=&from=&to=`)
      .subscribe(result => {

        this.fasAhorros2 = result[0];
        this.aporte = result[0].aporte;
        this.validarFechaSolicitud(this.fasAhorros2.fechaSolicitud);
      }, err => this.cathException('error_' + err)
      );

  }
  copiarValores(fasAhorros: FasAhorros) {
    this.fasAhorros.fasAfiliadosCorreo = fasAhorros.fasAfiliadosCorreo;
    this.fasAhorros.monto = fasAhorros.monto;
    this.fasAhorros.fasTiposAhoIdTipoAho = fasAhorros.fasTiposAhoIdTipoAho;
    this.fasAhorros.fechaInicio = fasAhorros.fechaInicio;
    this.fasAhorros.codAhorro= fasAhorros.codAhorro;
  }
  validarFechaSolicitud(fechaSolicitud: Date){
    let fechaActual: Date= new Date();
    let fecha: Date= new Date(fechaSolicitud);
    let fechaMasTreinta : Date= new Date();
    console.log(this.fasAhorros.aporte + "aporte")
    fecha.setDate(fecha.getDate()+30);
    if(fecha<=fechaActual){
      this.modalMessage.disabled=false;
      this.deshabilitar = false;
    
    }
    else{
      this.deshabilitar = true;
      this.modalMessage.disabled=true;
      this.localAlert=  new AlertObject('No ha pasado un mes desde su última solicitud de cambio de aporte', 'danger', true, 1000000);
      this.generateAlert();
    }
  }

  
  }