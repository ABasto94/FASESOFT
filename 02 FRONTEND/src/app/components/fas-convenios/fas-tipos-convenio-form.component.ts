import { Component, AfterViewChecked, OnInit, ViewChild, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';

import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import { FasTiposConvenio, FasTiposConvenioMetadata, FasTiposConvenioDomain } from 'app/core/domain/fas-tipos-convenio.domain';
import { UploadService } from 'app/uploads/share/upload.service';
import { Upload } from 'app/uploads/share/upload';

@Component({
  selector: 'fas-tipos-convenio-form',
  templateUrl: './fas-tipos-convenio-form.component.html',
  providers:  [UriProvider, GenericClientService]
})
export class FasTiposConvenioFormComponent implements AfterViewChecked {
  @Input() fasTiposConvenio : FasTiposConvenio;
  @ViewChild('fasTiposConvenioForm') currentForm: NgForm;
  private sub: any;
  private fasTiposConvenioDomain = new FasTiposConvenioDomain();
  private isNewFasTiposConvenio : boolean = false;
  private metadata : FasTiposConvenioMetadata = new FasTiposConvenioDomain().getFasTiposConvenioMetadata();
  private formErrors : any = this.fasTiposConvenioDomain.getFormErrors();
  private validationMessages : any = this.fasTiposConvenioDomain.getValidationMessages();
  selectedFiles: FileList;
  imagenCargadaUrlAsignada: boolean;
  currentUpload: Upload;
  @Input()padre: any;

  submitted = false;
  active = true;
  fasTiposConvenioForm: NgForm;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage : ConfirmationModalOptions
    = new ConfirmationModalOptions('Confirmación',
                                    '¿Deseas guardar el convenio?',
                                    'Guardar', 'Cancelar', null, true, false);
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private _spinnerService: SpinnerService,
    private genericClientService: GenericClientService,
    private notificationService: NotificationService,
    private upservice : UploadService
    ) {
  }

  ngOnInit(): void {
    this.imagenCargadaUrlAsignada = false;
    if (this.fasTiposConvenio == null) {
      this.fasTiposConvenio = new FasTiposConvenio();
      this.isNewFasTiposConvenio = true;
      this.fasTiposConvenio.cuotasMaximas =36;
      this.fasTiposConvenio.tasa=0.12;
    }
    else{
      this.imagenCargadaUrlAsignada = true;
    }
  }
  ngAfterViewChecked() {
    this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.fasTiposConvenioForm) { return; }
    this.fasTiposConvenioForm = this.currentForm;
    if (this.fasTiposConvenioForm) {
      this.fasTiposConvenioForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
    this.modalMessage.disabled = !this.fasTiposConvenioForm.form.valid || !this.imagenCargadaUrlAsignada
    console.log("FORM CHANGED: ", this.modalMessage.disabled);
  }
  addFasTiposConvenio() {
    this.active = false;
    setTimeout(() => this.active = true, 0);
  }
  onSubmit() {
    //this.submitted = true;
    this._spinnerService.show();
    if (this.isNewFasTiposConvenio) {
      console.log(this.fasTiposConvenio.urlConvenio);
      console.log(this.fasTiposConvenio);
      this.post(this.fasTiposConvenio);
    } else {
      this.put(this.fasTiposConvenio);
    }
    
    if(this.padre){

      this.padre.close();
    }
  }
  onValueChanged(data?: any) {
    if (!this.fasTiposConvenioForm) { return; }
    const form = this.fasTiposConvenioForm.form;

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
    this.modalMessage.disabled = !this.fasTiposConvenioForm.form.valid || !this.imagenCargadaUrlAsignada;
  }
  
  post(request: any) {
    let response : any;
    let serviceProvider : string = 'FasTiposConvenio';
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
    let serviceProvider : string = 'FasTiposConvenio';
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
    this.localAlert = new AlertObject('Operación Exitosa', 'success', true, 10000);
    this.generateAlert();
    console.log(response);
  }

  detectarFiles(event){
    const file: File = event.target.files[0];
    if(file.type === 'image/jpeg' || file.type === 'image/png') {
      this.selectedFiles = event.target.files;
    } else {
      this.modalMessage.disabled = true;
      this.selectedFiles = null;
    }
  }

  uploadFile(){
    let file = this.selectedFiles.item(0);
    this.currentUpload = new Upload(file);
      
    //se llama para la subida del archivo
    this.upservice.subirFile(this.currentUpload);
    //se obtiene la url del archivo
    this.upservice.urlRespuesta.subscribe(url=>{
      console.log(url);
      this.fasTiposConvenio.urlConvenio = url;
      console.log(this.fasTiposConvenio.urlConvenio);
      this.imagenCargadaUrlAsignada = (this.fasTiposConvenio.urlConvenio !== null && 
      this.fasTiposConvenio.urlConvenio !== undefined && this.fasTiposConvenio.urlConvenio.length !== 0);
      this.modalMessage.disabled = !this.fasTiposConvenioForm.form.valid || !this.imagenCargadaUrlAsignada
    });
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
}