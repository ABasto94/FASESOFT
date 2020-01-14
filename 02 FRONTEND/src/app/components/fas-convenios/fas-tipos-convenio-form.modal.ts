import {Component, Input} from '@angular/core';
import {FasTiposConvenioFormComponent} from './fas-tipos-convenio-form.component';
import {ModalService} from '../../core/util/modal/modal.service'

@Component({
  selector: 'fas-tipos-convenio-form-modal',
  templateUrl: './fas-tipos-convenio-form.modal.html'
})
export class FasTiposConvenioFormModal {
  @Input() fasTiposConvenio;
  constructor(private modalService: ModalService) {}
  open() {
    const modalRef = this.modalService.show(FasTiposConvenioFormComponent, "fasTiposConvenio", this.fasTiposConvenio);
  }
}