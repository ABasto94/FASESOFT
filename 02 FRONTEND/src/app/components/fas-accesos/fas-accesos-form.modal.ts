import {Component, Input} from '@angular/core';
import {FasAccesosFormComponent} from './fas-accesos-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-accesos-form-modal',
  templateUrl: './fas-accesos-form.modal.html'
})
export class FasAccesosFormModal {
  @Input() fasAccesos;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasAccesosFormComponent, "fasAccesos", this.fasAccesos);
  }
}