
import { Field } from './generic.domain';
export class FasSolConvenios {
  constructor(
    public idSolicitud? : number, 
    public fasAfiliadosCorreo? : string, 
    public fasConveniosIdConvenio? : number 
  ) { }
}

export class FasSolConveniosMetadata {
  constructor(
  	public idSolicitud : Field, 
  	public fasAfiliadosCorreo : Field, 
  	public fasConveniosIdConvenio : Field 
  ) { }
}

export class FasSolConveniosDomain {
  private fasSolConveniosMetadata = new FasSolConveniosMetadata(
  	  	  new Field('idSolicitud','idSolicitud','number'), 
	  	  new Field('fasAfiliadosCorreo','fasAfiliadosCorreo','string'), 
	  	  new Field('fasConveniosIdConvenio','fasConveniosIdConvenio','number') 
      );
  getFasSolConveniosMetadata () : FasSolConveniosMetadata {
    return this.fasSolConveniosMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasSolConveniosMetadata.idSolicitud);
  	listOfFields.push(this.fasSolConveniosMetadata.fasAfiliadosCorreo);
  	listOfFields.push(this.fasSolConveniosMetadata.fasConveniosIdConvenio);
    return listOfFields;
  }
  
  formErrors = {
  	'idSolicitud': '',	
  	'fasAfiliadosCorreo': '',  	'fasConveniosIdConvenio': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idSolicitud': {
  	  'required': 	'idSolicitud es obligatorio',
  	  'maxlength':	'idSolicitud no puede exceder 18'
  	},  	'fasAfiliadosCorreo': {
  	  'maxlength':	'fasAfiliadosCorreo no puede exceder 40'
  	},  	'fasConveniosIdConvenio': {
  	  'required': 	'fasConveniosIdConvenio es obligatorio',
  	  'maxlength':	'fasConveniosIdConvenio no puede exceder 22'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

