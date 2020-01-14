
import { Field } from './generic.domain';

export class Datos {
    constructor(
    public correo: any,
    public nombre: any,
    public apellido: any,
    public telefono: any,
    public direccion: any,
    public identificacion: any,
    public tipo_id: any,
    public fecha_ingreso: any,
    public cuenta_bancaria :    any,
    public total_otros_ahorros  :  any
    // public cuentaBancaria: any;
    // public totalOtrosAhorros: any;
    // public saldoAportes: any;
    // public cuotaAportes: any;
    // public aportesOrdinarios: any;
    // public ahorropermanente: any;
    // public saldoCartera: any;
    // public numeroCreditos: any;
    // public tipoCadaCredito: any;
    // public saldoCarteraCadaCredito: any;
    // public tasaCadaCredito: any;
    // public plazoCadaCredito: any;
    // public moraCadaCredito: any;
    // public fechaSolicitudCadaCredito: any;
    // public fechaDesembolsoCadaCredito: any;
    // public fechaInicioPagoCadaCredito: any;
    // public coutasPendientesCadaCredito: any;
    // public coutaCarteraCadaCredito: any;
    // public valorInteresesCadaCuota: any;
    // public valorSeguroCadaCouta: any;
    // public valorAporteCapitalCadaCuota: any;
    // public saldoAhorros: any;
    // public numeroAhorros: any;
    // public saldoAhorrosdeCadaAhorro: any;
    // public tasaCadaAhorro: any;
    // public coutaAhorroCadaAhorro: any;
    // public fechaSolicitudCadaAhorro: any;
    // public fechaInicioAporteCadaAhorro: any;
    // public saldoServicios: any;
    // public numeroServicios: any;
    // public nombreCadaServicio: any;
    // public saldoServicioCadaServicio: any;
    // public plazoCadaServicio: any;
    // public moraCadacredito: any;
    // public fechaSolicituCadaServicio: any;
    // public fechaInicioCadaServicio: any;
    // public fechaInicioPagoCadaServicio: any;
    // public coutasPendientesCadaServicio: any;
    // public tasaCadaServicio: any;
    // public coutaServicioCadaServicio: any;
    // public valorInteresesCadaCuotaServicio: any;
    // public valorSeguroCadaCuotaServicio: any;
    // public valorAporteCapitalCadaCuotaServicio: any;
    ){}
}

export class DatosMetadata {
  constructor(
    public correo: Field,
    public nombre:  Field,
    public apellido:  Field,
    public telefono:  Field,
    public direccion:  Field,
    public identificacion:  Field,
    public tipoId:  Field,
    public fechaIngreso:  Field,
    public cuentaBancaria :    Field,
    public totalOtrosAhorros  :   Field
    // public cuentaBancaria: any;
    // public totalOtrosAhorros: any;
    // public saldoAportes: any;
    // public cuotaAportes: any;
    // public aportesOrdinarios: any;
    // public ahorropermanente: any;
    // public saldoCartera: any;
    // public numeroCreditos: any;
    // public tipoCadaCredito: any;
    // public saldoCarteraCadaCredito: any;
    // public tasaCadaCredito: any;
    // public plazoCadaCredito: any;
    // public moraCadaCredito: any;
    // public fechaSolicitudCadaCredito: any;
    // public fechaDesembolsoCadaCredito: any;
    // public fechaInicioPagoCadaCredito: any;
    // public coutasPendientesCadaCredito: any;
    // public coutaCarteraCadaCredito: any;
    // public valorInteresesCadaCuota: any;
    // public valorSeguroCadaCouta: any;
    // public valorAporteCapitalCadaCuota: any;
    // public saldoAhorros: any;
    // public numeroAhorros: any;
    // public saldoAhorrosdeCadaAhorro: any;
    // public tasaCadaAhorro: any;
    // public coutaAhorroCadaAhorro: any;
    // public fechaSolicitudCadaAhorro: any;
    // public fechaInicioAporteCadaAhorro: any;
    // public saldoServicios: any;
    // public numeroServicios: any;
    // public nombreCadaServicio: any;
    // public saldoServicioCadaServicio: any;
    // public plazoCadaServicio: any;
    // public moraCadacredito: any;
    // public fechaSolicituCadaServicio: any;
    // public fechaInicioCadaServicio: any;
    // public fechaInicioPagoCadaServicio: any;
    // public coutasPendientesCadaServicio: any;
    // public tasaCadaServicio: any;
    // public coutaServicioCadaServicio: any;
    // public valorInteresesCadaCuotaServicio: any;
    // public valorSeguroCadaCuotaServicio: any;
    // public valorAporteCapitalCadaCuotaServicio: any;
    ){}
}

export class DatosDomain {
  private datosMetadata = new DatosMetadata(
  	  	  new Field('correo','correo','string'), 
	  	  new Field('nombre','nombre','string'), 
	  	  new Field('apellido','apellido','string'), 
	  	  new Field('telefono','telefono','number'), 
	  	  new Field('direccion','direccion','string'), 
	  	  new Field('identificacion','identificacion','number'), 
	  	  new Field('tipoId','tipoId','string'), 
          new Field('fechaIngreso','fechaIngreso','any'), 
	  	  new Field('cuentaBancaria','cuentaBancaria','any'), 
          new Field('totalOtrosAhorros','totalOtrosAhorros','any') 
      );
  getDatosMetadata () : DatosMetadata {
    return this.datosMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.datosMetadata.correo);
  	listOfFields.push(this.datosMetadata.nombre);
  	listOfFields.push(this.datosMetadata.apellido);
  	listOfFields.push(this.datosMetadata.telefono);
  	listOfFields.push(this.datosMetadata.direccion);
  	listOfFields.push(this.datosMetadata.identificacion);
  	listOfFields.push(this.datosMetadata.tipoId);
    listOfFields.push(this.datosMetadata.fechaIngreso);
  	listOfFields.push(this.datosMetadata.cuentaBancaria);
  	listOfFields.push(this.datosMetadata.totalOtrosAhorros);
    return listOfFields;
  }
  
  formErrors = {
  	'correo': '',	
  	'nombre': '',  	'apellido': '',  	'telefono': '',  	'direccion': '',  	'identificacion': '',  	'tipoId': '',  	'fechaIngreso': '',  	'totalOtrosAhorros': '' };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'correo': {
  	  'required': 	'correo es obligatorio',
  	  'maxlength':	'correo no puede exceder 40'
  	},  	'nombre': {
  	  'required': 	'nombre es obligatorio',
  	  'maxlength':	'nombre no puede exceder 20'
  	},  	'apellido': {
  	  'required': 	'apellido es obligatorio',
  	  'maxlength':	'apellido no puede exceder 20'
  	},  	'telefono': {
  	  'required': 	'telefono es obligatorio',
  	  'maxlength':	'telefono no puede exceder 18'
  	},  	'direccion': {
  	  'required': 	'direccion es obligatorio',
  	  'maxlength':	'direccion no puede exceder 30'
  	},  	'identificacion': {
  	  'required': 	'identificacion es obligatorio',
  	  'maxlength':	'identificacion no puede exceder 18'
  	},  	'tipoId': {
  	  'required': 	'tipoId es obligatorio',
  	  'maxlength':	'tipoId no puede exceder 4'
  	},  	'estado': {
  	  'required': 	'estado es obligatorio',
  	  'maxlength':	'estado no puede exceder 20'
  	},  	'fechaRetiro': {
  	  'required': 	'fechaRetiro es obligatorio',
  	  'maxlength':	'fechaRetiro no puede exceder 7'
  	},  	'mora': {
  	  'required': 	'mora es obligatorio',
  	  'maxlength':	'mora no puede exceder 18'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

