import { Component, OnInit, ViewChild, Input, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasCreditos } from '../../core/domain/fas-creditos.domain';

import { FasCreditosMetadata } from '../../core/domain/fas-creditos.domain';
import { FasCreditosDomain } from '../../core/domain/fas-creditos.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { AdalService } from 'adal-angular4';
import { SpinnerService } from '../../core/util/spinner/spinner.service'
import { NotificationService } from "../../shared/utils/notification.service";
import { FasAfiliados } from 'app/core/domain/fas-afiliados.domain';
import { FasTiposDeCredito } from 'app/core/domain/fas-tipos-de-credito.domain';
import { FasCreditosServiceService } from './fas-creditos-service.service';


@Component({
  selector: 'fas-cambiar-tasa',
  templateUrl: './fas-cambiar-tasa.html',
 // styleUrls: ['./estilos-creditos.css'],
  providers: [UriProvider, GenericClientService],
  
})
export class FasCambiarTasaComponent implements OnInit {
  @Input() fasCreditos: FasCreditos;
  @Output('respuesta') CreacionCredito = new EventEmitter();
  @ViewChild('fasCreditosForm') currentForm: NgForm;
  private sub: any;
  private fasCreditosDomain = new FasCreditosDomain();
  private isNewFasCreditos: boolean = false;
  
  private metadata: FasCreditosMetadata = new FasCreditosDomain().getFasCreditosMetadata();
  private formErrors: any = this.fasCreditosDomain.getFormErrors();
  private validationMessages: any = this.fasCreditosDomain.getValidationMessages();
  public fasAfiliadoInfo: FasAfiliados[];
  private fasTiposDeCreditoList: FasTiposDeCredito[];
  private fasCreditosList : FasCreditos[];




  @Input() padre: any;

  submitted = false;
  active = true;
  fasCreditosForm: NgForm;
  private localAlert: AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage: ConfirmationModalOptions
    = new ConfirmationModalOptions('Cambio tasa',
      '¿Seguro desea la tasa del crédito?',
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
     
    });
    if (this.fasCreditos == null) {
      this.fasCreditos = new FasCreditos();
      this.isNewFasCreditos = true;

    }
   
    
    this.fasCreditos.idCredito=43;

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
  generateAlert() {
    this.notificationService.smallBox({
      title: "Mensaje",
      content: this.localAlert.message,
      color: this.localAlert.resolveColor(),
      timeout: this.localAlert.lifetime,
      icon: this.localAlert.resolveIcon()
    });
  }
  prueba(){
      console.log("que pasa");
      
  }
  getFasCreditosList() {
    
    let serviceProvider: string = "FasCreditos";
    let uriService = this.uriProvider.getUri(
      new UriControl(serviceProvider, null, null)
    );
    console.log(uriService);
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.get(uriService)
          .subscribe(result => {
            this.fasCreditosList = result;
          },
                       err  => this.cathException('error_' + err)
          );
      });
   }
}
