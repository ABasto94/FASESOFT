
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasCreditosComponent } from '../../components/fas-creditos/fas-creditos.component';

import { FasCreditosListComponent } from '../../components/fas-creditos/fas-creditos-list.component';
import { FasCreditosFormComponent } from '../../components/fas-creditos/fas-creditos-form.component';

const FasCreditosRoutes: Routes = [
  { path: 'base',  component: FasCreditosComponent },
  { path: 'fas-creditos-list', component: FasCreditosListComponent },
  { path: 'fas-creditos-form', component: FasCreditosFormComponent }
];

export const FasCreditosRouting: ModuleWithProviders = RouterModule.forChild(FasCreditosRoutes);