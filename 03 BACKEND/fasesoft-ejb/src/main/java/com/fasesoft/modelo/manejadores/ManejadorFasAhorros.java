package com.fasesoft.modelo.manejadores;

import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;
import com.fasesoft.modelo.dtos.FasAhorrosDTO;
import com.fasesoft.modelo.entidades.FasAhorros;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasAhorros;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasAhorros.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasAhorros extends ManejadorCrud<FasAhorros,Number>{
	

    public ManejadorFasAhorros() {
        super(FasAhorros.class);
    }   
    
    public List<FasAhorrosDTO> consultarAporte(List<Object> listaParam) {
    	return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_APORTE_PERMANENTE, listaParam, ConstantesConsultas.RESULT_MAPPING_APORTE_PERMANENTE);
    }
    
    public List<FasAhorrosDTO> consultarAhorroVoluntario(List<Object> listaParam) {
    	return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_CONSULTAR_AHORROS_POR_CORREO, listaParam, ConstantesConsultas.RESULT_MAPPING_CONSULTAR_AHORROS_POR_CORREO);
    }
    
    public int actualizarAporte(Number var) {

    	return  mp.createNamedQuery("Ahorro.NuevoAporte").setParameter(1, var).executeUpdate();
	}
    
    
    
    // protected region Use esta region para su implementacion del manejador on begin 
    
    public List<FasAhorros> consultarAhorrosPorCorreoAfiliado(String atributo) {
		return mp.createNamedQuery("FasAhorros.findSavingsByEmail").setParameter("paramCorreo", atributo)
				.getResultList();
	}
    
    // protected region Use esta region para su implementacion del manejador end 
	public List<FasAhorros> consultarSolicitudesVoluntariasPendientes() {

		// TODO Auto-generated method stub
		return mp.createNamedQuery("FasAhorros.voluntarioPendiente").getResultList();
	}

	// protected region Use esta region para su implementacion del manejador on
	// begin

	// protected region Use esta region para su implementacion del manejador end
}
