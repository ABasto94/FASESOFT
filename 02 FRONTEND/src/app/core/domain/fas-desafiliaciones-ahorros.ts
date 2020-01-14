import { Field } from './generic.domain';
export class FasDesafiliacionesAhorros{
  constructor(
    public monto? : number, 
    public tipo? : string, 
    public fasAfiliadosCorreo? : string 
  ) { }
}