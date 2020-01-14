
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasAhorrosComponent }    from './fas-ahorros.component';
import { FasAhorrosListComponent }  from './fas-ahorros-list.component';
import { FasAhorrosFormComponent }  from './fas-ahorros-form.component';
import { FasAhorrosFormModal } from './fas-ahorros-form.modal';
import { FasAhorrosRouting } from '../../core/routes/fas-ahorros.routing';

import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";
import { FasAhorrosVoluntariosPendientes } from './fas-ahorros-voluntarios-pendientes';
import { FasCambiarAhorrosFormComponent } from 'app/components/fas-ahorros/fas-cambio-ahorro-form.component';


@NgModule({
  imports: [
    SmartadminInputModule,
    SmartadminDatatableModule,
    SmartadminModule,
    CommonModule,
    FormsModule,
    UtilModule,
    FasAhorrosRouting
  ],
  declarations: [
    FasAhorrosListComponent,
    FasAhorrosFormComponent,
    FasCambiarAhorrosFormComponent,
    FasAhorrosFormModal,
    FasAhorrosComponent,
    FasAhorrosVoluntariosPendientes
  ],
  entryComponents: [FasAhorrosFormModal]
})
export class FasAhorrosModule {}