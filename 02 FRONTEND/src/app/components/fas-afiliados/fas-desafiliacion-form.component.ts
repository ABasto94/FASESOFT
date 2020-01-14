import { Component, AfterViewChecked, OnInit, ViewChild, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasAfiliados } from '../../core/domain/fas-afiliados.domain';
import { DatePipe } from '@angular/common'

import { FasAfiliadosMetadata } from '../../core/domain/fas-afiliados.domain';
import { FasAfiliadosDomain } from '../../core/domain/fas-afiliados.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import { FasDesafilicionesCreditos } from 'app/core/domain/fas-desafiliaciones-creditos';
import { FasDesafiliacionesAhorros } from 'app/core/domain/fas-desafiliaciones-ahorros';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'fas-desafiliacion-form',
  templateUrl: './fas-desafiliacion-form.component.html',
  providers:  [UriProvider, GenericClientService, DatePipe]
})
export class FasDesafiliacionComponent implements AfterViewChecked {
  @Input() fasAfiliados : FasAfiliados;
  @ViewChild('fasAfiliadosForm') currentForm: NgForm;
  private sub: any;
  private fasAfiliadosDomain = new FasAfiliadosDomain();
 //private isNewFasAfiliados : boolean = false;
 //private metadata : FasAfiliadosMetadata = new FasAfiliadosDomain().getFasAfiliadosMetadata();
  private formErrors : any = this.fasAfiliadosDomain.getFormErrors();
  private validationMessages : any = this.fasAfiliadosDomain.getValidationMessages();
  private fasDesafiliacionesCreditos: FasDesafilicionesCreditos[];
  private fasDesafiliacionesAhorros: FasDesafiliacionesAhorros[];
  private correo:any;
  private sumaAhorros: number=0;
  private sumaCreditos: number=0;
  private saldoAFavor: number=0;
  private montoNegativo: boolean= false;
  private fecha: Date;
  private fechaParseado: string;


  @Input()padre: any;

  submitted = false;
  active = true;
  fasAfiliadosForm: NgForm;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage : ConfirmationModalOptions
    = new ConfirmationModalOptions('Confirmación',
                                    '¿Seguro desea desafiliarce del fondo? Después de realizar esta acción no podra acceder a esta plataforma y será redirigido al inicio de Fasesoft',
                                    'Desafiliarse', 'Cancelar', null, true, false);
  
 
  
  
  constructor(
    //private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private _spinnerService: SpinnerService,
    private genericClientService: GenericClientService,
    private datepipe: DatePipe,
    private router: Router,
    private notificationService: NotificationService
    ) {
  }

  ngOnInit(): void {
    if (this.fasAfiliados == null) {
      this.fasAfiliados = new FasAfiliados();
    }
    
    this.obtenerAhorros();
  }
  ngAfterViewChecked() {
    this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.fasAfiliadosForm) { return; }
    this.fasAfiliadosForm = this.currentForm;
    if (this.fasAfiliadosForm) {
      this.fasAfiliadosForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  
  onSubmit() {
    //this.submitted = true;
    this._spinnerService.show();
    this.put(0);
    this.putDesafiliaciones(0);
    this.router.navigate([""])
    if(this.padre){

      this.padre.close();
    }
  }
  onValueChanged(data?: any) {
    this.modalMessage.disabled = !this.fasAfiliadosForm.form.valid;
    if (!this.fasAfiliadosForm) { return; }
    const form = this.fasAfiliadosForm.form;

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
  obtenerDeudas(){
    this.correo=localStorage.getItem("correo");
    this.correo=this.correo.replace("\"","");
    this.correo=this.correo.replace("\"","");
    let serviceProvider: string = 'FasAfiliados';

    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
   
    this.genericClientService.get(`${uriService}/datosDeudas?correo=${this.correo}`)
      .subscribe(result => {
        this.fasDesafiliacionesCreditos= result;
        this.calculoSaldoAFavor(this.fasDesafiliacionesAhorros, this.fasDesafiliacionesCreditos);
      
       
      }
      );
  }
  obtenerAhorros(){
    this.correo=localStorage.getItem("correo");
    this.correo=this.correo.replace("\"","");
    this.correo=this.correo.replace("\"","");
    let serviceProvider: string = 'FasAfiliados';

    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
   
    this.genericClientService.get(`${uriService}/datosAhroros?correo=${this.correo}`)
      .subscribe(result => {
        this.fasDesafiliacionesAhorros= result;
        this.obtenerDeudas();
       
      }
      );
  }
  calculoSaldoAFavor(ahorros: FasDesafiliacionesAhorros[], creditos: FasDesafilicionesCreditos[]){
    console.log(ahorros);
    ahorros.forEach(element => {
      this.sumaAhorros+=element.monto;
    });
    creditos.forEach(element => {
      this.sumaCreditos+=element.saldo;
    });
    this.saldoAFavor= this.sumaAhorros- this.sumaCreditos;
    if(this.saldoAFavor<0){
      this.montoNegativo=false;
      this.localAlert = new AlertObject('Su saldo es negativo, por tanto no se permite la desafiliación', 'danger', true, 100000);
      this.generateAlert();
    }
    else{
      this.montoNegativo= true;
      this.modalMessage.disabled= false;
    }
    
  }
  put(request: any) {
    let response : any;
    
    this.correo=localStorage.getItem("correo");
    this.correo=this.correo.replace("\"","");
    this.correo=this.correo.replace("\"","");
    this.fecha= new Date();
    this.fechaParseado=this.datepipe.transform(this.fecha, 'dd/MM/yyyy');
    let serviceProvider : string = 'FasAfiliados';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.put(`${uriService}/actualizarAfiliado?fechaRetiro=${this.fechaParseado}&correo=${this.correo}`,request)
          .subscribe(result => {response = result;
                                this.handleResponse(response); },
                       err  => this.cathException('error_' + err)
          );
      });
  }
  putDesafiliaciones(request: any) {
    let response : any;
    
    this.correo=localStorage.getItem("correo");
    this.correo=this.correo.replace("\"","");
    this.correo=this.correo.replace("\"","");
    let serviceProvider : string = 'FasAfiliados';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.put(`${uriService}/actualizarDesfiliaciones?correo=${this.correo}`,request)
          .subscribe(result => {response = result;
                                this.handleResponse(response); },
                       err  => this.cathException('error_' + err)
          );
      });
  }
  

}