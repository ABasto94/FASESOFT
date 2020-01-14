import {Component, Input} from '@angular/core';
import {FasTiposDeCreditoFormComponent} from './fas-tipos-de-credito-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-tipos-de-credito-form-modal',
  templateUrl: './fas-tipos-de-credito-form.modal.html'
})
export class FasTiposDeCreditoFormModal {
  @Input() fasTiposDeCredito;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasTiposDeCreditoFormComponent, "fasTiposDeCredito", this.fasTiposDeCredito);
  }
}