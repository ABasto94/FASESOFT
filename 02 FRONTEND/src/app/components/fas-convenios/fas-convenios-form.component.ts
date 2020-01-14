import { Component, AfterViewChecked, OnInit, ViewChild, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasConvenios, FasConveniosMetadata, FasConveniosDomain } from '../../core/domain/fas-convenios.domain';
import { FasTiposConvenio, FasTiposConvenioMetadata, FasTiposConvenioDomain } from '../../core/domain/fas-tipos-convenio.domain';
import { FasSolConvenios, FasSolConveniosMetadata, FasSolConveniosDomain} from '../../core/domain/fas-sol-convenios.domain';

import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";

@Component({
  selector: 'fas-convenios-form',
  templateUrl: './fas-convenios-form.component.html',
  providers:  [UriProvider, GenericClientService]
})
export class FasConveniosFormComponent implements AfterViewChecked {
  @Input() fasConvenios : FasConvenios;
  fasSolConvenios : FasSolConvenios;
  @ViewChild('fasConveniosForm') currentForm: NgForm;

  fasTiposConvenioList : FasTiposConvenio[];
  private sub: any;
  private fasConveniosDomain = new FasConveniosDomain();
  private fasSolConveniosDomain = new FasSolConveniosDomain();
  private isNewFasConvenios : boolean = false;
  private metadata : FasConveniosMetadata = new FasConveniosDomain().getFasConveniosMetadata();
  private metadata2 : FasSolConveniosMetadata = new FasSolConveniosDomain().getFasSolConveniosMetadata();
  private formErrors : any = this.fasConveniosDomain.getFormErrors();
  private validationMessages : any = this.fasConveniosDomain.getValidationMessages();
  private maximo: number;
  @Input()padre: any;

  submitted = false;
  active = true;
  fasConveniosForm: NgForm;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage : ConfirmationModalOptions
    = new ConfirmationModalOptions('Confirmación',
                                    '¿Deseas continuar con la operación?',
                                    'Continuar', 'Cancelar', null, true, false);
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
    if (this.fasConvenios == null) {
      this.fasConvenios = new FasConvenios();
      this.isNewFasConvenios = true;
    } 
    if(this.fasTiposConvenioList == null){
      this.getTiposConvenio();
    }
  }
  getTiposConvenio(){
    let response : any;
    let serviceProvider : string = 'FasTiposConvenio';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    console.log(uriService);
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.get(uriService)
          .subscribe(result => {
            this.fasTiposConvenioList = result;
            this.fasTiposConvenioList = this.fasTiposConvenioList.filter(tipoConvenio=> tipoConvenio.estado=="ACTIVO")
            this._spinnerService.hide(); 
          },
          err  => this.cathException('error_' + err));
      });
  }

  ngAfterViewChecked() {
    this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.fasConveniosForm) { return; }
    this.fasConveniosForm = this.currentForm;
    if (this.fasConveniosForm) {
      this.fasConveniosForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  addFasConvenios() {
    this.active = false;
    setTimeout(() => this.active = true, 0);
  }
  onSubmit() {
    //this.submitted = true;
    this._spinnerService.show();
    if (this.isNewFasConvenios) {
      this.fasConvenios.estado = "REGISTRADO"
      this.fasConvenios.fechaSolicitud = new Date();
      this.fasConvenios.monto = 0;
      this.fasConvenios.saldo = 0;
      this.fasConvenios.mora = 0;
      this.fasConvenios.cuotasPendientes = 0;
      this.fasConvenios.cuotaIntereses = 0;
      this.fasConvenios.cuotaSeguro = 0;
      this.fasConvenios.cuotaAporte = 0;

      let temp = this.fasConvenios.idConvenio;
      this.post(this.fasConvenios);
    } else {
      this.put(this.fasConvenios);
    }
    
    if(this.padre){

      this.padre.close();
    }
  }

  onValueChanged(data?: any) {
    this.modalMessage.disabled = !this.fasConveniosForm.form.valid;
    if (!this.fasConveniosForm) { return; }
    const form = this.fasConveniosForm.form;

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
    let serviceProvider : string = 'FasConvenios';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.post(uriService, request)
          .subscribe(result => {response = result;
                                this.handleResponse(response);

                                let solConvenios = new FasSolConvenios();
                                solConvenios.fasConveniosIdConvenio = response.idConvenio;
                                this.postFasSolConvenio(solConvenios.fasConveniosIdConvenio);
                              },
                       err  => this.cathException('error_' + err)
          );
      });
  }
  postFasSolConvenio(idConvenio: number) {
    this.fasSolConvenios = new FasSolConvenios();
    this.fasSolConvenios.fasAfiliadosCorreo= localStorage.getItem("correo").replace('"', '').replace('"','');
    this.fasSolConvenios.fasConveniosIdConvenio= idConvenio;

    let response : any;
    console.log(this.fasSolConvenios);
    let serviceProvider : string = 'FasSolConvenios';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.post(uriService, this.fasSolConvenios)
          .subscribe(result => {response = result;
                                this.handleResponse(response); },
                       err  => this.cathException('error_' + err)
          );
      });
  }
  put(request: any) {
    let response : any;
    let serviceProvider : string = 'FasConvenios';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    console.log(uriService);
    console.log(JSON.stringify(request));
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
    console.log(response);
  }

  cathException(error: string) {
  	this._spinnerService.hide();
    this.localAlert = new AlertObject('Error on service', 'danger', true, 10000);
    this.generateAlert();
    switch (error) {
      case 'error_401':
        //this.router.navigate(['']);
        break;
      default:
        //this.router.navigate(['']);
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
  cambiarmaximo(id:number){
    this.maximo = this.fasTiposConvenioList.find(tipoconvenio=> tipoconvenio.idTipoConvenio == id).cuotasMaximas;
    this.fasConvenios.numeroCuotas=1;
  }
}