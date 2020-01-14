import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasConvenios } from '../../core/domain/fas-convenios.domain';
import { FasConveniosMetadata } from '../../core/domain/fas-convenios.domain';
import { FasConveniosDomain } from '../../core/domain/fas-convenios.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import { DatePipe } from '@angular/common';
import { FasTiposConvenio } from 'app/core/domain/fas-tipos-convenio.domain';

@Component({
  selector: 'fas-convenios-list',
  templateUrl: './fas-convenios-list.component.html',
  providers:  [UriProvider, GenericClientService, DatePipe]
})
export class FasConveniosListComponent implements OnInit {
  private tiposConv: Map<number, string> = new Map();
  private sub: any;
  private fasConveniosList : FasConvenios[];
  private fas2: FasConvenios[];
  private temp: string;
  private queryParamList: [string, string][] = [['','']];

  private metadata : FasConveniosMetadata;
  private fasConveniosDomain : FasConveniosDomain = new FasConveniosDomain();
  private fieldList: Field[];
  private modalDeleteMessage : ConfirmationModalOptions;
  private openGenericSearch : boolean = false;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
	
  private selectedFasConvenios: FasConvenios;
  private actual: string[];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private _spinnerService: SpinnerService,
    private notificationService: NotificationService,
    private datepipe: DatePipe,
    ) {}

  ngOnInit(): void {
  	this.fieldList = this.fasConveniosDomain.getSearchListOfFields();
    this.metadata = this.fasConveniosDomain.getFasConveniosMetadata();
    this.getFasConveniosList([["correo", localStorage.getItem("correo").replace('"', '').replace('"','')]]);
	  this.modalDeleteMessage = new ConfirmationModalOptions('Title',
                                    'Estamos Esperando tu Confirmación !!!',
                                    'Eliminar', 'Cancelar', 'icon glyphicon glyphicon-trash', false, false);
  }

  advancedSearch() {
   if (this.queryParamList !== null && this.queryParamList.length > 0) {
     if (this.queryParamList.length === 1 && this.queryParamList[0][0].length === 0) {
       this.getFasConveniosList(null);
       this.openGenericSearch = true;
     } else {
       this.getFasConveniosList(this.queryParamList);
     }
   	 } else {
       this.getFasConveniosList(null);
     }
   }

   procesar(tipo){
    this.tiposConv = tipo;
   }
   onFasConveniosDelete(fasConvenios : FasConvenios) {
    let queryParam : Array<[string, string]> = new Array<[string, string]>();
    queryParam.push(['idConvenio', fasConvenios.idConvenio.toString()]);
    this.deleteFasConvenios(queryParam);
  }
  
  onSelectedFasConvenios(fasConvenios: FasConvenios){
    this.selectedFasConvenios = fasConvenios;
  }
   
   getFasConveniosList(queryParamList: [string, string][]) {
   	this._spinnerService.show();
    let serviceProvider : string = 'FasConvenios';
    let pathParams : Array<[number, string]> = null;
    let queryParams : Array<[string, string]> = new Array<[string, string]>();
    let commonQuery : Array<string> = ["correo","filterBy", "orderBy", "from", "to"];
    if (queryParamList !== null) {
      for (let queryParam of queryParamList) {
        queryParams.push([queryParam[0], this.uriProvider.encodeURI(queryParam[1])]);
        commonQuery = commonQuery.filter(item => item !== queryParam[0]);
      }
    }

    for ( let cq of commonQuery ){
      queryParams.push([cq, this.uriProvider.encodeURI("")]);
    }

    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, [[1, 'misconvenios']], queryParams));
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.get(uriService)
          .subscribe(result => {
            this.fasConveniosList = result; 
            this._spinnerService.hide();
          },
            err  => this.cathException('error_' + err)
          );
      });
   }

   deleteFasConvenios(queryParam: Array<[string, string]>) {
   	this._spinnerService.show();
    let idResult: any = 0;
    let serviceProvider : string = 'FasConvenios';
    let pathParams : Array<[number, string]> = null;
    let queryParams : Array<[string, string]> = new Array<[string, string]>();
    if (queryParam !== null) {
      queryParams = queryParam;
    }
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, pathParams, queryParams));

    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.delete(uriService)
          .subscribe(result => {idResult = result;
                                this.handleResponse(result); },
                       err  => this.cathException('error_' + err)
          );
      });
  }
  
  handleResponse(response : any) {
  	this._spinnerService.hide();
    this.localAlert = new AlertObject('Operación Exitosa', 'info', true, 10000);
    this.generateAlert();
    this.getFasConveniosList(null);
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
  onSearchEdit(queryParamList: [string, string][]) {
    console.log(queryParamList);
    this.queryParamList = queryParamList;
  }
  
  ngOnDestroy(): void {
  }
  
  getConfirmationResponse($event : [boolean, any]) {
    if ($event[0]) {
      console.log(JSON.stringify($event));
      this.onFasConveniosDelete($event[1]);
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

  setActual(idConvenio: string, estado: string){
    this.actual = [];
    this.actual.push(idConvenio);
    this.actual.push(estado);
  }
  
}