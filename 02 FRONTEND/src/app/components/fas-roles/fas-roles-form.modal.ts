import {Component, Input} from '@angular/core';
import {FasRolesFormComponent} from './fas-roles-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-roles-form-modal',
  templateUrl: './fas-roles-form.modal.html'
})
export class FasRolesFormModal {
  @Input() fasRoles;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasRolesFormComponent, "fasRoles", this.fasRoles);
  }
}