import { Component, OnInit, OnDestroy, Input, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from '../../core/client/generic-client.service';
import { FasCreditoAfiliado, FasCreditoAfiliadoMetadata, FasCreditoAfiliadoDomain } from '../../core/domain/fas-creditos-solicitudes.domain';
import { Field } from '../../core/domain/generic.domain';
import { ConfirmationModalOptions } from '../../core/domain/generic.domain';
import { AlertObject } from '../../core/domain/generic.domain';
import { SpinnerService } from '../../core/util/spinner/spinner.service';
import { ModalModule, ModalDirective } from "ngx-bootstrap";
import { NotificationService } from "../../shared/utils/notification.service";
import { FasAfiliados } from 'app/core/domain/fas-afiliados.domain';
import { FasUsuarios } from 'app/core/domain/fas-usuarios.domain';
import { FasSolicitudAfiliacion } from 'app/core/domain/fas-solicitudes-afiliacion';
import { map } from 'rxjs/operators';


@Component({
  selector: 'fas-aprobacion-afiliados',
  templateUrl: './fas-aprobacion-afiliados.html',
  providers: [UriProvider, GenericClientService]
})
export class FasAprobacionAfiliadosComponent implements OnInit {

  private localAlert: AlertObject = new AlertObject(null, null, null, 0);
  private solicitudesAfiliacion: FasSolicitudAfiliacion[] = [];
  private seleccionoTodos: boolean = false;
  private contador: number = 0;

  @ViewChild('lgModal') public lgModal: ModalDirective;

  public showChildModal(): void {
    this.lgModal.show();
  }

  public hideChildModal(): void {
    this.lgModal.hide();
  }
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
    this.obtenerSolicitudesAfiliacion();
  }

  obtenerSolicitudesAfiliacion() {
    this.solicitudesAfiliacion = [];
    let serviceProvider: string = 'FasSolicitudesAfiliacion';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.genericClientService.get(uriService).subscribe(result => {
      if(result.length==0){
        this.localAlert = new AlertObject(`No hay solicitudes pendientes`, 'info', true, 5000);
        this.generateAlert();
      }else{
      this.solicitudesAfiliacion = result;
      for (let index = 0; index < this.solicitudesAfiliacion.length; index++) {
        this.solicitudesAfiliacion[index].seleccionado = null;
      }
    }
    }, error => {
      this.localAlert = new AlertObject(`Error al obtener las solicitudes`, 'danger', true, 5000);
      this.generateAlert();
    });
  }
  generateAlert() {
    this.notificationService.smallBox({
      title: "Mensaje",
      content: this.localAlert.message,
      color: this.localAlert.resolveColor(),
      timeout: this.localAlert.lifetime,
      icon: this.localAlert.resolveIcon()
    });
  }

  seleccionarTodos(evento) {
    if (evento == true) {
      for (let index = 0; index < this.solicitudesAfiliacion.length; index++) {
        this.solicitudesAfiliacion[index].seleccionado = true;
      }
    } else if (evento == false) {
      for (let index = 0; index < this.solicitudesAfiliacion.length; index++) {
        this.solicitudesAfiliacion[index].seleccionado = false;
      }
    }
  }
  actualizarUsusarioAfiliar() {
    var solicitudesSeleccionados = this.solicitudesAfiliacion.filter(extracto => extracto.seleccionado == true);
    if (solicitudesSeleccionados.length <= 0) {
      this.localAlert = new AlertObject('Seleccione al menos un elemento de la tabla', 'warning', true, 10000);
      this.generateAlert();
      return;
    }
    let serviceProvider: string = 'FasUsuario';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    for (let indice = 0; indice < solicitudesSeleccionados.length; indice++) {
      this._spinnerService.show();
      let usuario = new FasUsuarios;
      usuario.contraseña = solicitudesSeleccionados[indice].contraseña;
      usuario.estado = 'AFILIADO';
      usuario.fasAfiliadosCorreo = solicitudesSeleccionados[indice].correo;
      usuario.fechaCracion = new Date(solicitudesSeleccionados[indice].fechaCreacion);
      usuario.idUsuario = solicitudesSeleccionados[indice].idUsuario;
      this.genericClientService.put(uriService, usuario).subscribe(result => {
        this.contador = this.contador + 1;
        if (this.contador == solicitudesSeleccionados.length) {
          this.limpiarVariables();
        }
      }, error => {
        this.contador = this.contador + 1;
        if (this.contador == solicitudesSeleccionados.length) {
          this.limpiarVariables();
        }
      });
    }
  }
  actualizarUsuarioRechazar(motivoRechazo: string) {
    this.lgModal.hide();
    var solicitudesSeleccionados = this.solicitudesAfiliacion.filter(extracto => extracto.seleccionado == true);
    let serviceProvider: string = 'FasUsuario';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    for (let indice = 0; indice < solicitudesSeleccionados.length; indice++) {
      this._spinnerService.show();
      let usuario = new FasUsuarios;
      usuario.contraseña = solicitudesSeleccionados[indice].contraseña;
      usuario.estado = 'RECHAZADO';
      usuario.fasAfiliadosCorreo = solicitudesSeleccionados[indice].correo;
      usuario.fechaCracion = new Date(solicitudesSeleccionados[indice].fechaCreacion);
      usuario.idUsuario = solicitudesSeleccionados[indice].idUsuario;
      usuario.motRechazo = motivoRechazo;
      this.genericClientService.put(uriService, usuario).subscribe(result => {
        this.contador = this.contador + 1;
        if (this.contador == solicitudesSeleccionados.length) {
          this.limpiarVariables();
        }
      }, error => {
        this.contador = this.contador + 1;
        if (this.contador == solicitudesSeleccionados.length) {
          this.limpiarVariables();
        }
      });
    }
  }

  limpiarVariables() {
    this.contador = 0;
    this.localAlert = new AlertObject(`se actualizaron los usuarios`, 'success', true, 5000);
    this.generateAlert();
    this.obtenerSolicitudesAfiliacion();
    this._spinnerService.hide();
  }

  abrirModalMotivoRechazo(valid: boolean) {
    if (this.solicitudesAfiliacion.filter(extracto => extracto.seleccionado == true).length <= 0) {
      this.localAlert = new AlertObject('Seleccione al menos un elemento de la tabla', 'warning', true, 5000);
      this.generateAlert();
      return;
    }
    this.lgModal.show();
  }
}

