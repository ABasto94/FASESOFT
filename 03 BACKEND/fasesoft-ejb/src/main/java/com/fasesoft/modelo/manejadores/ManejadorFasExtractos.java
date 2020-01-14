package com.fasesoft.modelo.manejadores;

import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

import com.fasesoft.modelo.dtos.FasConveniosTiposPagosDTO;
import com.fasesoft.modelo.dtos.FasCreditosPagosTipoDTO;

import com.fasesoft.modelo.dtos.FasExtAhorrosAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasExtAhorrosVoluntariosDTO;
import com.fasesoft.modelo.dtos.FasExtractosDTO;
import com.fasesoft.modelo.dtos.FasGeneracionExtractoDTO;
import com.fasesoft.modelo.entidades.FasExtractos;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasExtractos.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasExtractos extends ManejadorCrud<FasExtractos,Number>{
	

    public ManejadorFasExtractos() {
        super(FasExtractos.class);
    }   
    

    
    /*public List<FasGeneracionExtractoDTO> consultarExtractosAfiliados(){
		return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVA_GENERECION_EXTRACTOS, null, ConstantesConsultas.RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_EXTRACTOS);
    }*/
    public List<FasExtractos> consultarExtractosPorFecha(String nombre){
    	 return this.mp.createNamedQuery("FasExtractos.porFecha").setParameter("paramNombre", nombre).getResultList();
    }
    
    public List<FasConveniosTiposPagosDTO>consultarPagoConvenios(List<Object> parametros){
    	return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_TIPO_PAGO_CONVENIO, parametros, ConstantesConsultas.RESULTMAPPING_QUERY_CONSULTAR_PAGOS_CONVENIOS);
    }
    
    public List<FasCreditosPagosTipoDTO> consultarPagoCreditos(List<Object> parametros) {
    	return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_TIPO_PAGO_CREDITO, parametros, ConstantesConsultas.RESULT_MAPPING_CONSULTAR_PAGO_CREDITOS);
    }
    

    public List<FasExtAhorrosAfiliadosDTO> consultarAhorroPermanenteAfiliado(List<Object> parametros) {
    	return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVA_CONSULTAR_AHORROS_PERMANENTES_AFILIADO, parametros, ConstantesConsultas.RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_APORTE_PERMANENTE_AFILIADO);
    }
    

    public List<FasExtAhorrosVoluntariosDTO> consultarAhorroVoluntarioAfiliado(List<Object> parametros) {
    	return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVA_CONSULTAR_AHORROS_VOLUNTARIOS_AFILIADO, parametros, ConstantesConsultas.RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_APORTE_VOLUNTARIO_AFILIADO);
    }



	public List<FasExtractos> consultarExtractoPorAfiliado(String correoAfiliado) {
		return mp.createNamedQuery("FasExtractos.findPorAfiliado").setParameter("paramCorreo", correoAfiliado)
				.getResultList();
	}
    

    // protected region Use esta region para su implementacion del manejador on begin 
    
    // protected region Use esta region para su implementacion del manejador end        


	// protected region Use esta region para su implementacion del manejador on
	// begin

	// protected region Use esta region para su implementacion del manejador end
}
