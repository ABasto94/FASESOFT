import {Routes, RouterModule} from '@angular/router';
import {MainLayoutComponent} from "./shared/layout/app-layouts/main-layout.component";
import {AuthLayoutComponent} from "./shared/layout/app-layouts/auth-layout.component";
import {ModuleWithProviders} from "@angular/core";
import { BarraHomeComponent } from './informacion/barra-home/barra-home.component';
import { UploadFormsComponent } from './uploads/upload-forms/upload-forms.component';
import { AdalGuard } from 'adal-angular4';
import { AuthGuardAdal } from './core/guards/auth-guard-adal';
import { RegistroComponent } from './registro/registro.component';

export const routes: Routes = [
  {
    path: '', 
    component: RegistroComponent,
    canActivate: [AuthGuardAdal],
    data: {pageTitle: 'Home'},
  },
  {
    path: 'inicio', 
    redirectTo : "/home/quienes-somos", pathMatch :"full",
    data: {pageTitle: 'Home'},
    canActivate: [AdalGuard]
  },
  {
    path: 'firebase', 
    component: UploadFormsComponent,
  },
  {
    path: 'layout',
    component: MainLayoutComponent,
    canActivate: [AuthGuardAdal],
    canActivateChild:[AuthGuardAdal],
    data: {pageTitle: 'Home'},
    children: [
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
      },
      {
        path: '',
        loadChildren: 'app/components/home/home.module#HomeModule',
      },
      {
        path: 'fas-accesos',
        loadChildren: 'app/components/fas-accesos/fas-accesos.module#FasAccesosModule'
      },      {
        path: 'fas-afiliados',
        loadChildren: 'app/components/fas-afiliados/fas-afiliados.module#FasAfiliadosModule'
      },      {
        path: 'fas-ahorros',
        loadChildren: 'app/components/fas-ahorros/fas-ahorros.module#FasAhorrosModule'
      },      {
        path: 'fas-aportes',
        loadChildren: 'app/components/fas-aportes/fas-aportes.module#FasAportesModule'
      },      {
        path: 'fas-convenios',
        loadChildren: 'app/components/fas-convenios/fas-convenios.module#FasConveniosModule'
      },      {
        path: 'fas-creditos',
        loadChildren: 'app/components/fas-creditos/fas-creditos.module#FasCreditosModule'
      },      {
        path: 'fas-pagos',
        loadChildren: 'app/components/fas-pagos/fas-pagos.module#FasPagosModule'
      },      {
        path: 'fas-perfiles',
        loadChildren: 'app/components/fas-perfiles/fas-perfiles.module#FasPerfilesModule'
      },      {
        path: 'fas-permisos',
        loadChildren: 'app/components/fas-permisos/fas-permisos.module#FasPermisosModule'
      },      {
        path: 'fas-roles',
        loadChildren: 'app/components/fas-roles/fas-roles.module#FasRolesModule'
      },      {
        path: 'fas-extractos',
        loadChildren: 'app/components/fas-extractos/fas-extractos.module#FasExtractosModule'
      },      {
        path: 'fas-sol-convenios',
        loadChildren: 'app/components/fas-sol-convenios/fas-sol-convenios.module#FasSolConveniosModule'
      },      {
        path: 'fas-tipos-de-credito',
        loadChildren: 'app/components/fas-tipos-de-credito/fas-tipos-de-credito.module#FasTiposDeCreditoModule'
      }, {
        path: 'datos',
        loadChildren: 'app/components/datos/datos.module#DatosModule'
      } , {
        path: 'fas-comite',
        loadChildren: 'app/components/fas-comite/fas-comite.module#FasComiteModulo'
      }   
    ]
  },

  {path: 'auth', component: AuthLayoutComponent, loadChildren: 'app/+auth/auth.module#AuthModule'},

  {path: '**', redirectTo: 'miscellaneous/error404'}

];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes, {useHash: true});
