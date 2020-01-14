
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasPerfilesComponent } from '../../components/fas-perfiles/fas-perfiles.component';

import { FasPerfilesListComponent } from '../../components/fas-perfiles/fas-perfiles-list.component';
import { FasPerfilesFormComponent } from '../../components/fas-perfiles/fas-perfiles-form.component';
import { FasPerfilesAsignarPerfil } from 'app/components/fas-perfiles/fas-perfiles-asignar-perfil';
import { FasPerfilesAfiliadosList } from 'app/components/fas-perfiles/fas-perfiles-afiliados-list';
import { FasPerfilesFormComponentAfiliados } from 'app/components/fas-perfiles/fas-perfiles-form-component-afiliados';
import { FasGeneracionForm } from 'app/components/fas-perfiles/fas-generacion-form-csv';
import { FasPerfilesFormEditModal } from 'app/components/fas-perfiles/fas-perfiles-form-edit.modal';
import { FasPerfilesFormEditComponent } from 'app/components/fas-perfiles/fas-perfiles-form-edit.component';
const FasPerfilesRoutes: Routes = [
  { path: 'base',  component: FasPerfilesComponent },
  { path: 'fas-perfiles-list', component: FasPerfilesListComponent },
  { path: 'fas-perfiles-form', component: FasPerfilesFormComponent },
  { path: 'fas-perfiles-afiliados-list', component: FasPerfilesAfiliadosList},
  { path: 'fas-perfiles-form-component-afiliados', component: FasPerfilesFormComponentAfiliados},
  { path: 'fas-generacion-form-csv', component: FasGeneracionForm},
  { path: 'fas-perfiles-form-edit-modal', component: FasPerfilesFormEditModal},
  { path: 'fas-perfiles-form-edit', component: FasPerfilesFormEditComponent}
];

export const FasPerfilesRouting: ModuleWithProviders = RouterModule.forChild(FasPerfilesRoutes);