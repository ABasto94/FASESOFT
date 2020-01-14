
import { Field } from './generic.domain';
export class FasAccesos {
  constructor(
    public idAcceso? : number, 
    public nombre? : string, 
	public componente? : string, 
	public descripcion? : string,
	public elegido?: boolean,
  ) { }
}

export class FasAccesosMetadata {
  constructor(
  	public idAcceso : Field, 
  	public nombre : Field, 
  	public url : Field, 
  	public descripcion : Field 
  ) { }
}

export class FasAccesosDomain {
  private fasAccesosMetadata = new FasAccesosMetadata(
  	  	  new Field('idAcceso','idAcceso','number'), 
	  	  new Field('nombre','nombre','string'), 
	  	  new Field('url','url','string'), 
	  	  new Field('descripcion','descripcion','string') 
      );
  getFasAccesosMetadata () : FasAccesosMetadata {
    return this.fasAccesosMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasAccesosMetadata.idAcceso);
  	listOfFields.push(this.fasAccesosMetadata.nombre);
  	listOfFields.push(this.fasAccesosMetadata.url);
  	listOfFields.push(this.fasAccesosMetadata.descripcion);
    return listOfFields;
  }
  
  formErrors = {
  	'idAcceso': '',	
  	'nombre': '',  	'url': '',  	'descripcion': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idAcceso': {
  	  'required': 	'idAcceso es obligatorio',
  	  'maxlength':	'idAcceso no puede exceder 18'
  	},  	'nombre': {
  	  'required': 	'nombre es obligatorio',
  	  'maxlength':	'nombre no puede exceder 20'
  	},  	'url': {
  	  'required': 	'url es obligatorio',
  	  'maxlength':	'url no puede exceder 250'
  	},  	'descripcion': {
  	  'required': 	'descripcion es obligatorio',
  	  'maxlength':	'descripcion no puede exceder 250'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

