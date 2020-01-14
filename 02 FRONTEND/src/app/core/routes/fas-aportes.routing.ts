
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasAportesComponent } from '../../components/fas-aportes/fas-aportes.component';

import { FasAportesListComponent } from '../../components/fas-aportes/fas-aportes-list.component';
import { FasAportesFormComponent } from '../../components/fas-aportes/fas-aportes-form.component';
const FasAportesRoutes: Routes = [
  { path: 'base',  component: FasAportesComponent },
  { path: 'fas-aportes-list', component: FasAportesListComponent },
  { path: 'fas-aportes-form', component: FasAportesFormComponent }  
];

export const FasAportesRouting: ModuleWithProviders = RouterModule.forChild(FasAportesRoutes);