
import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';
import { UtilModule } from '../../core/util/util.module';

import { FasPerfilesComponent }    from './fas-perfiles.component';
import { FasPerfilesListComponent }  from './fas-perfiles-list.component';
import { FasPerfilesFormComponent }  from './fas-perfiles-form.component';
import { FasPerfilesFormModal } from './fas-perfiles-form.modal';
import { FasPerfilesRouting } from '../../core/routes/fas-perfiles.routing';

import {SmartadminInputModule} from "../../shared/forms/input/smartadmin-input.module";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import {SmartadminModule} from "../../shared/smartadmin.module";
import { FasPerfilesAsignarPerfil } from './fas-perfiles-asignar-perfil';
import { FasAfiliadosFormModalPerfiles } from './fas-afiliados-form-modal-perfiles';
import { FasAfiliadosFormComponentPerfiles } from './fas-afiliados-form-component-perfiles';
import { FasPerfilesAfiliadosList } from './fas-perfiles-afiliados-list';
import { FasPerfilesFormAfiliados } from './fas-perfiles-form-afiliados';
import { FasPerfilesFormComponentAfiliados } from './fas-perfiles-form-component-afiliados';
import { FasGeneracionForm } from './fas-generacion-form-csv';
import { FasPerfilesFormEditModal } from './fas-perfiles-form-edit.modal';
import { FasPerfilesFormEditComponent } from './fas-perfiles-form-edit.component';

@NgModule({
  imports: [
    SmartadminInputModule,
    SmartadminDatatableModule,
    SmartadminModule,
    CommonModule,
    FormsModule,
    UtilModule,
    FasPerfilesRouting
  ],
  declarations: [
    FasPerfilesListComponent,
    FasPerfilesFormComponent,
    FasPerfilesFormModal,
    FasPerfilesComponent,
    FasPerfilesAfiliadosList,
    FasPerfilesFormAfiliados,
    FasPerfilesFormComponentAfiliados,
    FasGeneracionForm,
    FasPerfilesFormEditModal,
    FasPerfilesFormEditComponent
  ],
  entryComponents: [FasPerfilesFormModal]
})
export class FasPerfilesModule {}