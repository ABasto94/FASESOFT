
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasPermisosComponent }    from './fas-permisos.component';
import { FasPermisosListComponent }  from './fas-permisos-list.component';
import { FasPermisosFormComponent }  from './fas-permisos-form.component';
import { FasPermisosFormModal } from './fas-permisos-form.modal';
import { FasPermisosRouting } from '../../core/routes/fas-permisos.routing';

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
    FasPermisosRouting
  ],
  declarations: [
    FasPermisosListComponent,
    FasPermisosFormComponent,
    FasPermisosFormModal,
    FasPermisosComponent
  ],
  entryComponents: [FasPermisosFormModal]
})
export class FasPermisosModule {}