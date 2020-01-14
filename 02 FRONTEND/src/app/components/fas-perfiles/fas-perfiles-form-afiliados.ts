import {Component, Input} from '@angular/core';
import {FasPerfilesFormComponent} from './fas-perfiles-form.component';
import {ModalService} from '../../core/util/modal/modal.service'
import { FasPerfilesFormComponentAfiliados } from './fas-perfiles-form-component-afiliados';

@Component({
  selector: 'fas-perfiles-form-afiliados',
  templateUrl: './fas-perfiles-form-afiliados.html'
})
export class FasPerfilesFormAfiliados {
  @Input() fasAfiliados;

  constructor(private modalService: ModalService) {}
  open() {
      const modalRef = this.modalService.show(FasPerfilesFormComponentAfiliados, "fasAfiliados", this.fasAfiliados);
  }
} 