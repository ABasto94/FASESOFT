import {Component, Input} from '@angular/core';
import {FasAportesFormComponent} from './fas-aportes-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-aportes-form-modal',
  templateUrl: './fas-aportes-form.modal.html'
})
export class FasAportesFormModal {
  @Input() fasAportes;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasAportesFormComponent, "fasAportes", this.fasAportes);
  }
}