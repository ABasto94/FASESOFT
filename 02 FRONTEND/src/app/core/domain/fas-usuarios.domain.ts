
import { Field } from './generic.domain';
export class FasUsuarios {
  constructor(
    public idUsuario?: number,
    public contrasena?: string,
    public contraseña?: string,
    public estado?: string,
    public fechaCracion?: any,
    public fasAfiliadosCorreo?: string,
    public motRechazo?:string,
    public seleccionado?: boolean,
  ) { }
}

export class FasUsuariosMetadata {
  constructor(
    public idUsuario?: Field,
    public contrasena?: Field,
    public estado?: Field,
    public fechaCracion?: Field,
    public fasAfiliadosCorreo?: Field,
  ) { }
}

export class FasUsuariosDomain {
  private fasUsuariosMetadata = new FasUsuariosMetadata(
    new Field('idUsuario', 'idUsuario', 'number'),
    new Field('contrasena', 'contrasena', 'string'),
    new Field('estado', 'estado', 'string'),
    new Field('fechaCracion', 'fechaCracion', 'any'),
    new Field('fasAfiliadosCorreo', 'fasAfiliadosCorreo', 'string')
  );
  getFasUsuariosMetadata(): FasUsuariosMetadata {
    return this.fasUsuariosMetadata;
  }
  getSearchListOfFields(): Field[] {
    let listOfFields: Field[] = new Array<Field>();
    listOfFields.push(this.fasUsuariosMetadata.idUsuario);
    listOfFields.push(this.fasUsuariosMetadata.contrasena);
    listOfFields.push(this.fasUsuariosMetadata.estado);
    listOfFields.push(this.fasUsuariosMetadata.fechaCracion);
    listOfFields.push(this.fasUsuariosMetadata.fasAfiliadosCorreo);
    return listOfFields;
  }

  formErrors = {
    'idUsuario': '',
    'contrasena': '', 'estado': '', 'fechaCracion': '', 'fasAfiliadosCorreo': ''
  };

  getFormErrors() {
    return this.formErrors;
  }

}

