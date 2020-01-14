import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FasCreditosSolicitudesComponent } from 'app/components/fas-creditos-solicitudes/fas-creditos-solicitudes.component';
import { FasSolDesafiliacionComponent } from 'app/components/fas-comite/fas-sol-desafiliacion';
import { FasAprobacionAfiliadosComponent } from 'app/components/fas-comite/fas-aprobacion-afiliados';

const FasComiteRoutes: Routes = [
    { path: 'fas-sol-desafiliacion', component: FasSolDesafiliacionComponent},
    { path: 'fas-creditos-solicitudes', component: FasCreditosSolicitudesComponent},
    { path: 'fas-aprobacion-afiliacion', component: FasAprobacionAfiliadosComponent},
  ];
  
  export const FasComiteRouting: ModuleWithProviders = RouterModule.forChild(FasComiteRoutes);