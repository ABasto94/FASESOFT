
import { Field } from './generic.domain';
export class FasPagos {
  constructor(
    public idPago? : number, 
    public cuotaTotal? : number, 
    public fechaDePago? : any, 
    public saldo? : number, 
    public fasCreditosIdCredito? : number, 
    public cuotaIntereses? : number, 
    public cuotaSeguro? : number, 
    public cuotaDeuda? : number 
  ) { }
}

export class FasPagosMetadata {
  constructor(
  	public idPago : Field, 
  	public cuotaTotal : Field, 
  	public fechaDePago : Field, 
  	public saldo : Field, 
  	public fasCreditosIdCredito : Field, 
  	public cuotaIntereses : Field, 
  	public cuotaSeguro : Field, 
  	public cuotaDeuda : Field 
  ) { }
}

export class FasPagosDomain {
  private fasPagosMetadata = new FasPagosMetadata(
  	  	  new Field('idPago','idPago','number'), 
	  	  new Field('cuotaTotal','cuotaTotal','number'), 
	  	  new Field('fechaDePago','fechaDePago','any'), 
	  	  new Field('saldo','saldo','number'), 
	  	  new Field('fasCreditosIdCredito','fasCreditosIdCredito','number'), 
	  	  new Field('cuotaIntereses','cuotaIntereses','number'), 
	  	  new Field('cuotaSeguro','cuotaSeguro','number'), 
	  	  new Field('cuotaDeuda','cuotaDeuda','number') 
      );
  getFasPagosMetadata () : FasPagosMetadata {
    return this.fasPagosMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasPagosMetadata.idPago);
  	listOfFields.push(this.fasPagosMetadata.cuotaTotal);
  	listOfFields.push(this.fasPagosMetadata.fechaDePago);
  	listOfFields.push(this.fasPagosMetadata.saldo);
  	listOfFields.push(this.fasPagosMetadata.fasCreditosIdCredito);
  	listOfFields.push(this.fasPagosMetadata.cuotaIntereses);
  	listOfFields.push(this.fasPagosMetadata.cuotaSeguro);
  	listOfFields.push(this.fasPagosMetadata.cuotaDeuda);
    return listOfFields;
  }
  
  formErrors = {
  	'idPago': '',	
  	'cuotaTotal': '',  	'fechaDePago': '',  	'saldo': '',  	'fasCreditosIdCredito': '',  	'cuotaIntereses': '',  	'cuotaSeguro': '',  	'cuotaDeuda': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idPago': {
  	  'required': 	'idPago es obligatorio',
  	  'maxlength':	'idPago no puede exceder 18'
  	},  	'cuotaTotal': {
  	  'required': 	'cuotaTotal es obligatorio',
  	  'maxlength':	'cuotaTotal no puede exceder 18'
  	},  	'fechaDePago': {
  	  'required': 	'fechaDePago es obligatorio',
  	  'maxlength':	'fechaDePago no puede exceder 7'
  	},  	'saldo': {
  	  'required': 	'saldo es obligatorio',
  	  'maxlength':	'saldo no puede exceder 18'
  	},  	'fasCreditosIdCredito': {
  	  'required': 	'fasCreditosIdCredito es obligatorio',
  	  'maxlength':	'fasCreditosIdCredito no puede exceder 18'
  	},  	'cuotaIntereses': {
  	  'required': 	'cuotaIntereses es obligatorio',
  	  'maxlength':	'cuotaIntereses no puede exceder 18'
  	},  	'cuotaSeguro': {
  	  'required': 	'cuotaSeguro es obligatorio',
  	  'maxlength':	'cuotaSeguro no puede exceder 18'
  	},  	'cuotaDeuda': {
  	  'required': 	'cuotaDeuda es obligatorio',
  	  'maxlength':	'cuotaDeuda no puede exceder 18'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

