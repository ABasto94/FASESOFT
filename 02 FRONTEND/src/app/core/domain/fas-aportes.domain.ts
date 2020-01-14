
import { Field } from './generic.domain';
export class FasAportes {
  constructor(
    public idAporte? : number, 
    public aporte? : number, 
    public beneficio? : number, 
    public fasAhorrosIdAhorro? : number, 
    public fechaAporte? : any 
  ) { }
}

export class FasAportesMetadata {
  constructor(
  	public idAporte : Field, 
  	public aporte : Field, 
  	public beneficio : Field, 
  	public fasAhorrosIdAhorro : Field, 
  	public fechaAporte : Field 
  ) { }
}

export class FasAportesDomain {
  private fasAportesMetadata = new FasAportesMetadata(
  	  	  new Field('idAporte','idAporte','number'), 
	  	  new Field('aporte','aporte','number'), 
	  	  new Field('beneficio','beneficio','number'), 
	  	  new Field('fasAhorrosIdAhorro','fasAhorrosIdAhorro','number'), 
	  	  new Field('fechaAporte','fechaAporte','any') 
      );
  getFasAportesMetadata () : FasAportesMetadata {
    return this.fasAportesMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasAportesMetadata.idAporte);
  	listOfFields.push(this.fasAportesMetadata.aporte);
  	listOfFields.push(this.fasAportesMetadata.beneficio);
  	listOfFields.push(this.fasAportesMetadata.fasAhorrosIdAhorro);
  	listOfFields.push(this.fasAportesMetadata.fechaAporte);
    return listOfFields;
  }
  
  formErrors = {
  	'idAporte': '',	
  	'aporte': '',  	'beneficio': '',  	'fasAhorrosIdAhorro': '',  	'fechaAporte': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idAporte': {
  	  'required': 	'idAporte es obligatorio',
  	  'maxlength':	'idAporte no puede exceder 18'
  	},  	'aporte': {
  	  'required': 	'aporte es obligatorio',
  	  'maxlength':	'aporte no puede exceder 18'
  	},  	'beneficio': {
  	  'required': 	'beneficio es obligatorio',
  	  'maxlength':	'beneficio no puede exceder 18'
  	},  	'fasAhorrosIdAhorro': {
  	  'maxlength':	'fasAhorrosIdAhorro no puede exceder 18'
  	},  	'fechaAporte': {
  	  'required': 	'fechaAporte es obligatorio',
  	  'maxlength':	'fechaAporte no puede exceder 7'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

