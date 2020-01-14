import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasCreditoAfiliado, FasCreditoAfiliadoMetadata, FasCreditoAfiliadoDomain } from '../../core/domain/fas-creditos-solicitudes.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import {ModalService} from '../../core/util/modal/modal.service'
import { FasCreditosFormComponent } from '../fas-creditos/fas-creditos-form.component';
import { FasCambiarTasaComponent } from '../fas-creditos/fas-cambiar-tasa';
import { FasCreditos } from 'app/core/domain/fas-creditos.domain';

@Component({
  selector: 'fas-creditos-solicitudes',
  templateUrl: './fas-creditos-solicitudes.component.html',
  providers:  [UriProvider, GenericClientService]
})
export class FasCreditosSolicitudesComponent implements OnInit {

  private sub: any;
  private fasCreditoAfiliadoList : FasCreditoAfiliado[];
  private queryParamList: [string, string][] = [['','']];

  private metadata2 : FasCreditoAfiliadoMetadata;
  private fasCreditoAfiliadoDomain : FasCreditoAfiliadoDomain = new FasCreditoAfiliadoDomain();
  private fieldList: Field[];
  private fieldList2: Field[];
  private modalDeleteMessage : ConfirmationModalOptions;
  private openGenericSearch : boolean = false;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
	
  private selectedFasCreditoAfiliado: FasCreditoAfiliado;
private fasCreditoAfiliado: FasCreditoAfiliado;
private tasaReal : number;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private _spinnerService: SpinnerService,
    private notificationService: NotificationService,
    private modalService: ModalService
    ) {
  }

  ngOnInit(): void {
  	this.fieldList2 = this.fasCreditoAfiliadoDomain.getSearchListOfFields2();
    this.metadata2 = this.fasCreditoAfiliadoDomain.getFasCreditoAfiliadoMetadata();
	this.getFasCreditoAfiliadoList(null);
	this.modalDeleteMessage = new ConfirmationModalOptions('Title',
                                   'We are waiting for you confirmation !!!',
                                   'Delete', 'Cancel', 'icon glyphicon glyphicon-trash', false, false);
  }

  advancedSearch() {
   if (this.queryParamList !== null && this.queryParamList.length > 0) {
     if (this.queryParamList.length === 1 && this.queryParamList[0][0].length === 0) {
       this.getFasCreditoAfiliadoList(null);
       this.openGenericSearch = true;
     } else {
       this.getFasCreditoAfiliadoList(this.queryParamList);
     }
   	 } else {
       this.getFasCreditoAfiliadoList(null);
     }
   }

  onSelectedFasCreditoAfiliado(fasCreditoAfiliado: FasCreditoAfiliado){
    this.selectedFasCreditoAfiliado = fasCreditoAfiliado;
  }
   
  getFasCreditoAfiliadoList(queryParamList: [string, string][]) {
   	this._spinnerService.show();
    let serviceProvider : string = 'FasCreditosSolicitudes';
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
          .subscribe(result => {this.fasCreditoAfiliadoList = result; this._spinnerService.hide(); },
                       err  => this.cathException('error_' + err)
          );
      });
   }
   
  handleResponse(response : any) {
  	this._spinnerService.hide();
    this.localAlert = new AlertObject('Actuliazación del estado del crédito', 'success', true, 10000);
    this.generateAlert();
    this.getFasCreditoAfiliadoList(null);
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
  onSearchEdit(queryParamList: [string, string][]) {
    console.log(queryParamList);
    this.queryParamList = queryParamList;
  }
  
  ngOnDestroy(): void {
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
  put(request: any) {
    let response: any;
    let serviceProvider: string = 'FasCreditos';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

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
  aceptar(fasCreditoAfiliado: FasCreditoAfiliado){
    let fasCredito = new FasCreditos();
    fasCredito.tasaReal = fasCreditoAfiliado.tasaReal;
    fasCredito.numeroCuotas= fasCreditoAfiliado.cuota;
    fasCredito.fechaSolicitud=fasCreditoAfiliado.fechaSolicitud;
    fasCredito.idCredito=fasCreditoAfiliado.idCredito;
    fasCredito.monto=fasCreditoAfiliado.monto;
    fasCredito.estado= "APROBADO";
    this.put(fasCredito);

  }
  rechazar(fasCreditoAfiliado: FasCreditoAfiliado){
    let fasCredito = new FasCreditos();
    fasCredito.tasaReal = fasCreditoAfiliado.tasaReal;
    fasCredito.numeroCuotas= fasCreditoAfiliado.cuota;
    fasCredito.fechaSolicitud=fasCreditoAfiliado.fechaSolicitud;
    fasCredito.idCredito=fasCreditoAfiliado.idCredito;
    fasCredito.monto=fasCreditoAfiliado.monto;
    fasCredito.estado= "RECHAZADO";
    this.put(fasCredito);
  }
  


  
} 