
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasPermisosComponent } from '../../components/fas-permisos/fas-permisos.component';

import { FasPermisosListComponent } from '../../components/fas-permisos/fas-permisos-list.component';
import { FasPermisosFormComponent } from '../../components/fas-permisos/fas-permisos-form.component';
const FasPermisosRoutes: Routes = [
  { path: 'base',  component: FasPermisosComponent },
  { path: 'fas-permisos-list', component: FasPermisosListComponent },
  { path: 'fas-permisos-form', component: FasPermisosFormComponent }  
];

export const FasPermisosRouting: ModuleWithProviders = RouterModule.forChild(FasPermisosRoutes);