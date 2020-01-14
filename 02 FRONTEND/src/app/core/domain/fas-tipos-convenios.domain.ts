
import { Field } from './generic.domain';
export class FasTiposConvenios {
    constructor(
        public idTipoConvenio?: number,
        public tipo?: String,
        public tasa?: number,
        public estado?: String,
        public descripcion?: String,
        public urlConvenio?: String
    ) { }
}

export class FasTiposConveniosMetadata {
    constructor(
        public idTipoConvenio?: Field,
        public tipo?: Field,
        public tasa?: Field,
        public estado?: Field,
        public descripcion?: Field,
        public urlConvenio?: Field
    ) { }
}

export class FasTiposConveniosDomain {
    private fasTiposConveniosMetadata = new FasTiposConveniosMetadata(
        new Field('idTipoConvenio', 'idTipoConvenio', 'number'),
        new Field('tipo', 'tipo', 'string'),
        new Field('tasa', 'tasa', 'number'),
        new Field('estado', 'estado', 'string'),
        new Field('descripcion', 'descripcion', 'string'),
        new Field('urlConvenio', 'urlConvenio', 'string')
    );
    getFasConveniosMetadata(): FasTiposConveniosMetadata {
        return this.fasTiposConveniosMetadata;
    }
    getSearchListOfFields(): Field[] {
        let listOfFields: Field[] = new Array<Field>();
        listOfFields.push(this.fasTiposConveniosMetadata.idTipoConvenio);
        listOfFields.push(this.fasTiposConveniosMetadata.tipo);
        listOfFields.push(this.fasTiposConveniosMetadata.tasa);
        listOfFields.push(this.fasTiposConveniosMetadata.estado);
        listOfFields.push(this.fasTiposConveniosMetadata.descripcion);
        listOfFields.push(this.fasTiposConveniosMetadata.urlConvenio);
        return listOfFields;
    }
}

