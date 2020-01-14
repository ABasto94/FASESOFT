package com.fasesoft.modelo.manejadores;

import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;
import com.fasesoft.modelo.entidades.FasSolConvenios;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre
 * la tabla correspondiente a la entidad FasSolConvenios.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasSolConvenios extends ManejadorCrud<FasSolConvenios,Integer>{
	

    public ManejadorFasSolConvenios() {
        super(FasSolConvenios.class);
    }


    
    // protected region Use esta region para su implementacion del manejador on begin 

    // protected region Use esta region para su implementacion del manejador end        
}

