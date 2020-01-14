
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasAccesosComponent } from '../../components/fas-accesos/fas-accesos.component';

import { FasAccesosListComponent } from '../../components/fas-accesos/fas-accesos-list.component';
import { FasAccesosFormComponent } from '../../components/fas-accesos/fas-accesos-form.component';
const FasAccesosRoutes: Routes = [
  { path: 'base',  component: FasAccesosComponent },
  { path: 'fas-accesos-list', component: FasAccesosListComponent },
  { path: 'fas-accesos-form', component: FasAccesosFormComponent }  
];

export const FasAccesosRouting: ModuleWithProviders = RouterModule.forChild(FasAccesosRoutes);