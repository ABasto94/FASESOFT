import {Component, Input, style} from '@angular/core';
import {FasCreditosFormComponent} from './fas-creditos-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-creditos-form-modal',
  templateUrl: './fas-creditos-form.modal.html',
  styles: [`#myDIV {
    display: none
    }`]
})
export class FasCreditosFormModal {
  @Input() fasCreditos;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasCreditosFormComponent, "fasCreditos", this.fasCreditos);
  }

}