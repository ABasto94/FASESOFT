
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasExtractosComponent }    from './fas-extractos.component';
import { FasExtractosListComponent }  from './fas-extractos-list.component';
import { FasExtractosRouting } from '../../core/routes/fas-extractos.routing';

import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";
import { DatosComponent } from '../datos/datos.component';
import { DatosExtractoComponent } from '../datos/datosExtracto.component';

@NgModule({
  imports: [
    SmartadminInputModule,
    SmartadminDatatableModule,
    SmartadminModule,
    CommonModule,
    FormsModule,
    UtilModule,
    FasExtractosRouting,
    
  ],
  declarations: [
    FasExtractosListComponent,
    FasExtractosComponent,
    DatosComponent,
    DatosExtractoComponent
  ],
  entryComponents: [DatosExtractoComponent],
  providers:[],
})
export class FasExtractosModule {}