export class FasSolicitudAfiliacion {
  constructor(
    public correo?: string,
    public nombres?: string,
    public aporte?: number,
    public telefono?: number,
    public estado?: number,
    public idUsuario?: number,
    public contraseña?: string,
    public fechaCreacion?: Date,
    public seleccionado?: boolean,
  ) { }
}