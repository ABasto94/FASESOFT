
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasPagosComponent } from '../../components/fas-pagos/fas-pagos.component';

import { FasPagosListComponent } from '../../components/fas-pagos/fas-pagos-list.component';
import { FasPagosFormComponent } from '../../components/fas-pagos/fas-pagos-form.component';
const FasPagosRoutes: Routes = [
  { path: 'base',  component: FasPagosComponent },
  { path: 'fas-pagos-list', component: FasPagosListComponent },
  { path: 'fas-pagos-form', component: FasPagosFormComponent }  
];

export const FasPagosRouting: ModuleWithProviders = RouterModule.forChild(FasPagosRoutes);