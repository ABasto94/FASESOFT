
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasAccesosComponent }    from './fas-accesos.component';
import { FasAccesosListComponent }  from './fas-accesos-list.component';
import { FasAccesosFormComponent }  from './fas-accesos-form.component';
import { FasAccesosFormModal } from './fas-accesos-form.modal';
import { FasAccesosRouting } from '../../core/routes/fas-accesos.routing';

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
    FasAccesosRouting
  ],
  declarations: [
    FasAccesosListComponent,
    FasAccesosFormComponent,
    FasAccesosFormModal,
    FasAccesosComponent
  ],
  entryComponents: [FasAccesosFormModal]
})
export class FasAccesosModule {}