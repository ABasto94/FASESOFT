package com.fasesoft.modelo.manejadores;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasAccesos;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasAccesos.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasAccesos extends ManejadorCrud<FasAccesos, BigDecimal> {

	public ManejadorFasAccesos() {
		super(FasAccesos.class);
	}

	// protected region Use esta region para su implementacion del manejador on
	// begin
	public List<FasAccesos> consultarListaPorUsuario(String correo) {
		return mp.createNamedQuery("FasAccesos.findAccesosByUser").setParameter("correo", correo).getResultList();
	}

	public List<FasAccesos> consultarAccesosPorPerfil(String tipo) {
		return mp.createNamedQuery("FasAccesos.findAccesosByProfile").setParameter("tipo", tipo).getResultList();
	}
	// protected region Use esta region para su implementacion del manejador end
}
