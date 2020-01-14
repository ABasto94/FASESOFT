
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasTiposDeCreditoComponent } from '../../components/fas-tipos-de-credito/fas-tipos-de-credito.component';

import { FasTiposDeCreditoListComponent } from '../../components/fas-tipos-de-credito/fas-tipos-de-credito-list.component';
import { FasTiposDeCreditoFormComponent } from '../../components/fas-tipos-de-credito/fas-tipos-de-credito-form.component';
const FasTiposDeCreditoRoutes: Routes = [
  { path: 'base',  component: FasTiposDeCreditoComponent },
  { path: 'fas-tipos-de-credito-list', component: FasTiposDeCreditoListComponent },
  { path: 'fas-tipos-de-credito-form', component: FasTiposDeCreditoFormComponent }  
];

export const FasTiposDeCreditoRouting: ModuleWithProviders = RouterModule.forChild(FasTiposDeCreditoRoutes);