import { Component, OnInit } from '@angular/core';
import { AdalService } from 'adal-angular4';
import { url } from 'inspector';
import { UriControl } from 'app/core/domain/generic.domain';
import { GenericClientService } from 'app/core/client/generic-client.service';
import { UriProvider } from 'app/core/service/uri.provider';
import { FasAccesos } from 'app/core/domain/fas-accesos.domain';
import { Router, ActivatedRoute } from '@angular/router';
import { GraphServiceService } from 'app/graph-service.service';

@Component({
  selector: 'app-barra-home',
  templateUrl: './barra-home.component.html',
  styleUrls: ['./barra-home.component.css'],
  providers: [UriProvider, GenericClientService]
})
export class BarraHomeComponent implements OnInit {
  isOpen = false;
  isDropdownOpen = false;
  seleccion: String = 'quienes-somos';
  token: String;
  AccesosList: FasAccesos[];
  constructor(
    private adalService: AdalService,
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private graphServiceService: GraphServiceService,
  ) { }

  ngOnInit() {
    //this.adalService.handleWindowCallback();
    this.adalService.getUser().subscribe(respuesta => {
      if (this.adalService.userInfo.authenticated) {
        this.getFasAccesos(respuesta.userName);
      }
    }, error => {
      localStorage.clear();
    });
  }

  login() {
    this.adalService.login();
  }

  logout() {
    this.adalService.logOut();
  }

  get authenticated(): boolean {
    return this.adalService.userInfo.authenticated;
  }

  toggleNavbar() {
    this.isOpen = !this.isOpen;
  }

  toggleDropDown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  seleccionOpcionMenu(seleccion: String) {
    this.seleccion = seleccion;
  }

  getFasAccesos(usuario: string) {
    let serviceProvider: string = 'FasAccesos';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null)) + "/correo?correo=" + usuario;
    this.genericClientService.get(uriService)
      .subscribe(result => {
        this.AccesosList = result;
        localStorage.setItem("correo", JSON.stringify(usuario));
        localStorage.setItem("accesos", JSON.stringify(this.AccesosList));
        // this.router.navigate(['/layout']);
      }
      )
  };


  obtenerPhoto() {
    console.log("este ese  el token",this.adalService.userInfo.token);
    this.graphServiceService.getMePhoto().subscribe(result => {
      console.log(result);
    });
  }
}