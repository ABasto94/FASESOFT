import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BarraHomeComponent } from './barra-home/barra-home.component';
import { QuienesSomosComponent } from './quienes-somos/quienes-somos.component';
import { CreditosComponent } from './creditos/creditos.component';
import { AhorrosComponent } from './ahorros/ahorros.component';
import { ConveniosComponent } from './convenios/convenios.component';
import { ComiteComponent } from './comite/comite.component';
import { AdalGuard } from 'adal-angular4';

const routes: Routes = [
{
  path: 'home',
  component: BarraHomeComponent,
  children: [
    {
      path: 'quienes-somos',
      component: QuienesSomosComponent
    },
    {
      path: 'creditos',
      component: CreditosComponent
    },
    {
      path: 'ahorros',
      component: AhorrosComponent
    },
    {
      path: 'convenios',
      component: ConveniosComponent
    },
    {
      path: 'comite',
      component: ComiteComponent
    }
  ]
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InformacionRoutingModule { }
