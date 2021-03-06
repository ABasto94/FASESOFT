import {Component, Input, OnInit} from '@angular/core';
import {FasPerfilesFormComponent} from './fas-perfiles-form.component';
import {ModalService} from '../../core/util/modal/modal.service'
import { FasAfiliados, FasAfiliadosMetadata, FasAfiliadosDomain } from 'app/core/domain/fas-afiliados.domain';
import { Field, ConfirmationModalOptions, AlertObject, UriControl } from 'app/core/domain/generic.domain';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from 'app/core/service/uri.provider';
import { GenericClientService } from 'app/core/client/generic-client.service';
import { SpinnerService } from 'app/core/util/spinner/spinner.service';
import { NotificationService } from 'app/shared/utils/notification.service';

@Component({
  selector: 'fas-perfiles-afiliados-list',
  templateUrl: './fas-perfiles-afiliados-list.html',
  providers:  [UriProvider, GenericClientService]
})
export class FasPerfilesAfiliadosList implements OnInit{
  private sub: any;
  private fasAfiliadosList : FasAfiliados[];
  private queryParamList: [string, string][] = [['','']];

  private metadata : FasAfiliadosMetadata;
  private fasAfiliadosDomain : FasAfiliadosDomain = new FasAfiliadosDomain();
  private fieldList: Field[];
  private modalDeleteMessage : ConfirmationModalOptions;
  private openGenericSearch : boolean = false;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
	
  private selectedFasAfiliados: FasAfiliados;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private _spinnerService: SpinnerService,
    private notificationService: NotificationService
    ) {
  }

  ngOnInit(): void {
    this.getAfiliadosUsuarios();
  	this.fieldList = this.fasAfiliadosDomain.getSearchListOfFields();
    this.metadata = this.fasAfiliadosDomain.getFasAfiliadosMetadata();
	this.modalDeleteMessage = new ConfirmationModalOptions('Title',
                                   'We are waiting for you confirmation !!!',
                                   'Delete', 'Cancel', 'icon glyphicon glyphicon-trash', false, false);
  }

  advancedSearch() {
   if (this.queryParamList !== null && this.queryParamList.length > 0) {
     if (this.queryParamList.length === 1 && this.queryParamList[0][0].length === 0) {
       this.getFasAfiliadosList(null);
       this.openGenericSearch = true;
     } else {
       this.getFasAfiliadosList(this.queryParamList);
     }
   	 } else {
       this.getFasAfiliadosList(null);
     }
   }
   
   onFasAfiliadosDelete(fasAfiliados : FasAfiliados) {
    let queryParam : Array<[string, string]> = new Array<[string, string]>();
    queryParam.push(['correo', fasAfiliados.correo.toString()]);
    this.deleteFasAfiliados(queryParam);
  }
  
  onSelectedFasAfiliados(fasAfiliados: FasAfiliados){
    this.selectedFasAfiliados = fasAfiliados;
  }
   
   getFasAfiliadosList(queryParamList: [string, string][]) {
   	this._spinnerService.show();
    let serviceProvider : string = 'FasAfiliados';
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
          .subscribe(result => { this._spinnerService.hide(); },
                       err  => this.cathException('error_' + err)
          );
      });
   }

   getAfiliadosUsuarios(){
    
    let uriService = this.uriProvider.getUri(new UriControl(`FasAfiliadosUsuario`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.get(`${uriService}`)
        .subscribe(result => {                    
          this.fasAfiliadosList = result;        
        }
        );
    });
}
   
   deleteFasAfiliados(queryParam: Array<[string, string]>) {
   	this._spinnerService.show();
    let idResult: any = 0;
    let serviceProvider : string = 'FasAfiliados';
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
    this.localAlert = new AlertObject('Successful operation', 'info', true, 10000);
    this.generateAlert();
    this.getFasAfiliadosList(null);
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
  
  getConfirmationResponse($event : [boolean, any]) {
    if ($event[0]) {
      console.log(JSON.stringify($event));
      this.onFasAfiliadosDelete($event[1]);
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
}