package com.fasesoft.modelo.manejadores;

import java.util.List;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasPerfiles;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasPerfiles.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasPerfiles extends ManejadorCrud<FasPerfiles, Integer> {

	public ManejadorFasPerfiles() {
		super(FasPerfiles.class);
	}

	public List<FasPerfiles> consultarPerfilesUsuario(String correo) {
		return mp.createNamedQuery("FasPerfiles.perfilesPorUsuario").setParameter("correo", correo).getResultList();
	}

	// protected region Use esta region para su implementacion del manejador on
	// begin

	// protected region Use esta region para su implementacion del manejador end
}
