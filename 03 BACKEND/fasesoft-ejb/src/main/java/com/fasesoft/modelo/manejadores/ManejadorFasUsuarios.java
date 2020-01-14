package com.fasesoft.modelo.manejadores;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasUsuarios;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasUsuarios.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasUsuarios extends ManejadorCrud<FasUsuarios, Integer> {

	public ManejadorFasUsuarios() {
		super(FasUsuarios.class);
	}

	public List<FasUsuarios> consultarUsuarioPorCorreo(String correo) {
		return mp.createNamedQuery("FasUsuarios.findUsuarioAfiliado").setParameter("paramCorreo", correo)
				.getResultList();
	}

	// protected region Use esta region para su implementacion del manejador on
	// begin

	// protected region Use esta region para su implementacion del manejador end
}
