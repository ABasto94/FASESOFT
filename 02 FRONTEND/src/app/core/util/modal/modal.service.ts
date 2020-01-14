import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs/Rx';

export interface IModalState {
  show: boolean;
}

@Injectable()
export class ModalService {
  showModal:Subject<any> = new Subject();
  componentInstance:any;
  field:any;
  value:any;

  show(component, field, value){
    this.componentInstance = component;
    this.field = field;
    this.value = value;
    this.showModal.next(this.componentInstance);
    return this;
  }

}