import { Component, OnInit, ViewChild } from '@angular/core';
import { AdalService } from 'adal-angular4';
import { UriProvider } from 'app/core/service/uri.provider';
import { GenericClientService } from 'app/core/client/generic-client.service';
import { UriControl, AlertObject, ConfirmationModalOptions } from 'app/core/domain/generic.domain';
import { FasAccesos } from 'app/core/domain/fas-accesos.domain';
import { Router } from '@angular/router';
import { FasAfiliados, FasAfiliadosDomain } from 'app/core/domain/fas-afiliados.domain';
import { FormGroup, FormControl, Validators, MaxLengthValidator } from '@angular/forms';
import { NotificationService } from 'app/shared/utils/notification.service';
import { FasUsuarios } from 'app/core/domain/fas-usuarios.domain';
import { FasAhorros } from 'app/core/domain/fas-ahorros.domain';
import { ModalDirective } from 'ngx-bootstrap';
import { FasParametros } from 'app/core/domain/fas-parametros';
import { GraphServiceService } from 'app/graph-service.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  @ViewChild('lgModal') public lgModal: ModalDirective;

  @ViewChild('lgModalObservaciones') public lgModalObservaciones: ModalDirective;

  public showChildModal(): void {
    this.lgModal.show();
  }

  public hideChildModal(): void {
    this.lgModal.hide();
  }
  valorMinimo: Number = 0;
  public validationOptions = {
    rules: {
      nombres: {
        required: true,
      },
      apellidos: {
        required: true
      },
      identificacion: {
        required: true,
      },
      ciudad: {
        required: true,
        maxlength: 15,
      },
      correo: {
        required: true,
        email: true
      },
      celular: {
        required: true,
      },
      direccion: {
        required: true,
      },
      ciudadResidencia: {
        required: true,
        maxlength: 15,
      },
      aporte: {
        required: true,
      },
      cuenta: {
        required: true,
      },
      banco: {
        required: true,
      },
    },

    // Messages for form validation
    messages: {
      nombres: {
        required: 'Ingrese sus nombres'
      },
      apellidos: {
        required: 'Ingrese sus apellidos'
      },
      identificacion: {
        required: 'Ingrese su No de identificación'
      },
      ciudad: {
        required: 'Ingrese la ciudad'
      },
      correo: {
        required: 'Ingrese su correo',
        email: 'Ingrese un correo valido'
      },
      celular: {
        required: 'Ingrese numero de celular'
      },
      direccion: {
        required: 'Ingrese su dirección'
      },
      ciudadResidencia: {
        required: 'Ingrese ciudad'
      },
      aporte: {
        required: 'Ingrese el valor del aporte',
        min: 'valor entre 2% y 10 % del sueldo',
        max: 'valor entre 2% y 10 % del sueldo'
      },
      cuenta: {
        required: 'Ingrese su cuenta de nomina'
      },
      banco: {
        required: 'Ingrese el banco de la cuenta de nomina'
      },

    },
    submitHandler: this.onSubmit
  };
  formularioAfiliado: FormGroup;
  AccesosList: FasAccesos[];
  UsuarioAres = new FasAfiliados();
  usuario: FasUsuarios;
  Deshabilitar: boolean = false;
  MostrarMensaje: boolean = false;
  MostrarMensaje2: boolean = false;
  MostrarMensaje3: boolean = false;
  observacionesRechazo: string = '';
  fechaFinMulta: Date = new Date();
  ocultarFormulario: Boolean = true;

  private localAlert: AlertObject = new AlertObject(null, null, null, 0);

  constructor(
    private adalService: AdalService,
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private router: Router,
    private notificationService: NotificationService,
    private graphServiceService: GraphServiceService,
  ) { }

  ngOnInit() {
    this.formularioAfiliado = new FormGroup({
      nombres: new FormControl({ value: null, disabled: true }, Validators.required),
      apellidos: new FormControl({ value: null, disabled: true }, Validators.required),
      identificacion: new FormControl({ value: null, disabled: true }, Validators.required),
      ciudad: new FormControl('', [Validators.required, Validators.maxLength(15)]),
      correo: new FormControl({ value: null, disabled: true }, [Validators.email, Validators.required]),
      celular: new FormControl('', Validators.required),
      direccion: new FormControl('', Validators.required),
      ciudadResidencia: new FormControl('', [Validators.required, Validators.maxLength(15)]),
      aporte: new FormControl('', Validators.required),
      cuenta: new FormControl({ value: null, disabled: true }, Validators.required),
      banco: new FormControl({ value: null, disabled: true }, [Validators.required, Validators.max(9000000)])
    });
    this.adalService.getUser().subscribe(respuesta => {
      if (this.adalService.userInfo.authenticated) {
        this.getFasAccesos(respuesta.userName);

        this.getParametros();
      }
    }, error => {
      this.router.navigate(['/inicio']);
    });
  }
  getFasAccesos(usuario: string) {
    let serviceProvider: string = 'FasAccesos';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null)) + "/correo?correo=" + usuario;
    this.genericClientService.get(uriService)
      .subscribe(result => {
        if (result.length > 0) {
          this.AccesosList = result;
          localStorage.setItem("accesos", JSON.stringify(this.AccesosList));
          localStorage.setItem("correo", JSON.stringify(usuario));
          this.router.navigate(['/layout']);
        } else {
          this.ocultarFormulario = false;
          this.obtenerUsuarioAres(usuario);
        }
      }
      )
  };

  obtenerUsuarioAres(usuario: String) {
    let serviceProvider: string = 'DetalleUsuarioAres';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null)) + '/' + usuario;
    this.genericClientService.get(uriService)
      .subscribe(result => {
        if (result[0]) {
          this.MostrarMensaje2 = false;
          this.UsuarioAres = result[0];
          this.formularioAfiliado.patchValue(
            {
              nombres: this.UsuarioAres.nombre,
              apellidos: this.UsuarioAres.apellido,
              identificacion: this.UsuarioAres.identificacion,
              ciudad: this.UsuarioAres.ciudad,
              correo: this.UsuarioAres.correo,
              celular: this.UsuarioAres.telefono,
              direccion: this.UsuarioAres.direccion,
              ciudadResidencia: this.UsuarioAres.expedicion,
              aporte: this.UsuarioAres.aporte,
              cuenta: this.UsuarioAres.cuentaBancaria,
              banco: this.UsuarioAres.banco,
            });
          this.obtenerUsuario(usuario);
        } else {
          this.MostrarMensaje2 = true;
        }
      });
  };

  validarFechaRetiro(): boolean {
    this.fechaFinMulta = new Date(this.UsuarioAres.fechaRetiro);
    this.fechaFinMulta.setDate(this.fechaFinMulta.getDate() + 90);
    if (new Date() <= this.fechaFinMulta) {
      this.MostrarMensaje3 = true;
      this.Deshabilitar = true;
      return true;
    } else {
      return false;
    }
  }
  obtenerUsuario(usuario) {
    let serviceProvider: string = 'FasUsuario';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null)) + `?filterBy=fasAfiliadosCorreo%3D${usuario}`;
    this.genericClientService.get(uriService).subscribe(result => {
      console.log(result)
      if (result.length > 0) {
        if (result[0].estado == 'REGISTRADO') {
          this.MostrarMensaje = true;
        } else if (result[0].estado == 'RECHAZADO') {
          this.observacionesRechazo = result[0].motRechazo;
          this.usuario = result[0];
          this.lgModalObservaciones.show();

        } else if (result[0].estado == 'RETIRADO') {
          if (this.validarFechaRetiro() == false) {
            if (result.length > 0) {
              this.usuario = result[0];
            }
          }
        }
      }
    });
  }
  onSubmit() { };
  enviarFormulario(valido: boolean) {
    this.lgModal.hide();
    if (valido) {
      let usuario = new FasAfiliados();
      usuario.correo = this.formularioAfiliado.get('correo').value;
      usuario.nombre = this.formularioAfiliado.get('nombres').value;
      usuario.apellido = this.formularioAfiliado.get('apellidos').value;
      usuario.identificacion = this.formularioAfiliado.get('identificacion').value;
      usuario.ciudad = this.formularioAfiliado.get('ciudad').value;
      usuario.telefono = this.formularioAfiliado.get('celular').value;
      usuario.direccion = this.formularioAfiliado.get('direccion').value;
      usuario.expedicion = this.formularioAfiliado.get('ciudadResidencia').value;
      usuario.cuentaBancaria = this.formularioAfiliado.get('cuenta').value;
      usuario.banco = this.formularioAfiliado.get('banco').value;
      usuario.tipoId = this.UsuarioAres.tipoId;
      this.fasafiliadosPut(usuario)
    }
  }
  fasafiliadosPut(usuario: FasAfiliados) {
    let serviceProvider: string = 'FasAfiliados';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.genericClientService.put(uriService, usuario).subscribe(result => {
      this.crearUsuario(result);
    }, error => {

    })
  }
  crearUsuario(afiliado: FasAfiliados) {
    let usuario: FasUsuarios = new FasUsuarios();
    usuario.fasAfiliadosCorreo = afiliado.correo;
    usuario.estado = "REGISTRADO";
    usuario.fechaCracion = new Date();
    let serviceProvider: string = 'FasUsuario';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    if (this.usuario) {
      usuario.idUsuario = this.usuario.idUsuario;
      console.log("desde el put",usuario)
      this.genericClientService.put(uriService, usuario).subscribe(result => {
        this.crearAhorrro(afiliado);
      });
    } else {
      this.genericClientService.post(uriService, usuario).subscribe(result => {
        this.crearAhorrro(afiliado);
      });
    }
  }
  crearAhorrro(afiliado: FasAfiliados) {
    let ahorro: FasAhorros = new FasAhorros();
    ahorro.fasAfiliadosCorreo = afiliado.correo;
    ahorro.aporte = this.formularioAfiliado.get('aporte').value;
    ahorro.estado = "PENDIENTE";
    ahorro.fasTiposAhoIdTipoAho = 2;
    ahorro.fechaSolicitud = new Date();
    ahorro.monto = 0;
    let serviceProvider: string = 'FasAhorros';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.genericClientService.post(uriService, ahorro).subscribe(result => {
      this.localAlert = new AlertObject('Se ha creado el usuario, por favor esperar la aceptacion de la solicitud.', 'success', true, 5000);
      this.generateAlert();
      this.Deshabilitar = true;
      this.MostrarMensaje = true;
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

  abrirModal(valid: boolean) {
    if (this.formularioAfiliado.get('aporte').value < this.valorMinimo || this.formularioAfiliado.get('aporte').value > 9000000) {
      this.localAlert = new AlertObject('Recuerde que el valor del aporte debe ser entre el 2% y el 10% de su sueldo.', 'danger', true, 5000);
      this.generateAlert();
      return;
    }
    if (valid) {
      this.lgModal.show();
    } else {
      this.localAlert = new AlertObject('Por favor revisar todos los campos.', 'danger', true, 5000);
      this.generateAlert();
    }
  }

  getParametros() {
    let serviceProvider: string = 'FasParametros';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.genericClientService.get(uriService).subscribe(result => {
      let parametros: FasParametros[] = result;
      this.valorMinimo = parseInt(parametros.find(parametro => parametro.codigo == 0).valor, 10)
      localStorage.setItem('parametros', JSON.stringify(parametros))
    });
  }


}
