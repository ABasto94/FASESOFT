
import { Field } from './generic.domain';
export class FasTiposConvenio {
  constructor(
    public idTipoConvenio? : number, 
    public tipo? : string, 
    public tasa? : number,
    public estado?: string,
    public descripcion?: string,
    public urlConvenio?: string,
    public cuotasMaximas?: number,
  ) { }
}

export class FasTiposConvenioMetadata {
  constructor(
  	public idTipoConvenio : Field, 
  	public tipo : Field, 
    public tasa : Field,
    public estado : Field, 
  	public descripcion : Field, 
    public urlConvenio : Field,
    public cuotasMaximas : Field, 
  ) { }
}

export class FasTiposConvenioDomain {s
  private fasTiposConvenioMetadata = new FasTiposConvenioMetadata(
  	  	  new Field('idTipoConvenio','idTipoConvenio','number'), 
	  	  new Field('tipo','tipo','string'), 
        new Field('tasa','tasa','number'),
        new Field('estado','estado','string'),
        new Field('descripcion','descripcion','string'),
        new Field('urlConvenio','urlConvenio','string'),
        new Field('cuotasMaximas','cuotasMaximas','number'), 
      );


  getFasTiposConvenioMetadata () : FasTiposConvenioMetadata {
    return this.fasTiposConvenioMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasTiposConvenioMetadata.idTipoConvenio);
  	listOfFields.push(this.fasTiposConvenioMetadata.tipo);
    listOfFields.push(this.fasTiposConvenioMetadata.tasa);
    listOfFields.push(this.fasTiposConvenioMetadata.estado);
  	listOfFields.push(this.fasTiposConvenioMetadata.descripcion);
    listOfFields.push(this.fasTiposConvenioMetadata.urlConvenio);
    listOfFields.push(this.fasTiposConvenioMetadata.cuotasMaximas);
    return listOfFields;
  }
  
  formErrors = {
    'idTipoConvenio': '',	'tipo': '',  	'tasa': '',
    'estado':'', 'descripcion':'', 'urlConvenio':'', 'cuotasMaximas':''};
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idTipoConvenio': {
  	  'required': 	'idConvenio es obligatorio',
  	  'maxlength':	'idConvenio no puede exceder 22'
  	},  	'tipo': {
  	  'required': 	'tipo es obligatorio',
  	  'maxlength':	'tipo no puede exceder 30'
  	},  	'tasa': {
  	  'required': 	'tasa es obligatorio',
  	  'maxlength':	'tasa no puede exceder 250'
  	},  	'estado': {
  	  'required': 	'estado es obligatorio',
  	  'maxlength':	'estado no puede exceder 30'
  	},  	'descripcion': {
  	  'required': 	'descripcion es obligatorio',
  	  'maxlength':	'descripcion no puede exceder 250'
  	},  	'urlConvenio': {
  	  'required': 	'urlConvenio es obligatorio',
  	  'maxlength':	'urlConvenio no puede exceder 1000'
  	},  	'cuotasMaximas': {
  	  'required': 	'cuotas maximas es obligatorio',
  	  'maxlength':	'cuotas maximas no puede exceder el establecido'
  	}
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

