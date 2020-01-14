import { Field } from './generic.domain';
export class FasHistorialCreditos {
  constructor(

    //Data FAS_TIPOS_DE_CREDITOS
    public descripcion? : string,
    public tipo?: string ,

    //Data FAS_CREDITOS
     
    public fechaSolicitud? : any, 
    public idCredito?: number,
    public tasaReal?: number,
    public monto?: number,
    public saldo?: number,
    public cuotas?: number,
    public mora?: number,
    public estadoCredito?: string,

    // Data FAS_AFILIADOS

    public correo?: string,
    public nombre?: string,
    public apellido?: string,
    public telefono?: number,
    public direccion?: string,
    public tipoId?: string,
    public identificacion?: number,
    public estadoAfiliado?: string,

    // Variable para FRONTEND

    public elegido?:boolean,

  ) { }
}
