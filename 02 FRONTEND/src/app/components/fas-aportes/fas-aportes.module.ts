
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasAportesComponent }    from './fas-aportes.component';
import { FasAportesListComponent }  from './fas-aportes-list.component';
import { FasAportesFormComponent }  from './fas-aportes-form.component';
import { FasAportesFormModal } from './fas-aportes-form.modal';
import { FasAportesRouting } from '../../core/routes/fas-aportes.routing';

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
    FasAportesRouting
  ],
  declarations: [
    FasAportesListComponent,
    FasAportesFormComponent,
    FasAportesFormModal,
    FasAportesComponent
  ],
  entryComponents: [FasAportesFormModal]
})
export class FasAportesModule {}