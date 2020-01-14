
import { Field } from './generic.domain';
export class FasAfiliados {
	constructor(
		public correo?: string,
		public nombre?: string,
		public apellido?: string,
		public telefono?: number,
		public direccion?: string,
		public identificacion?: number,
		public tipoId?: string,
		public estado?: string,
		public ciudad?: string,
		public expedicion?: string,
		public fechaRetiro?: Date,
		public mora?: number,
		public banco?: string,
		public cuentaBancaria?: string,
		public aporte?:number,
	) { }
}

export class FasAfiliadosMetadata {
	constructor(
		public correo: Field,
		public nombre: Field,
		public apellido: Field,
		public telefono: Field,
		public direccion: Field,
		public identificacion: Field,
		public tipoId: Field,
		public estado: Field,
		public fechaRetiro: Field,
		public mora: Field,
		public banco: Field,
	) { }
}

export class FasAfiliadosDomain {
	private fasAfiliadosMetadata = new FasAfiliadosMetadata(
		new Field('correo', 'correo', 'string'),
		new Field('nombre', 'nombre', 'string'),
		new Field('apellido', 'apellido', 'string'),
		new Field('telefono', 'telefono', 'number'),
		new Field('direccion', 'direccion', 'string'),
		new Field('identificacion', 'identificacion', 'number'),
		new Field('tipoId', 'tipoId', 'string'),
		new Field('estado', 'estado', 'string'),
		new Field('fechaRetiro', 'fechaRetiro', 'any'),
		new Field('mora', 'mora', 'number'),
		new Field('banco', 'banco', 'string')
	);
	getFasAfiliadosMetadata(): FasAfiliadosMetadata {
		return this.fasAfiliadosMetadata;
	}
	getSearchListOfFields(): Field[] {
		let listOfFields: Field[] = new Array<Field>();
		listOfFields.push(this.fasAfiliadosMetadata.correo);
		listOfFields.push(this.fasAfiliadosMetadata.nombre);
		listOfFields.push(this.fasAfiliadosMetadata.apellido);
		listOfFields.push(this.fasAfiliadosMetadata.telefono);
		listOfFields.push(this.fasAfiliadosMetadata.direccion);
		listOfFields.push(this.fasAfiliadosMetadata.identificacion);
		listOfFields.push(this.fasAfiliadosMetadata.tipoId);
		listOfFields.push(this.fasAfiliadosMetadata.estado);
		listOfFields.push(this.fasAfiliadosMetadata.fechaRetiro);
		listOfFields.push(this.fasAfiliadosMetadata.mora);
		listOfFields.push(this.fasAfiliadosMetadata.banco);
		return listOfFields;
	}

	formErrors = {
		'correo': '',
		'nombre': '', 'apellido': '', 'telefono': '', 'direccion': '', 'identificacion': '', 'tipoId': '', 'estado': '', 'fechaRetiro': '', 'mora': ''
	};

	getFormErrors() {
		return this.formErrors;
	}

	validationMessages = {
		'correo': {
			'required': 'correo es obligatorio',
			'maxlength': 'correo no puede exceder 40'
		}, 'nombre': {
			'required': 'nombre es obligatorio',
			'maxlength': 'nombre no puede exceder 20'
		}, 'apellido': {
			'required': 'apellido es obligatorio',
			'maxlength': 'apellido no puede exceder 20'
		}, 'telefono': {
			'required': 'telefono es obligatorio',
			'maxlength': 'telefono no puede exceder 18'
		}, 'direccion': {
			'required': 'direccion es obligatorio',
			'maxlength': 'direccion no puede exceder 30'
		}, 'identificacion': {
			'required': 'identificacion es obligatorio',
			'maxlength': 'identificacion no puede exceder 18'
		}, 'tipoId': {
			'required': 'tipoId es obligatorio',
			'maxlength': 'tipoId no puede exceder 4'
		}, 'estado': {
			'required': 'estado es obligatorio',
			'maxlength': 'estado no puede exceder 20'
		}, 'fechaRetiro': {
			'required': 'fechaRetiro es obligatorio',
			'maxlength': 'fechaRetiro no puede exceder 7'
		}, 'mora': {
			'required': 'mora es obligatorio',
			'maxlength': 'mora no puede exceder 18'
		}, 'banco': {
			'required': 'mora es obligatorio',
			'maxlength': 'mora no puede exceder 18'
		}
		
	};

	getValidationMessages(): any {
		return this.validationMessages;
	}
}

