import { Field } from "./generic.domain";

export class FasCreditoAfiliado {
	constructor(
	  public idCredito? : number, 
	  public fechaSolicitud? : any, 
	  public nombre? : string,
	  public identificacion? : number, 
	  public monto? : number, 
	  public cuota? : number,
	  public tasaReal? : number, 
	  public tipoCredito? : string,
	  public montoFijo? : number,
	  public deuda? : number, 
	  public estado? : string 
	) { }
  }

  export class FasCreditoAfiliadoMetadata {
	constructor(
		public idCredito : Field,
		public fechaSolicitud : Field,
		public nombre : Field,
		public identificacion : Field,
		public monto : Field,
		public cuota: Field,
		public tasaReal : Field,
		public tipoCredito : Field,
		public montoFijo : Field,
		public deuda : Field,
		public estado : Field
	) { }
  }
  
  export class FasCreditoAfiliadoDomain {
	private FasCreditoAfiliadoMetadata = new FasCreditoAfiliadoMetadata(
			new Field('idCredito','Id crédito','number'), 
			new Field('fechaSolicitud','Fecha de\r solicitud','any'), 
			new Field('nombre','Nombre del\r solicitante','string'), 
			new Field('identificacion','Identificación','number'), 
			new Field('monto','Monto solicitado','number'), 
			new Field('cuota','Cuotas','number'), 
			new Field('tasaReal','Tasa de\r interés','number'), 
			new Field('tipoCredito','Tipo de crédito','string'),
			new Field('montoFijo','Monto ahorrado','number'),
			new Field('deuda','Deuda','number'),
			new Field('estado','Estado de la\r solicitud','string')
		);
		
	getFasCreditoAfiliadoMetadata () : FasCreditoAfiliadoMetadata {
	  return this.FasCreditoAfiliadoMetadata;
	}
	getSearchListOfFields2 () : Field[] {
	  let listOfFields2 : Field[] = new Array<Field>();
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.idCredito);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.fechaSolicitud);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.nombre);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.identificacion);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.monto);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.cuota);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.tasaReal);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.tipoCredito);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.montoFijo);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.deuda);
		listOfFields2.push(this.FasCreditoAfiliadoMetadata.estado);
	  return listOfFields2;
	}
  }