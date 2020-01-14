
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasAhorrosComponent } from '../../components/fas-ahorros/fas-ahorros.component';

import { FasAhorrosListComponent } from '../../components/fas-ahorros/fas-ahorros-list.component';
import { FasAhorrosFormComponent } from '../../components/fas-ahorros/fas-ahorros-form.component';
import { FasAhorrosVoluntariosPendientes } from 'app/components/fas-ahorros/fas-ahorros-voluntarios-pendientes';
import { FasCambiarAhorrosFormComponent } from 'app/components/fas-ahorros/fas-cambio-ahorro-form.component';
const FasAhorrosRoutes: Routes = [
  { path: 'base',  component: FasAhorrosComponent },
  { path: 'fas-ahorros-list', component: FasAhorrosListComponent },
  { path: 'fas-ahorros-form', component: FasAhorrosFormComponent },
  { path: 'fas-ahorros-voluntarios-pendientes', component: FasAhorrosVoluntariosPendientes},
  { path: 'fas-cambio-ahorros-form', component: FasCambiarAhorrosFormComponent }

];

export const FasAhorrosRouting: ModuleWithProviders = RouterModule.forChild(FasAhorrosRoutes);