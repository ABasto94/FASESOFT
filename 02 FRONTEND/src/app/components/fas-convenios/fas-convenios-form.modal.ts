import {Component, Input} from '@angular/core';
import {FasConveniosFormComponent} from './fas-convenios-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-convenios-form-modal',
  templateUrl: './fas-convenios-form.modal.html'
})
export class FasConveniosFormModal {
  @Input() fasConvenios;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasConveniosFormComponent, "fasConvenios", this.fasConvenios);
  }
}