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
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule } from "ngx-bootstrap";
import { NotificationService } from "../../shared/utils/notification.service";
import { FasAfiliados } from 'app/core/domain/fas-afiliados.domain';
import { FasTiposDeCredito } from 'app/core/domain/fas-tipos-de-credito.domain';
import { messaging } from 'firebase';
import { FirebaseError } from '@firebase/util';
import { FasGeneracionCsv } from 'app/core/domain/fas-generacionCsv';
import * as XLSX from 'xlsx';

@Component({
  selector: 'fas-generacion-form-csv',
  templateUrl: './fas-generacion-form-csv.html',
  providers: [UriProvider, GenericClientService],
  
})
export class FasGeneracionForm implements AfterViewChecked {
  @Input() fasCreditos: FasCreditos;
  @Output('respuesta') CreacionCredito = new EventEmitter();
  @ViewChild('FasGeneracionForm') currentForm: NgForm;
  private sub: any;
  private mes: number;
  private fasCreditosDomain = new FasCreditosDomain();
  private fasGeneracionCsv: FasGeneracionCsv[];
  private anioGeneracio: number;
  private mesGeneracion: number;
  private meses:string[]=['Enero', 'Febrero', 'Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
  private anioActual: number  = new Date().getFullYear();
  private isNewFasCreditos: boolean = false;
  private metadata: FasCreditosMetadata = new FasCreditosDomain().getFasCreditosMetadata();
  private formErrors: any = this.fasCreditosDomain.getFormErrors();
  private validationMessages: any = this.fasCreditosDomain.getValidationMessages();
  public fasAfiliadoInfo: FasAfiliados[];
  private fasTiposDeCreditoList: FasTiposDeCredito[];
  private selectedFasGeneracionCsv: FasGeneracionCsv;
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
    fasHistorial: any[];
  habiliatador: boolean;
 
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
    if (this.fasCreditos == null) {
      this.fasCreditos = new FasCreditos();
      this.isNewFasCreditos = true;
    

    }


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
 
  onSubmit() {
    //this.submitted = true;
    this._spinnerService.show();
    

    if (this.padre) {

      this.padre.close();
    }
    this.currentForm.reset();
    location.reload();
    
    
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


  respuestaGuardado() {
    this.CreacionCredito.emit([]);
  }

  getAfiliadoAporte(){
   
    let uriService = this.uriProvider.getUri(new UriControl(`GeneracionCsv`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.get(`${uriService}/${this.anioGeneracio}/${this.mesGeneracion}`)
        .subscribe(result => {
          this.fasGeneracionCsv = result;
          if(this.fasGeneracionCsv.length>0){
            this.click();
          }
          //this.esconder();
          //console.log(this.fasGeneracionCsv);
        }
        );
    });
}
click(){
  this.habiliatador=true;
}

esconder(){
  var x = document.getElementById("tabla");
  x.style.display="none";
  if (x.style.display==="none"){
    x.style.display="block";
  }
  else{
    x.style.display="none";
  }

  var y = document.getElementById("boton")
  y.style.display="none"
  if (y.style.display==="none"){
    y.style.display="block";
  }
  else{
    y.style.display="none"
  }
}
generarArchivoCsv(){
    const ws: XLSX.WorkSheet= XLSX.utils.json_to_sheet(this.fasGeneracionCsv);
    const wb: XLSX.WorkBook=XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, "Prueba");
    XLSX.writeFile(wb, "incentivo_al_ahorro_" + this.mesGeneracion +".xlsx");
}
onSelectedFasAfiliados(fasGeneracionCsv: FasGeneracionCsv){
  this.selectedFasGeneracionCsv = fasGeneracionCsv;
}
 

}




