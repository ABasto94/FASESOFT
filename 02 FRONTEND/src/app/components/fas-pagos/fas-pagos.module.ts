
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasPagosComponent }    from './fas-pagos.component';
import { FasPagosListComponent }  from './fas-pagos-list.component';
import { FasPagosFormComponent }  from './fas-pagos-form.component';
import { FasPagosFormModal } from './fas-pagos-form.modal';
import { FasPagosRouting } from '../../core/routes/fas-pagos.routing';

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
    FasPagosRouting
  ],
  declarations: [
    FasPagosListComponent,
    FasPagosFormComponent,
    FasPagosFormModal,
    FasPagosComponent
  ],
  entryComponents: [FasPagosFormModal]
})
export class FasPagosModule {}