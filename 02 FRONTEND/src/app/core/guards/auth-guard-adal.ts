import { Injectable } from '@angular/core';
import {
  CanActivate, Router,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  CanActivateChild,
  NavigationExtras,
  CanLoad, Route, ActivatedRoute, Params
} from '@angular/router';
import { AdalService } from 'adal-angular4';

@Injectable()
export class AuthGuardAdal implements CanActivate {
  constructor(private adalService: AdalService,
    private router: Router, private activatedRoute: ActivatedRoute) { }

  canActivate() {
    if (this.adalService.userInfo.authenticated && new Date(this.adalService.userInfo.profile.exp * 1000)) {
      return true;
    } else {
      this.router.navigate(['/inicio']);
      return false;
    }
  }

  canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    let tieneacceso: boolean = false;
    let url: string = state.url;
    let accesos = JSON.parse(localStorage.getItem("accesos"));
    if (this.adalService.userInfo.authenticated && accesos) {
      if (accesos.some(acceso => acceso.componente == url)) {
        tieneacceso = true;
      } else {
        tieneacceso = false;
      }
    } else if (!tieneacceso) {
      this.router.navigate(['']);
      tieneacceso = false;
    }
    return tieneacceso;
  }

  canLoad() {

  }

  checkLoggin() {

  }
}