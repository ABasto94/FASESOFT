import {Component, Input} from '@angular/core';
import {FasAhorrosFormComponent} from './fas-ahorros-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-ahorros-form-modal',
  templateUrl: './fas-ahorros-form.modal.html'
})
export class FasAhorrosFormModal {
  @Input() fasAhorros;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasAhorrosFormComponent, "fasAhorros", this.fasAhorros);
  }
}