import { Field } from './generic.domain';
export class FasAhorros {
  constructor(
    public aporte?: number,
    public fasTiposAhoIdTipoAho?: number,
    public estado?: string,
    public fasAfiliadosCorreo?: string,
    public fechaInicioAporte?: any,
    public fechaSolicitud?: Date,
    public monto?: number,
    public fechaInicio?: any,
    public idAhorro?: number,
    public codAhorro?: number
  ) { }
}

export class FasAhorrosMetadata {
  constructor(
    public aporte: Field,
    public fasTiposAhoIdTipoAho: Field,
    public estado: Field,
    public fechaInicioAporte: Field,
    public fasAfiliadosCorreo: Field,
    public fechaSolicitud: Field,
    public monto: Field,
    public fechaInicio: Field,
    public idAhorro: Field,
    public codAhorro: Field
  ) { }
}

export class FasAhorrosDomain {
  private fasAhorrosMetadata = new FasAhorrosMetadata(
    new Field('aporte', 'Aporte', 'number'),
    new Field('monto','Monto','number'),  
    new Field('fasTiposAhoIdTipoAho', 'fasTiposAhoIdTipoAho', 'string'),
    new Field('fechaInicioAporte', 'Fecha de Inicio del Aporte', 'any'),
    new Field('fasAfiliadosCorreo', 'Correo', 'string'),
    new Field('fechaInicio','fechaInicio','any'),
    new Field('estado', 'estado', 'string'),
    new Field('fechaSolicitud', 'fechaSolicitud', 'Date'),
    new Field('idAhorro', 'idAhorro', 'number'),
    new Field('codAhorro', 'codAhorro', 'number')
    
    
  );
  getFasAhorrosMetadata(): FasAhorrosMetadata {
    return this.fasAhorrosMetadata;
  }
  getSearchListOfFields(): Field[] {
    let listOfFields: Field[] = new Array<Field>();
    listOfFields.push(this.fasAhorrosMetadata.monto);
    listOfFields.push(this.fasAhorrosMetadata.aporte);
    listOfFields.push(this.fasAhorrosMetadata.fasTiposAhoIdTipoAho);
    listOfFields.push(this.fasAhorrosMetadata.fechaInicio);
    listOfFields.push(this.fasAhorrosMetadata.estado);
    listOfFields.push(this.fasAhorrosMetadata.fechaSolicitud);
    listOfFields.push(this.fasAhorrosMetadata.fechaInicioAporte);
    listOfFields.push(this.fasAhorrosMetadata.fasAfiliadosCorreo);
    listOfFields.push(this.fasAhorrosMetadata.fechaInicio);
    listOfFields.push(this.fasAhorrosMetadata.idAhorro);
    listOfFields.push(this.fasAhorrosMetadata.codAhorro);
    return listOfFields;
  }

  formErrors = {
    'monto': '',
    'aporte': '',
    'fasTiposAhoIdTipoAho': '',
    // 'fechaInicio': '', 
    'estado': '',
    'fechaSolicitud': '',
    'fechaInicioAporte': '',
    'fasAfiliadosCorreo': ''
  };

  getFormErrors() {
    return this.formErrors;
  }

  validationMessages = {
    'aporte': {
      'required': 'aporte es obligatorio',
      'minlength': 'aporte no puede ser inferior a 10.000 pesos'
    },
    // 'fasTiposAhoIdTipoAho': {
    //     'required':     'Tipo de ahorro es obligatorio',
    //     'maxlength':    'tipo de ahorro solo puede ser 2'

    //   },
    // 'fechaInicio': {
    // 'required':   'fechaInicio es obligatorio',
    //   'maxlength':    'fechaInicio no puede exceder 7'
    // }

  };

  getValidationMessages(): any {
    return this.validationMessages;
  }
}