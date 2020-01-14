
import { Field } from './generic.domain';
export class FasTiposDeCredito {
  constructor(
    public idTipo? : number, 
    public tipo? : string, 
    public tasa? : number, 
    public descripcion? : string,
	public cuotasMaximas? : number 
  ) { }
}

export class FasTiposDeCreditoMetadata {
  constructor(
  	public idTipo : Field, 
  	public tipo : Field, 
  	public tasa : Field, 
  	public descripcion : Field ,
	  public cuotasMaximas : Field
  ) { }
}

export class FasTiposDeCreditoDomain {
  private fasTiposDeCreditoMetadata = new FasTiposDeCreditoMetadata(
  	  	  new Field('idTipo','idTipo','number'), 
	  	  new Field('tipo','tipo','string'), 
	  	  new Field('tasa','tasa','number'), 
	  	  new Field('descripcion','descripcion','string'),
		new Field('cuotasMaximas','cuotasMaximas','number') 
      );
  getFasTiposDeCreditoMetadata () : FasTiposDeCreditoMetadata {
    return this.fasTiposDeCreditoMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasTiposDeCreditoMetadata.idTipo);
  	listOfFields.push(this.fasTiposDeCreditoMetadata.tipo);
  	listOfFields.push(this.fasTiposDeCreditoMetadata.tasa);
	  listOfFields.push(this.fasTiposDeCreditoMetadata.descripcion);
	  listOfFields.push(this.fasTiposDeCreditoMetadata.cuotasMaximas);
    return listOfFields;
  }
  
  formErrors = {
  	'idTipo': '',	
  	'tipo': '',  	'tasa': '',  	'descripcion': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idTipo': {
  	  'required': 	'idTipo es obligatorio',
  	  'maxlength':	'idTipo no puede exceder 18'
  	},  	'tipo': {
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

