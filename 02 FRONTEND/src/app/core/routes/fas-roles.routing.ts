
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasRolesComponent } from '../../components/fas-roles/fas-roles.component';

import { FasRolesListComponent } from '../../components/fas-roles/fas-roles-list.component';
import { FasRolesFormComponent } from '../../components/fas-roles/fas-roles-form.component';
const FasRolesRoutes: Routes = [
  { path: 'base',  component: FasRolesComponent },
  { path: 'fas-roles-list', component: FasRolesListComponent },
  { path: 'fas-roles-form', component: FasRolesFormComponent }  
];

export const FasRolesRouting: ModuleWithProviders = RouterModule.forChild(FasRolesRoutes);