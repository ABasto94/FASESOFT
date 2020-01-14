import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasAhorros } from '../../core/domain/fas-ahorros.domain';
import { FasAhorrosMetadata } from '../../core/domain/fas-ahorros.domain';
import { FasAhorrosDomain } from '../../core/domain/fas-ahorros.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule } from "ngx-bootstrap";
import { NotificationService } from "../../shared/utils/notification.service";
import { DatePipe } from '@angular/common';
import { FasAfiliados } from 'app/core/domain/fas-afiliados.domain';

@Component({
  selector: 'fas-ahorros-voluntarios-pendientes',
  templateUrl: './fas-ahorros-voluntarios-pendientes.html',
  providers: [UriProvider, GenericClientService, DatePipe],
  styleUrls: ["./fas-ahorros-solicitud-pendiente.css"]
})


export class FasAhorrosVoluntariosPendientes implements OnInit {

  private sub: any;
  private ahorrosVoluntarios: FasAhorros[];
  private afiliadoAhorros: FasAfiliados[];
  private ahorroAfiliadoSeleccionado: FasAhorros;
  private habilitar :boolean = false;
  
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private _spinnerService: SpinnerService,
    private notificationService: NotificationService,
    private datePipe: DatePipe
  ) {
  }

  ngOnInit(): void {
    this.getSolicitudesVoluntariasPendientes();
  }

  getSolicitudesVoluntariasPendientes() {
    let uriService = this.uriProvider.getUri(new UriControl(`AhorrosVoluntariosPendientes`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.get(`${uriService}`)
        .subscribe(result => {
          this.ahorrosVoluntarios = result;
        }
        );
    });
  }

  getAfiliadoPorCorreo(correoAfiliado: string) {
    let uriService = this.uriProvider.getUri(new UriControl(`AfiliadoUsuarioAhorrosVoluntarios`, null, null));
    this.sub = this.route.params.subscribe(params => {
      this.genericClientService.get(`${uriService}?correo=${correoAfiliado}`)
        .subscribe(result => {
          for (let index = 0; index < result.length; index++) {
            this.afiliadoAhorros= result[index];            
          }                    
          this.habilitar = !this.habilitar;
        }
        );
    });
  }
  
  ahorroSeleccionado(i) {
    this.getAfiliadoPorCorreo(this.ahorrosVoluntarios[i].fasAfiliadosCorreo);
    this.ahorroAfiliadoSeleccionado = this.ahorrosVoluntarios[i];
  }
  volverClicked(){
    this.habilitar=!this.habilitar;
    window.scroll(0,0);
  }
}