
import { Field } from './generic.domain';
export class FasCreditos {
	constructor(
		public idCredito?: number,
		public tasaReal?: number,
		public monto?: number,
		public saldo?: number,
		public fechaInicio?: any,
		public estado?: string,
		public fasAfiliadosCorreo?: string,
		public fasTiposDeCreditoIdTipo?: number,
		public fechaSolicitud?: any,
		public numeroCuotas?: number,
		public mora?: number


	) { }
}

export class FasCreditosMetadata {
	constructor(
		public idCredito: Field,
		public tasaReal: Field,
		public monto: Field,
		public saldo: Field,
		public fechaInicio: Field,
		public estado: Field,
		public fasAfiliadosCorreo: Field,
		public fasTiposDeCreditoIdTipo: Field,
		public fechaSolicitud: Field,
		public numeroCuotas: Field,
		public mora: Field


	) { }
}

export class FasCreditosDomain {
	private fasCreditosMetadata = new FasCreditosMetadata(
		new Field('idCredito', 'idCredito', 'number'),
		new Field('tasaReal', 'tasaReal', 'number'),
		new Field('monto', 'monto', 'number'),
		new Field('saldo', 'saldo', 'number'),
		new Field('fechaInicio', 'fechaInicio', 'any'),
		new Field('fechaSolicitud', 'fechaSolicitud', 'any'),
		new Field('estado', 'estado', 'string'),
		new Field('fasAfiliadosCorreo', 'fasAfiliadosCorreo', 'string'),
		new Field('fasTiposDeCreditoIdTipo', 'fasTiposDeCreditoIdTipo', 'number'),
		new Field('numerCuotas', 'numeroCuotas', 'number'),
		new Field('mora', 'mora', 'number')

	);
	getFasCreditosMetadata(): FasCreditosMetadata {
		return this.fasCreditosMetadata;
	}
	getSearchListOfFields(): Field[] {
		let listOfFields: Field[] = new Array<Field>();
		listOfFields.push(this.fasCreditosMetadata.idCredito);
		listOfFields.push(this.fasCreditosMetadata.tasaReal);
		listOfFields.push(this.fasCreditosMetadata.monto);
		listOfFields.push(this.fasCreditosMetadata.saldo);
		listOfFields.push(this.fasCreditosMetadata.fechaInicio);
		listOfFields.push(this.fasCreditosMetadata.estado);
		listOfFields.push(this.fasCreditosMetadata.fasAfiliadosCorreo);
		listOfFields.push(this.fasCreditosMetadata.fasTiposDeCreditoIdTipo);
		listOfFields.push(this.fasCreditosMetadata.numeroCuotas);
		listOfFields.push(this.fasCreditosMetadata.mora);
	
		return listOfFields;
	}

	formErrors = {
		'idCredito': '',
		'tasaReal': '',
		'monto': '',
		'saldo': '',
		'fechaInicio': '',
		'estado': '',
		'fasAfiliadosCorreo': '',
		'fasTiposDeCreditoIdTipo': '',
		'cuotas': ''
	};

	getFormErrors() {
		return this.formErrors;
	}

	validationMessages = {
		'idCredito': {
			'required': 'idCredito es obligatorio',
			'maxlength': 'idCredito no puede exceder 18'
		}, 'tasaReal': {
			'required': 'tasaReal es obligatorio',
			'maxlength': 'tasaReal no puede exceder 2'
		}, 'monto': {
			'required': 'El valor del monto a solicitar es obligatorio',
			'maxlength': 'monto no puede exceder 1.000.000.000',
			'minlength': 'el monto debe ser superior a 100.000 pesos'
		}, 'saldo': {
			'required': 'saldo es obligatorio',
			'maxlength': 'saldo no puede exceder 18'
		}, 'fechaInicio': {
			'required': 'fechaInicio es obligatorio',
			'maxlength': 'fechaInicio no puede exceder 7'
		}, 'estado': {
			'required': 'estado es obligatorio',
			'maxlength': 'estado no puede exceder 20'
		}, 'fasAfiliadosCorreo': {
			'required': 'fasAfiliadosCorreo es obligatorio',
			'maxlength': 'fasAfiliadosCorreo no puede exceder 40'
		}, 'fasTiposDeCreditoIdTipo': {
			'required': 'fasTiposDeCreditoIdTipo es obligatorio',
			'maxlength': 'fasTiposDeCreditoIdTipo no puede exceder 18'
		},
		'numeroCuotas': {
			'required': 'el numero de cuotas es obligatorio',
			'max': 'fasTiposDeCreditoIdTipo no puede exceder 30',
			'min': 'el numero de cuotas es 1'
		}
	};

	getValidationMessages(): any {
		return this.validationMessages;
	}
}

