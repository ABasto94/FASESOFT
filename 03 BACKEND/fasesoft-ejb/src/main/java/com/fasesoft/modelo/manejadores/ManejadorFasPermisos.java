package com.fasesoft.modelo.manejadores;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasPermisos;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasPermisos.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasPermisos extends ManejadorCrud<FasPermisos, Integer> {

	public ManejadorFasPermisos() {
		super(FasPermisos.class);
	}

	public int eliminarPorPerfil(Integer idPerfil) {
		return mp.createQuery("DELETE FROM FasPermisos p WHERE p.fasPerfilesIdPerfil= :idPerfil")
				.setParameter("idPerfil", idPerfil).executeUpdate();
	}
	// protected region Use esta region para su implementacion del manejador on
	// begin

	// protected region Use esta region para su implementacion del manejador end
}
