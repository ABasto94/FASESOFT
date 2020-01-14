
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasSolConveniosComponent } from '../../components/fas-sol-convenios/fas-sol-convenios.component';

import { FasSolConveniosListComponent } from '../../components/fas-sol-convenios/fas-sol-convenios-list.component';
import { FasSolConveniosFormComponent } from '../../components/fas-sol-convenios/fas-sol-convenios-form.component';
const FasSolConveniosRoutes: Routes = [
  { path: 'base',  component: FasSolConveniosComponent },
  { path: 'fas-sol-convenios-list', component: FasSolConveniosListComponent },
  { path: 'fas-sol-convenios-form', component: FasSolConveniosFormComponent }  
];

export const FasSolConveniosRouting: ModuleWithProviders = RouterModule.forChild(FasSolConveniosRoutes);