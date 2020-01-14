
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasConveniosComponent }    from './fas-convenios.component';
import { FasConveniosListComponent }  from './fas-convenios-list.component';
import { FasConveniosFormComponent }  from './fas-convenios-form.component';
import { FasConveniosFormModal } from './fas-convenios-form.modal';
import { FasConveniosRouting } from '../../core/routes/fas-convenios.routing';

import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";
import { FasTiposConvenioListComponent } from './fas-tipos-convenio-list.component';
import { FasTiposConvenioFormComponent } from './fas-tipos-convenio-form.component';
import { FasTiposConvenioFormModal } from './fas-tipos-convenio-form.modal';
import { ConveniosStepper } from './convenios-stepper.component';
import { ConveniosTipoConvenio } from './fas-convenios-tipo-convenio.component';

@NgModule({
  imports: [
    SmartadminInputModule,
    SmartadminDatatableModule,
    SmartadminModule,
    CommonModule,
    FormsModule,
    UtilModule,
    FasConveniosRouting
  ],
  declarations: [
    FasConveniosListComponent,
    FasConveniosFormComponent,
    FasConveniosFormModal,
    FasConveniosComponent,
    FasTiposConvenioListComponent,
    FasTiposConvenioFormComponent,
    FasTiposConvenioFormModal,
    ConveniosStepper,
    ConveniosTipoConvenio,
  ],
  entryComponents: [FasConveniosFormModal]
})
export class FasConveniosModule {}