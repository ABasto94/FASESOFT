import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasAfiliados } from '../../core/domain/fas-afiliados.domain';
import { FasAfiliadosMetadata } from '../../core/domain/fas-afiliados.domain';
import { FasAfiliadosDomain } from '../../core/domain/fas-afiliados.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import { FasDetalleUsuario } from 'app/core/domain/fas-detalle-usuario.domain';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'fas-afiliados-download-form',
  templateUrl: './fas-afiliados-download-form.html',
  providers:  [UriProvider, GenericClientService, DatePipe]
})
export class FasAfiliadosDownloadForm implements OnInit {

  private sub: any;
  private fasAfiliadosList : FasAfiliados[];
  private queryParamList: [string, string][] = [['','']];

  private metadata : FasAfiliadosMetadata;
  private fasAfiliadosDomain : FasAfiliadosDomain = new FasAfiliadosDomain();
  private modalDeleteMessage : ConfirmationModalOptions;
  private openGenericSearch : boolean = false;
  private localAlert : AlertObject = new AlertObject(null, null, null, 0);

  private usuariosDetalles: FasDetalleUsuario[];
  private usuarioDetalle: FasDetalleUsuario;
  prueba: boolean = false;
	  
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private _spinnerService: SpinnerService,
    private notificationService: NotificationService,
    private datepipe: DatePipe,
    ) {
  }

  ngOnInit(): void {
    this.getDetalleUsuario(localStorage.getItem('correo').replace('"', '').replace('"', ''));
  }

  getDetalleUsuario(IdCorreo: String){
      
      let uriService = this.uriProvider.getUri(new UriControl(`DetalleUsuario`, null, null));
      this.sub = this.route.params.subscribe(params => {

        this.genericClientService.get(`${uriService}/${IdCorreo}`)
          .subscribe(result => {    
            this.usuariosDetalles = result;
            for (let index = 0; index < this.usuariosDetalles.length; index++) {
              this.usuarioDetalle = this.usuariosDetalles[index];
            }
          }
          );
      });
  }

  imprimirClicked(){
    this.prueba=!this.prueba;
  }

}