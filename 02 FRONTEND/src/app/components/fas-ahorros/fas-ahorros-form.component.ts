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
import { FasTiposDeAhorro } from 'app/core/domain/fas-tipos-de-ahorro.domain';

@Component({
  selector: 'fas-ahorros-form',
  templateUrl: './fas-ahorros-form.component.html',
  providers: [UriProvider, GenericClientService]
})
export class FasAhorrosFormComponent implements AfterViewChecked {
  @Input() fasAhorros: FasAhorros;
  @ViewChild('fasAhorrosForm') currentForm: NgForm;
  private sub: any;
  private aporte : any;
  private fasAhorrosDomain = new FasAhorrosDomain();
  private isNewFasAhorros: boolean = false;
  private metadata: FasAhorrosMetadata = new FasAhorrosDomain().getFasAhorrosMetadata();
  private formErrors: any = this.fasAhorrosDomain.getFormErrors();
  private validationMessages: any = this.fasAhorrosDomain.getValidationMessages();
  @Input() padre: any;

  public listAcceso: FasTiposDeAhorro[];
  public listAhorros : FasAhorros[];
  public correo : String;

  submitted = false;
  active = true;
  fasAhorrosForm: NgForm;
  private localAlert: AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage: ConfirmationModalOptions
    = new ConfirmationModalOptions('Title',
      'Esperamos tu confirmación !!!',
      'Enviar', 'Cancelar', null, true, false);
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private _spinnerService: SpinnerService,
    private genericClientService: GenericClientService,
    private notificationService: NotificationService,
  ) {
  }

  ngOnInit(): void {
    if (this.fasAhorros == null) {
      this.fasAhorros = new FasAhorros();
      
      
     
      this.isNewFasAhorros = true;
      this.getFasAhorrosList(null);
      this.setCorreo();
    }
    
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
    this.post(this.fasAhorros);
    
    if (this.isNewFasAhorros) {
      let dateString : string = this.fasAhorros.fechaInicioAporte;
      console.log(dateString);
      let newDate = new Date(dateString);
      this.fasAhorros.fechaInicioAporte = newDate;
      this.post(this.fasAhorros);
    } else {
      this.put(this.fasAhorros);
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
    let serviceProvider: string = 'FasAhorros';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    
    this.sub = this.route
      .params
      .subscribe(params => {
        request.estado = "PENDIENTE";
        this.genericClientService.post(uriService, request)
          .subscribe(result => {
            response = result;
            this.handleResponse(response);
          },
            err => this.cathException('error_' + err)
          );
      });
  }

  put(request: any) {
    let response: any;
    let serviceProvider: string = 'FasAhorros';
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
    this.localAlert = new AlertObject('Operación exitosa', 'success', true, 10000);
    this.generateAlert();
    console.log(response);
  }

  cathException(error: string) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject('Error en servicio', 'danger', true, 10000);
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

  getFasAhorrosList(queryParamList: [string, string][]) {
    let serviceProvider: string = 'fasTiposDeAhorros';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null)) + "servicios/fastiposdeahorro";
    console.log(uriService);
    this.genericClientService.get(uriService)
      .subscribe(result => {
        this.listAcceso = result;
        console.log(result);

      }
      );
    }
   
setCorreo() {
  this.fasAhorros.fasAfiliadosCorreo = localStorage.getItem("correo").replace('"','').replace('"','');
  console.log(this.correo);
}
}