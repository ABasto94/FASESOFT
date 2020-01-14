
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DatosComponent } from '../../components/datos/datos.component';
import { DatosExtractoComponent } from 'app/components/datos/datosExtracto.component';
const DatosRoutes: Routes = [
  { path: 'base',  component: DatosComponent },
  // { path: 'baseExtractos',  component: DatosExtractoComponent }
];

export const DatosRouting: ModuleWithProviders = RouterModule.forChild(DatosRoutes);