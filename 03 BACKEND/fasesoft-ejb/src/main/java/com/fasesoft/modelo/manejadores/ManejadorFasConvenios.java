package com.fasesoft.modelo.manejadores;

import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;
import com.fasesoft.modelo.entidades.FasConvenios;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre
 * la tabla correspondiente a la entidad FasConvenios.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasConvenios extends ManejadorCrud<FasConvenios,Integer>{
	

    public ManejadorFasConvenios() {
        super(FasConvenios.class);
    }
    
    // protected region Use esta region para su implementacion del manejador on begin 
	public List<FasConvenios> consultarListaPorUsuario(String correo) {
        return this.mp.createNamedQuery("FasConvenios.findSolConveniosByUser").setParameter("correo", correo).getResultList();
	} 
    // protected region Use esta region para su implementacion del manejador end        
}

