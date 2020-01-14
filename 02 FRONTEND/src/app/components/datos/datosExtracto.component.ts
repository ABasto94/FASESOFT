import { Component, OnInit, ElementRef, Renderer2, Input } from '@angular/core';
import { ViewChild } from '@angular/core';
import { AlertObject, UriControl } from '../../core/domain/generic.domain';
import * as domtoimage from 'dom-to-image';
import * as saveAs from 'file-saver';
import { FasGeneracionExtracto } from 'app/core/domain/modelosExtracto/FasGeneracionExtracto';
import { GenericClientService } from 'app/core/client/generic-client.service';
import { UriProvider } from 'app/core/service/uri.provider';
import { ActivatedRoute } from '@angular/router';
import { UploadService } from 'app/uploads/share/upload.service';
import { Upload } from 'app/uploads/share/upload';
import { Subject, Subscription } from 'rxjs';
import { DatosServiceService } from './datos-service.service';
import { FasExtractos } from 'app/core/domain/fas-extractos.domain';

@Component({
  selector: 'app-datos-extractos',
  templateUrl: './datosExtracto.component.html',
  styleUrls: ['./datosExtracto.component.css'],
  providers: [UriProvider, GenericClientService]
})

export class DatosExtractoComponent implements OnInit {
  //extracto: FasGeneracionExtracto;

  htmlText: string;
  private sub: any;
  fechaActual = new Date;
  public constructor(
    private genericClientService: GenericClientService,
    private route: ActivatedRoute,
    private uriProvider: UriProvider,
    private upservice: UploadService,
    private datosServiceService: DatosServiceService,
  ) { }
  extracto
  //@Input() extractos: FasGeneracionExtracto[];
  vari: Subscription;

  @ViewChild('formulario') formulario: ElementRef;
  imagensvg: any = null;


  ngOnInit() {
    this.crearSVG();
  }



  crearSVG() {
    domtoimage.toSvg(this.formulario.nativeElement)
      .then(
        (blob) => {
          // se genera el archivo, se recorta el tipo formato de la respuesta de la libreria y se remplaza los simbolos
          let file = new File([blob.slice(33).replace(/%23/g, '#').replace(/%0A/g, '\n')], `${this.extracto.ahorroAfiliado.identificacion}-${this.fechaActual.getMonth() + 1}.svg`, { type: 'image/svg+xml;charset=utf-8' });
          //se llama llaama el currentUpload para la subida del archivo en firebase
          let currentUpload = new Upload(file);
          this.upservice.subirFile(currentUpload);
          //se obtiene la url del archivo firebase
          this.vari = this.upservice.urlRespuesta.subscribe(url => {
            this.guardarFasExtracto(url);
          });
        }
      );
  }
  guardarFasExtracto(url) {
    if (url) {
      // se obtiene la url del servicio
      let serviceProvider: string = 'FasExtractos';
      let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));

      // se crea el fasextracto para enviar al servicio
      let fasExtracto = new FasExtractos();
      fasExtracto.fasAfiliadosCorreo = this.extracto.ahorroAfiliado.correo;
      fasExtracto.fechaExtracto = this.fechaActual;
      fasExtracto.nombreExtracto = this.obtenerMes(this.fechaActual.getMonth());
      fasExtracto.urlExtracto = url;


      //se llama el servicio de guarde del fasextracto
      this.genericClientService.post(uriService, fasExtracto)
        .subscribe(result => {
          //se desuscribe del servicio de aviso
          this.vari.unsubscribe();
          //se envia la notificacion de completa operacion
          this.datosServiceService.terminoProceso.next();
        }, error => {
          this.vari.unsubscribe();
          this.datosServiceService.terminoProceso.next();
        }
        );
    } else {
      this.vari.unsubscribe();
      this.datosServiceService.terminoProceso.next();
     }

  }
  obtenerMes(mes: number) {
    switch (mes) {
      case 0:
        return 'Enero';
      case 1:
        return 'Febrero';
      case 2:
        return 'Marzo';
      case 3:
        return 'Abril';
      case 4:
        return 'Mayo';
      case 5:
        return 'Junio';
      case 6:
        return 'Julio';
      case 7:
        return 'Agosto';
      case 8:
        return 'Septiembre';
      case 9:
        return 'Octubre';
      case 10:
        return 'Noviembre';
      case 11:
        return 'Diciembre';
      default:
        return '';
    }

  }
}







