import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasCreditoAfiliado, FasCreditoAfiliadoMetadata, FasCreditoAfiliadoDomain } from '../../core/domain/fas-creditos-solicitudes.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import { FasAfiliados } from 'app/core/domain/fas-afiliados.domain';


@Component({
    selector: 'fas-sol-desafiliacion',
    templateUrl: './fas-sol-desafiliacion.html',
    providers:  [UriProvider, GenericClientService]
  })
  export class FasSolDesafiliacionComponent implements OnInit {
    private inicial: Date;
    private final: Date;
    private fasAfiliado: FasAfiliados[];
    sub: any;
    private selectedFasAfiliados: FasAfiliados;
    private localAlert : AlertObject = new AlertObject(null, null, null, 0);
    constructor(
      private router: Router,
      private route: ActivatedRoute,
      private uriProvider: UriProvider,
      private genericClientService: GenericClientService,
      private _spinnerService: SpinnerService,
      private notificationService: NotificationService
      ) {
    }
  
    ngOnInit(): void {
      if (this.inicial){
          console.log(this.inicial);
      }
    }
    mostraFecha(){
        console.log(this.inicial)
    }
     getSolicitudesDesafiliacion(){
        let uriService = this.uriProvider.getUri(new UriControl(`Retiro`, null, null));
         this.sub = this.route.params.subscribe(params => {
           this.genericClientService.get(`${uriService}/${this.inicial}/${this.final}`)
             .subscribe(result => {
              this.fasAfiliado = result;
             }
             );
         });
     }

     onSelectedFasAfiliados(fasAfiliados: FasAfiliados){
      this.selectedFasAfiliados = fasAfiliados;
    }
    comparacionFechas(fechaInicial: Date, fechaFinal: Date){
      if (fechaFinal< fechaInicial){
        console.log("Entrooo")
        this.localAlert = new AlertObject('Fecha final debe ser mayor a la inicial', 'warning', true, 10000);
        this.generateAlert();
      }
    }
    generateAlert() {
      this.notificationService.smallBox({
        title: "Mensaje",
        content: this.localAlert.message,
        color: this.localAlert.resolveColor() ,
        timeout: this.localAlert.lifetime,
        icon: this.localAlert.resolveIcon()
      });
    }
}

