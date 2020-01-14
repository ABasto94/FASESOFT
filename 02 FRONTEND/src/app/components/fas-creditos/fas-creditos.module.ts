import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { UtilModule } from "../../core/util/util.module";

import { FasCreditosComponent } from "./fas-creditos.component";
import { FasCreditosListComponent } from "./fas-creditos-list.component";
import { FasCreditosFormComponent } from "./fas-creditos-form.component";
import { FasCreditosFormModal } from "./fas-creditos-form.modal";
import { FasCreditosRouting } from "../../core/routes/fas-creditos.routing";

import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";
import { NgxPrintModule } from "ngx-print";
import { FasCreditosServiceService } from"./fas-creditos-service.service";
import { FasCambiarTasaComponent } from "./fas-cambiar-tasa";


@NgModule({
  imports: [
    SmartadminInputModule,
    SmartadminDatatableModule,
    SmartadminModule,
    CommonModule,
    FormsModule,
    UtilModule,
    FasCreditosRouting,
    NgxPrintModule
  ],
  declarations: [
    FasCreditosListComponent,
    FasCreditosFormComponent,
    FasCreditosFormModal,
    FasCreditosComponent, 
    FasCambiarTasaComponent,
  ],
  providers:[FasCreditosServiceService],
  entryComponents: [FasCreditosFormModal,FasCambiarTasaComponent]
})
export class FasCreditosModule {}
