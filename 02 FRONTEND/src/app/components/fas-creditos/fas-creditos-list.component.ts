import { Component, OnInit, OnDestroy, Input } from '@angular/core';
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
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import { FasHistorialCreditos } from 'app/core/domain/fas-historial-creditos';
import { DatePipe, CurrencyPipe } from '@angular/common';
import { FasCreditosServiceService } from './fas-creditos-service.service';


@Component({
  selector: 'fas-creditos-list',
  templateUrl: './fas-creditos-list.component.html',
  providers:  [UriProvider, GenericClientService,DatePipe,CurrencyPipe],
  styleUrls: ["./fas-sol-creditos.component.css"]
})
export class FasCreditosListComponent implements OnInit {
  private sub: any;
  private fasCreditosList : FasCreditos[];
  private habilitar = false;
  private fasHistorial : FasHistorialCreditos[];
  private detalleCredito: FasHistorialCreditos;
  private queryParamList: [string, string][] = [['','']];


  private metadata : FasCreditosMetadata;
  private fasCreditosDomain : FasCreditosDomain = new FasCreditosDomain();
  private fieldList: Field[];
  private modalDeleteMessage: ConfirmationModalOptions;
  private openGenericSearch: boolean = false;
  private localAlert: AlertObject = new AlertObject(null, null, null, 0);

  private correo :any;
  private selectedFasCreditos: FasCreditos;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private _spinnerService: SpinnerService,
    private notificationService: NotificationService,
    private datePipe: DatePipe,
    private currency: CurrencyPipe,
    private fasCreditosServiceService: FasCreditosServiceService
    ) {}

  ngOnInit(): void {
    this.fieldList = this.fasCreditosDomain.getSearchListOfFields();
    this.metadata = this.fasCreditosDomain.getFasCreditosMetadata();
    this.correo=localStorage.getItem("correo");
    this.correo=this.correo.replace("\"","");
    this.correo=this.correo.replace("\"","");
  
    
    this.toggleForm()
	  this.modalDeleteMessage = new ConfirmationModalOptions('Title',
                                   'We are waiting for you confirmation !!!',
                                   'Delete', 'Cancel', 'icon glyphicon glyphicon-trash', false, false);
  }


  advancedSearch() {
    if (this.queryParamList !== null && this.queryParamList.length > 0) {
      if (
        this.queryParamList.length === 1 &&
        this.queryParamList[0][0].length === 0
      ) {
        this.getFasCreditosList(null);
        this.openGenericSearch = true;
      } else {
        this.getFasCreditosList(this.queryParamList);
      }
    } else {
      this.getFasCreditosList(null);
    }
  }

  onFasCreditosDelete(fasCreditos: FasCreditos) {
    let queryParam: Array<[string, string]> = new Array<[string, string]>();
    queryParam.push(["idCredito", fasCreditos.idCredito.toString()]);
    this.deleteFasCreditos(queryParam);
  }

  onSelectedFasCreditos(fasCreditos: FasCreditos) {
    this.selectedFasCreditos = fasCreditos;
  }

  getFasCreditosList(queryParamList: [string, string][]) {
    this._spinnerService.show();
    let serviceProvider: string = "FasCreditos";
    let pathParams: Array<[number, string]> = null;
    let queryParams: Array<[string, string]> = new Array<[string, string]>();
    let commonQuery: Array<string> = ["filterBy", "orderBy", "from", "to"];
    if (queryParamList !== null) {
      for (let queryParam of queryParamList) {
        queryParams.push([
          queryParam[0],
          this.uriProvider.encodeURI(queryParam[1])
        ]);
        commonQuery = commonQuery.filter(item => item !== queryParam[0]);
      }
    }

    for (let cq of commonQuery) {
      queryParams.push([cq, this.uriProvider.encodeURI("")]);
    }

    let uriService = this.uriProvider.getUri(
      new UriControl(serviceProvider, pathParams, queryParams)
    );
    console.log(uriService);
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.get(uriService)
          .subscribe(result => {
            this.fasCreditosList = result;
            this._spinnerService.hide(); 
          },
                       err  => this.cathException('error_' + err)
          );
      });
   }
   getHistorialCreditos(IdCorreo: String){
    
    let uriService = this.uriProvider.getUri(new UriControl(`Historial`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.get(`${uriService}/${IdCorreo}`)
        .subscribe(result => {
          this.fasHistorial = result;
        }
        );
    });
}
   
   deleteFasCreditos(queryParam: Array<[string, string]>) {
   	this._spinnerService.show();
    let idResult: any = 0;
    let serviceProvider: string = "FasCreditos";
    let pathParams: Array<[number, string]> = null;
    let queryParams: Array<[string, string]> = new Array<[string, string]>();
    if (queryParam !== null) {
      queryParams = queryParam;
    }
    let uriService = this.uriProvider.getUri(
      new UriControl(serviceProvider, pathParams, queryParams)
    );

    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.delete(uriService).subscribe(
        result => {
          idResult = result;
          this.handleResponse(result);
        },
        err => this.cathException("error_" + err)
      );
    });
  }

  handleResponse(response: any) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject(
      "Successful operation",
      "info",
      true,
      10000
    );
    this.generateAlert();
    this.getFasCreditosList(null);
    console.log(response);
  }

  cathException(error: string) {
    this._spinnerService.hide();
    this.localAlert = new AlertObject(
      "Error on service",
      "danger",
      true,
      10000
    );
    this.generateAlert();
    switch (error) {
      case "error_401":
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

  ngOnDestroy(): void {}

  getConfirmationResponse($event: [boolean, any]) {
    if ($event[0]) {
      console.log(JSON.stringify($event));
      this.onFasCreditosDelete($event[1]);
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
    toggleForm() {
      this.getHistorialCreditos(this.correo);
      this.getFasCreditosList(null);

    var x = document.getElementById("myDIV");
    var y = document.getElementById("myDIVTabla");
    var z = document.getElementById("myDIVBoton");
    var w = document.getElementById("myDIVBotonRegresar");

    if (x.style.display === "none" && y.style.display == "block") {
      

      x.style.display = "block";
      w.style.display = "block";
      y.style.display = "none";
      z.style.display = "none";
    }
    else {
      
      
      x.style.display = "none";
      w.style.display = "none";
      y.style.display = "block";
      z.style.display = "block";
      this.fasCreditosServiceService.limpiar.next();


    }
    // if (x.style.display === "none" ) {
    //   x.style.display = "block";
    // } else {
    //   x.style.display = "none";
    // }
  }

  creditoSeleccionado(i){
    this.fasHistorial[i].elegido = !this.fasHistorial[i].elegido;
    this.habilitar= this.fasHistorial[i].elegido;
    this.detalleCreditoSeleccionado(this.fasHistorial[i]);
  }

  detalleCreditoSeleccionado(seleccionado: FasHistorialCreditos){
    if(seleccionado.elegido == true){
      this.detalleCredito = seleccionado;
    }
  }
  volverClicked(seleccionado: FasHistorialCreditos){
    this.habilitar = !this.habilitar;
    window.scroll(0,0);
    for (let index = 0; index < this.fasHistorial.length; index++) {
      this.fasHistorial[index].elegido=false;
    }
  }
}
