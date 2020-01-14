
import { Field } from './generic.domain';
export class FasRoles {
  constructor(
    public idRol? : number, 
    public fasUsuariosIdUsuario? : number, 
    public fasPerfilesIdPerfil? : number 
  ) { }
}

export class FasRolesMetadata {
  constructor(
  	public idRol : Field, 
  	public fasUsuariosIdUsuario : Field, 
  	public fasPerfilesIdPerfil : Field 
  ) { }
}

export class FasRolesDomain {
  private fasRolesMetadata = new FasRolesMetadata(
  	  	  new Field('idRol','idRol','number'), 
	  	  new Field('fasUsuariosIdUsuario','fasUsuariosIdUsuario','number'), 
	  	  new Field('fasPerfilesIdPerfil','fasPerfilesIdPerfil','number') 
      );
  getFasRolesMetadata () : FasRolesMetadata {
    return this.fasRolesMetadata;
  }
  getSearchListOfFields () : Field[] {
    let listOfFields : Field[] = new Array<Field>();
  	listOfFields.push(this.fasRolesMetadata.idRol);
  	listOfFields.push(this.fasRolesMetadata.fasUsuariosIdUsuario);
  	listOfFields.push(this.fasRolesMetadata.fasPerfilesIdPerfil);
    return listOfFields;
  }
  
  formErrors = {
  	'idRol': '',	
  	'fasAfiliadosCorreo': '',  	'fasPerfilesIdPerfil': ''  };
  
  getFormErrors () {
    return this.formErrors;
  }

  validationMessages = {
  	'idRol': {
  	  'required': 	'idRol es obligatorio',
  	  'maxlength':	'idRol no puede exceder 18'
  	},  	'fasAfiliadosCorreo': {
  	  'required': 	'fasAfiliadosCorreo es obligatorio',
  	  'maxlength':	'fasAfiliadosCorreo no puede exceder 40'
  	},  	'fasPerfilesIdPerfil': {
  	  'required': 	'fasPerfilesIdPerfil es obligatorio',
  	  'maxlength':	'fasPerfilesIdPerfil no puede exceder 18'
  	}  	
  };
  
  getValidationMessages () : any {
    return this.validationMessages;
  }
}

