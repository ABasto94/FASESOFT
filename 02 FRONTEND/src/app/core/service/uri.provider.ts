import { Injectable } from '@angular/core';
import { UriControl } from '../domain/generic.domain';
import { AppSettings } from '../../app.settings';

@Injectable()
export class UriProvider {
  private host: string = AppSettings.API_ENDPOINT;

  getUri(control: UriControl): string {
    let provider = this.getProvider(control.serviceProvider);
    let uri = this.host + provider;
    if (control.pathParameters != null) {
      let path = this.getPathParams(control.pathParameters);
      uri = uri + path;
    }
    if (control.queryParameters != null) {
      let query = this.getQueryParams(control.queryParameters);
      uri = uri + query;
    }
    return uri;
  }

  private getProvider(serviceProvider: string): string {
    switch (serviceProvider) {
      case 'FasAccesos':
        return 'servicios/fasaccesos';
      case 'FasAfiliadosUsuario':
        return 'servicios/fasafiliados/afiliadosUsuarios';
      case 'FasAfiliados':
        return 'servicios/fasafiliados';
      case 'FasAhorros':
        return 'servicios/fasahorros';
      case 'AhorrosVoluntariosPendientes':
        return 'servicios/fasahorros/solicitudesVoluntarioPendientes';
        case 'AfiliadoUsuarioAhorrosVoluntarios':
          return 'servicios/fasafiliados/ahorroAfiliado';
      case 'FasAhorrosCrearNuevoAporte':
        return 'servicios/fasahorros/crearnuevoaporte';
      case 'FasAhorrosAportes':
        return 'servicios/fasahorros/actualizaraportespermanentes';
      case 'FasAportes':
        return 'servicios/fasaportes';
      case 'FasConvenios':
        return 'servicios/fasconvenios';
      case 'FasTiposConvenio':
        return 'servicios/fastiposconvenio';
      case 'FasCreditos':
        return 'servicios/fascreditos';
      case 'FasCreditosSolicitudes':
        return 'servicios/fascreditos/c';
      case 'FasPagos':
        return 'servicios/faspagos';
      case 'FasPerfiles':
        return 'servicios/fasperfiles';
      case 'FasPermisos':
        return 'servicios/faspermisos';
      case 'FasRoles':
        return 'servicios/fasroles';
      case 'FasExtractos':
        return 'servicios/fasextractos';
      case 'FasSolConvenios':
        return 'servicios/fassolconvenios';
      case 'UsuariosSearch':
        return 'servicios/fasusuarios/afiliadoPorCorreo';
      case 'FasTiposDeCredito':
        return 'servicios/fastiposdecredito';
      case 'AfiliadoID':
        return 'servicios/fasafiliados/datos';
      case 'Historial':
        return 'servicios/fascreditos/historial';
      case 'Datos':
        return 'servicios/datos';
      case 'Extractos':
        return 'servicios/fasextractos/extracto';
      case 'Login':
        return '/Login';
      case 'DetalleUsuarioAres':
        return 'servicios/fasafiliados/detalleUsuarioAres';
      case 'FasParametros':
        return 'servicios/fasParametros';
      case 'GeneracionCsv':
        return 'servicios/fasafiliados/permanente';
      case 'Retiro':
        return 'servicios/fasafiliados/retiro';
      case 'FasExtractosClientes':
        return 'servicios/fasextractos/generacionExtracto';
      case 'FasSolicitudesAfiliacion':
        return 'servicios/fasafiliados/solicitudAfiliacion';
      case 'DetalleUsuario':
        return 'servicios/fasafiliados/detalleUsuario';
      case 'FasUsuario':
        return 'servicios/fasusuarios';
      default:
        return '';
    }
  }

  private getPathParams(pathParams: [number, string][]): string {
    var paramResponse = '';
    for (let param of pathParams) {
      paramResponse = paramResponse + param[1] + '&';
    }
    let urilenght = paramResponse.length;
    return '/' + paramResponse.substring(0, (urilenght - 1));
  }

  private getQueryParams(queryParams: [string, string][]): string {
    var paramResponse = '';
    for (let param of queryParams) {
      paramResponse = paramResponse + param[0] + '=' + param[1] + '&';
    }
    let urilenght = paramResponse.length;
    return '?' + paramResponse.substring(0, (urilenght - 1));
  }

  public encodeURI(uri: string): string {
    return encodeURIComponent(uri);
  }
  public decodeURI(uri: string): string {
    return decodeURIComponent(uri);
  }
}