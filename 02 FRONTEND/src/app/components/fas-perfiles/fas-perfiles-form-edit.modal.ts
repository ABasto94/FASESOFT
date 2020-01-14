import {Component, Input} from '@angular/core';
import {FasPerfilesFormComponent} from './fas-perfiles-form.component';
import {ModalService} from '../../core/util/modal/modal.service'
import { FasPerfilesFormEditComponent } from './fas-perfiles-form-edit.component';

@Component({
  selector: 'fas-perfiles-form-edit-modal',
  templateUrl: './fas-perfiles-form-edit.modal.html'
})
export class FasPerfilesFormEditModal {
  @Input() fasPerfiles;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasPerfilesFormEditComponent, "fasPerfiles", this.fasPerfiles);
  }
}