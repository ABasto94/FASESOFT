
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasAhorrosFormModal } from './fas-ahorros-form.modal';

import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";
import { FasComiteRouting } from 'app/core/routes/fas-comite';
import { FasSolDesafiliacionComponent } from './fas-sol-desafiliacion';
import { FasCreditosSolicitudesComponent } from '../fas-creditos-solicitudes/fas-creditos-solicitudes.component';
import { FasAprobacionAfiliadosComponent } from './fas-aprobacion-afiliados';

@NgModule({
  imports: [
    SmartadminInputModule,
    SmartadminDatatableModule,
    SmartadminModule,
    CommonModule,
    FormsModule,
    UtilModule,
    FasComiteRouting
  ],
  declarations: [
    FasSolDesafiliacionComponent,
    FasCreditosSolicitudesComponent,
    FasAprobacionAfiliadosComponent
  ],
  entryComponents: []
})
export class FasComiteModulo {}