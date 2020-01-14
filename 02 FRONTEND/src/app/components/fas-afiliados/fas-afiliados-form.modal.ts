import {Component, Input} from '@angular/core';
import {FasAfiliadosFormComponent} from './fas-afiliados-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-afiliados-form-modal',
  templateUrl: './fas-afiliados-form.modal.html'
})
export class FasAfiliadosFormModal {
  @Input() fasAfiliados;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasAfiliadosFormComponent, "fasAfiliados", this.fasAfiliados);
  }
}