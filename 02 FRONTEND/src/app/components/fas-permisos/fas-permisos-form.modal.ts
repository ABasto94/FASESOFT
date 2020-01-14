import {Component, Input} from '@angular/core';
import {FasPermisosFormComponent} from './fas-permisos-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-permisos-form-modal',
  templateUrl: './fas-permisos-form.modal.html'
})
export class FasPermisosFormModal {
  @Input() fasPermisos;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasPermisosFormComponent, "fasPermisos", this.fasPermisos);
  }
}