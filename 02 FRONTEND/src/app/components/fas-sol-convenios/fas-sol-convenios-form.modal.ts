import {Component, Input} from '@angular/core';
import {FasSolConveniosFormComponent} from './fas-sol-convenios-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-sol-convenios-form-modal',
  templateUrl: './fas-sol-convenios-form.modal.html'
})
export class FasSolConveniosFormModal {
  @Input() fasSolConvenios;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasSolConveniosFormComponent, "fasSolConvenios", this.fasSolConvenios);
  }
}