
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasConveniosComponent } from '../../components/fas-convenios/fas-convenios.component';

import { FasConveniosListComponent } from '../../components/fas-convenios/fas-convenios-list.component';
import { FasConveniosFormComponent } from '../../components/fas-convenios/fas-convenios-form.component';
import { FasTiposConvenioListComponent } from 'app/components/fas-convenios/fas-tipos-convenio-list.component';
import { FasTiposConvenioFormComponent } from 'app/components/fas-convenios/fas-tipos-convenio-form.component';
import { ConveniosStepper } from 'app/components/fas-convenios/convenios-stepper.component';
const FasConveniosRoutes: Routes = [
  { path: 'base',  component: FasConveniosComponent },
  { path: 'fas-convenios-list', component: FasConveniosListComponent },
  { path: 'fas-convenios-form', component: FasConveniosFormComponent },
  { path: 'fas-tipos-convenio-list', component: FasTiposConvenioListComponent },
  { path: 'fas-tipos-convenio-form', component: FasTiposConvenioFormComponent },
  { path: 'convenios-stepper', component: ConveniosStepper},
];

export const FasConveniosRouting: ModuleWithProviders = RouterModule.forChild(FasConveniosRoutes);