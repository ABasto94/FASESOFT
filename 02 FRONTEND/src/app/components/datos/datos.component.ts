import { Component, OnInit, ViewContainerRef, ComponentFactoryResolver } from '@angular/core';
import { ViewChild, Pipe } from '@angular/core';
import { AlertObject, UriControl } from '../../core/domain/generic.domain';
import { GenericClientService } from 'app/core/client/generic-client.service';
import { FasGeneracionExtracto } from 'app/core/domain/modelosExtracto/FasGeneracionExtracto';
import { UriProvider } from 'app/core/service/uri.provider';
import { DatosExtractoComponent } from './datosExtracto.component';
import { DatosServiceService } from './datos-service.service';
import { UploadService } from 'app/uploads/share/upload.service';
import { Subscription } from 'rxjs';
import { NotificationService } from 'app/shared/utils/notification.service';
import { SpinnerService } from 'app/core/util/spinner/spinner.service';

@Component({
  selector: 'app-datos',
  templateUrl: './datos.component.html',
  styleUrls: ['./datos.component.css'],
  providers: [UriProvider, GenericClientService]
})

export class DatosComponent implements OnInit {
  aComponentRef;
  extractosGenerados: FasGeneracionExtracto[] = [];
  vari: Subscription;
  seleccionoTodos: boolean = false;
  activarBarraCarga: boolean = false;
  porcentajeBarraCarga: number = 0;

  private localAlert: AlertObject = new AlertObject(null, null, null, 0);
  private fecha: any = null;
  private mes: number;
  private anioActual: number  = new Date().getFullYear();
  private anio: number;
  private mesLetras: String;
  private meses:string[]=['Enero', 'Febrero', 'Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
  private datosExtratos : DatosExtractoComponent;
  selectedItem=false;
  @ViewChild('extractos', { read: ViewContainerRef }) comps: ViewContainerRef;
  contador = 0;
  public constructor(
    private genericClientService: GenericClientService,
    private uriProvider: UriProvider,
    private componentFactoryResolver: ComponentFactoryResolver,
    private datosServiceService: DatosServiceService,
    private upservice: UploadService,
    private notificationService: NotificationService,
    private _spinnerService: SpinnerService,
  ) { }

  ngOnInit(): void {
    // this.obtenerExtractos();
  }

  obtenerMes(mes: number) {
    console.log('este es el mes que llega '+mes);
    
    switch (mes) {
      case 1:
        return 'Enero'; 
      case 2:
        return 'Febrero';
      case 3:
        return 'Marzo';
      case 4:
        return 'Abril';
      case 5:
        return 'Mayo';
      case 6:
        return 'Junio';
      case 7:
        return 'Julio';
      case 8:
        return 'Agosto';
      case 9:
        return 'Septiembre';
      case 10:
        return 'Octubre';
      case 11:
        return 'Noviembre';
      case 12:
        return 'Diciembre';
      default:
        console.log(
         'no encuentra nada');
    }
  }

  

  obtenerExtractos() {
    this.extractosGenerados = undefined;
    this.extractosGenerados = null;
    this.extractosGenerados = [];
    this.seleccionoTodos = false;
    if (this.mes && this.anio) {
      this._spinnerService.show();
      let serviceProvider: string = 'FasExtractosClientes';
      let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
      this.genericClientService.get(`${uriService}/${this.anio}/${this.mes}/${this.obtenerMes(this.mes)}`)
        .subscribe(result => {
          this.selectedItem=false;
          this.extractosGenerados = result;
          for (let index = 0; index < this.extractosGenerados.length; index++) {
            this.extractosGenerados[index].seleccionado = null;
          }
          this._spinnerService.hide();
        },error=>{
          this._spinnerService.hide();
        }
        )
    }else{
      this.localAlert = new AlertObject('Seleccione una fecha por favor', 'warning', true, 10000);
      this.generateAlert();
    }
  }

  seleccionarTodos(evento) {

    if (evento == true) {
        for (let index = 0; index < this.extractosGenerados.length; index++) {
          this.extractosGenerados[index].seleccionado = true;
        }
    } else if(evento == false){
      for (let index = 0; index < this.extractosGenerados.length; index++) {
        this.extractosGenerados[index].seleccionado = false;
      }
    }
  }
  EnviarExtractos() {
    let extractosParaGenerar = this.extractosGenerados.filter(extracto => extracto.seleccionado == true);
    if (extractosParaGenerar.length <= 0) {
      this.localAlert = new AlertObject('Seleccione al menos un elemento de la tabla', 'warning', true, 10000);
      this.generateAlert();
      return;
    }
    this.activarBarraCarga = true;
    this.cargarComponente(extractosParaGenerar[0]);
    this.datosServiceService.terminoProceso.subscribe(respuesta => {
      this.contador++;
      this.porcentajeBarraCarga = ((this.contador * 100) / extractosParaGenerar.length);
      this.aComponentRef.destroy();
      if (this.contador < extractosParaGenerar.length) {
        this.cargarComponente(extractosParaGenerar[this.contador]);
      } else {
        this.limpiarVariables();
      }
    });
  }
  limpiarVariables() {
    this.activarBarraCarga = false;
    this.contador = 0;
    this.porcentajeBarraCarga = 0;
    this.extractosGenerados = this.extractosGenerados.splice(0,this.extractosGenerados.length)
    this.localAlert = new AlertObject('Se generaron los extractos exitosamente.', 'success', true, 5000);
    this.generateAlert();
    this.obtenerExtractos();
  }
  cargarComponente(result) {
    this.comps.clear();
    let aComponentFactory = this.componentFactoryResolver.resolveComponentFactory(DatosExtractoComponent);
    this.aComponentRef = this.comps.createComponent(aComponentFactory);
    this.aComponentRef.instance.extracto = result;
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
  crearAños(){

  }

}


