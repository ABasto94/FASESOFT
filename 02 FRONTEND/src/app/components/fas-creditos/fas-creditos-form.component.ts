import { Component, AfterViewChecked, OnInit, ViewChild, Input, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasCreditos } from '../../core/domain/fas-creditos.domain';

import { FasCreditosMetadata } from '../../core/domain/fas-creditos.domain';
import { FasCreditosDomain } from '../../core/domain/fas-creditos.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { AdalService } from 'adal-angular4';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule } from "ngx-bootstrap";
import { NotificationService } from "../../shared/utils/notification.service";
import { FasAfiliados } from 'app/core/domain/fas-afiliados.domain';
import { FasTiposDeCredito } from 'app/core/domain/fas-tipos-de-credito.domain';
import { FasCreditosServiceService } from './fas-creditos-service.service';


@Component({
  selector: 'fas-creditos-form',
  templateUrl: './fas-creditos-form.component.html',
  styleUrls: ['./estilos-creditos.css'],
  providers: [UriProvider, GenericClientService],
  
})
export class FasCreditosFormComponent implements AfterViewChecked {
  @Input() fasCreditos: FasCreditos;
  @Output('respuesta') CreacionCredito = new EventEmitter();
  @ViewChild('fasCreditosForm') currentForm: NgForm;
  private sub: any;
  private fasCreditosDomain = new FasCreditosDomain();
  private isNewFasCreditos: boolean = false;
  private correo : any;
  
  private metadata: FasCreditosMetadata = new FasCreditosDomain().getFasCreditosMetadata();
  private formErrors: any = this.fasCreditosDomain.getFormErrors();
  private validationMessages: any = this.fasCreditosDomain.getValidationMessages();
  public fasAfiliadoInfo: FasAfiliados[];
  private fasTiposDeCreditoList: FasTiposDeCredito[];
  cuotaMaxima: number;
  cuotaMaximalist: any=[];



  @Input() padre: any;

  submitted = false;
  active = true;
  fasCreditosForm: NgForm;
  private localAlert: AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage: ConfirmationModalOptions
    = new ConfirmationModalOptions('Solicitud de crédito',
      '¿Seguro desea enviar la solicitud de crédito?',
      'Enviar', 'Cancelar', null, true, false);
  constructor(
    private adalService: AdalService, 
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private _spinnerService: SpinnerService,
    private genericClientService: GenericClientService,
    private notificationService: NotificationService,
    private fasCreditosServiceService: FasCreditosServiceService,
  ) {
  }

  ngOnInit(): void {
    this.fasCreditosServiceService.limpiar.subscribe(result=>{
      this.limpiar();
    });
    if (this.fasCreditos == null) {
      this.fasCreditos = new FasCreditos();
      this.isNewFasCreditos = true;

    }
    this.getFasTiposDeCreditoList(null);
    console.log("inició")
    this.correo=localStorage.getItem("correo");
    this.correo=this.correo.replace("\"","");
    this.correo=this.correo.replace("\"","");
    this.fasCreditos.fasAfiliadosCorreo=this.correo;
    

  }
  ngAfterViewChecked() {
    this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.fasCreditosForm) { return; }
    this.fasCreditosForm = this.currentForm;
    if (this.fasCreditosForm) {
      this.fasCreditosForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  addFasCreditos() {
    this.active = false;
    setTimeout(() => this.active = true, 0);
  }
  onSubmit() {
    //this.submitted = true;
    this._spinnerService.show();
    if (this.isNewFasCreditos) {
      this.post(this.fasCreditos);
    } else {
      this.put(this.fasCreditos);
    }

    if (this.padre) {

      this.padre.close();
    }
    this.currentForm.reset();
  //  location.reload();
    
    
  }
  onValueChanged(data?: any) {
    this.modalMessage.disabled = !this.fasCreditosForm.form.valid;
    if (!this.fasCreditosForm) { return; }
    const form = this.fasCreditosForm.form;

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
    let serviceProvider: string = 'FasCreditos';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.post(uriService, request)
          .subscribe(result => {
            response = result;
            console.log(result);
            
            this.handleResponse(response);
            this.respuestaGuardado()
          },
            err => this.cathException('error_' + err)
          );
      });
  }

  put(request: any) {
    let response: any;
    let serviceProvider: string = 'FasCreditos';
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

  handleResponse(response: any) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject('Envío exitoso', 'success', true, 10000);
    this.generateAlert();
    console.log(response);
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
    console.log("mi evento es: ", $event);
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


  getFasTiposDeCreditoList(queryParamList: [string, string][]) {
    let serviceProvider: string = 'FasTiposDeCredito';

    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    console.log(uriService);
    this.genericClientService.get(uriService)
      .subscribe(result => {
        this.fasTiposDeCreditoList = result;
        console.log(result);
      }
      );
  }
  respuestaGuardado() {
    this.CreacionCredito.emit([]);
  }
  cambiarTasa(id){
 
    this.fasCreditos.tasaReal=this.fasTiposDeCreditoList.find(tipoCredito=> tipoCredito.idTipo==id).tasa;
    
}
cuotasMaxima(id){
  this.cuotaMaxima=0;
  this.cuotaMaxima= this.fasTiposDeCreditoList.find(tipoCredito=> tipoCredito.idTipo==id).cuotasMaximas;
  console.log(this.cuotaMaxima);
  this.cuotaMaximalist= [];
  for(let i=1; i<=this.cuotaMaxima; i++){
   
    this.cuotaMaximalist.push(i); 
  }
}
limpiar(){
  this.currentForm.reset();
  //this.fasCreditosList.toggleForm();
}

}