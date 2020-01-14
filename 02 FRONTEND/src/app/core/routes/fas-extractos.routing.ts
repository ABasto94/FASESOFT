
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasExtractosComponent } from '../../components/fas-extractos/fas-extractos.component';
import { FasExtractosListComponent } from 'app/components/fas-extractos/fas-extractos-list.component';
import { DatosComponent } from 'app/components/datos/datos.component';

const FasExtractosRoutes: Routes = [
  { path: 'base',  component: FasExtractosComponent },
  { path: 'fas-extractos-list', component: FasExtractosListComponent },
  { path: 'generar-extractos',  component: DatosComponent },
];

export const FasExtractosRouting: ModuleWithProviders = RouterModule.forChild(FasExtractosRoutes);