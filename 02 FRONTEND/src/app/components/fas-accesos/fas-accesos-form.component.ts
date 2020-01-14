import { Component, AfterViewChecked, OnInit, ViewChild, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasAccesos } from '../../core/domain/fas-accesos.domain';

import { FasAccesosMetadata } from '../../core/domain/fas-accesos.domain';
import { FasAccesosDomain } from '../../core/domain/fas-accesos.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";

@Component({
  selector: 'fas-accesos-form',
  templateUrl: './fas-accesos-form.component.html',
  providers:  [UriProvider, GenericClientService]
})
export class FasAccesosFormComponent implements AfterViewChecked {
  @Input() fasAccesos : FasAccesos;
  @ViewChild('fasAccesosForm') currentForm: NgForm;
  private sub: any;
  private fasAccesosDomain = new FasAccesosDomain();
  private isNewFasAccesos : boolean = false;
  private metadata : FasAccesosMetadata = new FasAccesosDomain().getFasAccesosMetadata();
  private formErrors : any = this.fasAccesosDomain.getFormErrors();
  private validationMessages : any = this.fasAccesosDomain.getValidationMessages();
  @Input()padre: any;

  submitted = false;
  active = true;
  fasAccesosForm: NgForm;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);
  private modalMessage : ConfirmationModalOptions
    = new ConfirmationModalOptions('Title',
                                    'Esperamos tu confirmación !!!',
                                    'Submit', 'Cancel', null, true, false);
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
    if (this.fasAccesos == null) {
      this.fasAccesos = new FasAccesos();
      this.isNewFasAccesos = true;
    }
  }
  ngAfterViewChecked() {
    this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.fasAccesosForm) { return; }
    this.fasAccesosForm = this.currentForm;
    if (this.fasAccesosForm) {
      this.fasAccesosForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  addFasAccesos() {
    this.active = false;
    setTimeout(() => this.active = true, 0);
  }
  onSubmit() {
    //this.submitted = true;
    this._spinnerService.show();
    if (this.isNewFasAccesos) {
      this.post(this.fasAccesos);
    } else {
      this.put(this.fasAccesos);
    }
    
    if(this.padre){

      this.padre.close();
    }
  }
  onValueChanged(data?: any) {
    this.modalMessage.disabled = !this.fasAccesosForm.form.valid;
    if (!this.fasAccesosForm) { return; }
    const form = this.fasAccesosForm.form;

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
    let serviceProvider : string = 'FasAccesos';
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
    let serviceProvider : string = 'FasAccesos';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
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
}