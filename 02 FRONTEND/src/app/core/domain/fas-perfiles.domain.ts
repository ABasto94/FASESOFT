
import { Field } from './generic.domain';
export class FasPerfiles {
  constructor(
    public idPerfil? : number, 
    public tipo? : string,
    public elegido?: boolean
  ) { }
}

export class FasPerfilesMetadata {
  constructor(
  	public idPerfil : Field, 
  	public tipo : Field 
  ) { }
}

export class FasPerfilesDomain {
  private fasPerfilesMetadata = new FasPerfilesMetadata(
  	  	new Field('idPerfil','idPerfil','number'), 
	  	  new Field('tipo','tipo','string') 
      );
  getFasPerfilesMetadata () : FasPerfilesMetadata {
    return this.fasPerfilesMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasPerfilesMetadata.idPerfil);
  	listOfFields.push(this.fasPerfilesMetadata.tipo);
    return listOfFields;
  }
  
  formErrors = {
  	'idPerfil': '',	
  	'tipo': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idPerfil': {
  	  'required': 	'idPerfil es obligatorio',
  	  'maxlength':	'idPerfil no puede exceder 18'
  	},  	'tipo': {
  	  'required': 	'El nombre del perfil es obligatorio',
  	  'maxlength':	'tipo no puede exceder 20'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

