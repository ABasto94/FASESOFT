
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasSolConveniosComponent }    from './fas-sol-convenios.component';
import { FasSolConveniosListComponent }  from './fas-sol-convenios-list.component';
import { FasSolConveniosFormComponent }  from './fas-sol-convenios-form.component';
import { FasSolConveniosFormModal } from './fas-sol-convenios-form.modal';
import { FasSolConveniosRouting } from '../../core/routes/fas-sol-convenios.routing';

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
    FasSolConveniosRouting
  ],
  declarations: [
    FasSolConveniosListComponent,
    FasSolConveniosFormComponent,
    FasSolConveniosFormModal,
    FasSolConveniosComponent
  ],
  entryComponents: [FasSolConveniosFormModal]
})
export class FasSolConveniosModule {}