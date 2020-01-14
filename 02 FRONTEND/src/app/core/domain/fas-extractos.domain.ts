
import { Field } from './generic.domain';
export class FasExtractos {
  constructor(
    public idExtracto?: number,
    public correo?: string,
    public fechaExtracto?: any,
    public nombreExtracto?: string,
    public urlExtracto?: string,
    public fasAfiliadosCorreo? : string,
  ) { }
}

export class FasExtractosMetadata {
  constructor(
    public idExtracto: Field,

    public correo: Field,
    public fechaExtracto: Field,

    public nombreExtracto: Field,
    public urlExtracto: Field
  ) { }
}

export class FasExtractosDomain {
  private fasExtractosMetadata = new FasExtractosMetadata(
    new Field('idExtracto', 'Id', 'number'),

    new Field('correo', 'Correo', 'string'),
    new Field('fechaExtracto', 'Fecha', 'any'),
    new Field('nombreExtracto', 'Nombre', 'string'),
    new Field('urlExtracto', 'Url', 'string')
  );
  getFasExtractosMetadata(): FasExtractosMetadata {
    return this.fasExtractosMetadata;
  }
  getSearchListOfFields(): Field[] {
    let listOfFields: Field[] = new Array<Field>();
    listOfFields.push(this.fasExtractosMetadata.idExtracto);

    listOfFields.push(this.fasExtractosMetadata.correo);
    listOfFields.push(this.fasExtractosMetadata.fechaExtracto);
    listOfFields.push(this.fasExtractosMetadata.nombreExtracto);
    listOfFields.push(this.fasExtractosMetadata.urlExtracto);
    return listOfFields;
  }

  formErrors = {
    'id': '', 'correo': '',
    'fecha': '', 'nombre': '', 'url': ''
  };

  getFormErrors() {
    return this.formErrors;
  }

  validationMessages = {
    'id': {
      'required': 'id es obligatorio',
      'maxlength': 'id no puede exceder 18'
    }, 'correo': {
      'required': 'correo es obligatorio',
      'maxlength': 'correo no puede exceder 18'
    }, 'fecha': {
      'required': 'fecha es obligatorio',
      'maxlength': 'fecha no puede exceder 20'
    }, 'nombre': {
      'required': 'nombre es obligatorio',
      'maxlength': 'nombre no puede exceder 250'
    }, 'url': {
      'required': 'url es obligatorio',
      'maxlength': 'url no puede exceder 250'
    }
  };

  getValidationMessages(): any {
    return this.validationMessages;
  }
}

