import {Component, Input} from '@angular/core';
import {FasPerfilesFormComponent} from './fas-perfiles-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-perfiles-form-modal',
  templateUrl: './fas-perfiles-form.modal.html'
})
export class FasPerfilesFormModal {
  @Input() fasPerfiles;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasPerfilesFormComponent, "fasPerfiles", this.fasPerfiles);
  }
}