package com.fasesoft.modelo.manejadores;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasRoles;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasRoles.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasRoles extends ManejadorCrud<FasRoles, Integer> {

	public ManejadorFasRoles() {
		super(FasRoles.class);
	}

	public int eliminarPorUsuario(Integer idUsuario) {
		return mp.createQuery("DELETE FROM FasRoles p WHERE p.fasUsuariosIdUsuario= :idUsuario")
				.setParameter("idUsuario", idUsuario).executeUpdate();
	}

	// protected region Use esta region para su implementacion del manejador on
	// begin

	// protected region Use esta region para su implementacion del manejador end
}
