
import { NgModule } from '@angular/core';
import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';
import { DatosComponent } from './datos.component';
import { DatosRouting } from 'app/core/routes/datos.routing';
import { DatosExtractoComponent } from './datosExtracto.component';
import { DatosServiceService } from './datos-service.service';

@NgModule({
  declarations: [
    
    
  ],
  imports: [
        SmartadminInputModule,
        SmartadminDatatableModule,
        SmartadminModule,
        CommonModule,
        FormsModule,
        UtilModule,
        DatosRouting,
  ],
  providers: [DatosServiceService],
  bootstrap: []
})
export class DatosModule { }
