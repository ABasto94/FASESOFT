package com.fasesoft.modelo.manejadores;

import com.fasesoft.modelo.manejadores.utils.ConstantesConsultaCreditos;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;
import com.fasesoft.modelo.dtos.FasTiposConvenioDTO;
import com.fasesoft.modelo.entidades.FasTiposConvenio;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre
 * la tabla correspondiente a la entidad FasTiposConvenio.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasTiposConvenio extends ManejadorCrud<FasTiposConvenio,Number>{
	

    public ManejadorFasTiposConvenio() {
        super(FasTiposConvenio.class);
    }

	public FasTiposConvenioDTO crearTipoConvenio(FasTiposConvenioDTO fasTiposConvenioDTO) {
		List<Object> parametros = new ArrayList<Object>();
		parametros.add(fasTiposConvenioDTO.getTipo());
		parametros.add(fasTiposConvenioDTO.getTasa());
		parametros.add(fasTiposConvenioDTO.getEstado());
		parametros.add(fasTiposConvenioDTO.getDescripcion());
		parametros.add(fasTiposConvenioDTO.getUrlConvenio());
		parametros.add(fasTiposConvenioDTO.getCuotasMaximas());
		mp.doNativeQueryUpdate(ConstantesConsultas.CREATE_TIPO_CONVENIO, parametros);
		return fasTiposConvenioDTO;
				

	}   
    
    // protected region Use esta region para su implementacion del manejador on begin 
    
    
    
    // protected region Use esta region para su implementacion del manejador end        
}

