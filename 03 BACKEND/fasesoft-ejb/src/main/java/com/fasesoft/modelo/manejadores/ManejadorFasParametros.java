package com.fasesoft.modelo.manejadores;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

import com.fasesoft.modelo.dtos.FasParametrosDTO;
import com.fasesoft.modelo.entidades.FasParametros;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

@Stateless
public class ManejadorFasParametros extends ManejadorCrud<FasParametros,BigDecimal>{
	
    public ManejadorFasParametros() {
        super(FasParametros.class);
    }



	public List<FasParametrosDTO> consultarParametros() {

		return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_PARAMETROS, null, ConstantesConsultas.RESULT_MAPPING_PARAMETROS);
	}
    
}
