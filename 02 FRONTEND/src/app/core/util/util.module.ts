import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { GenericSearchComponent } from './search/generic-search.component';
import { ConfirmationModal } from './modal/confirmation-modal';
import {ModalModule} from "ngx-bootstrap";


/**
  * @author      gbuchely@asesoftware.com
  * @description Descriptions about component here ... 
  */
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ModalModule.forRoot()
  ],
  declarations: [
    GenericSearchComponent,
    ConfirmationModal,
  ],
  exports: [
    GenericSearchComponent,
    ConfirmationModal,
  ]
})
export class UtilModule {}