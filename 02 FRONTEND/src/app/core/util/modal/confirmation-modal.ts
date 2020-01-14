import { Component, Input, Output, EventEmitter, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ConfirmationModalOptions } from '../../domain/generic.domain';
import { ModalService } from './modal.service';
import {ModalDirective} from "ngx-bootstrap";


/**
  * @author      GeneradorCRUD
  * @description Descriptions about component here ...
  */
@Component({
  selector: 'confirmation-modal',
  templateUrl: './confirmation-modal.html'
})
export class ConfirmationModal {
  @Input('msg') modalOptions: ConfirmationModalOptions;
  @Input('data') data: any;
  @Output('resp') modalResponse = new EventEmitter();
  private responseTuple : [boolean, any] = [false, null];
  constructor() {
 }
 /**
   * @description Descriptions about method here ...
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  @ViewChild('mdModal') modal:ModalDirective;

  open(content) {
  	this.modal.config.animated = true;
    this.modal.config.backdrop = 'static';
    this.modal.config.keyboard = false;
    
    this.modal.show();
  }

  onAccept(){
    this.modal.hide();
    this.modalResponse.emit([true,this.data]);
  }

  onCancel(){
    this.modal.hide();
    this.modalResponse.emit([false,this.data]);
  }
}