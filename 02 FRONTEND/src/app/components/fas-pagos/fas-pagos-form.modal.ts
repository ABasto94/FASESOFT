import {Component, Input} from '@angular/core';
import {FasPagosFormComponent} from './fas-pagos-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-pagos-form-modal',
  templateUrl: './fas-pagos-form.modal.html'
})
export class FasPagosFormModal {
  @Input() fasPagos;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasPagosFormComponent, "fasPagos", this.fasPagos);
  }
}