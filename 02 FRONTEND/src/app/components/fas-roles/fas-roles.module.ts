
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasRolesComponent }    from './fas-roles.component';
import { FasRolesListComponent }  from './fas-roles-list.component';
import { FasRolesFormComponent }  from './fas-roles-form.component';
import { FasRolesFormModal } from './fas-roles-form.modal';
import { FasRolesRouting } from '../../core/routes/fas-roles.routing';

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
    FasRolesRouting
  ],
  declarations: [
    FasRolesListComponent,
    FasRolesFormComponent,
    FasRolesFormModal,
    FasRolesComponent
  ],
  entryComponents: [FasRolesFormModal]
})
export class FasRolesModule {}