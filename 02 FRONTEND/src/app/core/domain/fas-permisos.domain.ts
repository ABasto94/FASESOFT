
import { Field } from './generic.domain';
export class FasPermisos {
  constructor(
    public idPermiso? : number, 
    public fasPerfilesIdPerfil? : number, 
    public fasAccesosIdAcceso? : number 
  ) { }
}

export class FasPermisosMetadata {
  constructor(
  	public idPermiso : Field, 
  	public fasPerfilesIdPerfil : Field, 
  	public fasAccesosIdAcceso : Field 
  ) { }
}

export class FasPermisosDomain {
  private fasPermisosMetadata = new FasPermisosMetadata(
  	  	  new Field('idPermiso','idPermiso','number'), 
	  	  new Field('fasPerfilesIdPerfil','fasPerfilesIdPerfil','number'), 
	  	  new Field('fasAccesosIdAcceso','fasAccesosIdAcceso','number') 
      );
  getFasPermisosMetadata () : FasPermisosMetadata {
    return this.fasPermisosMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasPermisosMetadata.idPermiso);
  	listOfFields.push(this.fasPermisosMetadata.fasPerfilesIdPerfil);
  	listOfFields.push(this.fasPermisosMetadata.fasAccesosIdAcceso);
    return listOfFields;
  }
  
  formErrors = {
  	'idPermiso': '',	
  	'fasPerfilesIdPerfil': '',  	'fasAccesosIdAcceso': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idPermiso': {
  	  'required': 	'idPermiso es obligatorio',
  	  'maxlength':	'idPermiso no puede exceder 22'
  	},  	'fasPerfilesIdPerfil': {
  	  'required': 	'fasPerfilesIdPerfil es obligatorio',
  	  'maxlength':	'fasPerfilesIdPerfil no puede exceder 18'
  	},  	'fasAccesosIdAcceso': {
  	  'required': 	'fasAccesosIdAcceso es obligatorio',
  	  'maxlength':	'fasAccesosIdAcceso no puede exceder 18'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

