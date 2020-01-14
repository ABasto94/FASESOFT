
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasTiposDeCreditoComponent }    from './fas-tipos-de-credito.component';
import { FasTiposDeCreditoListComponent }  from './fas-tipos-de-credito-list.component';
import { FasTiposDeCreditoFormComponent }  from './fas-tipos-de-credito-form.component';
import { FasTiposDeCreditoFormModal } from './fas-tipos-de-credito-form.modal';
import { FasTiposDeCreditoRouting } from '../../core/routes/fas-tipos-de-credito.routing';

import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";

@NgModule({
  imports: [
    SmartadminInputModule,
    SmartadminDatatableModule,
    SmartadminModule,
    CommonModule,
    FormsModule,
    UtilModule,
    FasTiposDeCreditoRouting
  ],
  declarations: [
    FasTiposDeCreditoListComponent,
    FasTiposDeCreditoFormComponent,
    FasTiposDeCreditoFormModal,
    FasTiposDeCreditoComponent
  ],
  entryComponents: [FasTiposDeCreditoFormModal]
})
export class FasTiposDeCreditoModule {}