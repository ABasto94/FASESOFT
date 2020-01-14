
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasAfiliadosComponent } from '../../components/fas-afiliados/fas-afiliados.component';
import { FasAfiliadosListComponent } from '../../components/fas-afiliados/fas-afiliados-list.component';
import { FasAfiliadosFormComponent } from '../../components/fas-afiliados/fas-afiliados-form.component';
import { FasDetalleUsuario } from '../domain/fas-detalle-usuario.domain';
import { FasAfiliadosDownloadForm } from 'app/components/fas-afiliados/fas-afiliados-download-form';
import { FasDesafiliacionComponent } from '../../components/fas-afiliados/fas-desafiliacion-form.component';


const FasAfiliadosRoutes: Routes = [
  { path: 'base',  component: FasAfiliadosComponent },
  { path: 'fas-afiliados-list', component: FasAfiliadosListComponent },
  { path: 'fas-afiliados-form', component: FasAfiliadosFormComponent },
  { path: 'fas-afiliados-download-form', component: FasAfiliadosDownloadForm},
  { path: 'fas-desafiliacion-form', component: FasDesafiliacionComponent }
  
];

export const FasAfiliadosRouting: ModuleWithProviders = RouterModule.forChild(FasAfiliadosRoutes);