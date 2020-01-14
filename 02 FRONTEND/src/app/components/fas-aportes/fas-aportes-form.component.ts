import { Component, AfterViewChecked, OnInit, ViewChild, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasAportes } from '../../core/domain/fas-aportes.domain';

import { FasAportesMetadata } from '../../core/domain/fas-aportes.domain';
import { FasAportesDomain } from '../../core/domain/fas-aportes.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import { FasAhorros } from 'app/core/domain/fas-ahorros.domain';

@Component({
  selector: 'fas-aportes-form',
  templateUrl: './fas-aportes-form.component.html',
  providers:  [UriProvider, GenericClientService]
})
export class FasAportesFormComponent implements AfterViewChecked {
  @Input() fasAportes : FasAportes;
  @ViewChild('fasAportesForm') currentForm: NgForm;
  private sub: any;
  private fasAportesDomain = new FasAportesDomain();
  private isNewFasAportes : boolean = false;
  private isNewFasAhorros : boolean = false;
  private metadata : FasAportesMetadata = new FasAportesDomain().getFasAportesMetadata();
  private formErrors : any = this.fasAportesDomain.getFormErrors();
  private validationMessages : any = this.fasAportesDomain.getValidationMessages();
  private aporte : any;
  private fasAhorros: FasAhorros;
  @Input()padre: any;

  submitted = false;
  active = true;
  fasAportesForm: NgForm;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage : ConfirmationModalOptions
    = new ConfirmationModalOptions('Title',
                                    'Esperamos tu confirmación !!!',
                                    'Enviar', 'Cancelar', null, true, false);
  
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
    if (this.fasAportes == null) {
      this.fasAportes = new FasAportes();
      this.isNewFasAportes = true;
      this.isNewFasAhorros = true;
    }
    this.obtenerAporte();
    this.fasAhorros.fasAfiliadosCorreo= localStorage.getItem("correo");
  }
  ngAfterViewChecked() {
    this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.fasAportesForm) { return; }
    this.fasAportesForm = this.currentForm;
    if (this.fasAportesForm) {
      this.fasAportesForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  addFasAportes() {
    this.active = false;
    setTimeout(() => this.active = true, 0);
  }
  onSubmit() {
    //this.submitted = true;
    this._spinnerService.show();
    if (this.isNewFasAhorros) {
      this.postAhorros(this.fasAhorros);
    } else {
      this.put(this.fasAportes);
    }

    if(this.padre){

      this.padre.close();
    }
  }
  onValueChanged(data?: any) {
    this.modalMessage.disabled = !this.fasAportesForm.form.valid;
    if (!this.fasAportesForm) { return; }
    const form = this.fasAportesForm.form;

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




  // post(request: any) {
  //   let response : any;
  //   let serviceProvider : string = 'FasAportes';
  //   let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

  //   this.sub = this.route
  //     .params
  //     .subscribe(params => {
  //       this.genericClientService.post(uriService, request)
  //         .subscribe(result => {response = result;
  //                               this.handleResponse(response); },
  //                      err  => this.cathException('error_' + err)
  //         );
  //     });
  // }

  postAhorros(request: any) {
    let response : any;
    let serviceProvider : string = 'FasAhorros';
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

  put(request: any) {
    let response : any;
    let serviceProvider : string = 'FasAportes';
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
  obtenerAporte(){
    let correo = localStorage.getItem("correo");
    correo = correo.replace("\"","");
    correo = correo.replace("\"","");
    let serviceProvider : string = 'FasAhorros';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

       this.genericClientService.get(`${uriService}/aportespermanentes?correo=${correo}`)
          .subscribe(result => {
            console.log(correo);
            
            this.aporte =result[0].aporte;
            // this.fasAportes.aporte=result[0].aporte;
          },err  => this.cathException('error_' + err)
          );

  }
}