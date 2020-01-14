
import { Field } from './generic.domain';
export class FasConvenios {
  constructor(
    public idConvenio? : number, 
    public saldo?: number,
    public monto? : number, 
    public fechaInicioConvenio? : Date,
    public estado? : string,
    public numeroCuotas? : number,
    public mora? : number,
    public fasTipoConvIdTipoConv?: number,
    public fechaSolicitud?: Date,
    public fechaInicioPago?: Date,
    public cuotasPendientes?: number,
    public cuotaIntereses?: number,
    public cuotaSeguro?: number,
    public cuotaAporte?: number,
    public urlImagen?: string,
    public principal?: number
  ) { }
}

export class FasConveniosMetadata {
  constructor(    
    public idConvenio? : Field, 
    public saldo?: Field,
    public monto? : Field, 
    public fechaInicioConvenio? : Field,
    public estado? : Field,
    public numeroCuotas? : Field,
    public mora? : Field,
    public fasTipoConvIdTipoConv?: Field,
    public fechaSolicitud?: Field,
    public fechaInicioPago?: Field,
    public cuotasPendientes?: Field,
    public cuotaIntereses?: Field,
    public cuotaSeguro?: Field,
    public cuotaAporte?: Field,
    public urlImagen?: Field,
    public principal?: Field
  ) { }
}

export class FasConveniosDomain {
  private fasConveniosMetadata = new FasConveniosMetadata(
          new Field('idConvenio','idConvenio','number'), 
          new Field('saldo','saldo', 'number'),
	  	  new Field('monto','monto','number'),
        new Field('fechaInicioConvenio','fechaInicioConvenio','Date'),
        new Field('estado', 'estado', 'string'),
        new Field('numeroCuotas', 'numeroCuotas', 'number'),
        new Field('mora', 'mora', 'number'),
        new Field('fasTipoConvIdTipoConv', 'fasTipoConvIdTipoConv', 'number'),
        new Field('fechaSolicitud', 'fechaSolicitud', 'Date'),
        new Field('fechaInicioPago', 'fechaInicioPago', 'Date'),
        new Field('cuotasPendientes', 'cuotasPendientes', 'number'),
        new Field('cuotaIntereses', 'cuotaIntereses', 'number'),
        new Field('cuotaSeguro', 'cuotaSeguro', 'number'),
        new Field('cuotaAporte', 'cuotaAporte', 'number'),
        new Field('urlImagen', 'urlImagen', 'string'),
        new Field('principal', 'principal', 'number'),
      );
  getFasConveniosMetadata () : FasConveniosMetadata {
    return this.fasConveniosMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
    listOfFields.push(this.fasConveniosMetadata.idConvenio);
    listOfFields.push(this.fasConveniosMetadata.saldo);
  	listOfFields.push(this.fasConveniosMetadata.monto);
    listOfFields.push(this.fasConveniosMetadata.fechaInicioConvenio);
    listOfFields.push(this.fasConveniosMetadata.estado);
  	listOfFields.push(this.fasConveniosMetadata.numeroCuotas);
  	listOfFields.push(this.fasConveniosMetadata.mora);
  	listOfFields.push(this.fasConveniosMetadata.fasTipoConvIdTipoConv);
  	listOfFields.push(this.fasConveniosMetadata.fechaSolicitud);
  	listOfFields.push(this.fasConveniosMetadata.fechaInicioPago);
  	listOfFields.push(this.fasConveniosMetadata.cuotasPendientes);
  	listOfFields.push(this.fasConveniosMetadata.cuotaIntereses);
  	listOfFields.push(this.fasConveniosMetadata.cuotaSeguro);
  	listOfFields.push(this.fasConveniosMetadata.cuotaAporte);
  	listOfFields.push(this.fasConveniosMetadata.urlImagen);
  	listOfFields.push(this.fasConveniosMetadata.principal);

    return listOfFields;
  }
  
  formErrors = {
    'idConvenio': '', 'saldo':'',	'monto': '', 'fechaInicioConvenio': '', 'estado': '',
    'numeroCuotas': '', 'mora': '', 'fasTipoConvIdTipoConv': '', 'fechaSolicitud': '',
    'fechaInicioPago': '', 'cuotasPendientes': '', 'cuotaIntereses': '', 'cuotaSeguro': '',
    'cuotaAporte': '', 'urlImagen': '', 'principal': '', 
  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idConvenio': {
  	  'required': 	'idConvenio es obligatorio',
  	  'maxlength':	'idConvenio no puede exceder 22'
  	},  'saldo': {
  	  'required': 	'saldo es obligatorio',
  	  'maxlength':	'saldo no puede exceder 22'
  	},	'monto': {
  	  'required': 	'monto es obligatorio',
  	  'maxlength':	'monto no puede exceder 30'
  	},    'fechaInicioConvenio': {
  	  'required': 	'fechaInicioConvenio es obligatorio',
  	  'maxlength':	'fechaInicioConvenio no puede exceder 30'
    },    'estado': {
  	  'required': 	'estado es obligatorio',
  	  'maxlength':	'estado no puede exceder 33'
    },    'numeroCuotas': {
  	  'required': 	'numeroCuotas es obligatorio',
      'min': 'El numero minimo de cuotas es 1',
      'max': 'El numero maximo de cuotas es 60'

    },    'mora': {
  	  'required': 	'mora es obligatorio',
  	  'maxlength':	'mora no puede exceder 30'
    },    'fasTipoConvIdTipoConv': {
  	  'required': 	'fasTipoConvIdTipoConv es obligatorio',
  	  'maxlength':	'fasTipoConvIdTipoConv no puede exceder 30'
    },    'fechaSolicitud': {
  	  'required': 	'fechaSolicitud es obligatorio',
  	  'maxlength':	'fechaSolicitud no puede exceder 30'
    },    'fechaInicioPago': {
  	  'required': 	'fechaInicioPago es obligatorio',
  	  'maxlength':	'fechaInicioPago no puede exceder 30'
    },    'cuotasPendientes': {
  	  'required': 	'cuotasPendientes es obligatorio',
  	  'maxlength':	'cuotasPendientes no puede exceder 30'
    },    'cuotaIntereses': {
  	  'required': 	'cuotaIntereses es obligatorio',
  	  'maxlength':	'cuotaIntereses no puede exceder 30'
    },    'cuotaSeguro': {
  	  'required': 	'cuotaSeguro es obligatorio',
  	  'maxlength':	'cuotaSeguro no puede exceder 30'
    },    'cuotaAporte': {
  	  'required': 	'cuotaAporte es obligatorio',
  	  'maxlength':	'cuotaAporte no puede exceder 30'
    },    'urlImagen': {
  	  'required': 	'urlImagen es obligatorio',
  	  'maxlength':	'urlImagen no puede exceder 250'
    },    'principal': {
  	  'required': 	'principal es obligatorio',
  	  'maxlength':	'principal no puede exceder 30'
    },
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

