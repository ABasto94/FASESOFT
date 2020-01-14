import { Field } from './generic.domain';
import { FasCreditosTipo } from './fas-creditos-tipo-credito';
export class FasDesafilicionesCreditos {
	constructor(
        public saldo?: number,
        public tipo?: string,
        public estado?: string,
		public fasAfiliadosCorreo?: string
	) { }
}