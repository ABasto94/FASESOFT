package com.fasesoft.modelo.manejadores;

import java.util.List;

import javax.ejb.Stateless;

import com.fasesoft.modelo.dtos.FasCreditosAfiliadoDTO;
import com.fasesoft.modelo.entidades.FasCreditos;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultaCreditos;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasCreditos.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasCreditos extends ManejadorCrud<FasCreditos, Integer> {

	public ManejadorFasCreditos() {
		super(FasCreditos.class);
	}

	public List<FasCreditos> consultarHistorial(String correoAfiliado) {
		return mp.createNamedQuery("FasAfiliados.findUserInfoByCorreo").setParameter("paramCorreo", correoAfiliado)
				.getResultList();
	}

	public List<FasCreditos> consultarHistorialSolicitudes(String atributo) {

		// TODO Auto-generated method stub
		return mp.createNamedQuery("FasCreditos.findDetalleCredito").setParameter("paramCorreo", atributo)
				.getResultList();
	}
	
	public List<FasCreditosAfiliadoDTO> consultarCreditosPorAprobar() {
		
		
		return this.mp.doNativeQuery(ConstantesConsultaCreditos.CONSULTA_SOLICITUDES_CREDUTIS, null,ConstantesConsultaCreditos.RESULTMAPPING_QUERY_NATIVA_SOLICITUDES_CREDITOS);
		
	}   
    

	// protected region Use esta region para su implementacion del manejador on
	// begin

	// protected region Use esta region para su implementacion del manejador end
}
