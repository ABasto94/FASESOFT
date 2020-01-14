
import { Field } from './generic.domain';
export class FasTiposDeAhorro {
  constructor(
    public idTipoAhorro? : number, 
    public tipo? : string, 
    public tasa? : number, 
    public descripcion? : string,
  ) { }
}

export class FasTiposDeAhorroMetadata {
  constructor(
  	public idTipoAhorro : Field, 
  	public tipo : Field, 
  	public tasa : Field, 
  	public descripcion : Field ,
	
  ) { }
}

export class FasTiposDeAhorroDomain {
  private fasTiposDeCreditoMetadata = new FasTiposDeAhorroMetadata(
  	  	  new Field('idTipoAhorro','idTipoAhorro','number'), 
	  	  new Field('tipo','tipo','string'), 
	  	  new Field('tasa','tasa','number'), 
	  	  new Field('descripcion','descripcion','string'),

      );
  getFasTiposDeAhorroMetadata () : FasTiposDeAhorroMetadata {
    return this.fasTiposDeCreditoMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasTiposDeCreditoMetadata.idTipoAhorro);
  	listOfFields.push(this.fasTiposDeCreditoMetadata.tipo);
  	listOfFields.push(this.fasTiposDeCreditoMetadata.tasa);
	  listOfFields.push(this.fasTiposDeCreditoMetadata.descripcion);
	
    return listOfFields;
  }
  
  formErrors = {
  	'idTipoAhorro': '',	
  	'tipo': '',  	'tasa': '',  	'descripcion': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	  'tipo': {
  	  'required': 	'tipo es obligatorio',
  	  'maxlength':	'tipo no puede exceder 20'
  	},  	'tasa': {
  	  'required': 	'tasa es obligatorio',
  	  'maxlength':	'tasa no puede exceder 2'
  	},  	'descripcion': {
  	  'required': 	'descripcion es obligatorio',
  	  'maxlength':	'descripcion no puede exceder 250'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

