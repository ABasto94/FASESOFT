
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasAfiliadosComponent }    from './fas-afiliados.component';
import { FasAfiliadosListComponent }  from './fas-afiliados-list.component';
import { FasAfiliadosFormComponent }  from './fas-afiliados-form.component';
import { FasAfiliadosFormModal } from './fas-afiliados-form.modal';
import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";
import { FasAfiliadosDownloadForm } from './fas-afiliados-download-form';
import { NgxPrintModule } from "ngx-print";
import { FasDesafiliacionComponent } from './fas-desafiliacion-form.component';
import { FasAfiliadosRouting } from 'app/core/routes/fas-afiliados.routing';



@NgModule({
  imports: [
    SmartadminInputModule,
    SmartadminDatatableModule,
    SmartadminModule,
    CommonModule,
    FormsModule,
    UtilModule,
    FasAfiliadosRouting, 
    NgxPrintModule
  ],
  declarations: [
    FasAfiliadosListComponent,
    FasAfiliadosFormComponent,
    FasAfiliadosFormModal,
    FasAfiliadosComponent,
    FasAfiliadosDownloadForm,
    FasDesafiliacionComponent
  ],
  entryComponents: [FasAfiliadosFormModal]
})
export class FasAfiliadosModule {}