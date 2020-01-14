import { Field } from './generic.domain';
export class FasDetalleUsuario {
  constructor(

    // Data FAS_AFILIADOS

    public correo?: string,
    public nombre?: string,
    public apellido?: string,
    public telefono?: number,
    public direccion?: string,
    public tipoId?: string,
    public identificacion?: number,
    public estadoAfiliado?: string,
    public cuentaBancaria?: string,
    public banco?: string,
    public expedicion?: string,
    public ciudad?: string,
    public dependencia?: string,
    public estadoCivil?: string,

    // Data FAS_USUARIOS
    public fechaCracion?: any,

    public estado?: string,
  
    // Data FAS_AHORROS
  
    public aporte?: number

  ) { }
}
